package bffisher.fasnap;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

public class MainActivity extends Activity implements OnFragmentInteractionListener{
    private Fragment home;
    private Fragment edit;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, home).commit();
                    break;
                case R.id.navigation_edit:
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, edit).commit();
                    break;
            }
            item.setChecked(true);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        home = HomeFragment.newInstance();
        edit = EditFragment.newInstance(10);

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, home).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
