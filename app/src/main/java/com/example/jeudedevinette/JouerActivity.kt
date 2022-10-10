package com.example.jeudedevinette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random.Default.nextInt

class JouerActivity : AppCompatActivity() {
    lateinit var textView :TextView
    lateinit var textView2 :TextView
    lateinit var resultat:TextView
    lateinit var editId : EditText

    var random : Int= nextInt(1,1000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jouer)
        textView=findViewById(R.id.textView)
        textView2=findViewById(R.id.textView2)
        editId=findViewById(R.id.editId)

        resultat=findViewById(R.id.resultat)

        textView2.text="Donner un nombre:"

        editId.setOnClickListener {
            val number:Int =editId.text.toString().toInt()
            if (number <random){
               resultat.text="faux, votre numéro est trop petit !"
                editId.text.clear()

            }else if (number>random){
                resultat.text="faux, votre numéro est trop grand!"
                editId.text.clear()

            }else {
                editId.setOnClickListener {
                    resultat.text="Bravo!c'est gagné"
                editId.text.clear()


            }
        }
fun reset(){
    random= nextInt(1,1000)
    textView2.text="Donner un nombre :"
    editId.text.clear()

            resultat.setOnClickListener{
                reset()
            }

        }
    }
}
}