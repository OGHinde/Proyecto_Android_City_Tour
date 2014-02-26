package com.example.citytour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	String[] ciudad,recorrido,duracion;
	
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
		spinnerCiudades.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		        // your code here
		    	int index = parentView.getSelectedItemPosition();
                
	            // storing string resources into Array
	            ciudad = getResources().getStringArray(R.array.array_ciudades);
	                    
	            Toast.makeText(getBaseContext(), "You have selected : " +ciudad[index], Toast.LENGTH_SHORT).show();
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        // your code here
		    }

		});
		
		// Spinner de los recorridos
		Spinner spinnerRecorridos = (Spinner) findViewById(R.id.spinnerRecorridos);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterRecorridos = ArrayAdapter.createFromResource(this,
		        R.array.array_recorridos, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterRecorridos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerRecorridos.setAdapter(adapterRecorridos);
		spinnerRecorridos.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		        // your code here
		    	int index = parentView.getSelectedItemPosition();
                
	            // storing string resources into Array
	            recorrido = getResources().getStringArray(R.array.array_recorridos);
	                    
	            Toast.makeText(getBaseContext(), "You have selected : " +recorrido[index], Toast.LENGTH_SHORT).show();
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        // your code here
		    }

		});
		
		// Spinner de las duraciones
		Spinner spinnerDuraciones = (Spinner) findViewById(R.id.spinnerDuraciones);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterDuraciones = ArrayAdapter.createFromResource(this,
		        R.array.array_duraciones, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterDuraciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerDuraciones.setAdapter(adapterDuraciones);
		spinnerDuraciones.setOnItemSelectedListener(new OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		        // your code here
		    	int index = parentView.getSelectedItemPosition();
                
	            // storing string resources into Array
	            duracion = getResources().getStringArray(R.array.array_duraciones);
	                    
	            Toast.makeText(getBaseContext(), "You have selected : " +duracion[index], Toast.LENGTH_SHORT).show();
		    }

		    @Override
		    public void onNothingSelected(AdapterView<?> parentView) {
		        // your code here
		    }

		});
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
		String url = getString(R.string.pzaEspaña);
		intent.putExtra("url", url);
		startActivity(intent);
	}

}
