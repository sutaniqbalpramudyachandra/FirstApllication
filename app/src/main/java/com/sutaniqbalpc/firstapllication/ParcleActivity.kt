package com.sutaniqbalpc.firstapllication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sutaniqbalpc.firstapllication.model.User
import kotlinx.android.synthetic.main.activity_explicit_intent.*

class ParcleActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcle)

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User

        txt_nama.text = user.name
        txt_email.text = user.email
        txt_age.text = user.age

        btn_back.setOnClickListener {
            val backItem = Intent(this@ParcleActivity, MainActivity::class.java)
            startActivity(backItem)
        }
    }
}