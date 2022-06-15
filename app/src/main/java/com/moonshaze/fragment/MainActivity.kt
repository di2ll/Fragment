package com.moonshaze.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.moonshaze.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater).also { binding = it }
        setContentView(binding.root)
        openFrag(BlankFragment(), R.id.place_holder)
        openFrag(BlankFragment2(), R.id.place_holder2)
        dataModel.message.observe(this, {
            binding.textView.text = it
        })
        binding.button.setOnClickListener {
            binding.textView.text = "null"
        }
    }
    private fun openFrag(f: Fragment, place: Int){
        supportFragmentManager.beginTransaction().replace(place, f).commit()
    }
}