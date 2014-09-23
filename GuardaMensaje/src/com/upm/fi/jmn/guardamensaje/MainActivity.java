package com.upm.fi.jmn.guardamensaje;

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	public static final String PREFS_NAME = "MyPrefsFile";
	public static final String MENSAJE = "mensaje";
	
	EditText editTextTexto;
	Button botonCargar;
	Button botonGuardar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String mensaje = settings.getString(MENSAJE,"");
        editTextTexto = (EditText) findViewById(R.id.editTextTexto);
        editTextTexto.setText(mensaje);
        
        botonGuardar = (Button) findViewById(R.id.botonGuardar);
        
        botonGuardar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences.Editor editor = settings.edit();
				EditText text = (EditText)findViewById(R.id.editTextTexto);
				String mensaje = text.getText().toString();
				editor.putString(MENSAJE, mensaje);
				editor.commit();
			}
		});
        
                
        botonCargar = (Button) findViewById(R.id.botonCargar);
        
        botonCargar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String mensaje = settings.getString(MENSAJE,"");
				EditText text = (EditText)findViewById(R.id.editTextTexto);
				text.setText(mensaje);
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
