package abika.sinau.assignmentweek3.adapter.viewHolder

import abika.sinau.assignmentweek3.model.ArticlesItem
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_headline.view.*

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 12 August 2020
 * Bismillahirrahmanirrahim
 */
class MenuHeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val headImg = itemView.hlImage
    val headSource = itemView.hlSumber
    val headTitle = itemView.hlJudul


    fun bindContent(menuItem: ArticlesItem) {
        headSource.text = menuItem.source?.name
        headTitle.text = menuItem.title
        Glide.with(itemView).load(menuItem.source).into(headImg)
    }
}