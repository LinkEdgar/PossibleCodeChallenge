package com.example.edgarreyes.possiblecodetest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class MainActivity : AppCompatActivity(), DvdContract.View {

    private lateinit var mLayout: RecyclerView.LayoutManager
    private lateinit var mAdapter: DvdAdapter
    private lateinit var mPresenter: DvdContract.Presenter
    private lateinit var mDvdData: ArrayList<Dvd>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mPresenter = DvdPresenter(this)
        mPresenter.intiateLoad(savedInstanceState)
    }

    override fun initViews() {
        mLayout = LinearLayoutManager(applicationContext)
        mDvdData = ArrayList()
        mAdapter = DvdAdapter(mDvdData)
        main_recycler_view.layoutManager = mLayout
        main_recycler_view.adapter = mAdapter

    }

    override fun setDvdData(jsonArray: JSONArray) {
        this@MainActivity.runOnUiThread {
            try {
                addDataToAdapter(jsonArray)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun addDataToAdapter(jsonArray: JSONArray){
        for(x in 0..(jsonArray.length()-1)){
            try {
                val json = jsonArray.getJSONObject(x)
                val title = json.getString(jsonTitle)
                val url = json.getString(jsonImageUrl)
                val dvd = Dvd(url, title)
                mDvdData.add(dvd)
                mAdapter!!.notifyItemInserted(x)
            }catch(e: JSONException){
                e.printStackTrace()
            }

        }
    }
    companion object {
        val jsonTitle = "title"
        val jsonImageUrl = "imageURL"
    }
}
