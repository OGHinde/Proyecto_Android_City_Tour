package com.example.citytour;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerActivity extends Activity implements OnItemSelectedListener{
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
		switch (parent.getId()){
			case R.id.spinnerCiudades:
			case R.id.spinnerRecorridos:
			case R.id.spinnerDuraciones:
		}
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
