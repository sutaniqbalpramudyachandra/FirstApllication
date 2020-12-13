package com.sutaniqbalpc.firstapllication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ExplicitIntentActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_AGE = "extra_age"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit_intent)

    txt_nama.text = intent.getStringExtra(EXTRA_NAME)
        txt_email.text = intent.getStringExtra(EXTRA_EMAIL)
        txt_age.text = intent.getStringExtra(EXTRA_AGE)

    btn_back.setOnClickListener {
        val backItem = Intent(this@ExplicitIntentActivity,MainActivity::class.java)
        startActivity(backItem)
    }

    }
}