package com.vishalpvijayan.assesmentproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val repository = DataRepository(DataApi())
        GlobalScope.launch (Dispatchers.Main){
            val allData = repository.getData()
            Toast.makeText(this@MainActivity,allData.toString(), Toast.LENGTH_LONG).show()
        }
    }
}