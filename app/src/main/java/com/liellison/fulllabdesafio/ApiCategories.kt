package com.liellison.fulllabdesafio

import retrofit2.Call
import retrofit2.http.GET

interface ApiCategories {
    @get:GET("StorePreference/CategoryTree")
    val categories: Call<CategoriesList>
}