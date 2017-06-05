import android.util.Log

/**
 * Created by zxy on 2017/5/19.
 */
object LogUtils {
    private val TAG = "TestKotlin"
    fun d(info: String) {
        Log.d(TAG, info)
    }
}