package co.edu.uan.android.ejemplofinal106d.ui.dashboard

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.uan.android.ejemplofinal106d.database.Notification
import co.edu.uan.android.ejemplofinal106d.database.NotificationsDatabase
import co.edu.uan.android.ejemplofinal106d.service.CatApi
import co.edu.uan.android.ejemplofinal106d.service.CatPhoto
import com.google.gson.Gson
import com.koushikdutta.async.future.FutureCallback
import com.koushikdutta.ion.Ion
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.lang.Exception

class DashboardViewModel(val app: Application) : AndroidViewModel(app) {

    private val _catUrl = MutableLiveData<String>().apply {
        value = "https://cdn2.thecatapi.com/images/21v.jpg"
    }
    val catUrl: LiveData<String> = _catUrl

    fun refreshPhoto() {
        viewModelScope.launch {
            // llamo al API dentro de una corutina
            val cats = CatApi.getInstance().search()
            Log.d("CATAPI","API result: $cats")
            _catUrl.value = cats[0].url
            // generar notificacion de descarga de la foto
            try {
                val n = Notification("New photo: ${cats[0].url}")
                val dao = NotificationsDatabase.getInstance(app).notificationsDao()
                dao.create(n)
            } catch (e: Exception) {
                Log.e("CATAPI","ERROR: ${e.message}", e)
            }

        }
    }
}