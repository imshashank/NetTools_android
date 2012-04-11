package com.android.nettools;
import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * @author shashank agarwal
 *
 */
public class DNS extends Activity{

	/**
	 * @param args
	 */
	
	@Override
	public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.index);	
	final EditText eText = (EditText) findViewById(R.id.address1);
    final TextView tView = (TextView) findViewById(R.id.pagetext1);
    final TextView port = (TextView) findViewById(R.id.port1);

   
    final Button portButton = (Button) findViewById(R.id.portScan1);

    
    
	  
	Button b = (Button) findViewById(R.id.btnClick);
	b.setOnClickListener(new View.OnClickListener() {
	public void onClick(View arg0) {
	Intent i = new Intent(DNS.this, NetToolsActivity.class);
	startActivity(i);
	         } 
	      });
	      
	
	
    portButton.setOnClickListener(new Button.OnClickListener() {
    	
	  	
    	public void onClick(View v)
    	
    	{
    		String temp1= eText.getText().toString();

			String temp = port.getText().toString();
			int i= Integer.parseInt(temp);

    		
    		try
            {
           	        			
    		Socket ServerSok = new Socket(temp1,i);
    		
    		ServerSok.close();
          
             tView.setText("Port in use: " + i );

             
            }
    		
       	 catch (Exception e)
            {

       		tView.setText("Port not in use: " + i );
            }
     
    		
    	}
    	
    	
    });


}
	}
