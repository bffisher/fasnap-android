package bffisher.fasnap.edit

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import bffisher.fasnap.R
import bffisher.fasnap.entity.SnapshotEntity

/**
 * [RecyclerView.Adapter] that can display a [SnapshotEntity] and makes a call to the
 * specified [AdapterView.OnItemClickListener].
 */
class ListItemRecyclerViewAdapter(private val mValues: List<SnapshotEntity>, private val mListener: AdapterView.OnItemClickListener?) : RecyclerView.Adapter<ListItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.edit_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mNameView.text = mValues[position].date
        holder.mAmountView.text = mValues[position].amount.toString()

        holder.mView.setOnClickListener {
            mListener?.onItemClick(null, holder.mView, position, 0)
        }
    }

    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mNameView: TextView = mView.findViewById<View>(R.id.list_item_name) as TextView
        val mAmountView: TextView = mView.findViewById<View>(R.id.list_item_amount) as TextView
        var mItem: SnapshotEntity? = null

        override fun toString(): String {
            return super.toString() + " '" + mAmountView.text + "'"
        }
    }
}
