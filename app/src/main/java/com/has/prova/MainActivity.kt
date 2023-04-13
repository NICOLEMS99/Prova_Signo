package com.has.prova;


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View.inflate
import android.widget.EditText
import android.widget.ImageView
import com.has.prova.R
import com.has.prova.databinding.ActivityMainBinding
import com.has.prova.databinding.ActivityMainBinding.*


class MainActivity : AppCompatActivity() {

    //private val Calcular: Any
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        binding.Button.setOnClickListener{ descobrirSigno() }

        val dayInput = findViewById<EditText>(R.id.DiaText)
        dayInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "31")
        )

        val monthInput = findViewById<EditText>(R.id.MesText)
        monthInput.filters = arrayOf<InputFilter>(
            InputFilter.LengthFilter(2),
            InputFilterMinMax("1", "12")
        )

    }

    fun descobrirSigno() {
        val MonthText = binding.MesText.text.toString()
        val mesInt = MonthText.toInt()

        val DayText = binding.DiaText.text.toString()
        val dayInt = DayText.toInt()

        val SignoImage: ImageView = findViewById(R.id.imageView)
        val SignoText = binding.signoText

        when(mesInt) {
            1 -> if(dayInt >= 1 && dayInt < 20) {
                SignoImage.setImageResource(R.drawable.capricorn)
                SignoText.text = "Capricórnio"
            } else {
                SignoImage.setImageResource(R.drawable.aquarius)
                SignoText.text = "Aquário"
            }
            2 -> if(dayInt >= 1 && dayInt < 20) {
                SignoImage.setImageResource(R.drawable.aquarius)
                SignoText.text = "Aquário"
            } else {
                SignoImage.setImageResource(R.drawable.pisces)
                SignoText.text = "Peixes"
            }
            3 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.pisces)
                SignoText.text = "Peixes"
            } else {
                SignoImage.setImageResource(R.drawable.aries)
                SignoText.text = "Áries"
            }
            4 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.aries)
                SignoText.text = "Áries"
            } else {
                SignoImage.setImageResource(R.drawable.bull)
                SignoText.text = "Touro"
            }
            5 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.bull)
                SignoText.text = "Touro"
            } else {
                SignoImage.setImageResource(R.drawable.gemini)
                SignoText.text = "Gêmeos"
            }
            6 -> if(dayInt >= 1 && dayInt < 21) {
                SignoImage.setImageResource(R.drawable.gemini)
                SignoText.text = "Gêmeos"
            } else {
                SignoImage.setImageResource(R.drawable.cancer)
                SignoText.text = "Câncer"
            }
            7 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.cancer)
                SignoText.text = "Câncer"
            } else {
                SignoImage.setImageResource(R.drawable.leo)
                SignoText.text = "Leão"
            }
            8 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.leo)
                SignoText.text = "Leão"
            } else {
                SignoImage.setImageResource(R.drawable.virgo)
                SignoText.text = "Virgem"
            }
            9 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.virgo)
                SignoText.text = "Virgem"
            } else {
                SignoImage.setImageResource(R.drawable.libra)
                SignoText.text = "Libra"
            }
            10 -> if(dayInt >= 1 && dayInt < 23) {
                SignoImage.setImageResource(R.drawable.libra)
                SignoText.text = "Libra"
            } else {
                SignoImage.setImageResource(R.drawable.scorpio)
                SignoText.text = "Escorpião"
            }
            11 -> if(dayInt >= 1 && dayInt < 22) {
                SignoImage.setImageResource(R.drawable.scorpio)
                SignoText.text = "Escorpião"
            } else {
                SignoImage.setImageResource(R.drawable.sagittarius)
                SignoText.text = "Sagitário"
            }
            12 -> if(dayInt >= 1 && dayInt < 22) {
                SignoImage.setImageResource(R.drawable.sagittarius)
                SignoText.text = "Sagitário"
            } else {
                SignoImage.setImageResource(R.drawable.capricorn)
                SignoText.text = "Capricórnio"
            }
        }

    }

}




class InputFilterMinMax : InputFilter {
    private var min: Int
    private var max: Int

    constructor(minValue: Int, maxValue: Int) {
        this.min = minValue
        this.max = maxValue
    }

    constructor(minValue: String, maxValue: String) {
        this.min = minValue.toInt()
        this.max = maxValue.toInt()
    }

    override fun filter(
        source: CharSequence,
        start: Int,
        end: Int,
        dest: Spanned,
        dstart: Int,
        dend: Int
    ): CharSequence? {
        try {
            val input = (dest.toString() + source.toString()).toInt()
            if (isInRange(min, max, input)) return null
        } catch (nfe: NumberFormatException) {
        }
        return ""
    }

    private fun isInRange(a: Int, b: Int, c: Int): Boolean {
        return if (b > a) c in a..b else c in b..a
    }
}