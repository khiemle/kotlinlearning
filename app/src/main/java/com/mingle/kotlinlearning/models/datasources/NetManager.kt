package com.mingle.kotlinlearning.models.datasources

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetManager @Inject constructor(var context: Context) {
    private var status: Boolean? = false
    val isConnectedToInternet: Boolean?
        get() {
            val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = connManager.activeNetworkInfo
            return ni != null && ni.isConnected

        }
}