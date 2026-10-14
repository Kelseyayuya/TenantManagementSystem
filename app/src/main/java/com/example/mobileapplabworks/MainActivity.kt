package com.example.mobileapplabworks

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.mobileapplabworks.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val phone = binding.phoneEditText.text.toString()
            val rent = binding.rentEditText.text.toString()

            val tenant = Tenant(name, phone, rent)
            binding.tenant = tenant
        }
    }
}
