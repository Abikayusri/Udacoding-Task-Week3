package abika.sinau.assignmentweek3

import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_news.*

class DetailNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)
        swipeRefresh.setOnRefreshListener {
            loadWeb()
        }

        loadWeb()
    }

    private fun loadWeb() {
        swipeRefresh.isRefreshing = false
        val url = intent.getStringExtra("Url")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, URL: String?): Boolean {
                view?.loadUrl(URL)
                swipeRefresh.isRefreshing = false
                detailProgress.visibility = View.VISIBLE
                return true
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view?.loadUrl(request?.url.toString())
                    swipeRefresh.isRefreshing = false
                }
                detailProgress.visibility = View.VISIBLE
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing = false
                detailProgress.visibility = View.GONE
            }
        }
        webView.loadUrl(url)
    }

}
