package edu.selu.cgonzales.hammondddd;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.selu.cgonzales.hammondddd.Data.Event;
import edu.selu.cgonzales.hammondddd.Utils.EventsArrayAdapter;

public class MainActivity extends AppCompatActivity {

    public Toolbar.OnMenuItemClickListener parentToolbarListener =
        new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_search:
                        System.out.println("Search");
                        return true;
                    case R.id.action_contact:
                        openContact();
                        return true;
//                    case R.id.action_settings:
//                        System.out.println("Settings");
//                        return true;
                }
                return false;
            }
        };

    private NavigationView.OnNavigationItemSelectedListener navDrawerItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_map:
                    openMap();
                    return true;
                case R.id.navigation_eat:
                    openBusiness("eat");
                    return true;
                case R.id.navigation_drink:
                    return true;
                case R.id.navigation_shop:
                    return true;
                case R.id.navigation_play:
                    return true;
                case R.id.navigation_more:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar parentToolbar = (Toolbar) findViewById(R.id.parent_toolbar);
        setSupportActionBar(parentToolbar);
        parentToolbar.setOnMenuItemClickListener(parentToolbarListener);

        NavigationView navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(navDrawerItemSelectedListener);

        final HammondDDD context = (HammondDDD) this.getApplicationContext();

        EventsArrayAdapter adapter = new EventsArrayAdapter(this, context.getEventList());
        final ListView eventsList = (ListView) findViewById(R.id.eventsList);
        eventsList.setAdapter(adapter);
        eventsList.setEmptyView(findViewById(R.id.emptyEventsView));
        eventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Event event = context.getEventList().get(position);
                String location = event.getLocation();
                Uri gmmIntentUri = Uri.parse("geo:30.504358,-90.461197?q=" + location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.parent_toolbar, menu);
        return true;
    }

    public void openMap(){
        Intent openMapIntent = new Intent(this, MapActivity.class);
        startActivity(openMapIntent);
    }

    public void openContact(){
        Intent openContactIntent = new Intent(this, ContactActivity.class);
        startActivity(openContactIntent);
    }

    public void openBusiness(String category){
        Intent openBusinessIntent = new Intent(this, BusinessActivity.class);
        startActivity(openBusinessIntent);
    }
}
