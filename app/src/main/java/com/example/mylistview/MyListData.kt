package com.example.mylistview

class MyListData(description: String , count: Int) {

    private var description: String
    private var count: Int = 0

    fun getDescription(): String {
        return description
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getImgId(): Int {
        return count
    }

    fun setImgId(imgId: Int) {
        this.count = imgId
    }

    init {
        this.description = description
        this.count = count

    }
}