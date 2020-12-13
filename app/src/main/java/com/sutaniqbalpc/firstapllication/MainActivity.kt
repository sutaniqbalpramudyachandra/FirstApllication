    package com.sutaniqbalpc.firstapllication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sutaniqbalpc.firstapllication.model.User
import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {
        companion object {
            const val REQUEST_CODE = 100
        }
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_simple_intent.setOnClickListener{
            val simpleIntent = Intent(this@MainActivity,SimpleActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_intent_with_data.setOnClickListener {
            val dataInten = Intent(this@MainActivity,ExplicitIntentActivity::class.java)
            dataInten.putExtra(ExplicitIntentActivity.EXTRA_NAME,"Sepeda Brompton")
            dataInten.putExtra(ExplicitIntentActivity.EXTRA_EMAIL,"1000")
            dataInten.putExtra(ExplicitIntentActivity.EXTRA_AGE,"Rp.25.000.000")
            startActivity(dataInten)
        }
        btn_intent_parcelable.setOnClickListener {
            val parcelIntent = Intent(this@MainActivity,ParcleActivity::class.java)
            val user = User("Sepeda Brompton","20 Desember 2020","Rp.25.000.000")
            parcelIntent.putExtra(ParcleActivity.EXTRA_USER, user)
            startActivity(parcelIntent)
        }
        btn_implicit_intent.setOnClickListener {
            val phoneNumber = "089504497883"
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:$phoneNumber"))
            intent.putExtra("sms_body","Hallo Pak")
            startActivity(intent)

        }

        btn_intent_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(resultCode, resultCode, data)
            if(resultCode == 200){
                val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
                Log.d("Color",color.toString())
                view_result.setBackgroundColor(Color.parseColor(color.toString()))
            }
        }
}