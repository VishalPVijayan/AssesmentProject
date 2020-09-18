package com.vishalpvijayan.assesmentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        img_logo.alpha = 0f
        img_logo.animate().setDuration(5000).alpha(1f).withEndAction{
            val i = Intent (this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_out,android.R.anim.bounce_interpolator)
            finish()
        }
    }
}