package com.ecci.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttton: Button = findViewById(R.id.botonC)
        val email_ : String = "juanp.rodriguezb@ecci.edu.co"
        val texcorreo : TextView = findViewById(R.id.correo)
        val alerta : TextView = findViewById(R.id.alerta)
        val contra : TextView = findViewById(R.id.pass)
        val password : Int = 123456

        buttton.setOnClickListener {
            println(email_ == texcorreo.getText().toString())
            println(password == Integer.parseInt(contra.getText().toString()))
            if (email_ == texcorreo.getText().toString() && password == Integer.parseInt(contra.getText().toString())){
                val intent = Intent( this, LoginActivity::class.java)
                startActivity(intent)
            }
            if (texcorreo.text.length == 0 && contra.text.length == 0)
            {
                alerta.visibility = android.view.View.VISIBLE
                alerta.text = getString(R.string.instru1)
            }
            else if (contra.text.length < 5)
            {
                alerta.visibility = android.view.View.VISIBLE
                alerta.text = getString(R.string.instru3)
            }
            else if (email_ != texcorreo.text.toString() || password != Integer.parseInt(contra.getText().toString()))
            {
                alerta.visibility = android.view.View.VISIBLE
                alerta.text = getString(R.string.instru2)
            }

        }
    }
}