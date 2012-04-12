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

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This is the activity for feature 4 in the dashboard application.
 * It displays some text and provides a way to get back to the home activity.
 *
 */

public class F4Activity extends DashboardActivity 
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
    setContentView (R.layout.activity_f4);
    setTitleFromActivityLabel (R.id.title_text);
    
    final EditText hex1 = (EditText) findViewById(R.id.hex);
    final TextView bin1 = (TextView) findViewById(R.id.bin1);
    final TextView long1 = (TextView) findViewById(R.id.long1);
    
    final Button button1 = (Button) findViewById(R.id.button1);
    
    	  
    	  button1.setOnClickListener(new Button.OnClickListener() {
    		   	    	       
    	          
    	          
    	         public void onClick(View v) {
    	         	
    	         	try {  
    	         		
    	         	String hex = hex1.getText().toString();
    	         	int i= Integer.parseInt(hex,16);
    	         	String by = Integer.toBinaryString(i);
    	          	  
    	          	bin1.setText(by);
    	          	  
    	          	  long num = Long.parseLong(hex,16);
    	          	  String num1= String.valueOf(num);
    	          	  long1.setText(num1);
    	         		} finally{
    	         		}
    	         		
    	         }  	  
    	        
    	     });
    	  
}
    
} 
