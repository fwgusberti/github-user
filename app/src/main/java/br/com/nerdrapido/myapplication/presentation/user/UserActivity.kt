package br.com.nerdrapido.myapplication.presentation.user

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.nerdrapido.myapplication.R
import br.com.nerdrapido.myapplication.data.model.User
import br.com.nerdrapido.myapplication.data.remote.service.UserService
import br.com.nerdrapido.myapplication.data.repository.UserRepositoryImpl
import br.com.nerdrapido.myapplication.domain.usecases.GetUserUseCase
import com.bumptech.glide.Glide
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created By FELIPE GUSBERTI @ 08/02/2022
 */
class UserActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by lazy {
        UserViewModel(
            GetUserUseCase(
                UserRepositoryImpl(
                    Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .client(getInterceptor())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(UserService::class.java)
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        viewModel.user.observe(this, Observer {
            renderUser(it)
        })

        findViewById<Button>(R.id.bt_get_user).setOnClickListener {
            viewModel.loadUser()
        }
    }

    private fun renderUser(user: User) {
        findViewById<TextView>(R.id.tv_user_name).text = user.name
        Glide.with(this)
            .load(user.avatarUrl)
            .into(findViewById<ImageView>(R.id.iv_user_image))
        findViewById<ImageView>(R.id.iv_user_image)
    }

    private fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)
        return builder.build()
    }
}