package ts.lab.watchtower.data

class WatchTowerItem(
    val featureFlagItem: FeatureFlagItem,
    val selectedMode: FeatureFlagMode = FeatureFlagMode.LOCAL_ONLY
) {
}