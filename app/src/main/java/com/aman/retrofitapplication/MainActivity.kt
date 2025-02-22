package com.aman.retrofitapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aman.retrofitapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var userViewModel: UserViewModel
    var arrayList = ArrayList<UserResponseItem>()
    var userAdapter = UserAdapter(arrayList)
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val TAG = "MainActivity"
    private val userViewModel : UserViewModel by ViewModels
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.getUser()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
        userViewModel.userList.observe(this){
            Log.e(TAG, "in observe")
            if(it.isNotEmpty()){
                arrayList.addAll(it)
                userAdapter.notifyDataSetChanged()
            }
        }

    }
}