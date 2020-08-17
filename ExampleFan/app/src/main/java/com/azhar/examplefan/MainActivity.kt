package com.azhar.examplefan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get data
        data
    }

    private val data: Unit
        private get() {
            AndroidNetworking.get("https://dev.farizdotid.com/api/purwakarta/kuliner/1")
                    .setPriority(Priority.LOW)
                    .build()
                    .getAsJSONObject(object : JSONObjectRequestListener {
                        override fun onResponse(response: JSONObject) {
                            try {
                                tvNama!!.text = response.getString("nama")
                                tvAlamat!!.text = response.getString("alamat")
                            } catch (e: JSONException) {
                                e.printStackTrace()
                            }
                        }

                        override fun onError(error: ANError) {
                            // handle error
                        }
                    })
        }
}