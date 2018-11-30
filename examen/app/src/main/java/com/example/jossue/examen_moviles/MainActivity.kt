package com.example.jossue.examen_moviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_insertar
            .setOnClickListener {
                this.irAInsertar()
            }
        button_listar.setOnClickListener {
            this.irAListar()
        }
    }
    fun irAInsertar(){
        val intentRespuestaInsertar = Intent(this, InsertarActivity::class.java);
        this.startActivityForResult(intentRespuestaInsertar, requestCodeInsertar)
    }
    fun irAListar(){
        val intentListar = Intent(this, ListarActivity::class.java);
        this.startActivity(intentListar)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode){
            requestCodeInsertar -> {
                when (resultCode) {
                    RESULT_OK -> {
                        Log.i("intent-nombre-apellido", "LLEGOOOO ${data!!.getStringExtra("numeroCasa")}")
                        Log.i("intent-nombre-apellido", "LLEGOOOO ${data!!.getStringExtra("descripcion")}")
                        Log.i("intent-nombre-apellido", "LLEGOOOO ${data!!.getStringExtra("m2")}")
                        Log.i("intent-nombre-apellido", "LLEGOOOO ${data!!.getStringExtra("precio")}")

                        IngresarCasa(data!!.getStringExtra("numeroCasa"), data!!.getStringExtra("descripcion"),
                            data!!.getStringExtra("m2"), data!!.getStringExtra("precio"))
                    }
                    RESULT_CANCELED -> {
                        Log.i("error", "Error")
                    }
                }

            }
            else -> {
                Log.e("indefinido", "indefinido")
            }
        }
    }

    fun IngresarCasa (indiceCasa: String, descipcionIng:String, m2Ing: String, precioIng:String):Unit{

        val nuevaCasa: Casa = Casa(indiceCasa,descipcionIng, m2Ing, precioIng)

        BDD.Casa.add(nuevaCasa)

        Log.i("intent-nombre-apellido", "CASA ${BDD.Casa.toString()}")
    }

    companion object {
        val requestCodeInsertar = 101
    }
}



