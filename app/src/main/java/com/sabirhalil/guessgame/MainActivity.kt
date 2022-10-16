package com.sabirhalil.guessgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sabirhalil.guessgame.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private var count = 0
    private var isGameOver = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      //  val r = Random.nextInt(0..100)
        val r = Random.nextInt(0 until 100)

        binding.btnSubmit.setOnClickListener {

            if (isGameOver)
                recreate()

            if (binding.etUserGuess.text.isNotEmpty()){
                val userNum = binding.etUserGuess.text.toString().toInt()
                if(userNum in 1..99){
                    checkNumbers(userNum,r)
                }else{
                    Toast.makeText(this,"Please enter a number between 1 to 99",Toast.LENGTH_SHORT).show()
                }


            }else{
                Toast.makeText(this,"Please enter your guess",Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun checkNumbers(userNumber : Int, guess : Int){
        count++
        if (guess > userNumber){
            binding.tvStatus.text = "Choose a higher number"
        }else if(guess < userNumber){
            binding.tvStatus.text = "Choose a lower number"
        }else{
            binding.tvStatus.text = "Congratulations you have found it in $count tries."
            binding.btnSubmit.text = "Start a new game"
            isGameOver = true
        }

        binding.etUserGuess.text.clear()
    }
}