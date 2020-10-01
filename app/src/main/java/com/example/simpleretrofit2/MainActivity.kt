package com.example.simpleretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleretrofit2.adapter.MyAdapter
import com.example.simpleretrofit2.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy {
        MyAdapter()
    }
//
//    val son = son_id.toInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        btn_click.setOnClickListener {

        setupRecyclerview()
//        mainLoadData()

//        edit_view.toString().toInt()
//        val son_id = 1
//        }

//        Log.d("TTT", son_id.toString())
//    private fun mainLoadData(){
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCustomPosts(1, "id", "desc")
        viewModel.myCustomPosts.observe(this, { response ->
            run {
                if (response.isSuccessful) {
                    response.body()?.let { myAdapter.setData(it) }
                } else {
                    Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    //}
    private fun setupRecyclerview() {
        recycler_view.adapter = myAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

}