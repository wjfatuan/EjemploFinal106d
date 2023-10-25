package co.edu.uan.android.ejemplofinal106d.ui.notifications

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.edu.uan.android.ejemplofinal106d.database.Notification
import co.edu.uan.android.ejemplofinal106d.database.NotificationsDatabase
import kotlinx.coroutines.launch

class NotificationsViewModel(val app: Application) : AndroidViewModel(app) {

    val notifications = MutableLiveData<List<Notification>>()

    fun refreshNotifications() {
        viewModelScope.launch {
            val dao = NotificationsDatabase.getInstance(app).notificationsDao()
            val nots = dao.findAll()
            notifications.postValue(nots)
        }
    }
}