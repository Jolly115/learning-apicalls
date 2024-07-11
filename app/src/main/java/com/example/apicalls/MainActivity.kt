package com.example.apicalls

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apicalls.model.PeopleModel
import com.example.apicalls.viewModel.PeopleViewModel

class MainActivity : AppCompatActivity() {
    private var viewModel: PeopleViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel =PeopleViewModel()

        //now calling the api fun
        viewModel?.peopleItems()
        observer()
    }

    private fun observer() {
        viewModel?.peoplelist?.observe(this@MainActivity){
            Log.e("JollyLog","$it")
        }
    }
}