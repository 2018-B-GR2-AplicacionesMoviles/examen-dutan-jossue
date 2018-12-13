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

        if (casa != null) {
            mostrarCampos(casa)
        }

        Log.i("intent-nombre-apellido", "casa actualizar ${casa.toString()}")

        button_actualizar.setOnClickListener {
            this.ActualizarCasa(id_editar.text.toString(), desc_editar.text.toString(), m2_editar.text.toString(), precio_editar.text.toString(), pos)
            Log.i("intent-nombre-apellido", "id editar ${id_editar.text.toString()}")

            this.irAListar()
        }
        button_eliminar.setOnClickListener {
            this.BorrarCasa(pos)
            this.irAListar()
        }
    }

    fun ActualizarCasa (indiceCasa: String, descipcionIng:String, m2Ing: String, precioIng:String, pos:Int):Unit{

        val nuevaCasa: Casa = Casa(indiceCasa,descipcionIng, m2Ing, precioIng)

        BDD.Casa[pos] = nuevaCasa

        Log.i("intent-nombre-apellido", "CASA ${BDD.Casa[pos].toString()}")
    }

    fun BorrarCasa (pos:Int):Unit{



        Log.i("intent-nombre-apellido", "pos ${pos}")
        BDD.Casa.remove(BDD.Casa[pos])

    }
    fun irAListar(){
        val intentListar = Intent(this, ListarActivity::class.java);
        this.startActivity(intentListar)
    }
    fun mostrarCampos(casa: Casa){
        id_editar.setText(casa.numeroCasa);
        desc_editar.setText(casa.descripcion);
        m2_editar.setText(casa.m2);
        precio_editar.setText(casa.precio);
    }

}
