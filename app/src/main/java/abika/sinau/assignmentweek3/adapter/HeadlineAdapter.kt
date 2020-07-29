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
import kotlinx.android.synthetic.main.item_headline.view.*
import java.text.SimpleDateFormat

/**
 * Created by Abika Chairul Yusri
 * on Friday, 29 May 2020
 * Bismillahirrahmanirrahim
 */
class HeadlineAdapter(var data: List<ArticlesItem>?) :
    RecyclerView.Adapter<HeadlineAdapter.HeadlineHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_headline, parent, false)
        val holder = HeadlineHolder(view)

        return holder
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HeadlineHolder, position: Int) {
        val context = holder.itemView.context
        val date = data?.get(position)?.publishedAt

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val newFormat = SimpleDateFormat("dd MMMM yyyy")
        val newDate = newFormat.format(parser.parse(date))

        holder.headSource.text = data?.get(position)?.source?.name
        holder.headTitle.text = data?.get(position)?.title

        Glide.with(context).load(data?.get(position)?.urlToImage).into(holder.headImg)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailNewsActivity::class.java)
            intent.putExtra("Url", data?.get(position)?.url)
            context.startActivity(intent)
        }

    }

    class HeadlineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headImg = itemView.hlImage
        val headSource = itemView.hlSumber
        val headTitle = itemView.hlJudul

    }
}