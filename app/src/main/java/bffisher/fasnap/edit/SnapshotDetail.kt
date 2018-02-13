package bffisher.fasnap.edit

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import bffisher.fasnap.R

/**
 * A simple [InteractionFragment] subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 */
class SnapshotDetail : InteractionFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.edit_snapshot_detail, container, false)

        val addBtn = view.findViewById<Button>(R.id.edit_snapshot_detail_add_button)
        addBtn.setOnClickListener({ this.addHandler() })

        return view
    }

    private fun addHandler() {
        mFragmentInteractionListener?.changeFragment("AssetItem")
    }

    companion object {
        fun newInstance(): SnapshotDetail {
            return SnapshotDetail()
        }
    }
}// Required empty public constructor
