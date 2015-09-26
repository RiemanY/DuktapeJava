package com.furture.react.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

import com.furture.react.JSApi;
import com.furture.react.demo.R;


/**
 * 
 * https://github.com/svaarala/duktape/commit/99807ae89be300c3c2f7923043bbb2e2792e3c43
 * 
 * */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		  
		 JSApi.registerJavaObject("http", new HttpApi());
		 JSApi.registerJavaObject("map", new MapApi(getApplicationContext()));
		
		
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
				intent.putExtra("file", "test_convert_number.js");
				startActivity(intent);
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
				intent.putExtra("file", "testRef.js");
				startActivity(intent);
			}
		});
		
		
       findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
				intent.putExtra("file", "testIntent.js");
				startActivity(intent);
			}
		});
       
       findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
		
		   @Override
		   public void onClick(View v) {
			   Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
			   intent.putExtra("file", "main.js");
			   startActivity(intent);
		   }
	    });
       
       
       
       findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
      		
		   @Override
		   public void onClick(View v) {
			   
			   Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
			   intent.putExtra("file", "http.js");
			   startActivity(intent);
		   }
	    });
       
       
       findViewById(R.id.button6).setOnClickListener(new OnClickListener() {
     		
		   @Override
		   public void onClick(View v) {
			   Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
			   intent.putExtra("file", "ui.js");
			   startActivity(intent);
		   }
	    });
       
       
       findViewById(R.id.button7).setOnClickListener(new OnClickListener() {
    		
		   @Override
		   public void onClick(View v) {
			   Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
			   intent.putExtra("file", "location.js");
			   startActivity(intent);
		   }
	    });
       
       /**
       findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
   		
		   @Override
		   public void onClick(View v) {
			   Intent intent = new Intent(getBaseContext(), ScriptTestActivity.class);
			   intent.putExtra("file", "asynctask.js");
			   startActivity(intent);
		   }
	    });*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private Reader readerFromAsset(String fileName) throws IOException {
		InputStream is = getAssets().open(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		return br;
 
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