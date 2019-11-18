package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit = late initialise
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Lau")
    private val myContactNumber: MyContactNumber = MyContactNumber("016-8368545")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) //activity itself

        binding.buttonSetName.setOnClickListener{
            //it = object (button)
            addNickName(it)
        }

        binding.buttonSetContactNumber.setOnClickListener {
            addContactNumber(it)
        }

        binding.myName = myName
        binding.myContactNumber = myContactNumber
        //setContentView(R.layout.activity_main)
    }

    private fun addNickName(it: View?){
        binding.apply {
            myName?.name = editTextName.text.toString()
            this.invalidateAll() //refresh the content
        }
    }

    private fun addContactNumber(it: View?){
        binding.apply{
            myContactNumber?.contactNumber = editTextContactNumber.text.toString()
            this.invalidateAll()
        }
    }
}
