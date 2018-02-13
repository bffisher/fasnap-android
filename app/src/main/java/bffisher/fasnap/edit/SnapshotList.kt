package bffisher.fasnap.edit

import android.content.Context
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import bffisher.fasnap.R

import bffisher.fasnap.entity.DummyContent

/**
 * A fragment representing a list of Snapshot.
 */
/**
 * Mandatory empty constructor for the fragment manager to instantiate the
 * fragment (e.g. upon screen orientation changes).
 */
class SnapshotList : InteractionFragment(), AdapterView.OnItemClickListener {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.edit_snapshot_list, container, false)

        val listView = view.findViewById<RecyclerView>(R.id.edit_snapshot_list_list)

        // Set the adapter
        val context = view.context
        listView.layoutManager = GridLayoutManager(context, 2)
        listView.adapter = ListItemRecyclerViewAdapter(DummyContent.ITEMS, this)

        val addBtn = view.findViewById<Button>(R.id.edit_snapshot_list_add_button)
        addBtn.setOnClickListener({ this.addHandler() })

        return view
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    private fun addHandler() {
        mFragmentInteractionListener?.changeFragment("SnapshotDetail")
    }

    companion object {
        fun newInstance(): SnapshotList {
            return SnapshotList()
        }
    }
}
