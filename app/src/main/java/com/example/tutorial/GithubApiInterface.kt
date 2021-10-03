package com.example.tutorial

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface GithubApiInterface {
//    @GET("users/{user}")
//    suspend fun getGithubUser(@Path("user") user: String): Response<List<User>>

    @GET("users")
    suspend fun getGithubUser(): Response<List<User>>

    @GET("users/{user}/repos")
    suspend fun getProjectList(@Path("user") user: String): Response<List<Project>>
}

data class User(

    @SerializedName("login") var login: String,
    @SerializedName("id") var id: Int,
    @SerializedName("node_id") var nodeId: String,
    @SerializedName("avatar_url") var avatarUrl: String,
    @SerializedName("gravatar_id") var gravatarId: String,
    @SerializedName("url") var url: String,
    @SerializedName("html_url") var htmlUrl: String,
    @SerializedName("followers_url") var followersUrl: String,
    @SerializedName("following_url") var followingUrl: String,
    @SerializedName("gists_url") var gistsUrl: String,
    @SerializedName("starred_url") var starredUrl: String,
    @SerializedName("subscriptions_url") var subscriptionsUrl: String,
    @SerializedName("organizations_url") var organizationsUrl: String,
    @SerializedName("repos_url") var reposUrl: String,
    @SerializedName("events_url") var eventsUrl: String,
    @SerializedName("received_events_url") var receivedEventsUrl: String,
    @SerializedName("type") var type: String,
    @SerializedName("site_admin") var siteAdmin: Boolean

)

data class Project(
    val userName: String,
    var id: Long,
    var name: String = userName,
    var full_name: String,
    var owner: User,
    var html_url: String,
    var description: String,
    var url: String,
    var created_at: Date,
    var updated_at: Date,
    var pushed_at: Date,
    var git_url: String,
    var ssh_url: String,
    var clone_url: String,
    var svn_url: String,
    var homepage: String,
    var stargazers_count: Int,
    var watchers_count: Int,
    var language: String?,
    var has_issues: Boolean,
    var has_downloads: Boolean,
    var has_wiki: Boolean,
    var has_pages: Boolean,
    var forks_count: Int,
    var open_issues_count: Int,
    var forks: Int,
    var open_issues: Int,
    var watchers: Int,
    var default_branch: String
)