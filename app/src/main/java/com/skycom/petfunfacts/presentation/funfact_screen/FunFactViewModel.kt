package com.skycom.petfunfacts.presentation.funfact_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skycom.petfunfacts.domain.repository.CatFactRepo
import com.skycom.petfunfacts.domain.repository.CatPicRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FunFactViewModel @Inject constructor(
    private val catFactRepo: CatFactRepo,
    private val catPicRepo: CatPicRepo
) : ViewModel(){

    private val _funFact = MutableStateFlow("")
    val funFact = _funFact

    init {
        fetchRandomCatImage()
        fetchRandomCatFact()
    }

    fun fetchRandomCatFact() {
        viewModelScope.launch(Dispatchers.IO) {
            var factData: String? = ""
            while (factData.isNullOrBlank()) {
                val response = catFactRepo.getCatFact()
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    factData = responseBody?.find { x -> x.status.verified }?.text
                    _funFact.value = factData ?: "Sorry, this cat is just not that funny :c"
                }
            }
        }
    }

    private val _imageData = MutableStateFlow<ByteArray?>(null)
    val imageData = _imageData

    fun fetchRandomCatImage() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = catPicRepo.getCatPic()
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    val imageData = responseBody.bytes()
                    _imageData.value = imageData
                }
            }
        }
    }
}