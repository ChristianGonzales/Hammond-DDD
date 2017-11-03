package edu.selu.cgonzales.hammondddd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import edu.selu.cgonzales.hammondddd.Data.Event;
import edu.selu.cgonzales.hammondddd.Utils.BusinessesArrayAdapter;
import edu.selu.cgonzales.hammondddd.Utils.EventsArrayAdapter;

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        final HammondDDD context = (HammondDDD) this.getApplicationContext();

        BusinessesArrayAdapter adapter = new BusinessesArrayAdapter(this, context.getBusinessList().get("eat"));
        final ListView businessList = (ListView) findViewById(R.id.businessList);
        businessList.setAdapter(adapter);
        businessList.setEmptyView(findViewById(R.id.emptyBusinessView));
        businessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // do something
            }
        });

        Toolbar childToolbar = (Toolbar) findViewById(R.id.child_toolbar);
        setSupportActionBar(childToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.child_toolbar, menu);
        return true;
    }
}
