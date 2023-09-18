package ts.lab.hiltsample

import androidx.lifecycle.ViewModel
import javax.inject.Inject
import timber.log.Timber
import ts.lab.hiltsample.di.People

//@HiltViewModel
class MainViewModel @Inject constructor(
//    val maps : Map<String, Int>,
     val mySet: Set<Int>,
    val pp : People
) : ViewModel() {
    fun test1() {
        Timber.d(">>> this is test1")
        Timber.d(">>>map size:" + mySet.size)

    }

    fun k1(): String = "k1"
}