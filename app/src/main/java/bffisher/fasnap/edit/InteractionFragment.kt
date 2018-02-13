package bffisher.fasnap.edit

import android.app.Fragment
import android.content.Context

/**
 * Created by bffisher on 2018/02/12.
 */
open class InteractionFragment : Fragment(){
    protected var mFragmentInteractionListener: OnFragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val parentFragment = this.parentFragment
        if (parentFragment is OnFragmentInteractionListener) {
            mFragmentInteractionListener = parentFragment
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mFragmentInteractionListener = null
    }
}