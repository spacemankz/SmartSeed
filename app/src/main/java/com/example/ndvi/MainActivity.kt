package com.example.ndvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="http://example.com/"

class MainActivity : AppCompatActivity() {

    // private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()

    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Payload>?> {
            override fun onResponse(
                call: Call<List<Payload>?>,
                response: Response<List<Payload>?>
            ) {
                val responseType = response.body()!!

                val myStringBuilder = StringBuilder()
                for (myData in responseType) {
                    myStringBuilder.append(myData.text)

                }

                localtext.text = myStringBuilder //set information from api to text view localtext=textview id

            }
            override fun onFailure(call: Call<List<Payload>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ")
            }
        })
    }



       /* Mapbox.getInstance(applicationContext, getString(R.string.access_token))

        mapView = findViewById(R.id.mapbox)

        mapView.onCreate(savedInstanceState)*/

        }

   /* override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (outState != null) {
            mapView.onSaveInstanceState(outState)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }*/

    }
