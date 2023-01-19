package ru.graymonk.popularlibraries.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.graymonk.popularlibraries.utils.Constants

object NetworkProvider {

    val usersApi: UsersApi by lazy { createRetrofit().create(UsersApi::class.java) }

    private fun createGson() = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.CONST_SEVER_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}