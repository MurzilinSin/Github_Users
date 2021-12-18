package com.example.client_github.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.util.Log
import androidx.core.content.getSystemService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

const val tag = "network"
class AndroidNetworkStatus(context: Context): INetworkStatus {
    private val statusSubject: BehaviorSubject<Boolean> = BehaviorSubject.create()

    init {
        statusSubject.onNext(false)
        val connectivityManager = context.getSystemService<ConnectivityManager>()
        val request = NetworkRequest.Builder().build()
        connectivityManager?.registerNetworkCallback(request, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                statusSubject.onNext(true)
                Log.d(tag,"NETWORK STATUS onAvailable")
            }

            override fun onUnavailable() {
                statusSubject.onNext(false)
                Log.d(tag,"NETWORK STATUS onUNAVAILABLE")
            }

            override fun onLosing(network: Network, maxMsToLive: Int) {
                statusSubject.onNext(false)
                Log.d(tag,"NETWORK STATUS onLosing")
            }

            override fun onLost(network: Network) {
                Log.d(tag,"NETWORK STATUS onLOST")
            }
        })
    }

    override fun isOnline(): Observable<Boolean> {
        return statusSubject
    }

    override fun isOnlineSingle(): Single<Boolean> {
        return statusSubject.first(false)
    }
}