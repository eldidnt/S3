package dev.didnt.desmov.s3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {

    private lateinit var txtn1:EditText
    private lateinit var txtn2:EditText
    private lateinit var btnC:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        asignarPreferencias()
    }

    fun asignarPreferencias(){
        txtn1 = findViewById(R.id.txtn1)
        txtn2 = findViewById(R.id.txtn2)
        btnC = findViewById(R.id.btnCalcular)

        btnC.setOnClickListener {
            calcular()
        }
    }

    fun calcular(){
        val n1 = txtn1.text.toString()
        val n2 = txtn2.text.toString()

        var valida:Boolean = true
        if(n1.isEmpty()){
            txtn1.setError("N1 es obligatorio")
            valida = false
        }
        if(n2.isEmpty()){
            txtn2.setError("N2 es obligatorio")
            valida = false
        }

        if(valida){
            val suma = n1.toInt() + n2.toInt()
            mostrarMensaje("La suma es: $suma")
        }
    }

    fun mostrarMensaje(mensaje:String){
        val ventana = AlertDialog.Builder(this)
        ventana.setTitle("Mensaje")
        ventana.setMessage(mensaje)
        ventana.setPositiveButton("Aceptar",null)
        ventana.create().show()
    }
}