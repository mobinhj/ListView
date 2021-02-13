package com.example.mylistview

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.text.SpannableString
import android.text.style.AlignmentSpan
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {


    var mFab: FloatingActionButton? = null

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val cotext = this
//        val db = DataBaseHandler(cotext)
        mFab = findViewById(R.id.fab)
//        var myListData: MutableList<MyListData>
        val alert = mutableListOf("ali", "mamad", "mobin", "jafar", "kazem", "ali", "ali")
        val myListData = mutableListOf(
                MyListData("Alert", 10)
        )
//        val user = mutableListOf(
//            "jafar"
//        )

//        val counter : TextView = findViewById<TextView>(R.id.counter)

        val recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView.addItemDecoration(DefaultItemDecorator(resources.getDimensionPixelSize(R.dimen.activity_horizontal_margin),
                resources.getDimensionPixelSize(R.dimen.activity_vertical_margin)))



        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.addItemDecoration(HeaderFooterDecoration(0))

        recyclerView.apply {
            layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            layoutManager
            adapter = MyListAdapter(myListData)
        }
//        fun View.showKeyboard() {
//            this.requestFocus()
//            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
//        }
//
//        fun View.hideKeyboard() {
//            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
//        }
        mFab?.setOnClickListener {
//            val user: FName = FName()
//            var success: Boolean = false

            val inflater = layoutInflater
            val title = SpannableString("افزودن پوشه جدید")
            val dialogLayout = inflater.inflate(R.layout.dialog_layout, null)
            val editText  = dialogLayout.findViewById<EditText>(R.id.folder)

            title.setSpan(
                    AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                    0,
                    title.length,
                    0
            )

            val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)

                builder.setTitle(title)

            builder.setView(dialogLayout)
                builder.setPositiveButton("افزودن") { dialogInterface, i ->
                    if(editText.text.toString().trim().isNotEmpty()) {
                        val count = alert.count()
                        myListData.add(MyListData(editText.text.toString(), count))

                        recyclerView.apply {
                            layoutManager =
                                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            layoutManager
                            adapter = MyListAdapter(myListData)

                        }
//                        val adapter = MyListAdapter(myListData)
//
//
//                        recyclerView.adapter = adapter
//                        myListData.add(MyListData(editText.text.toString()))
//                        val user = FName(editText.text.toString())
//                        db.insertData(user)

//                            if (success) {
//                                Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show()
//
//                        }
//                        myListData.add(MyListData(editText.text.toString()))

                        Log.i("console", myListData.toString())
                    }

                    Toast.makeText(
                            applicationContext,
                            "نام پوشه شما هست: " + editText.text.toString(), Toast.LENGTH_SHORT
                    ).show() }
                builder.setNegativeButton("لغو"){ dilogInterface, i ->

                    Toast.makeText(
                            applicationContext,
                            "لغو ", Toast.LENGTH_SHORT
                    ).show()}

            builder.show()


//            Toast.makeText(
//                this@MainActivity,
//                "FAB Clicked",
//                Toast.LENGTH_SHORT
//            ).show()
        }

//        val relativeLayout: RelativeLayout = findViewById<View>(R.id.relativeLayout) as RelativeLayout
//        relativeLayout.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
////            var us :String? = null
//            startActivity(intent)
////            for (i in myListData.indices)  {
////                us = myListData[i].toString()
////                Toast.makeText(applicationContext, us, Toast.LENGTH_LONG).show()
////
////            }
//        }
//        val arrayAdapter: ArrayAdapter<*>
//        val mListView = findViewById<ListView>(R.id.listView)
//        arrayAdapter = ArrayAdapter(
//                this,
//                android.R.layout.simple_list_item_1,user
//        )
//        Toast.makeText(
//                this@MainActivity,
//                "one $user.toString()",
//                Toast.LENGTH_SHORT
//        ).show()
//        Log.i("console","$user")
//        mListView.setBackgroundResource(R.drawable.rounded)
//        mListView.adapter = arrayAdapter
//
//        mListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, positon, id ->
//            val intent = Intent(this, SecondActivity::class.java)
//            var us :String? = null
//            startActivity(intent)
//
//            for (i in user.indices) if (positon == i) {
//                us = user[i].toString()
//                Toast.makeText(applicationContext, us, Toast.LENGTH_LONG).show()
//
//            }
//
//        }


    }

}
