package edu.selu.cgonzales.hammondddd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    openHome();
                    return true;
                case R.id.navigation_map:
                    openMap();
                    return true;
                case R.id.navigation_contact:
//                    mTextMessage.setText(R.string.title_contact);
                    return true;
            }
            return false;
        }

    };

    private Toolbar.OnMenuItemClickListener menuItemClickListener =
            new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.action_search:
                            System.out.println("Search");
                            return true;
//                    case R.id.action_contact:
//                        System.out.println("Contact");
//                        return true;
                        case R.id.action_settings:
                            System.out.println("Settings");
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar parentToolbar = (Toolbar) findViewById(R.id.parent_toolbar);
        setSupportActionBar(parentToolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        parentToolbar.setOnMenuItemClickListener(menuItemClickListener);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_toolbar, menu);
        return true;
    }

    public void openHome(){
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

    public void openMap(){
        Intent openMapIntent = new Intent(this, MapActivity.class);
        startActivity(openMapIntent);
    }

}
