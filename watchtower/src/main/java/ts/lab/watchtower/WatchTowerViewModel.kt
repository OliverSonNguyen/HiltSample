package ts.lab.watchtower

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import ts.lab.watchtower.data.FeatureFlagItem
import ts.lab.watchtower.data.FeatureFlagMode
import ts.lab.watchtower.data.FeatureFlagVertical
import ts.lab.watchtower.data.WatchTowerItem
import ts.lab.watchtower.repo.WatchTowerRepo


data class FeatureList(
    val features: List<FeatureFlagItem>
)

data class WatchTowerItemList(val watchTowerItems: List<WatchTowerItem>)

class WatchTowerViewModel(
    val map: Map<FeatureFlagVertical, FeatureFlagItem>,
    val myset: Set<FeatureFlagItem>,
    val repo: WatchTowerRepo

) : ViewModel() {

    val uiState = MutableStateFlow(FeatureList(myset.toList()))
    val shareUiState: StateFlow<FeatureList> = uiState

    val watchTowerUiState = MutableStateFlow(WatchTowerItemList(emptyList()))
    val sharedWatchTowerUiState: StateFlow<WatchTowerItemList> = watchTowerUiState


    fun fetch() {

        myset.forEach {
            Timber.d(">>>set item:" + it.label)
        }
        val t = repo.initList(FeatureFlagVertical.WALLET)
        watchTowerUiState.update { WatchTowerItemList(t) }
    }

    fun changeMode(item: WatchTowerItem, mode: FeatureFlagMode) {
        val keyName = item.featureFlagItem.key


    }


}