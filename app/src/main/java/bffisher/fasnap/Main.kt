package bffisher.fasnap

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView

typealias Home = bffisher.fasnap.home.Main
typealias Edit = bffisher.fasnap.edit.Main

class MainActivity : Activity() {
    private var home: Fragment = Home.newInstance()
    private var edit: Fragment = Edit.newInstance()
    private var current: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var target: Fragment? = null
        when (item.itemId) {
            R.id.navigation_home -> target = home
            R.id.navigation_edit -> target = edit
        }

        var ft = fragmentManager.beginTransaction().hide(current)
        if (target!!.isAdded) {
            ft.show(target).commit()
        } else {
            ft.add(R.id.main_container, target).commit()
        }
        current = target
        item.isChecked = true
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout._main)

        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        current = home
        fragmentManager.beginTransaction().add(R.id.main_container, home).commit()
    }
}
