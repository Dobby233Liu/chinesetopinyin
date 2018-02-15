package com.l.chinesetopinyin;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View.*;
import com.l.chinesetopinyin.util.*;
/**
 * @author appfour
 * @author wenyuan
 **/
public class MainActivity extends Activity 
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		setOnClickListener(((Button)findViewById(R.id.c2p)),new View.OnClickListener(){
			public void onClick(View p1){
				ProgressDialog dialog = new ProgressDialog(MainActivity.this);
            
            dialog.setMessage("I'm converting");
            dialog.setIndeterminate(true);
            dialog.setCancelable(false);
            dialog.show();
				wrotePinyin(toPinyin());
				dialog.dismiss();
			}
		});
    }
	String getHanzi(){
		return ((EditText)findViewById(R.id.hz)).getText().toString();
	}
	void wrotePinyin(String p1){
	((EditText)findViewById(R.id.py)).setText(p1);
	}
	/**
	* @param view
	* @param listener
	**/
	void setOnClickListener(View view,OnClickListener listener){
		view.setOnClickListener(listener);
	}
	/**
	* @return The pinyin result decleared from util/To.java
	**/
	String toPinyin(){
		return(To.getPinYin(getHanzi()));
	}
	void comment(String p1){}
}
