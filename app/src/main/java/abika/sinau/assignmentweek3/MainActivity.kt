package abika.sinau.assignmentweek3

import abika.sinau.assignmentweek3.adapter.HeadlineAdapter
import abika.sinau.assignmentweek3.adapter.NewsAdapter
import abika.sinau.assignmentweek3.model.ArticlesItem
import abika.sinau.assignmentweek3.model.Response
import abika.sinau.assignmentweek3.network.ConfigNetwork
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainSwipe.setOnRefreshListener {
            fetchData()
        }
        fetchData()
    }

    fun fetchData() {
        if (isConnected()) {
            mainSwipe.isRefreshing = false
            ConfigNetwork.getRetrofitNews().getDataNews().enqueue(object : Callback<Response> {
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    mainSwipe.isRefreshing = false
                    pbMain.visibility = View.GONE
                    Log.d("Error Server", t.message)
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    mainSwipe.isRefreshing = false
                    Log.d("Respon server", response.message())

                    if (response.isSuccessful) {
                        pbMain.visibility = View.GONE

                        val status = response.body()?.status
                        if (status == "ok") {
                            val data = response.body()?.articles
                            showNews(data)
                        }
                    }
                }
            })


            ConfigNetwork.getRetrofitHeadline().getDataHeadline()
                .enqueue(object : Callback<Response> {
                    override fun onFailure(call: Call<Response>, t: Throwable) {
                        pbMain.visibility = View.GONE
                        Log.d("Error Server", t.message)
                    }

                    override fun onResponse(
                        call: Call<Response>,
                        response: retrofit2.Response<Response>
                    ) {
                        Log.d("Respon server", response.message())

                        if (response.isSuccessful) {
                            pbMain.visibility = View.GONE

                            val status = response.body()?.status
                            if (status == "ok") {
                                val data = response.body()?.articles
                                showHeadline(data)
                            }
                        }
                    }
                })
        } else {
            mainSwipe.isRefreshing = false
            pbMain.visibility = View.GONE
            Log.d("Main Activity", "Device tidak connect")
            Toast.makeText(this, "Device tidak connect dengan internet", Toast.LENGTH_SHORT).show()
        }
    }

    fun isConnected(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }

    private fun showNews(data: List<ArticlesItem>?) {
        rvNews.adapter = NewsAdapter(data)
    }

    private fun showHeadline(data: List<ArticlesItem>?) {
        rvHeadline.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvHeadline.adapter = HeadlineAdapter(data)
    }
}
