package com.example.xcode.mygooglemapassignment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

    private static final int WIDTH_MAX = 50;

    private static final int HUE_MAX = 360;

    private static final int ALPHA_MAX = 255;

    private Polyline mMutablePolyline;

    private Polyline mClickablePolyline;

    private SeekBar mColorBar;

    private SeekBar mAlphaBar;

    private SeekBar mWidthBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        LatLng SheridanCollegeBrampton = new LatLng(43.655360, -79.738170);
        LatLng SheridanCollegeMississauga = new LatLng(43.593208, -79.642593);
        LatLng SheridanCollegeTraflgar = new LatLng(43.468601, -79.700432);

        final Marker SheridanBrampton = mMap.addMarker(new MarkerOptions().position(SheridanCollegeBrampton).title("Sheridan College Davis").snippet("Davis " +
                "Sheridan College").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        final Marker SheridanMississauga = mMap.addMarker(new MarkerOptions().position(SheridanCollegeMississauga).title("Sheridan College Hazel Mccallion").snippet("Mississauga " +
                "Sheridan College").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        final Marker SheridanTraflgar = mMap.addMarker(new MarkerOptions().position(SheridanCollegeTraflgar).title("Sheridan College Traflgar").snippet("Davis " +
                "Sheridan College").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SheridanCollegeBrampton, 10));

        CircleOptions circleOptions0 = new CircleOptions().center(SheridanCollegeBrampton).radius(500).fillColor(Color.GREEN);
        CircleOptions circleOptions1 = new CircleOptions().center(SheridanCollegeMississauga).radius(500).fillColor(Color.YELLOW);
        CircleOptions circleOptions2 = new CircleOptions().center(SheridanCollegeTraflgar).radius(500).fillColor(Color.BLUE);

        Circle circle0 = mMap.addCircle(circleOptions0);
        Circle circle1 = mMap.addCircle(circleOptions1);
        Circle circle2 = mMap.addCircle(circleOptions2);

        mMap.setOnInfoWindowClickListener(this);

        //mMap.setOnLongClickListener(this);


        mMap.addPolyline((new PolylineOptions())
                .add(SheridanCollegeBrampton, SheridanCollegeMississauga, SheridanCollegeTraflgar));


    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        // TODO Auto-generated method stub
        if (marker.getTitle().equals("Sheridan College Davis")) {
            Toast.makeText(getApplicationContext(), "1400 Students in this campus",
                    Toast.LENGTH_SHORT).show();
        }
        if (marker.getTitle().equals("Sheridan College Hazel Mccallion")) {
            Toast.makeText(getApplicationContext(), "600 Students in this campus",
                    Toast.LENGTH_SHORT).show();
        }
        if (marker.equals("Sheridan College Traflgar")) {
            Toast.makeText(getApplicationContext(), "1000 Students in this campus",
                    Toast.LENGTH_SHORT).show();
        }

    }
}
