package com.example.basicstatecodelab

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()

    val tasks: List<WellnessTask>
        get() = _tasks


}

fun getWellnessTasks(): List<WellnessTask> = List(30) { i ->
    WellnessTask(i, "Task #$i")
}