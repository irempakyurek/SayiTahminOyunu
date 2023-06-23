package com.irempakyurek.sayitahminoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    var kalanHak = 0
    var randomSayi = 0
    var i = 3
    private lateinit var tahminButton : TextView
    private lateinit var edtTahmin : EditText
    private lateinit var tahminText : TextView
    private lateinit var kalanHakText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kalanHak = 3

        randomSayi = nextInt(0,101)

        tahminButton = findViewById(R.id.tahminButton)
        edtTahmin = findViewById(R.id.edtTahmin)
        tahminText = findViewById(R.id.tahminText)
        kalanHakText = findViewById(R.id.skorText)

        kalanHakText.setText(kalanHak.toString())

        tahminButton.setOnClickListener {
            tahmin()
        }
    }

    fun tahmin() {

        val tahminSayiStr = edtTahmin.text.toString()

        if (!tahminSayiStr.equals("")) {

            val tahminSayi = tahminSayiStr.toInt()

            while(i > 0){
                if (tahminSayi > randomSayi) {
                    tahminText.setText(getString(R.string.daha_kücük_sayi_giriniz))
                    kalanHak--
                    kalanHakText.setText(kalanHak.toString())
                    i -= 1
                    break
                } else if (tahminSayi < randomSayi) {
                    tahminText.setText(getString(R.string.daha_büyük_sayi_giriniz))
                    kalanHak--
                    kalanHakText.setText(kalanHak.toString())
                    i -= 1
                    break
                } else {
                    tahminText.setText(getString(R.string.tebrikler))
                    edtTahmin.isFocusable = false
                    tahminButton.isClickable = false
                    i -= 1
                    finish()
                }
            }

            if (i == 0){
                Toast.makeText(this, "Kullanımınız Bitti.", Toast.LENGTH_SHORT).show()
                finish()

            }
        }else {
            Toast.makeText(this, "Lütfen bir sayı giriniz", Toast.LENGTH_SHORT).show()
        }


    }
}