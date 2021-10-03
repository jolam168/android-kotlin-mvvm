package com.example.tutorial

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GithubRepository {
    private var service: GithubApiInterface = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(GithubApiInterface::class.java)

    suspend fun getUserList(user: String) = service.getGithubUser()
}
