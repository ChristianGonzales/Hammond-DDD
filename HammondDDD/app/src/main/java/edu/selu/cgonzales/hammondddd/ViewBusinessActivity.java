package edu.selu.cgonzales.hammondddd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.selu.cgonzales.hammondddd.Data.Business;

public class ViewBusinessActivity extends AppCompatActivity {

    private TextView businessName;
    private TextView businessLocation;
    private TextView businessPhone;
    private TextView businessCategory;
    private Button actionDirections;
    private Button actionWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_business);

        HammondDDD context = (HammondDDD) getApplicationContext();
        final Business business = context.getViewBusiness();

        businessName = (TextView) findViewById(R.id.view_business_name);
        businessLocation = (TextView) findViewById(R.id.view_business_location);
        businessPhone = (TextView) findViewById(R.id.view_business_phone);
        businessCategory = (TextView) findViewById(R.id.view_business_category);
        actionDirections = (Button) findViewById(R.id.view_action_directions);
        actionWebsite = (Button) findViewById(R.id.view_action_website);

        Toolbar childToolbar = (Toolbar) findViewById(R.id.child_toolbar);
        setSupportActionBar(childToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupLayoutText(business);

        actionDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = business.getLocation();
                Uri gmmIntentUri = Uri.parse("geo:30.504358,-90.461197?q=" + location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        actionWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = business.getWebsite();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(url));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.child_toolbar, menu);
        return true;
    }

    private void setupLayoutText(Business business){
        businessName.setText(business.getName());
        businessLocation.setText(business.getLocation());
        businessPhone.setText(business.getPhoneNumber());
        businessCategory.setText(business.getCategory());
    }
}
