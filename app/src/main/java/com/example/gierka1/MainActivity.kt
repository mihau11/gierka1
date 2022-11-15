package com.example.gierka1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import java.lang.StrictMath.random
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var guziki = arrayOf(findViewById<ToggleButton>(R.id.b1),findViewById<ToggleButton>(R.id.b2),findViewById<ToggleButton>(R.id.b3),findViewById<ToggleButton>(R.id.b4),findViewById<ToggleButton>(R.id.b5),findViewById<ToggleButton>(R.id.b6),findViewById<ToggleButton>(R.id.b7),findViewById<ToggleButton>(R.id.b8),findViewById<ToggleButton>(R.id.b9))
        var kolejka = arrayOf(1,2,3,4,5,6,7,8,9)
        var label=findViewById<TextView>(R.id.textView)
        var label2=findViewById<TextView>(R.id.textView2)
        var score=0
        var i =0
        for (g in guziki){
            g.setOnClickListener {
                label2.text=kolejka.toString()
                label.text="SCORE: "+score.toString()
                if((g.id-2131231205)==kolejka[i]){
                    i++
                    if(i>8){
                        for (gu in guziki){
                            gu.isChecked=false
                        }
                        i=0
                        score++
                        val builder = AlertDialog.Builder(this)
                        with(builder)
                        {
                            setTitle("BRAWO")
                            setMessage("Klikałeś w dobrej kolejności "+score+" raz!")
                            show()
                        }

                        for (i in 0..9){
                            kolejka[i]=0
                        }
                        var pomoc = 0
                        for (i in 0..9){
                            do {
                                pomoc = Random.nextInt(1, 9)
                            }while (!(kolejka.contains(pomoc)))
                            kolejka[i] = pomoc
                        }

                    }
                }
                else{
                    for (gu in guziki){
                        gu.isChecked=false
                    }
                    i=0
                }
            }
        }
    }
}