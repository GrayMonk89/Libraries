package ru.graymonk.popularlibraries

class CountersModel {
    private val counter = mutableListOf(0, 0, 0)

    fun getCounter(position: Int): Int {
        return counter[position]
    }

    fun next(position: Int): Int{
        return counter[position]++
    }

    fun set(position: Int, value: Int){
        counter[position] = value
    }
}