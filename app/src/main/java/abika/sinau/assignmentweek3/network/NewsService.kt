package abika.sinau.assignmentweek3.network

import abika.sinau.assignmentweek3.model.Response
import abika.sinau.assignmentweek3.network.Config.API_KEY
import abika.sinau.assignmentweek3.network.Config.NEWS
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 28 May 2020
 * Bismillahirrahmanirrahim
 */
interface NewsService {
    @GET("everything?q=$NEWS&apiKey=$API_KEY")
    fun getDataNews(): Call<Response>
}