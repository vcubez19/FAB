package com.example.fab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {


    var items = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    lateinit var listView: ListView
    lateinit var fab: FloatingActionButton
    lateinit var undoOnClickListener: View.OnClickListener


    var colors = arrayOf(
        Color.YELLOW,
        Color.GREEN,
        Color.GRAY,
        Color.CYAN,
        Color.BLUE,
        Color.LTGRAY
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.lv1)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            items
        )
        listView.adapter = adapter
        fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            addListItem()
            Snackbar.make(it, "Added an item", Snackbar.LENGTH_LONG)
                .setAction("Change color", undoOnClickListener)
                .show()
        }


        undoOnClickListener = View.OnClickListener {
            listView.setBackgroundColor(this.colors.random())
            adapter?.notifyDataSetChanged()
            Snackbar.make(it, "Colors changed", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }

    }


    private fun addListItem() {
        items.add("Item 1")
        adapter?.notifyDataSetChanged()
    }


}

