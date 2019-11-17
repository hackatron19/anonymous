package com.sossmart.redwheelbarrow.sos_smart;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GPSService myGPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myGPS = new GPSService();

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
        // Update GPS location
        myGPS.getCurrentLocation();
        // Add a marker to local Position and move the camera
        //LatLng currentPosition = new LatLng(myGPS.latitude, myGPS.longitude);
        LatLng currentPosition = new LatLng(23.653601, 86.473181);
        mMap.addMarker(new MarkerOptions().position(currentPosition).title("Crashed here"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPosition));
        mMap.setMinZoomPreference(1.0f);
        mMap.setMaxZoomPreference(50.0f);
    }
}
