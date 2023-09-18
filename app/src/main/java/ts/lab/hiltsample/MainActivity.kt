package ts.lab.hiltsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import timber.log.Timber
import ts.lab.hiltsample.ui.theme.HiltSampleTheme
import ts.lab.watchtower.WatchTowerActivity

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //    private val viewModel: MainViewModel by viewModels()
    @Inject
    lateinit var viewModel: MainViewModel

    @Inject
    lateinit var text: String

    @Inject
    lateinit var mySet: Set<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mySet.forEach {
                        Timber.d(">>>set item:$it")
                    }
                    Timber.d(">>>vm:${viewModel.test1()}")
                    Timber.d(">>>set:${mySet.size}")
                    Greeting("Android 1:" + text)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {

        Text(
            text = "Hello 123 $name!",
            modifier = modifier
        )
        Button(onClick = {
            context.startActivity(Intent(context, WatchTowerActivity::class.java))


        }) {
            Text(text = "Click me to WatTower")

        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltSampleTheme {
        Column {
            Greeting("Android")
            Button(onClick = {

            }) {
                Text(text = "Click me to WatTower")

            }

        }

    }
}