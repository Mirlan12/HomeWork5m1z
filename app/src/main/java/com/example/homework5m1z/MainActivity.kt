package com.example.homework5m1z

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import com.example.homework5m1z.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    var presenter = Presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)

        initClickers()
    }

    private fun initClickers() {
        with(binding){
            incrementBtn.setOnClickListener{
                presenter.incrementCount()
            }

            decrement.setOnClickListener{
               presenter.decrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.result.text = count
    }

    override fun showToast(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showColor(color: Int) = binding.result.setTextColor(color)
    }
