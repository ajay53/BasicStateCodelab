package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}*/

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}

//@Preview(showBackground = true, device  = Devices.DEFAULT)
//@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun WaterCounterPreview(modifier: Modifier = Modifier) {
//    WaterCounter(modifier)
}

//@Preview(showBackground = true, device = Devices.DEFAULT)
@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 720, heightDp = 360)
@Composable
fun WaterCounterStatePreview(modifier: Modifier = Modifier) {
    WaterCounterState(modifier = modifier)
}

@Composable
fun WaterCounterState(modifier: Modifier = Modifier) {
    var showTask by remember {
        mutableStateOf(false)
    }
    WaterCounter(showTask, { value -> showTask = value }, modifier = modifier)
//    WaterCounter(showTask, { showTask = true }, modifier = modifier)
}

@Composable
fun WaterCounter(showTask: Boolean, onShowTask: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(16.dp)) {
        var count by remember {
            mutableStateOf(0)
        }
        if (count > 0) {
            /*if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 min walk today?",
                    onClose = { onShowTask(false) })
//                    onClose = { showTask = false })
            }*/
            Text(
                text = "You've had $count glasses",
                modifier = modifier.padding(bottom = 10.dp)
            )
        }
        Row {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = "Drink water")
            }
            Button(onClick = { count = 0 }, modifier = Modifier.padding(start = 15.dp)) {
                Text(text = "Clear water count")
            }
            Button(
                onClick = { onShowTask(true) },
                enabled = true, modifier = Modifier.padding(start = 15.dp)
            ) {
                Text(text = "Show Task")
            }
        }
    }
}
