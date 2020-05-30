package abika.sinau.assignmentweek3.network

import abika.sinau.assignmentweek3.model.Response
import abika.sinau.assignmentweek3.network.Config.API_KEY
import abika.sinau.assignmentweek3.network.Config.COUNTRY
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Abika Chairul Yusri
 * on Friday, 29 May 2020
 * Bismillahirrahmanirrahim
 */
interface HeadlineService {
    @GET("top-headlines?country=${COUNTRY}&apiKey=${API_KEY}")
    fun getDataHeadline(): Call<Response>
}