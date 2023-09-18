package ts.lab.featurea.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import ts.lab.watchtower.data.FeatureDataType
import ts.lab.watchtower.data.FeatureFlagItem
import ts.lab.watchtower.data.FeatureFlagVertical
import ts.lab.watchtower.di.FeatureFlagVerticalKey


@Module
@InstallIn(ActivityComponent::class)
object WalletWatchTowerModule {
    @Provides
    @IntoMap
    @FeatureFlagVerticalKey(FeatureFlagVertical.WALLET)
    fun provideWalletFeatureA(): FeatureFlagItem = FeatureFlagItem(
        "Wallet A",
        label = "Wallet A Home Revamp",
        featureDataType = FeatureDataType.FeatureDataToggle(),
        vertical = FeatureFlagVertical.WALLET,
        createDate = "17-09-2023",
        bgColor = "#456765"
    )

    @Provides
    @IntoMap
    @FeatureFlagVerticalKey(FeatureFlagVertical.DEFI)
    fun provideWalletFeatureB(): FeatureFlagItem = FeatureFlagItem("Wallet A - 2")

    @Provides
    @IntoSet
    fun provideWalletFeatureASet(): FeatureFlagItem = FeatureFlagItem(
        "Wallet A",
        label = "Wallet A Home Revamp",
        featureDataType = FeatureDataType.FeatureDataToggle(false, false) {
                                                              true
        },
        vertical = FeatureFlagVertical.WALLET,
        createDate = "17-09-2023",
        bgColor = "#456765",

    )

    @Provides
    @IntoSet
    fun provideWalletFeatureA1Set(): FeatureFlagItem = FeatureFlagItem(
        "Wallet A1",
        label = "Wallet A1 Home Revamp",
        featureDataType = FeatureDataType.FeatureDataToggle(false, false) {
            false
        },
        vertical = FeatureFlagVertical.WALLET,
        createDate = "17-09-2023",
        bgColor = "#456765",

        )

    @Provides
    @IntoSet
    fun provideWalletFeatureBSet(): FeatureFlagItem = FeatureFlagItem("Wallet A - 2")


}