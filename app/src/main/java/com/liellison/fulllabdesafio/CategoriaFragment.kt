package com.liellison.fulllabdesafio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import kotlinx.android.synthetic.main.fragment_categoria.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass.
 */
class CategoriaFragment : Fragment() {
    val BASE_URL = "https://desafio.mobfiq.com.br/"
    var str:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getCategories()
        val view: View = inflater.inflate(R.layout.fragment_categoria, container, false)
        return view
    }

    companion object{
        fun newInstance(): CategoriaFragment = CategoriaFragment()
    }

    fun getCategories() {

        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        var api = retrofit.create(ApiCategories::class.java)

        var call = api.categories

        call.enqueue(object : Callback<CategoriesList> {
            override fun onResponse(call: Call<CategoriesList>?, response: Response<CategoriesList>?) {

                var usres = response?.body()
                var user = usres?.categories
                var length = user!!.size

                for (i in 0 until length) {
                    str = str + "\n" + user.get(i).Id + " " + user.get(i).Name
                }

                tv_users!!.text = str
            }

            override fun onFailure(call: Call<CategoriesList>?, t: Throwable?) {
                Log.v("Error", t.toString())
            }
        })
    }


}
