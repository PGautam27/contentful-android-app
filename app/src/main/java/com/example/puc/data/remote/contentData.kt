package com.example.puc.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.contentful.java.cda.CDAClient
import com.contentful.java.cda.CDAEntry
import com.contentful.java.cda.CDASpace
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*




fun content(){
    var type : String = "didn't work"

}

@SuppressLint("CheckResult")
fun newContent(){
//    contentClient()
//        .observeSpace()
//        .observeOn(AndroidSchedulers.mainThread()) // run code in the following action on main thread
//        .subscribeOn(Schedulers.io()) // run all other code (fetching, internet, etc) on different thread
//        .subscribe { space -> /*
//                 * Now that we have a space, we can find out the name of it. Thankfully the Contentful SDK has
//                 * already created an object based on the response from the Contentful API: A {@see CDASpace}.
//                 * This object does not contain all the entries of this space, it just allows us to retrieve the
//                 * general information of the space. Let us print the name we set in the WebApp of this space to
//                 * the command line.
//                 */
//            Log.i(
//                "contentfull", "accept: ${
//                    Collections.singletonList("name: <b>" + space.name() + "</b>")
//                }"
//            )
//        }
}
