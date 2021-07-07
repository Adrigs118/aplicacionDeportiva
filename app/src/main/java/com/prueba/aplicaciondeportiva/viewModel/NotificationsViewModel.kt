package com.prueba.aplicaciondeportiva.viewModel

import android.app.Notification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.NotificationEntity
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.NotificationRepository
import com.prueba.aplicaciondeportiva.server.APIService
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.prefab_notification.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NotificationsViewModel : ViewModel() {

    val repository = NotificationRepository(GymDatabase.getInstance(Utils.getApplicationContext())!!.notificationDao())
    val allNotifications = repository.notifications

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun getAllDietsObservers() : LiveData<List<NotificationEntity>> {
        return allNotifications
    }

    fun insert(entity : NotificationEntity) : Boolean{
        try{
            viewModelScope.launch {
                repository.insert(entity)
            }
            return true
        }
        catch (e :Exception){
            return false
        }
    }


    //region Api rest
    private fun getRetrofit() :Retrofit {
        return Retrofit.Builder().
            baseUrl("http://192.168.18.6:8080/").
            addConverterFactory(GsonConverterFactory.create()).
            build()
    }

    fun search(){
        if(Utils.notifications) {
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).getAll("/notifications")
                val notifications: List<NotificationEntity>? = call.body()
                if (call.isSuccessful) {
                    try {
                        for (element in notifications!!.iterator()) {
                            insert(element)
                        }
                    } catch (e: java.lang.Exception) {
                    }
                } else {
                    //show error
                }
            }
        }
    }

    private  fun showError() {
        Toast.makeText(Utils.getApplicationContext(), "Ha ocurrido un error en NotificationsViewModel", Toast.LENGTH_SHORT).show()
    }

    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var items: ArrayList<NotificationEntity> = ArrayList<NotificationEntity>()

        fun setListData(data: ArrayList<NotificationEntity>) {
            this.items = data
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.prefab_notification, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textViewName = itemView.textView_notification_title
            val textViewdescription = itemView.textView_notification_desc

            fun bind(data: NotificationEntity) {
                textViewName.text = data.title
                textViewdescription.text = data.description
            }

            /*init {
                itemView.setOnClickListener {
                    Utils.setDietContext(allDiets.value!![position])
                    navigateToDescription(itemView)
                }
            }
            */
        }
    }

    //endregion
}