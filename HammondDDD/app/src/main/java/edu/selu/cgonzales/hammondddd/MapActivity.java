package edu.selu.cgonzales.hammondddd;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import edu.selu.cgonzales.hammondddd.Utils.MapUtils;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng hammond = new LatLng(30.504358, -90.461197);
        LatLng stop1 = new LatLng(30.517316, -90.468857);
        LatLng stop2 = new LatLng(30.504612, -90.479336);
        LatLng stop3 = new LatLng(30.508551, -90.455016);
        LatLng stop4 = new LatLng(30.497199, -90.463793);
        mMap.addMarker(new MarkerOptions().position(stop1).title("Stop 1"));
        mMap.addMarker(new MarkerOptions().position(stop2).title("Stop 2"));
        mMap.addMarker(new MarkerOptions().position(stop3).title("Stop 3"));
        mMap.addMarker(new MarkerOptions().position(stop4).title("Stop 4"));
        mMap.addPolyline(new PolylineOptions().geodesic(true)
            .add(stop1)
            .add(stop2)
            .add(stop3)
            .add(stop4)
            .add(stop1)
        ); // Need to make this a little more filled out
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hammond, MapUtils.ZOOM_STREETS));
    }
}
