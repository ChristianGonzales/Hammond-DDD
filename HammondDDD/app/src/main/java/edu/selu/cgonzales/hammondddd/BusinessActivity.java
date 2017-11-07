package edu.selu.cgonzales.hammondddd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.selu.cgonzales.hammondddd.Data.Business;
import edu.selu.cgonzales.hammondddd.Utils.BusinessArrayAdapter;

public class BusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        Toolbar childToolbar = (Toolbar) findViewById(R.id.child_toolbar);
        setSupportActionBar(childToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String extraString;
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            extraString = null;
        } else {
            extraString = (String) extras.get(Intent.EXTRA_TEXT);
        }
        List<Business> businesses = getBusinessList(extraString);

        BusinessArrayAdapter adapter = new BusinessArrayAdapter(this, businesses);
        final ListView businessList = (ListView) findViewById(R.id.businessList);
        businessList.setAdapter(adapter);
        businessList.setEmptyView(findViewById(R.id.emptyBusinessView));
        // TODO - add an on click listener
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.child_toolbar, menu);
        return true;
    }

    public List<Business> getBusinessList(String filterString){
        if (filterString == null){
            return new ArrayList<>();
        }

        HammondDDD context = (HammondDDD) getApplicationContext();
        for (String c : context.getBusinessList().keySet()){
            if (c.equalsIgnoreCase(filterString)){
                return context.getBusinessList().get(c);
            }
        }

        // TODO - add a search for a query string

        return new ArrayList<>();
    }
}
