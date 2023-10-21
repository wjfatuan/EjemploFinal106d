package co.edu.uan.android.ejemplofinal106d.ui.dashboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import org.json.JSONArray
import java.lang.Exception

class DashboardViewModel(val app: Application) : AndroidViewModel(app) {

    private val _catUrl = MutableLiveData<String>().apply {
        value = "https://cdn2.thecatapi.com/images/21v.jpg"
    }
    val catUrl: LiveData<String> = _catUrl

    fun refreshPhoto() {
        Ion.with(app)
            .load("https://api.thecatapi.com/v1/images/search")
            .asString()
            .setCallback(object: FutureCallback<String> {
                override fun onCompleted(e: Exception?, result: String?) {
                    val arr = JSONArray(result)
                    val cat = arr.getJSONObject(0)
                    _catUrl.value = cat.getString("url")
                }

            })
    }
}