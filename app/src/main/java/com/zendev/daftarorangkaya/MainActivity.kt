package com.zendev.daftarorangkaya

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.zendev.daftarorangkaya.adapter.PeopleAdapter
import com.zendev.daftarorangkaya.model.People
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger {

    private lateinit var adapter: PeopleAdapter
    private var dataPeople: MutableList<People> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        adapter = PeopleAdapter(dataPeople){

        }

        recyclerView.adapter = adapter
        addPeople()
    }

    @SuppressLint("Recycle")
    private fun addPeople() {
        dataPeople.clear()
        val name: Array<String> = resources.getStringArray(R.array.name)
        val founder: Array<String> = resources.getStringArray(R.array.founder)
        val description: Array<String> = resources.getStringArray(R.array.description)
        val photo: Array<String> = resources.getStringArray(R.array.photo)

        for (i in name.indices) {
            val people = People(name[i], description[i], photo[i], founder[i])
            dataPeople.add(people)
        }

        adapter.notifyDataSetChanged()
    }
}
