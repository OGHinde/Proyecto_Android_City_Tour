package com.example.citytour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Spinner de las ciudades
		Spinner spinnerCiudades = (Spinner) findViewById(R.id.spinnerCiudades);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterCiudades = ArrayAdapter.createFromResource(this,
		        R.array.array_ciudades, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterCiudades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerCiudades.setAdapter(adapterCiudades);
		spinnerCiudades.getOnItemSelectedListener();
		
		// Spinner de los recorridos
		Spinner spinnerRecorridos = (Spinner) findViewById(R.id.spinnerRecorridos);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterRecorridos = ArrayAdapter.createFromResource(this,
		        R.array.array_recorridos, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterRecorridos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerRecorridos.setAdapter(adapterRecorridos);
		
		// Spinner de las duraciones
		Spinner spinnerDuraciones = (Spinner) findViewById(R.id.spinnerDuraciones);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterDuraciones = ArrayAdapter.createFromResource(this,
		        R.array.array_duraciones, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterDuraciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerDuraciones.setAdapter(adapterDuraciones);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	

	public void showMadridPage(View view){	
		Intent intent = new Intent(this, InfoActivity.class);
		String url = getString(R.string.madrid_webpage);
		intent.putExtra("url", url);
		startActivity(intent);
	}
	
	
	public void showPzaEspañaPage(View view){
		Intent intent = new Intent(this, InfoActivity.class);
		String url = getString(R.string.wiki);
		intent.putExtra("url", url);
		startActivity(intent);
	}
	
}
