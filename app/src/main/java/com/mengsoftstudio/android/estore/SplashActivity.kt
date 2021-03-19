package com.mengsoftstudio.android.estore


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashActivity : AppCompatActivity() {


    companion object{
        const val  ONE_SECOND  = 1000L
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splash()

    }


    private fun splash() {
        GlobalScope.launch {
            startAnimate()
            delay(ONE_SECOND * 3)
            nextActivity()
        }
    }




    private fun nextActivity(){
        val intent = (Intent(this,MainActivity::class.java))
        this.finish()
        startActivity(intent)
    }


    private fun setAnimate(id : Int) : Animation {
        return AnimationUtils.loadAnimation(this,id)
    }


    private fun startAnimate(){
        ImageView_logo_splash.startAnimation(setAnimate(R.anim.left_to_normal))
        ImageView_text_app.startAnimation(setAnimate(R.anim.right_to_normal))
        tv_sub_text_app.startAnimation(setAnimate(R.anim.right_to_normal))
        ImageView_Splash_progress.startAnimation(setAnimate(R.anim.rotate))
    }

}

