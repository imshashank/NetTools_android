/*
 * Copyright (C) 2011 Wglxy.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wglxy.example.dash1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the activity for feature 2 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class F2Activity extends DashboardActivity 
{

	public long time1;
    public long time2;
    public long pingTime=0;
    public String link1;
    public long response;

    
/**
 * onCreate
 *
 * Called when the activity is first created. 
 * This is where you should do all of your normal static set up: create views, bind data to lists, etc. 
 * This method also provides you with a Bundle containing the activity's previously frozen state, if there was one.
 * 
 * Always followed by onStart().
 *
 * @param savedInstanceState Bundle
 */

protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView (R.layout.activity_f2);
    setTitleFromActivityLabel (R.id.title_text);
    
    final EditText eText = (EditText) findViewById(R.id.address);
    final TextView tView = (TextView) findViewById(R.id.pagetext);
           
    final Button button = (Button) findViewById(R.id.ButtonGo);
   
   

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

   
}
    
} // end class
