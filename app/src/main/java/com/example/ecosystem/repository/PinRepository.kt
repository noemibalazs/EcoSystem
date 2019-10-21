package com.example.ecosystem.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecosystem.network.PinService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class PinRepository( val pinService:PinService) {

    inline fun <reified PinList> fetchList(crossinline call: (PinService) -> Call<PinList>): LiveData<PinList>{
        val result = MutableLiveData<PinList>()

        CoroutineScope(Dispatchers.IO).launch {
            val request = call(pinService)
            withContext(Dispatchers.Main){
                try {
                    request.enqueue(object :Callback<PinList>{

                        override fun onFailure(call: Call<PinList>, th: Throwable) {
                            Log.d("PinRepository", "onFailure message: ${th.message}")
                        }

                        override fun onResponse(call: Call<PinList>, response: Response<PinList>) {
                            if (!response.isSuccessful){
                                Log.d("PinRepository", "onResponse failure: ${response.code()}")
                            }

                            if (response.isSuccessful && response.body()!=null){
                                result.postValue(response.body())
                            }
                        }

                    })

                }catch (h: HttpException) {
                    Log.d("PinRepository", "Error getting response: ${h.message()}")
                } catch (t: Throwable) {
                    Log.d("PinRepository", "Ooops something really went wrong ${t.message}")
                }
            }

        }
        return result
    }
}