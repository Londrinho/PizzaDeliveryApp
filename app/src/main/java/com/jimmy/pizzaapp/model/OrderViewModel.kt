package com.jimmy.pizzaapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _crust = MutableLiveData<String>()
    val crust: LiveData<String> = _crust

    private val _pizza = MutableLiveData<String>()
    val pizza: LiveData<String> = _pizza

    private val _drinks = MutableLiveData<String>()
    val drinks: LiveData<String> = _drinks

    fun setCrust(crustType: String){
         _crust.value = crustType
    }

    fun setPizza(pizza: String){
        _pizza.value = pizza
    }

    fun setDrinks(drinks: String){
        _drinks.value = drinks
    }

}