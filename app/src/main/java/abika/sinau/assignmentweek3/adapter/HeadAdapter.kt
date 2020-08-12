package abika.sinau.assignmentweek3.adapter

import abika.sinau.assignmentweek3.R
import abika.sinau.assignmentweek3.adapter.viewHolder.MenuButtonHolder
import abika.sinau.assignmentweek3.adapter.viewHolder.MenuHeaderHolder
import abika.sinau.assignmentweek3.model.ArticlesItem
import abika.sinau.assignmentweek3.model.Button
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 12 August 2020
 * Bismillahirrahmanirrahim
 */
class HeadAdapter(private val data: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {

        private const val ITEM_HEADER = 0
        private const val ITEM_BUTTON = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)

        return when (viewType) {
            ITEM_BUTTON -> MenuButtonHolder(parent.inflate(R.layout.item_button))
            ITEM_HEADER -> MenuHeaderHolder(parent.inflate(R.layout.item_button))
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount(): Int {
        return data.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is Button -> ITEM_BUTTON
            is ArticlesItem -> ITEM_HEADER
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val context = holder.itemView.context
        val data = data[position]

        if (holder.itemViewType == ITEM_BUTTON) {
            val btnAdd = holder as MenuButtonHolder
            btnAdd.btnTitle.text = data.toString()
            btnAdd.btnDesc.text = data.toString()
        } else {
            val menuItem = data as ArticlesItem
            val itemHolder = holder as MenuHeaderHolder
            itemHolder.headTitle.text = menuItem.title
            itemHolder.headSource.text = menuItem.source?.name
            Glide.with(context).load(menuItem.source).into(itemHolder.headImg)
        }

        when (holder.itemViewType) {
            ITEM_BUTTON -> {
                val btnHolder = holder as MenuButtonHolder
                btnHolder.bindContent(data as Button)
            }
            ITEM_HEADER -> {
                val itemHeader = holder as MenuHeaderHolder
                itemHeader.bindContent(data as ArticlesItem)
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }
}