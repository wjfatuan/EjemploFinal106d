package co.edu.uan.android.ejemplofinal106d.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val myData = MutableLiveData<String>().apply {
        value = "default value"
    }

    fun changeData(newvalue: Int) {
        // validar q el nuevo valor siga las reglas de negocio
        // hacer los calculos
        viewModelScope.launch {
            myData.value = "My new value is $newvalue"
        }
    }

    
}