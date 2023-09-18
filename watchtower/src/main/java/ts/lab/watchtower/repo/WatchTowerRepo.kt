package ts.lab.watchtower.repo

import javax.inject.Inject
import ts.lab.watchtower.data.FeatureFlagItem
import ts.lab.watchtower.data.FeatureFlagMode
import ts.lab.watchtower.data.FeatureFlagVertical
import ts.lab.watchtower.data.WatchTowerItem

class WatchTowerRepo @Inject constructor(
    val inputSet: Set<FeatureFlagItem>,
    ) {
    fun initList(filter: FeatureFlagVertical): List<WatchTowerItem> {
        val watchList = mutableListOf<WatchTowerItem>()
        var i = 1
        var mode: FeatureFlagMode = FeatureFlagMode.LOCAL_ONLY
        inputSet.forEach {
            if (i % 2 == 0) {
                mode = FeatureFlagMode.LOCAL_ONLY
            } else {
                mode = FeatureFlagMode.REMOTE_ONLY
            }
            watchList.add(WatchTowerItem(it, mode))
            i++
        }


        return watchList
    }
}