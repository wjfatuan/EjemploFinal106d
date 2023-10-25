package co.edu.uan.android.ejemplofinal106d.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CatApi {

    @GET("/v1/images/search?limit=5")
    suspend fun search(): List<CatPhoto>

    companion object { // Metodo de fabrica

        fun getInstance() : CatApi {
            var retrofit = Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CatApi::class.java)
        }
    }
}