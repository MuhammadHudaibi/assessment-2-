package org.d3if3010.assessment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.d3if3010.assessment_2.databinding.ActivityMainBinding
import org.d3if3010.assessment_2.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            viewModel.setUser(name, email)
        }

        viewModel.user.observe(this, Observer { user ->
            binding.tvUser.text = "Name: ${user.name}\nEmail: ${user.email}"
        })
    }
}
