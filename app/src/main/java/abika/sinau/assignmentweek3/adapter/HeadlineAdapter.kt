//package abika.sinau.assignmentweek3.adapter
//
//import abika.sinau.assignmentweek3.DetailNewsActivity
//import abika.sinau.assignmentweek3.R
//import abika.sinau.assignmentweek3.model.ArticlesItem
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import kotlinx.android.synthetic.main.item_button.view.*
//import kotlinx.android.synthetic.main.item_headline.view.*
//import java.text.SimpleDateFormat
//
///**
// * Created by Abika Chairul Yusri
// * on Friday, 29 May 2020
// * Bismillahirrahmanirrahim
// */
//class HeadlineAdapter(var data: List<Any>?) :
//    RecyclerView.Adapter<HeadlineAdapter.HeadlineHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_headline, parent, false)
//
//        return HeadlineHolder(view)
//    }
//
//
//
////    val typeAdd = 0
////    val typeExercise = 1
////
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {
////        return if (viewType == typeAdd) {
////            //Create viewholder for your default cell
////            val view =
////                LayoutInflater.from(parent.context).inflate(R.layout.item_headline, parent, false)
////            HeadlineHolder(view)
////        } else {
////            //Create viewholder for your footer view
////            val view =
////                LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
////            HeadlineHolder(view)
////        }
////    }
//
//
//    override fun getItemCount(): Int {
//        return data?.size ?: 0
////        return data?.size!! + 1
//    }
//
//    override fun onBindViewHolder(holder: HeadlineHolder, position: Int) {
//        val context = holder.itemView.context
////        val date = data?.get(position)?.publishedAt
////
////        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
////        val newFormat = SimpleDateFormat("dd MMMM yyyy")
////        val newDate = newFormat.format(parser.parse(date))
//
//        holder.headSource.text = data?.get(position)?.source?.name
//        holder.headTitle.text = data?.get(position)?.title
//
//        Glide.with(context).load(data?.get(position)?.urlToImage).into(holder.headImg)
//
//        holder.itemView.setOnClickListener {
//            val intent = Intent(context, DetailNewsActivity::class.java)
//            intent.putExtra("Url", data?.get(position)?.url)
//            context.startActivity(intent)
//        }
//
//    }
//
////    override fun getItemViewType(position: Int): Int {
////
////        return when {
////            position <= data?.size!! -> {
////                typeExercise
////            }
////            position <= data?.size!! + 1 -> {
////                typeAdd
////            }
////            else -> {
////                typeAdd
////            }
////        }
////    }
//
//
//    class HeadlineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val headImg: ImageView = itemView.hlImage
//        val headSource: TextView = itemView.hlSumber
//        val headTitle: TextView = itemView.hlJudul
//
//        // Button
//        val btnImg = itemView.hlButtonImage
//        val btnTitle = itemView.hlButtonJudul
//        val btnDesc = itemView.hlButtonSumber
//    }
//}