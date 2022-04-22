package com.example.puc.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.contentful.java.cda.CDAClient
import com.contentful.java.cda.CDAEntry
import com.example.puc.di.AppModule_GsonFactory.gson
import com.example.puc.ui.theme.PucTheme
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentClient().observe(CDAEntry::class.java)
            .one("2FveE9tGsZ5T7GDuz5xafD")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe() {
                var result: CDAEntry = it
                Log.i("Contentful", gson().toJson(result))
            }
        setContent {
            PucTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "", style = TextStyle(fontSize = 30.sp))
                    }
                }
            }
        }
    }
}

fun contentClient() : CDAClient = CDAClient.builder()
    .setSpace("prrpf83ftxuk")
    .setToken("h0--DW8uDwfNCxTGbt87wk6PbPTcaJHtePWLdY3XYSE")
    .build()

fun gson() : Gson = GsonBuilder().setPrettyPrinting().create()

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PucTheme {
        Greeting("Android")
    }
}