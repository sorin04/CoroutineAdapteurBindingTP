package com.example.etudiants.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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
        MainScope().launch(Dispatchers.Main) {
            try {
                val response = api.getEtudiant()
                if (response.code() == 200) {
                    Log.d("Response", response.body().toString())
                    response.body()?.let {
                        updateData(it as EtuItem)
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

    fun fetchAllData() {
        MainScope().launch(Dispatchers.Main) {
            try {
                val response = api.getAllEtudiants()
                if (response.code() == 200) {
                    Log.d("Response", response.body().toString())
                    response.body()?.let {
                        updateData(it as ArrayList<EtuItem>)
                    }
                }
            } catch (e: Exception) {

            }
        }
    }

    fun updateData(arNewData: ArrayList<EtuItem>) {
        _data.value = arNewData
    }

    fun updateData(newEtuItem: EtuItem) {
        _data.value?.add(newEtuItem)
    }
}