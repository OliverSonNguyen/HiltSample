package ts.lab.watchtower.di

import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import ts.lab.watchtower.WatchTowerViewModel
import ts.lab.watchtower.data.FeatureFlagItem
import ts.lab.watchtower.data.FeatureFlagVertical
import ts.lab.watchtower.repo.WatchTowerRepo


@MapKey
annotation class FeatureFlagVerticalKey(val type: FeatureFlagVertical)

@Module
@InstallIn(ActivityComponent::class)
object WatchtowerModule {
    @Provides
    @IntoSet
    fun pw1(): Int = 100

    @Provides
    @IntoMap
    @FeatureFlagVerticalKey(FeatureFlagVertical.SAMPLE)
    fun providesample(): FeatureFlagItem = FeatureFlagItem("sample")


    @Provides
    fun provideWatchtowerViewModel(map: Map<FeatureFlagVertical, FeatureFlagItem>,
                                   myset: Set<FeatureFlagItem>,
                                   repo : WatchTowerRepo

                                   ): WatchTowerViewModel =
        WatchTowerViewModel(map, myset, repo)
}
