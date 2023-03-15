package tech.bawano.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import tech.bawano.composeplayground.components.CircularProgressIndicatorPreview
import tech.bawano.composeplayground.components.ImageWithGradientCaption
import tech.bawano.composeplayground.ui.theme.ComposePlayGroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                        CircularProgressIndicatorPreview()
//                            CircularProgressIndicator(30f, animationDurationMillis = 1000)
                        }
                    }
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePlayGroundTheme {
        val title = "A Picture of Sharif"
        ImageWithGradientCaption(painter = painterResource(id = R.drawable.img), title = title, contentDescription = title)
    }
}