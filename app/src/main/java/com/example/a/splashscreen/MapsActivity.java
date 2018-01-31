package com.example.a.splashscreen;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,LocationListener {

    double lat;
    double longi;
    LocationManager locationManager;
    private GoogleMap mMap;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);

        }

        fab=findViewById(R.id.fab);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
    }

    void getLocation() {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        }
        catch(SecurityException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
         mMap = googleMap;

        // Add a marker in Sydney and move the camera
        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(19.8895965,75.3133376))
                .anchor(0.5f, 0.5f)
                .title("Panchakki")
                /*.snippet("Snippet1")*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));

        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(19.9067035,75.3073241))
                .anchor(0.5f, 0.5f)
                .title("Soneri Mahal")
/*
                .snippet("Snippet2")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));

        Marker m3 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(19.9012092,75.3180665))
                .anchor(0.5f, 0.5f)
                .title("Bibi Ka Maqbara")
/*
                .snippet("Snippet3")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));

        Marker m4 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(19.9172516,75.3096931))
                .anchor(0.5f, 0.5f)
                .title("Buddha Caves Aurangabad")
/*
                .snippet("Snippet3")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));
        Marker m5 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.0265755,75.1667708))
                .anchor(0.5f, 0.5f)
                .title("Ellora Caves")
/*
                .snippet("Snippet3")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));
        Marker m6 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.0259351,75.1712958))
                .anchor(0.5f, 0.5f)
                .title("Grishneshwar Jyotirling")
/*
                .snippet("Snippet3")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));

        Marker m7 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(20.0102293,75.1940547))
                .anchor(0.5f, 0.5f)
                .title("Bhadra Maruti")
/*
                .snippet("Snippet3")
*/
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.mark)));

        LatLng sydney = new LatLng(19.870244,75.2351605);
/*
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
*/
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onLocationChanged(Location location) {
        lat=location.getLatitude();
        longi=location.getLongitude();
        Marker m8 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(lat,longi))
                .anchor(0.5f, 0.5f)
                .title("My Location")

                .snippet("Snippet3")

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
        LatLng sydney = new LatLng(lat,longi);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //Toast.makeText(MapsActivity.this,"Latitue :"+lat+" And Longitutde :"+longi,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
