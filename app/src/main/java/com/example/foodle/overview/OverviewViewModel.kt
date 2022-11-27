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

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
    }

    fun getData() {
        getKinsData()
        getJizzaData()
        getJclData()
        getJcmData()
        getCypressData()
        getFastData()
        getJ2Data()
        getLittlefieldData()
    }

    fun getKinsData() {
        // kins
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getKinsBreakfast()
                _kinsBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getKinsLunch()
                _kinsLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getKinsDinner()
                _kinsDinner.value = dinnerResult
                Log.d("test123", dinnerResult.toString())
            } catch (e: Exception) {
                Log.d("test123", "Error fetching Kins food data: ${e.message}")
                // Set empty values to prevent crashing
                _kinsBreakfast.value = listOf(FoodData("", "", ""))
                _kinsLunch.value = listOf(FoodData("", "", ""))
                _kinsDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getJcmData() {
        // Jester City Market
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJcmBreakfast()
                _jcmBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJcmLunch()
                _jcmLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJcmDinner()
                _jcmDinner.value = dinnerResult
                Log.d("test123", dinnerResult.toString())
            } catch (e: Exception) {
                Log.d("test123", "Error fetching JCM food data: ${e.message}")
                // Set empty values to prevent crashing
                _jcmBreakfast.value = listOf(FoodData("", "", ""))
                _jcmLunch.value = listOf(FoodData("", "", ""))
                _jcmDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getCypressData() {
        // Cypress Bend Cafe
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getCypressBreakfast()
                _cypressBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getCypressLunch()
                _cypressLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getCypressDinner()
                _cypressDinner.value = dinnerResult
                Log.d("test123", dinnerResult.toString())
            } catch (e: Exception) {
                Log.d("test123", "Error fetching Cypress food data: ${e.message}")
                // Set empty values to prevent crashing
                _cypressBreakfast.value = listOf(FoodData("", "", ""))
                _cypressLunch.value = listOf(FoodData("", "", ""))
                _cypressDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getFastData() {
        // Fast @ J2
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getFastBreakfast()
                _fastBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getFastLunch()
                _fastLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getFastDinner()
                _fastDinner.value = dinnerResult
                Log.d("test123", dinnerResult.toString())
            } catch (e: Exception) {
                Log.d("test123", "Error fetching Fast food data: ${e.message}")
                // Set empty values to prevent crashing
                _fastBreakfast.value = listOf(FoodData("", "", ""))
                _fastLunch.value = listOf(FoodData("", "", ""))
                _fastDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getJizzaData() {
        // jizza
        viewModelScope.launch {
            try {
                val breakfastResult = FoodApi.retrofitService.getJizzaBreakfast()
                _jestaBreakfast.value = breakfastResult
                val lunchResult = FoodApi.retrofitService.getJizzaLunch()
                _jestaLunch.value = lunchResult
                val dinnerResult = FoodApi.retrofitService.getJizzaDinner()
                _jestaDinner.value = dinnerResult
            } catch (e: Exception) {
                Log.d("OverviewViewModel", "Error fetching Jizza food data: ${e.message}")
                _jestaBreakfast.value = listOf(FoodData("", "", ""))
                _jestaLunch.value = listOf(FoodData("", "", ""))
                _jestaDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getJclData() {
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
                Log.d("OverviewViewModel", "Error fetching JCL food data: ${e.message}")
                _jclBreakfast.value = listOf(FoodData("", "", ""))
                _jclLunch.value = listOf(FoodData("", "", ""))
                _jclDinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getJ2Data() {
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
                Log.d("OverviewViewModel", "Error fetching J2 food data: ${e.message}")
                _j2Breakfast.value = listOf(FoodData("", "", ""))
                _j2Lunch.value = listOf(FoodData("", "", ""))
                _j2Dinner.value = listOf(FoodData("", "", ""))
            }
        }
    }

    fun getLittlefieldData() {
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
                Log.d("OverviewViewModel", "Error fetching Littlefield food data: ${e.message}")
                _littlefieldBreakfast.value = listOf(FoodData("", "", ""))
                _littlefieldLunch.value = listOf(FoodData("", "", ""))
                _littlefieldDinner.value = listOf(FoodData("", "", ""))

            }
        }
    }
}