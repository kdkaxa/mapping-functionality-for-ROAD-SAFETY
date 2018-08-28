package com.example.pooja.mygooglemap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    private GoogleMap googleMap;
    private double latitude=21.5078;
    private double longitude=70.4517;
    private LatLng loc;
    private MarkerOptions mrk;
    private BitmapDescriptor icon;
    private CameraPosition cmp;
    private CameraUpdate cmpupt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        googleMap = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.place_map)).getMap();

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        loc=new LatLng(latitude, longitude);

        mrk=new MarkerOptions();

        icon= BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);

        mrk.icon(icon);
        mrk.title("Junagadh Moti..");

        mrk.position(loc);

        googleMap.addMarker(mrk);

        cmp= CameraPosition.builder().target(loc).zoom(16).build();

        cmpupt= CameraUpdateFactory.newCameraPosition(cmp);

        googleMap.animateCamera(cmpupt);


    }
}
