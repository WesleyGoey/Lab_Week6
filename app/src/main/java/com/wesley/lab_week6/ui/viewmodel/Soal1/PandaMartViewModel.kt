package com.wesley.lab_week6.ui.viewmodel.Soal1

import androidx.lifecycle.ViewModel
import com.wesley.lab_week6.ui.model.Soal1.Product
import com.wesley.lab_week6.ui.model.Soal1.ProductDummyData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PandaMartViewModel: ViewModel() {

    private val _searchCraving = MutableStateFlow("")
    val searchCraving: StateFlow<String> = _searchCraving.asStateFlow()
    private val _selectedButton = MutableStateFlow(0)
    val selectedButton: StateFlow<Int> = _selectedButton.asStateFlow()
    private val _searchFood = MutableStateFlow("")
    val searchFood: StateFlow<String> = _searchFood.asStateFlow()

    private val _listPopular = MutableStateFlow<List<Product>>(emptyList())
    val listPopular: StateFlow<List<Product>> = _listPopular.asStateFlow()
    private val _searchVegetables = MutableStateFlow("")
    val searchVegetables: StateFlow<String> = _searchVegetables.asStateFlow()

    private val _listFeatured = MutableStateFlow<List<Product>>(emptyList())
    val listFeatured: StateFlow<List<Product>> = _listFeatured.asStateFlow()

    fun searchingCraving(value: String) {
        _searchCraving.value = value
    }

    fun selectButton(index: Int) {
        _selectedButton.value = index
    }

    fun searchingFood(value: String) {
        _searchFood.value = value
    }
    fun loadPopular(){
        _listPopular.value = ProductDummyData.populerMenus.toList()
    }

    fun searchingVegetables(value: String) {
        _searchVegetables.value = value
    }

    fun loadFeatured(){
        _listFeatured.value = ProductDummyData.featuredProducts.toList()
    }


}