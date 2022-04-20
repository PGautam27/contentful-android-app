package com.example.puc.data.remote

import android.util.Log
import com.contentful.java.cda.CDAClient
import com.contentful.java.cda.CDAEntry
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


fun contentClient() : CDAClient = CDAClient.builder()
    .setSpace("8k4vsqea01z5")
    .setToken("ntTX3V0m1T9acGRiZ-M0_-eIu2ME9YlkBeGJqJrOkUY")
    .build()

fun gson() : Gson = GsonBuilder().setPrettyPrinting().create()

class ContentData {

    private val contentItem = MutableStateFlow<String>("hi")
    val content = contentItem.asStateFlow()

    operator fun invoke() = flow<String> {
        contentClient().observe(CDAEntry::class.java)
            .one("10HHTERTXsvg2Wx3r5ui4i")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Subscriber<CDAEntry?> {
                var result: CDAEntry? = null
                fun onCompleted() {
                    Log.i("Contentful", gson().toJson(result))
                }

                override fun onError(error: Throwable?) {
                    Log.e("Contentful", "could not request entry", error)
                }

                override fun onNext(cdaEntry: CDAEntry?) {
                    result = cdaEntry
                }

                override fun onSubscribe(s: Subscription?) {
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    contentItem.value = gson().toJson(result)
                }
            })
    }


}