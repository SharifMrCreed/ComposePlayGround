package tech.bawano.composeplayground.components

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun CircularProgressIndicator(
    progress: Float,
    fontSize: TextUnit = 28.sp,
    indicatorSize: Dp = 12.dp,
    indicatorColor: Color = Color.Green,
    radius: Dp = 56.dp,
    animationDurationMillis: Int,
    animDelayMillis: Int = 0
) {
    var isAnimated by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        isAnimated = true
    }

    val progressAnimationConfig = animateFloatAsState(
        targetValue = if (isAnimated) progress else 0f,
        animationSpec = tween(
            durationMillis = animationDurationMillis,
            delayMillis = animDelayMillis,
            easing = EaseInOut
        )
    )
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //stroke using center
        Box(modifier = Modifier.size(radius * 2), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                    color = indicatorColor,
                    startAngle = -90f,
                    sweepAngle = 360 * progressAnimationConfig.value / 100,
                    useCenter = true, //if style is fill then set this to true
                    style = Stroke(width = indicatorSize.toPx(), cap = StrokeCap.Round)

                )
            }
            Text(
                text = progressAnimationConfig.value.toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.ExtraBold
            )
        }

        //stroke not using center

        Box(modifier = Modifier.size(radius * 2), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                    color = indicatorColor,
                    startAngle = -90f,
                    sweepAngle = 360 * progressAnimationConfig.value / 100,
                    useCenter = false, //if style is fill then set this to true
                    style = Stroke(width = indicatorSize.toPx(), cap = StrokeCap.Round)

                )
            }
            Text(
                text = progressAnimationConfig.value.toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.ExtraBold
            )
        }

        //fill using center
        Box(modifier = Modifier.size(radius * 2), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                    color = indicatorColor,
                    startAngle = -90f,
                    sweepAngle = 360 * progressAnimationConfig.value / 100,
                    useCenter = false, //if style is fill then set this to true
                    style = Fill

                )
            }
            Text(
                text = progressAnimationConfig.value.toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.ExtraBold
            )
        }

        //fill not using center
        Box(modifier = Modifier.size(radius * 2), contentAlignment = Alignment.Center) {
            Canvas(modifier = Modifier.size(radius * 2)) {
                drawArc(
                    color = indicatorColor,
                    startAngle = -90f,
                    sweepAngle = 360 * progressAnimationConfig.value / 100,
                    useCenter = true, //if style is fill then set this to true
                    style = Fill

                )
            }
            Text(
                text = progressAnimationConfig.value.toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.ExtraBold
            )
        }


    }


}

@Composable
fun CircularProgressIndicatorPreview() {
    var progress by remember {
        mutableStateOf(1f)
    }
    var key by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = key) {
        for (n in 1..100) {
            delay(250)
            progress = n.toFloat()
            if (n==100)key = !key
        }
    }

    CircularProgressIndicator(progress = progress, animationDurationMillis = 250)
}