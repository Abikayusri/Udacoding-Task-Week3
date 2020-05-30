package abika.sinau.assignmentweek3.adapter

import abika.sinau.assignmentweek3.DetailNewsActivity
import abika.sinau.assignmentweek3.R
import abika.sinau.assignmentweek3.model.ArticlesItem
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import java.text.SimpleDateFormat

/**
 * Created by Abika Chairul Yusri
 * on Thursday, 28 May 2020
 * Bismillahirrahmanirrahim
 */

class NewsAdapter(var data: List<ArticlesItem>?) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImg = itemView.newsImg
        val newsName = itemView.newsName
        val newsDate = itemView.newsDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        val holder = NewsHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val context = holder.itemView.context
        val date = data?.get(position)?.publishedAt

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val newFormat = SimpleDateFormat("dd MMMM yyyy")
        val newDate = newFormat.format(parser.parse(date))

        holder.newsName.text = data?.get(position)?.title
        holder.newsDate.text = newDate

        Glide.with(context).load(data?.get(position)?.urlToImage).into(holder.newsImg)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailNewsActivity::class.java)
            intent.putExtra("Url", data?.get(position)?.url)

            context.startActivity(intent)
        }
    }
}