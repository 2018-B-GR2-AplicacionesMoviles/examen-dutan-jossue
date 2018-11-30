package com.example.jossue.examen_moviles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_editar.*

class EditarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar)

        val casa = intent.getParcelableExtra<Casa?>("casa")
        val pos = intent.getIntExtra("pos", 0)

        button_actualizar.setOnClickListener {
            this.ActualizarCasa(id_editar.toString(), desc_editar.toString(), m2_editar.toString(), precio_editar.toString(), pos)
            this.irAListar()
        }
    }

    fun ActualizarCasa (indiceCasa: String, descipcionIng:String, m2Ing: String, precioIng:String, pos:Int):Unit{

        val nuevaCasa: Casa = Casa(indiceCasa,descipcionIng, m2Ing, precioIng)

        BDD.Casa[pos] = nuevaCasa

        Log.i("intent-nombre-apellido", "CASA ${BDD.Casa.toString()}")
    }
    fun irAListar(){
        val intentListar = Intent(this, ListarActivity::class.java);
        this.startActivity(intentListar)
    }

}
