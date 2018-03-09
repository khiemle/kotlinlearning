package com.mingle.kotlinlearning.models.datasources

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager

class NetManager(private val context: Context) {
    private var status: Boolean? = false
    val isConnectedToInternet: Boolean?
        get() {
            val connManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val ni = connManager.activeNetworkInfo
            return ni != null && ni.isConnected

        }
}