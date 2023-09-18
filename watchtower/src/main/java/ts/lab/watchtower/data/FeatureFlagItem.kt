package ts.lab.watchtower.data

enum class FeatureFlagType {
    TOGGLE, MULTI_OPTIONS, INPUT
}

enum class FeatureFlagMode {
    REMOTE_ONLY,
    LOCAL_ONLY
}

class FeatureFlagItem(
    val key: String = "n/a",
    val label: String = key,
    val type: FeatureFlagType = FeatureFlagType.TOGGLE,
    val mote: FeatureFlagMode = FeatureFlagMode.LOCAL_ONLY,
    val createDate: String? = null,
    val bgColor: String = "#000000",
    val vertical: FeatureFlagVertical = FeatureFlagVertical.UNKNOWN,
    val featureDataType: FeatureDataType = FeatureDataType.FeatureDataToggle(),
)

sealed class FeatureDataType {
    data class FeatureDataToggle(
        val defaultLocal: Boolean = false,
        val defaultRemote: Boolean = false,
        val currentSelected: () -> Boolean = { defaultLocal },
    ) : FeatureDataType()

    data class FeatureDataMultiOptions<T>(
        val options: List<Pair<T, String>>,
        val defaultOption: T
    ) : FeatureDataType()

    data class FeatureDataInput<T>(val defaultInput: T) : FeatureDataType()
}