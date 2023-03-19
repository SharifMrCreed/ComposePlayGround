package tech.bawano.composeplayground.components

import android.util.Log
import android.view.MotionEvent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import kotlin.math.PI
import kotlin.math.atan


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RotatableImage(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    limitingValue: Float = 0f,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    callback: (rotationValue: Float) -> Unit = {}
) {
    var rotationAngle by remember {
        mutableStateOf(0f)
    }
    var centerOffset by remember {
        mutableStateOf(Offset(0f, 0f))
    }

    Image(
        painter,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxSize()
            .onGloballyPositioned {
                centerOffset =
                    Offset(it.boundsInWindow().size.width / 2, it.boundsInWindow().size.height / 2)
            }
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_MOVE -> {
                        //first get the angle subtended by the touch offset with center offset as center. check documentation
                        //for return type of atan - radius
                        val radian = atan((centerOffset.y - it.y) / (centerOffset.x - it.x))
                        rotationAngle = if (radian < 0f) {
                            (radian * (180 / PI)).toFloat() +360
                        } else (radian * (180 / PI)).toFloat()
                        Log.d(
                            "Rotating",
                            "RotatableImage:\n {\n\t " +
                                    "centerOffset: $centerOffset\n\t " +
                                    "touchOffset: ${it.x}, ${it.y} \n\t " +
                                    "radian: $radian \n\t " +
                                    "angle: $rotationAngle\n }"
                        )

                    }
                }


                true
            }
            .rotate(rotationAngle-360),
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter
    )

    callback(rotationAngle)

}


