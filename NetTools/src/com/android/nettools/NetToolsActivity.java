package com.android.nettools;



import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NetToolsActivity extends Activity {
    /** Called when the activity is first created. */
	
	 public long time1;
     public long time2;
     public long pingTime=0;
     public String link1;
     public long response;
     
     public String hostResolved;
     public String host;
     
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         final EditText eText = (EditText) findViewById(R.id.address);
         final TextView tView = (TextView) findViewById(R.id.pagetext);
         
         final TextView port = (TextView) findViewById(R.id.port);

             
      
              
        final Button button = (Button) findViewById(R.id.ButtonGo);
        
        final Button button1 = (Button) findViewById(R.id.button1);
        
        final Button portButton = (Button) findViewById(R.id.portScan);

                
        button.setOnClickListener(new Button.OnClickListener() {
        	
        	 public boolean ping() {
        	       link1 = "http://"+eText.getText().toString();

             	  	try {

                     URL url = new URL(link1);

             HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
             urlc.setRequestProperty("User-Agent", "Android Application:");
             urlc.setRequestProperty("Connection", "close");
             
             urlc.setConnectTimeout(100 * 30); // mTimeout is in seconds
             time1=System.currentTimeMillis(); 
             urlc.connect();
             time2=System.currentTimeMillis();
             response=urlc.getResponseCode();
             urlc.disconnect();
            pingTime = time2 - time1;
             if (urlc.getResponseCode() == 200) {
            	 
                // main.Log("getResponseCode == 200");
                   return new Boolean(true);
                   
             }
             
             else 
            	 
             { 
                 urlc.disconnect();
                 return new Boolean(false);}

             
             } catch (MalformedURLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
         } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
             }
         
     
         
					return false;}
                 
        
               	
            public void onClick(View v) {
            	
            						
        		if (ping()) 
             	{  	tView.setText("Site is online, Ping Time:" + pingTime ); }
    					
    					else 
    					{ tView.setText("Error !!!"); }

                }
                            	
        });
        
        
        
        button1.setOnClickListener(new Button.OnClickListener() {
        	
         
       	 public boolean DNS(String h1) throws UnknownHostException{
            	
       		InetAddress i1 = InetAddress.getByName(h1);
            	
      
                host = (i1.getHostAddress());
          	                 
            	return true;
            };
            
            
           public void onClick(View v) {
           	
           	try {  
           		//Checks for IP address from hostname
           		
           		String temp= eText.getText().toString();
           		
					if (DNS(temp))
						{      tView.setText(host); } 
								
					else 
						{ tView.setText("Error !!!"); }
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           	
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
           
        