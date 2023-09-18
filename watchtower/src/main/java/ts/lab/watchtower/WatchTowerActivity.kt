package ts.lab.watchtower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import timber.log.Timber
import ts.lab.watchtower.data.FeatureDataType
import ts.lab.watchtower.data.FeatureFlagMode
import ts.lab.watchtower.ui.theme.HiltSampleTheme

@AndroidEntryPoint
class WatchTowerActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: WatchTowerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Timber.d(">>>hi Watch")
                    viewModel.fetch()
                    val uiList: FeatureList by viewModel.shareUiState.collectAsStateWithLifecycle()
                    val watchTowerUiState: WatchTowerItemList by viewModel.sharedWatchTowerUiState.collectAsStateWithLifecycle()

                    Greeting("Android", featureList = uiList, watchList = watchTowerUiState)
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String, modifier: Modifier = Modifier, featureList: FeatureList =
        FeatureList(
            emptyList()

        ),
    watchList: WatchTowerItemList = WatchTowerItemList(emptyList())
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp),

        ) {
        featureList.features.forEach { i ->
            item {
                Row {
                    Text(
                        text = "more " + i.label,
                        modifier = modifier
                    )
                    when (i.featureDataType) {
                        is FeatureDataType.FeatureDataToggle -> {
                            Checkbox(
                                checked = i.featureDataType.currentSelected.invoke(),
                                onCheckedChange = {

                                })
                        }

                        else -> {
                            Checkbox(checked = true, onCheckedChange = {

                            })
                        }
                    }

                }


            }

        }

        watchList.watchTowerItems.forEach { i->
            item {
                Column {
                    Text(
                        text = "more " + i.featureFlagItem.label,
                        modifier = modifier
                    )
                    RadioButton(
                        selected = i.selectedMode == FeatureFlagMode.REMOTE_ONLY,
                        onClick = {  },
                        )
                    RadioButton(
                        selected = i.selectedMode == FeatureFlagMode.LOCAL_ONLY,
                        onClick = {  },
                    )

//                    when(i.selectedMode) {
//                        FeatureFlagMode.LOCAL_ONLY -> {
//
//                        }
//                    }
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltSampleTheme {
        Greeting("Android")
    }
}