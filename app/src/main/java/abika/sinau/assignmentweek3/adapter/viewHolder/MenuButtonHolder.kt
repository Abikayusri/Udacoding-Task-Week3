package abika.sinau.assignmentweek3.adapter.viewHolder

import abika.sinau.assignmentweek3.R
import abika.sinau.assignmentweek3.model.Button
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 12 August 2020
 * Bismillahirrahmanirrahim
 */
class MenuButtonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val btnTitle = itemView.findViewById(R.id.hlButtonJudul) as TextView
    val btnDesc = itemView.findViewById(R.id.hlButtonSumber) as TextView

    fun bindContent(menuItem: Button) {
        btnTitle.text = menuItem.title
        btnDesc.text = menuItem.desc
    }
}