package com.mindorks.framework.mvp.data.network

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    var token: String? = ""

    fun Token(token: String) {
        this.token = token;
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        token = request.header("app-key")
        val finalToken = "Bearer " + token
        request = request.newBuilder()
            .addHeader("Authorization", finalToken)
            .build()

        return chain.proceed(request)
    }

}