package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/*fun getWellnessTasks(): List<WellnessTask> = List(30) { i ->
    WellnessTask(i, "Task #$i")
}*/

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)

        val list: List<WellnessTask> = wellnessViewModel.tasks
        WellnessTasksList(list = list,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            }, onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
//    WaterCounterState(modifier)
//    WaterCounter(modifier)
}

@Preview(showBackground = true)
//@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun WellnessScreenPreview(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        val list: List<WellnessTask> = wellnessViewModel.tasks
        WellnessTasksList(list, onCheckedTask = { _, _ -> }, onCloseTask = { _ -> })
    }
//    WaterCounterState(modifier)
//    WaterCounter(modifier)
}