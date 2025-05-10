package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentNumber = ""
    private var sum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding kullanımı
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sayısal Butonlar Listesi
        val buttons = listOf(
            binding.button0, binding.button1, binding.button2, binding.button3,
            binding.button4, binding.button5, binding.button6,
            binding.button7, binding.button8, binding.button9
        )

        // Sayısal Butonlara Tıklama Olayı
        for (button in buttons) {
            button.setOnClickListener {
                currentNumber += button.text
                binding.resultTextView.text = currentNumber
            }
        }

        // Toplama İşlemi
        binding.buttonPlus.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                sum += currentNumber.toInt()
                currentNumber = ""
                binding.resultTextView.text = sum.toString()
            }
        }

        // Eşittir Butonu (Sonucu Gösterme)
        binding.buttonEquals.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                sum += currentNumber.toInt()
                currentNumber = ""
            }
            binding.resultTextView.text = sum.toString()
        }

        // Sıfırlama (AC) Butonu
        binding.buttonAC.setOnClickListener {
            sum = 0
            currentNumber = ""
            binding.resultTextView.text = "0"
        }
    }
}
