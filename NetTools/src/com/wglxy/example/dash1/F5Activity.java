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

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the activity for feature 5 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class F5Activity extends DashboardActivity 
{

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
    setContentView (R.layout.activity_f5);
    setTitleFromActivityLabel (R.id.title_text);
    
    final EditText url1 = (EditText) findViewById(R.id.url1);
    final Button button1 = (Button) findViewById(R.id.whois1);
    final TextView out1 = (TextView) findViewById(R.id.whoisout);
    out1.setMovementMethod(ScrollingMovementMethod.getInstance());

    final int port = 43;
    final String hostname = "whois.internic.net";


       
	  
	  button1.setOnClickListener(new Button.OnClickListener() {
		   	  
	         public void onClick(View v) {
	         	
	        	 
	        	    
	        	    try {
	        	    	Socket theSocket;
	        	        DataInputStream theWhoisStream;
             	         PrintStream ps;
	        	        
	        	  	      theSocket = new Socket(hostname, port, true);
	        	   	      ps = new PrintStream(theSocket.getOutputStream());
	        	   	      
	        	   	      String link = url1.getText().toString(); 	  
	        	   	      ps.print(link + " ");
	        	   	      ps.print("\r\n");
	        	   	      theWhoisStream = new DataInputStream(theSocket.getInputStream());
	        	   	      String s;
	        	   	      while ((s = theWhoisStream.readLine()) != null) {
			        		    	        out1.append(s);
	        	    	      }
        	    	    }
        	    	    catch (IOException e) {
        	    	      System.err.println(e);
        	    	    }
	        	    
	         }
	     });
	  
    
}}


