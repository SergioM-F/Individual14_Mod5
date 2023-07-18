package cl.samf.individual14_mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.samf.individual14_mod5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOk.setOnClickListener {

            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButtonSaldo ->
                    binding.editTextMonto.setText(saldo.toString())

                R.id.radioButtonIngresar ->
                    ingresarSaldo()

                R.id.radioButtonRetirar ->
                    retirarSaldo()

                R.id.radioButtonSalir -> finish()
        }

         }
    }

    private fun retirarSaldo() {
        val monto = binding.editTextMonto.text.toString().toInt()
        if (monto <= saldo) {
            saldo -= monto
            Toast.makeText(this, "Su saldo a sido actualizado", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "El monto a retirar supera el saldo", Toast.LENGTH_LONG).show()
        }
    }

    private fun ingresarSaldo() {
        saldo += binding.editTextMonto.text.toString().toInt()
        Toast.makeText(this, "Su saldo a sido actualizado", Toast.LENGTH_LONG).show()

    }
}



