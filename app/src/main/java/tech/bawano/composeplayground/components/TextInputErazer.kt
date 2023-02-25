package tech.bawano.composeplayground.components

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.bawano.composeplayground.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputEraser(
    modifier: Modifier = Modifier,
    remText: String,
    setText: (text: String) -> Unit
) {
//    val remText = remember {
//        mutableStateOf(text)
//    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = remText)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            value = remText,
            label = {
                    Row {
                        Icon(modifier = Modifier.size(32.dp), painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "")
                        Text(text = "SomeText")
                    }
            },
            onValueChange = {
                setText(it)
            })
        Button(onClick = {

            setText("")
        }) {
            Text(text = "Erase All")
        }
    }
}


@Preview
@Composable
fun TextInputEraserPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
    ) {
        val text = remember {
            mutableStateOf("")
        }

        TextInputEraser(remText = text.value) {
            text.value = it
        }
    }
}