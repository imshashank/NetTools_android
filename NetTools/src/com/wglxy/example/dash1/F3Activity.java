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

import java.net.InetAddress;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the activity for feature 3 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class F3Activity extends DashboardActivity 
{

	public String hostResolved;
    public String host;
    
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
    setContentView (R.layout.activity_f3);
    setTitleFromActivityLabel (R.id.title_text);
    
    final EditText eText = (EditText) findViewById(R.id.address);
    final TextView tView = (TextView) findViewById(R.id.output);
  
   
   final Button button1 = (Button) findViewById(R.id.button1);
   
   
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
}
    
} // end class
