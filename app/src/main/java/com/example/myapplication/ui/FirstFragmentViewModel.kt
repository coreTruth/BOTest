package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.entity.SpyItem

class FirstFragmentViewModel: ViewModel() {
    private val _items = MutableLiveData<List<SpyItem>>()
    val items: LiveData<List<SpyItem>> get() = _items

    init {
        addMockData()
    }

    private fun addMockData() {
        _items.value = listOf(SpyItem(),
            SpyItem(
                rating = 2,
                distance = 15,
                score = 22,
                hint = "Hint2",
                author = "Author2"
            ),
            SpyItem(
                rating = 3,
                distance = 15,
                score = 22,
                hint = "Hint4",
                author = "Author4"
            ),
            SpyItem(
                rating = 4,
                distance = 17,
                score = 29,
                hint = "Hint3",
                author = "Author3"
            ),
            SpyItem(
                rating = 5,
                distance = 20,
                score = 273,
                hint = "Hint4",
                author = "Author4"
            ),
            SpyItem(
                rating = 6,
                distance = 20,
                score = 223,
                hint = "Hint5",
                author = "Author5"
            ),
            SpyItem(
                rating = 7,
                distance = 13,
                score = 22,
                hint = "Hint6",
                author = "Author6"
            ),
            SpyItem(
                rating = 2,
                distance = 15,
                score = 22,
                hint = "Hint7",
                author = "Author7"
            )
        )
    }

    fun addItem(hint: String) {
        _items.value = _items.value?.toMutableList()?.apply {
            add(SpyItem(
                hint = hint
            ))
        }
    }
}