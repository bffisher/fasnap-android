package bffisher.fasnap.edit


import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import bffisher.fasnap.R


/**
 * A simple [Fragment] subclass.
 * Use the [Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class Main : Fragment(), OnFragmentInteractionListener {
    private var list: Fragment? = null
    private var curFragment: Fragment? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.edit_main, container, false)

        list = SnapshotList.newInstance()
        curFragment = list
        childFragmentManager.beginTransaction().add(R.id.edit_main_container, list, "SnapshotList").commit()
        return view
    }

    override fun changeFragment(uri: String) {
        var fragment: Fragment? = childFragmentManager.findFragmentByTag(uri)
        var ft = childFragmentManager.beginTransaction().hide(curFragment)
        if (fragment == null) {
            when (uri) {
                "SnapshotDetail" -> {
                    fragment = SnapshotDetail.newInstance()
                }
                "AssetItem" ->{
                    fragment = AssetItem.newInstance()
                }
            }
            ft.add(R.id.edit_main_container, fragment, uri).commit()
        } else {
            ft.show(fragment).commit()
        }
        curFragment = fragment
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Main.
         */
        fun newInstance(): Main {
            return Main()
        }
    }

}// Required empty public constructor
