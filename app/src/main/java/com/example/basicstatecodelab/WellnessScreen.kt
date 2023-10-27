package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/*fun getWellnessTasks(): List<WellnessTask> = List(30) { i ->
    WellnessTask(i, "Task #$i")
}*/

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        var list: SnapshotStateList<WellnessTask> =
            remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
//    WaterCounterState(modifier)
//    WaterCounter(modifier)
}

@Preview(showBackground = true)
//@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun WellnessScreenPreview(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        val list: SnapshotStateList<WellnessTask> =
            remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list, onCloseTask = {})
    }
//    WaterCounterState(modifier)
//    WaterCounter(modifier)
}