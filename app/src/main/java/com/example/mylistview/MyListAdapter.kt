package com.example.mylistview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyListAdapter(private val listdata: MutableList<MyListData>) :
        RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val myListData = listdata[position]
        holder.textView.text = listdata[position].getDescription()
        holder.counter.text = listdata[position].getImgId().toString()
        holder.relativeLayout.setOnClickListener { view ->
            val context= holder.relativeLayout.context
            val intent = Intent( context, SecondActivity::class.java)
            context.startActivity(intent)

            Toast.makeText(
                    view.context,
                    "click on item: " + myListData.getDescription(),
                    Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imageView: ImageView
        var textView: TextView = itemView.findViewById<View>(R.id.textView) as TextView
        var relativeLayout: RelativeLayout = itemView.findViewById<View>(R.id.relativeLayout) as RelativeLayout
        var counter : TextView = itemView.findViewById(R.id.counter) as TextView
        init {
//            imageView = itemView.findViewById<View>(R.id.imageView) as ImageView
        }
    }
    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }
}

//
//import android.content.ContentValues
//import android.content.Context
//import android.database.Cursor
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteException
//import android.database.sqlite.SQLiteOpenHelper
//import android.util.Log
//
///**
// * Created by Eyehunt Team on 07/06/18.
// */
//class DatabaseHandler(context: Context) :
//        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        val CREATE_TABLE = "CREATE TABLE (" + TABLE_NAME + ") "
//        db?.execSQL(CREATE_TABLE)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        // Called when the database needs to be upgraded
//    }
//
//    //Inserting (Creating) data
//    fun addUser(user: FName): Boolean {
//        //Create and/or open a database that will be used for reading and writing.
//        val db = this.writableDatabase
//        val values = ContentValues()
//        values.put(FIRST_NAME, user.fName)
//        val _success = db.insert(TABLE_NAME, null, values)
//        db.close()
//        Log.v("InsertedID", "$_success")
//        return (Integer.parseInt("$_success") != -1)
//    }
//
//    //get all users
////    fun getAllUsers(): ArrayList<FName> {
////        val allUser  = ArrayList<FName>()
////        val db = readableDatabase
////        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
////        val cursor = db.rawQuery(selectALLQuery, null)
////        if (cursor != null) {
////            var user: String
////            if (cursor.moveToFirst()) {
////                do {
////
////                     user = cursor.getString(cursor.getColumnIndex(FIRST_NAME))
////                    allUser.add(FName(user))
////
////                } while (cursor.moveToNext())
////            }
////        }
////        cursor.close()
////        db.close()
////        return allUser
////    }
//
//    fun getAllUsers():ArrayList<FName>{
//        val cities = ArrayList<FName>()
//        val db = writableDatabase
//        var cursor : Cursor? = null
//        try {
//            cursor = db.rawQuery("select * from " +
//                    DBContract.FnameEntry.FOLDER_NAME, null)
//        }catch (e: SQLiteException) {
//            db.execSQL(SQL_CREATE_ENTRIES)
//            return ArrayList()
//        }
//        var name : String
//
//        if (cursor!!.moveToFirst()){
//            while (!cursor.isAfterLast){
//                name = cursor.getString(cursor.getColumnIndex(DBContract.FnameEntry.FOLDER_NAME))
//
//
//                cities.add(FName(name))
//                cursor.moveToNext()
//            }
//        }
//        return cities
//    }
//    companion object {
//        private val DB_NAME = "UsersDB"
//        private val DB_VERSIOM = 1;
//        private val TABLE_NAME = "users"
//        private val FIRST_NAME = "FirstName"
//        private const val SQL_CREATE_ENTRIES =
//                "CREATE TABLE " + DBContract.FnameEntry.FOLDER_NAME
//    }
//}
//import android.content.ContentValues
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//import android.widget.Toast
//val DATABASENAME = "MY DATABASE"
//val TABLENAME = "Users"
//val COL_NAME = "name"
//val COL_AGE = "age"
//val COL_ID = "id"
//class DatabaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
//        1) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_AGE + " INTEGER)"
//        db?.execSQL(createTable)
//    }
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        //onCreate(db);
//    }
//    fun insertData(user: FName) {
//        val database = this.writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put(COL_NAME, user.fName)
//        val result = database.insert(TABLENAME, null, contentValues)
//        if (result == (0).toLong()) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
//        }
//        else {
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//        }
//    }
//    fun readData(): ArrayList<FName> {
//        val list = ArrayList<FName>()
//        val db = this.readableDatabase
//        val query = "Select * from $TABLENAME"
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                val user = FName()
//                user.fName = result.getString(result.getColumnIndex(COL_NAME))
//                list.add(user)
//            }
//            while (result.moveToNext())
//        }
//        return list
//    }
//}
//
//import android.content.ContentValues
//import android.widget.Toast
//
//val DATABASENAME = "MY DATABASE"
//val TABLENAME = "Users"
//val COL_NAME = "name"
//
//class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
//    1) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        val createTable = "CREATE TABLE " + TABLENAME + COL_NAME + "VARCHAR(256)"
//        db?.execSQL(createTable)
//    }
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        //onCreate(db);
//    }
//    fun insertData(fName: FName) {
//        val database = this.writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put(COL_NAME, fName.fName)
//        val result = database.insert(TABLENAME, null, contentValues)
//        if (result == (0).toLong()) {
//            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
//        }
//        else {
//            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
//        }
//    }
//    @SuppressLint("Recycle")
//    fun readData(): ArrayList<FName> {
//        val list = ArrayList<FName>()
//        val db = this.readableDatabase
//        val query = "Select * from $TABLENAME"
//        val result = db.rawQuery(query, null)
//        if (result.moveToFirst()) {
//            do {
//                val user = FName()
//                user.fName = result.getString(result.getColumnIndex(COL_NAME))
//                list.add(user)
//            }
//            while (result.moveToNext())
//        }
//        return list
//    }
//}

