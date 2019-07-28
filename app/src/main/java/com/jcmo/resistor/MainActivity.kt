package com.jcmo.resistor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sp1: Spinner
    private lateinit var sp2: Spinner
    private lateinit var sp3: Spinner
    private lateinit var sp4: Spinner
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.sp1 = findViewById(R.id.Banda1)
        sp2 = findViewById(R.id.Banda2)
        sp3 = findViewById(R.id.Banda3)
        sp4 = findViewById(R.id.Banda4)
        lateinit var  band1: String
        lateinit var  band2: String
        lateinit var  band3: String
        lateinit var  band4: String
        lateinit var  bandacu1: String
        lateinit var  bandacu2: String
        lateinit var  bandacu3: String
        lateinit var  bandacu4: String
        val categories3 = arrayOf("Selecciona","Negro","Cafe","Rojo","Naranja","Amarillo","Verde","Azul","Violeta","Gris","Blanco","Dorado","Plateado")
        val categories2 = arrayOf("Selecciona","Negro","Cafe","Rojo","Naranja","Amarillo","Verde","Azul","Violeta","Gris","Blanco")
        val categories1 = arrayOf("Selecciona","Cafe","Rojo","Naranja","Amarillo","Verde","Azul","Violeta","Gris","Blanco")
        val categories4 = arrayOf("Selecciona","Cafe","Rojo","Verde","Azul","Violeta","Gris","Dorado","Plateado")
        val adapter = ArrayAdapter.createFromResource(this,R.array.Banda1, android.R.layout.simple_spinner_dropdown_item )
        val adapter2 = ArrayAdapter.createFromResource(this,R.array.Banda2, android.R.layout.simple_spinner_dropdown_item )
        val adapter3 = ArrayAdapter.createFromResource(this,R.array.Banda3, android.R.layout.simple_spinner_dropdown_item )
        val adapter4 = ArrayAdapter.createFromResource(this,R.array.Banda4, android.R.layout.simple_spinner_dropdown_item )
        sp1.adapter=adapter
        sp2.adapter=adapter2
        sp3.adapter=adapter3
        sp4.adapter=adapter4

        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener  {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                bandacu1 = "None"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                band1 = categories1[p2]
                bandacu1 = when (band1) {
                    categories1[0] -> "None"
                    categories1[1] -> "1"
                    categories1[2] -> "2"
                    categories1[3] -> "3"
                    categories1[4] -> "4"
                    categories1[5] -> "5"
                    categories1[6] -> "6"
                    categories1[7] -> "7"
                    categories1[8] -> "8"
                    categories1[9] -> "9"
                    else -> "None"
                }
            }
        }
        sp2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener  {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                bandacu2 = "None"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                band2 = categories2[p2]
                bandacu2 = when (band2) {
                    categories2[0] -> "None"
                    categories2[1] -> "0"
                    categories2[2] -> "1"
                    categories2[3] -> "2"
                    categories2[4] -> "3"
                    categories2[5] -> "4"
                    categories2[6] -> "5"
                    categories2[7] -> "6"
                    categories2[8] -> "7"
                    categories2[9] -> "8"
                    categories2[10] -> "9"
                    else -> "None"
                }
            }
        }
        sp3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                bandacu3 = "None"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                band3 = categories3[p2]
                bandacu3 = when (band3) {
                    categories3[0] -> "None"
                    categories3[1] -> "1"
                    categories3[2] -> "10"
                    categories3[3] -> "100"
                    categories3[4] -> "1K"
                    categories3[5] -> "10K"
                    categories3[6] -> "100K"
                    categories3[7] -> "1M"
                    categories3[8] -> "10M"
                    categories3[9] -> "100M"
                    categories3[10] -> "1G"
                    categories3[11] -> "0.1"
                    categories3[12] -> "0.01"
                    else -> "None"
                }
            }
        }
        sp4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                bandacu4 = "None"
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                band4 = categories4[p2]
                bandacu4 = when (band4) {
                    categories4[0] -> "None"
                    categories4[1] -> "1%"
                    categories4[2] -> "2%"
                    categories4[3] -> "0.5%"
                    categories4[4] -> "0.25%"
                    categories4[5] -> "0.1%"
                    categories4[6] -> "0.05%"
                    categories4[7] ->"5%"
                    categories4[8] ->"10%"
                    else -> "None"
                }
            }
        }
        btnCalcular.setOnClickListener {
            if (bandacu1=="None" || bandacu2=="None" || bandacu3=="None" || bandacu4=="None"){
                tvResult.text="Banda no esta selecionada"
            }else {
                when (bandacu3) {
                    "1" -> tvResult.text = "$bandacu1$bandacu2 Ohms ± $bandacu4"
                    "10" -> tvResult.text = ((bandacu1+bandacu2).toInt()*10).toString() + " Ohms ±" + bandacu4
                    "100" -> tvResult.text = ("$bandacu1.$bandacu2") + "K Ohms ± " + bandacu4
                    "1K" -> tvResult.text = (bandacu1+bandacu2)+"K" + " Ohms ± " + bandacu4
                    "10K" -> tvResult.text = ((bandacu1+bandacu2).toInt()*10).toString() + "K Ohms ±" + bandacu4
                    "100K" -> tvResult.text = ("$bandacu1.$bandacu2") + "M Ohms ± " + bandacu4
                    "1M" -> tvResult.text = (bandacu1+bandacu2) + "M Ohms ± " + bandacu4
                    "10M" -> tvResult.text = ((bandacu1+bandacu2).toInt()*10).toString() + "M Ohms ±" + bandacu4
                    "100M" -> tvResult.text = ("$bandacu1.$bandacu2") + "G Ohms ± " + bandacu4
                    "1G" -> tvResult.text = (bandacu1+bandacu2) + "G Ohms ± " + bandacu4
                    "0.1" -> tvResult.text = "$bandacu1.$bandacu2 Ohms ± $bandacu4"
                    "0.01" -> tvResult.text = ((bandacu1+bandacu2).toFloat()*0.01).toString() + " Ohms ±" + bandacu4
                }
            }
        }
    }
}
