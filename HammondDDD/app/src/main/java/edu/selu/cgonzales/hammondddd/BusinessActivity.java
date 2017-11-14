package edu.selu.cgonzales.hammondddd;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.selu.cgonzales.hammondddd.Data.Business;
import edu.selu.cgonzales.hammondddd.Utils.BusinessArrayAdapter;

public class BusinessActivity extends AppCompatActivity {

    private static List<Business> businesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        Toolbar childToolbar = (Toolbar) findViewById(R.id.child_toolbar);
        setSupportActionBar(childToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String extraString;
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            extraString = intent.getStringExtra(SearchManager.QUERY);
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null){
                extraString = null;
            } else {
                extraString = (String) extras.get(Intent.EXTRA_TEXT);
            }
        }
        if (extraString != null){
            businesses = getBusinessList(extraString);
        }

        BusinessArrayAdapter adapter = new BusinessArrayAdapter(this, businesses);
        final ListView businessList = (ListView) findViewById(R.id.businessList);
        businessList.setAdapter(adapter);
        businessList.setEmptyView(findViewById(R.id.emptyBusinessView));
        businessList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Business business = businesses.get(position);
                HammondDDD context = (HammondDDD) getApplicationContext();
                context.setViewBusiness(business);
                openBusiness();
            }
        });
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

        List<Business> resultSet = new ArrayList<>();
        filterString = filterString.toLowerCase();
        for (Map.Entry<String, List<Business>> entry : context.getBusinessList().entrySet()){
            List<Business> tmp = entry.getValue();
            for (Business b : tmp){
                if (b.getName().toLowerCase().contains(filterString)){
                    resultSet.add(b);
                }
            }
        }
        return resultSet;
    }

    private void openBusiness(){
        Intent viewBusinessIntent = new Intent(this, ViewBusinessActivity.class);
        startActivity(viewBusinessIntent);
    }
}
