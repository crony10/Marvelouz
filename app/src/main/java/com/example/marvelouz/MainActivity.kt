package com.example.marvelouz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.marvelouz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        board = arrayOf(
            arrayOf(binding.bt1, binding.bt2, binding.bt3),
            arrayOf(binding.bt4, binding.bt5, binding.bt6),
            arrayOf(binding.bt7, binding.bt8, binding.bt9)
        )

        for(i in board){
            for(button in i){
                button.setOnClickListener(this)
            }
        }
        binding.resetBtn.setOnClickListener{

        }

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.bt1->{

            }
            R.id.bt2->{

            }
            R.id.bt3->{

            }
            R.id.bt4->{

            }
            R.id.bt5->{

            }
            R.id.bt6->{

            }
            R.id.bt7->{

            }
            R.id.bt8->{

            }
            R.id.bt9->{

            }
        }
    }
}