package abika.sinau.assignmentweek3.network

import abika.sinau.assignmentweek3.network.Config.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 28 May 2020
 * Bismillahirrahmanirrahim
 */
class ConfigNetwork {

    companion object {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getRetrofitNews(): NewsService {
            val newsService = retrofit.create(NewsService::class.java)

            return newsService
        }

        fun getRetrofitHeadline(): HeadlineService {
            val headlineService = retrofit.create(HeadlineService::class.java)

            return headlineService
        }
    }
}