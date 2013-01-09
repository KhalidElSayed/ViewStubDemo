package com.michael.viewstubdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvList = (ListView)findViewById(R.id.lv_list);
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		for(int i = 0; i < 20; i++){
			
			map = new HashMap<String, String>();
			map.put("1234", "1234");
			data.add(map);
		}
		
		MainAdapter mainAdapter = new MainAdapter(this, data);
		lvList.setAdapter(mainAdapter);
	}

}
