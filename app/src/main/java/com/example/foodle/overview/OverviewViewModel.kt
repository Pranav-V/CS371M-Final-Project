package com.example.foodle.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodle.model.FoodData
import com.example.foodle.network.FoodApi
import kotlinx.coroutines.launch
import java.io.File

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request

    // JCL Data
    private val _jclBreakfast = MutableLiveData<List<FoodData>>()
    private val _jclLunch = MutableLiveData<List<FoodData>>()
    private val _jclDinner = MutableLiveData<List<FoodData>>()
    val jclBreakfast = _jclBreakfast
    val jclLunch = _jclLunch
    val jclDinner = _jclDinner

    // J2 Data
    private val _j2Breakfast = MutableLiveData<List<FoodData>>()
    private val _j2Lunch = MutableLiveData<List<FoodData>>()
    private val _j2Dinner = MutableLiveData<List<FoodData>>()
    val j2Breakfast = _j2Breakfast
    val j2Lunch = _j2Lunch
    val j2Dinner = _j2Dinner

    // Fast Data
    private val _fastBreakfast = MutableLiveData<List<FoodData>>()
    private val _fastLunch = MutableLiveData<List<FoodData>>()
    private val _fastDinner = MutableLiveData<List<FoodData>>()
    val fastBreakfast = _fastBreakfast
    val fastLunch = _fastLunch
    val fastDinner = _fastDinner

    // Kins Data
    private val _kinsBreakfast = MutableLiveData<List<FoodData>>()
    private val _kinsLunch = MutableLiveData<List<FoodData>>()
    private val _kinsDinner = MutableLiveData<List<FoodData>>()
    val kinsBreakfast = _kinsBreakfast
    val kinsLunch = _kinsLunch
    val kinsDinner = _kinsDinner

    // Jesta' Pizza Data
    private val _jestaBreakfast = MutableLiveData<List<FoodData>>()
    private val _jestaLunch = MutableLiveData<List<FoodData>>()
    private val _jestaDinner = MutableLiveData<List<FoodData>>()
    val jestaBreakfast = _jestaBreakfast
    val jestaLunch = _jestaLunch
    val jestaDinner = _jestaDinner

    // LittleField Data
    private val _littlefieldBreakfast = MutableLiveData<List<FoodData>>()
    private val _littlefieldLunch = MutableLiveData<List<FoodData>>()
    private val _littlefieldDinner = MutableLiveData<List<FoodData>>()
    val littlefieldBreakfast = _littlefieldBreakfast
    val littlefieldLunch = _littlefieldLunch
    val littlefieldDinner = _littlefieldDinner

    // Cypress Data
    private val _cypressBreakfast = MutableLiveData<List<FoodData>>()
    private val _cypressLunch = MutableLiveData<List<FoodData>>()
    private val _cypressDinner = MutableLiveData<List<FoodData>>()
    val cypressBreakfast = _cypressBreakfast
    val cypressLunch = _cypressLunch
    val cypressDinner = _cypressDinner

    // JCM Data
    private val _jcmBreakfast = MutableLiveData<List<FoodData>>()
    private val _jcmLunch = MutableLiveData<List<FoodData>>()
    private val _jcmDinner = MutableLiveData<List<FoodData>>()
    val jcmBreakfast = _jcmBreakfast
    val jcmLunch = _jcmLunch
    val jcmDinner = _jcmDinner


    // The external immutable LiveData for the request status
    val jclData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to jcmBreakfast,
        "lunch" to _jclLunch,
        "dinner" to _jclDinner
    )

    val j2Data: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _j2Breakfast,
        "lunch" to _j2Lunch,
        "dinner" to _j2Dinner
    )

    val fastData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _fastBreakfast,
        "lunch" to _fastLunch,
        "dinner" to _fastDinner
    )

    val kinsData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _kinsBreakfast,
        "lunch" to _kinsLunch,
        "dinner" to _kinsDinner
    )

    val jestaData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _jestaBreakfast,
        "lunch" to _jestaLunch,
        "dinner" to _jestaDinner
    )

    val littlefieldData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _littlefieldBreakfast,
        "lunch" to _littlefieldLunch,
        "dinner" to _littlefieldDinner
    )

    val cypressData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _cypressBreakfast,
        "lunch" to _cypressLunch,
        "dinner" to _cypressDinner
    )

    val jcmData: Map<String, MutableLiveData<List<FoodData>>> = mapOf(
        "breakfast" to _jcmBreakfast,
        "lunch" to _jcmLunch,
        "dinner" to _jcmDinner
    )

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getFoodData()
        println(kinsBreakfast.toString())
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getFoodData() {
        // kins
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getKinsBreakfast()
                _kinsBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getKinsBreakfast()
                _kinsLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getKinsDinner()
                _kinsDinner.value = dinnerResult
                Log.d("Kins", breakfastResult.toString())
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching Kins food data: ${e.message}")
            }
        }

        // jizza
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJizzaBreakfast()
                _jestaBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJizzaLunch()
                _jestaBreakfast.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJizzaDinner()
                _jestaBreakfast.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching Jizza food data: ${e.message}")
            }
        }

        // jizza
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJizzaBreakfast()
                _jestaBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJizzaLunch()
                _jestaBreakfast.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJizzaDinner()
                _jestaBreakfast.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching Jizza food data: ${e.message}")
            }
        }

        // jcl
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJclBreakfast()
                _jclBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJclLunch()
                _jclLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJclDinner()
                _jclDinner.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching JCL food data: ${e.message}")
            }
        }

        // j2
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJ2Breakfast()
                _j2Breakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJ2Lunch()
                _j2Lunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJ2Dinner()
                _j2Dinner.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching J2 food data: ${e.message}")
            }
        }

        // littlefield
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getLittlefieldBreakfast()
                _littlefieldBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getLittlefieldLunch()
                _littlefieldLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getLittlefieldDinner()
                _littlefieldDinner.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel","Error fetching J2 food data: ${e.message}")
            }
        }
    }
}