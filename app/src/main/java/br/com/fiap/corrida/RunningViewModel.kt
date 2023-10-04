import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class RunningViewModel : ViewModel() {
    val runningIsFinished1 = MutableLiveData<Int>()
    val runningIsFinished2 = MutableLiveData<Int>()

    suspend fun calculateRunning(progressHorse: Int, horseNumber: Int) {
        val result = withContext(Dispatchers.Default) {
            async {
                delay(1500)
                calculate(progressHorse)
            }.await()
        }
        if (horseNumber == 1) {
            runningIsFinished1.postValue(result)
        } else if (horseNumber == 2) {
            runningIsFinished2.postValue(result)
        }
    }

    private fun calculate(sequenceNumber: Int): Int {
        val random = kotlin.random.Random.nextInt(1, 21)
        return sequenceNumber + random
    }
}
