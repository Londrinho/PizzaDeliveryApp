package com.jimmy.pizzaapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val PRICE_PER_PIZZA = 8.00

class OrderViewModel : ViewModel() {

    private val _crust = MutableLiveData<String>()
    val crust: LiveData<String> = _crust

    private val _pizza = MutableLiveData<String>()
    val pizza: LiveData<String> = _pizza

    private val _drinks = MutableLiveData<String>()
    val drinks: LiveData<String> = _drinks

    private val _price = MutableLiveData<Double>()
    val price: LiveData<Double> = _price

    init {
        resetOrder()
    }

    fun setCrust(crustType: String){
         _crust.value = crustType
    }

    fun setPizza(pizza: String){
        _pizza.value = pizza
        updatePrice()
    }

    fun setDrinks(drinks: String){
        _drinks.value = drinks
    }



    fun hasNoCrust(): Boolean{
        return _crust.value.isNullOrEmpty()
    }

    fun resetOrder(){
        _crust.value = ""
        _pizza.value = ""
        _drinks.value = ""
    }

    private fun updatePrice(){
        _price.value = PRICE_PER_PIZZA
    }

}