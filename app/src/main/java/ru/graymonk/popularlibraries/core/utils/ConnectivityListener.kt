package ru.graymonk.popularlibraries.core.utils

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.PublishSubject

class ConnectivityListener(connectivityManager: ConnectivityManager) {

    private val subject = PublishSubject.create<Boolean>()

    init {
        val request = NetworkRequest.Builder().build()
        connectivityManager.requestNetwork(request, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                subject.onNext(true)
            }

            override fun onUnavailable() {
                subject.onNext(false)
            }

            override fun onLost(network: Network) {
                subject.onNext(false)
            }
        })
    }

    fun status(): Observable<Boolean> = subject

    fun statusSingle(): Single<Boolean> = subject.first(false)
}