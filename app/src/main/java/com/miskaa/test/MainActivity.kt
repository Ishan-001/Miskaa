package com.miskaa.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miskaa.test.adapters.Adapter
import com.miskaa.test.api.Api
import com.miskaa.test.classes.RegionResults
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        val progressBar:ProgressBar=findViewById(R.id.progress_bar)

        progressBar.visibility= View.VISIBLE

        Api.retrofitService.getCountryList().enqueue(object: Callback<ArrayList<RegionResults>>{
            override fun onResponse(call: Call<ArrayList<RegionResults>>, response: Response<ArrayList<RegionResults>>) {
                val adapter=Adapter(this@MainActivity, response.body()!!)
                recyclerView.layoutManager=LinearLayoutManager(baseContext)
                recyclerView.adapter=adapter
                progressBar.visibility=View.GONE
            }

            override fun onFailure(call: Call<ArrayList<RegionResults>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }
}