package tech.bawano.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.bawano.composeplayground.R
import tech.bawano.composeplayground.ui.theme.Typography

@Composable
fun ProfileView() {

}


@Composable
fun ImageWithGradientCaption(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String = "",
    title: String
) {
    Card(modifier = modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)) {
        Box(modifier = Modifier.height(200.dp), contentAlignment = Alignment.BottomCenter) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Black
                            ),
                            startY = 500f
                        )
                    ),
            )
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentSize(),
                text = title,
                style = Typography.bodyLarge,
                color = Color.White,
            )

        }

    }
}


@Preview
@Composable
fun Preview() {

    Box(
        modifier = Modifier
            .fillMaxWidth(0.45f)
            .wrapContentSize()
    ) {
        ImageWithGradientCaption(
            painter = painterResource(id = R.drawable.img),
            title = "An image of Sharif"
        )
    }


}


