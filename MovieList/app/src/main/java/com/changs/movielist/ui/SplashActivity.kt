package com.changs.movielist.ui

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat
import com.changs.movielist.R
import com.changs.movielist.config.ApplicationClass
import com.changs.movielist.config.BaseActivity
import com.changs.movielist.data.FilmsModel
import com.changs.movielist.data.FilmsModelItem
import com.changs.movielist.data.Webservice
import com.changs.movielist.databinding.ActivitySplashBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {
    companion object {
        var filmsList: ArrayList<FilmsModelItem> = arrayListOf<FilmsModelItem>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        tryGetFilms()

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }, 4000)


    }

    fun tryGetFilms(){
        val RetrofitInterface = ApplicationClass.sRetrofit.create(Webservice::class.java)
        RetrofitInterface.getFilms().enqueue(object : Callback<FilmsModel> {
            override fun onResponse(call: Call<FilmsModel>, response: Response<FilmsModel>) {
                if(response.isSuccessful())
                {
                    // 응답을 잘 받은 경우
                    val data = response.body() as FilmsModel
                    filmsList = data
                    Log.d("tryGetFilms()","성공")


                } else {
                    // 통신은 성공했지만 응답에 문제가 있는 경우
                    Log.d("tryGetFilms()","응답에 문제")
                }
            }

            override fun onFailure(call: Call<FilmsModel>, t: Throwable) {
                Log.d("tryGetFilms()",t.message ?:"통신 오류")
            }

        })
    }
}