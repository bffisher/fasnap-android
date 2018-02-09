package bffisher.fasnap

import android.app.Activity
import android.app.Fragment
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import bffisher.fasnap.edit.MainFragment
import bffisher.fasnap.edit.OnFragmentInteractionListener

class MainActivity : Activity(), OnFragmentInteractionListener {
    private var home: Fragment? = null
    private var edit: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> fragmentManager.beginTransaction()
                    .replace(R.id.main_container, home).commit()
            R.id.navigation_edit -> fragmentManager.beginTransaction()
                    .replace(R.id.main_container, edit).commit()
        }
        item.isChecked = true
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        home = HomeFragment.newInstance()
        edit = MainFragment.newInstance()

        fragmentManager.beginTransaction().replace(R.id.main_container, home).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}
