package com.example.citytour;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MapActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		comenzarLocalizacion();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void mostrarPosicion(Location loc) {
		// Taken from http://www.sgoliver.net/blog/?p=1887
		TextView lblLatitud = (TextView)findViewById(R.id.LblPosLatitud);
		TextView lblLongitud = (TextView)findViewById(R.id.LblPosLongitud);
		TextView lblPrecision = (TextView)findViewById(R.id.LblPosPrecision);
	    if(loc != null)
	    {
	        lblLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
	        lblLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
	        lblPrecision.setText("Precision: " + String.valueOf(loc.getAccuracy()));
	    }
	    else
	    {
	        lblLatitud.setText("Latitud: (sin_datos)");
	        lblLongitud.setText("Longitud: (sin_datos)");
	        lblPrecision.setText("Precision: (sin_datos)");
	    }
	}
	
	private void comenzarLocalizacion(){
	    //Obtenemos una referencia al LocationManager
		LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
	 
	    //Obtenemos la última posición conocida
	    Location loc =
	        locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	 
	    //Mostramos la última posición conocida
	    mostrarPosicion(loc);
	 
	    // Location listener
		LocationListener locListener = new LocationListener() {
			TextView lblEstado = (TextView)findViewById(R.id.LblEst);
		    public void onLocationChanged(Location location) {
		        mostrarPosicion(location);
		    }
		 
		    public void onProviderDisabled(String provider){
		        lblEstado.setText("Provider OFF");
		    }
		 
		    public void onProviderEnabled(String provider){
		        lblEstado.setText("Provider ON");
		    }
		 
		    public void onStatusChanged(String provider, int status, Bundle extras){
		        lblEstado.setText("Provider Status: " + status);
		    }
		};
	 
	    locManager.requestLocationUpdates(
	        LocationManager.GPS_PROVIDER, 30000, 0, locListener);
	}
}
