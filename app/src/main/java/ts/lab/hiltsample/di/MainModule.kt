package ts.lab.hiltsample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet


data class People (val name : String = "")


@Module
@InstallIn(ActivityComponent::class)
object MainModule {
    @Provides
    @ActivityScoped
    fun provideString(): String = " provide String"

    @ActivityScoped
    @Provides
    @IntoSet
    fun provideInt(): Int = 11

    @ActivityScoped
    @Provides
    fun providepp() : People = People("son")

    @ActivityScoped
    @Provides
    @IntoSet
    fun provideInt2(): Int = 12

    @Provides
    @IntoSet
    fun provideInt13(): Int = 13

    @ElementsIntoSet
    @Provides
    fun provideList(): Set<Int> = hashSetOf<Int>(7, 8)


//    @Provides
//    fun provideVM(pp: People) : MainViewModel = MainViewModel(pp)
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @IntoSet
    fun app1() : Int = -1
}

@Module
@InstallIn(ViewComponent::class)
object ViewModule {
    @Provides
    @IntoSet
    fun app1() : Int = -1
}

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelComponent {
    @Provides
    @IntoSet
    fun app1() : Int = -1
}

@Module
@InstallIn(FragmentComponent::class)
object BindingModule {
    @FragmentScoped
    @Provides
    @IntoSet
    fun provideInt1(): Int = 1

    @ActivityScoped
    @Provides
    @IntoSet
    fun provideInt2(): Int = 2

}

@Module
@InstallIn(ActivityComponent::class)
object BindingModule2 {
    @Provides
    @IntoSet
    fun provideInt1(): Int = 3

    @Provides
    @IntoSet
    fun provideInt2(): Int = 4

}