package com.jimmy.pizzaapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

private const val PRICE_PER_PIZZA = 8.00
private const val PRICE_PER_PIZZA_MARGARITA = 5.00
private const val PRICE_PER_DRINK = 1.00

class OrderViewModel : ViewModel() {

    private val _crust = MutableLiveData<String>()
    val crust: LiveData<String> = _crust

    private val _pizza = MutableLiveData<String>()
    val pizza: LiveData<String> = _pizza

    private val _drinks = MutableLiveData<String>()
    val drinks: LiveData<String> = _drinks

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance().format(it)
    }

    init {
        resetOrder()
    }

    fun setCrust(crustType: String){
         _crust.value = crustType


    }

    fun setPizza(pizza: String){
        _pizza.value = pizza
        if(_pizza.value == "MARGARITA"){
            updatePriceForMargarita()
        } else {
            updatePrice()
        }

    }

    fun setDrinks(drinks: String){
        _drinks.value = drinks
        updatePriceWithDrink()
    }



    fun hasNoCrust(): Boolean{
        return _crust.value.isNullOrEmpty()
    }

    fun resetOrder(){
        _crust.value = ""
        _pizza.value = ""
        _drinks.value = ""
        _price.value = 0.0
    }

    private fun updatePrice(){
        _price.value = PRICE_PER_PIZZA
    }

    private fun updatePriceForMargarita(){
        _price.value = PRICE_PER_PIZZA_MARGARITA
    }

    private fun updatePriceWithDrink(){
        _price.value = _price.value?.plus(PRICE_PER_DRINK)
    }

}