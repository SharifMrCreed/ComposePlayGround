package tech.bawano.composeplayground.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tech.bawano.composeplayground.R
import kotlin.random.Random


@Composable
fun ChangePosition(
    modifier: Modifier = Modifier,
    changeAlignment: (alignment: Alignment) -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .background(color = Color.Green, shape = RoundedCornerShape(12))
                .wrapContentSize()
                .clickable {
                    val alignments = listOf(
                        Alignment.BottomCenter,
                        Alignment.BottomEnd,
                        Alignment.Center,
                        Alignment.BottomStart,
                        Alignment.CenterEnd,
                        Alignment.CenterStart,
                        Alignment.TopCenter,
                        Alignment.TopStart,
                        Alignment.TopEnd,
                    )
                    changeAlignment(
                        alignments[Random.nextInt(alignments.size)]
                    )

                }, text = "Change Alignment"
        )
    }
}



@Preview
@Composable
fun ChangeViewAlignmentPreview() {


    Box(modifier = Modifier.fillMaxSize()) {
        val alignment = remember {
            mutableStateOf(Alignment.TopStart)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.45f)
                .wrapContentSize()
                .align(alignment.value), contentAlignment = alignment.value
        ) {
            ImageWithGradientCaption(
                painter = painterResource(id = R.drawable.img),
                title = "An image of Sharif"
            )
        }

        ChangePosition(Modifier.align(Alignment.BottomCenter)) {
            alignment.value = it
        }



    }

}