package com.example.etudiants.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.etudiants.pojo.EtuItem
import com.example.etudiants.retrofit.Api_Retroit.api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class EtuViewModel : ViewModel() {
    private val _data = MutableLiveData<ArrayList<EtuItem>>()
    val data: LiveData<ArrayList<EtuItem>> = _data

    fun initData() {
        val initialData = arrayListOf<EtuItem>()
        _data.value = initialData
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val response = api.getEtudiant()
                if (response.code() == 200) {
                    Log.d("Response", response.body().toString())
                    response.body()?.let {
                        val databuffer= arrayListOf<EtuItem>()
                        databuffer.add(it)
                        _data.value=databuffer
                    }
                }
            } catch (e: Exception) {
                Log.e("Erreur de fetch data", e.message.toString())

            }
        }
    }

    fun fetchAllData() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                val response = api.getAllEtudiants()
                if (response.code() == 200) {
                    Log.d("Response", response.body().toString())
                    response.body()?.let {
                        _data.value=it
                    }
                }
            } catch (e: Exception) {
                Log.e("Erreur de fetch data", e.message.toString())

            }
        }
    }

}