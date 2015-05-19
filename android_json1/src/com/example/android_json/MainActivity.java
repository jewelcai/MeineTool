package com.example.android_json;

import java.util.List;
import java.util.Map;

import domain.Person;
import json.JsonTools;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	private Button person, persons, liststring, listmap;
	private static final String TAG = "Main";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		person = (Button) this.findViewById(R.id.person);
		persons = (Button) this.findViewById(R.id.persons);
		liststring = (Button) this.findViewById(R.id.liststring);
		listmap = (Button) this.findViewById(R.id.listmap);
		person.setOnClickListener(this);
		persons.setOnClickListener(this);
		liststring.setOnClickListener(this);
		listmap.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.person:
			String path = "http://10.0.2.2:8080/JsonProject/servlet/JsonAction?action_flag=person";
			String jsonString = httpUtils.HttpUtils.getJsonContent(path);
			Person person = JsonTools.getPerson("person", jsonString);
			Log.i(TAG, person.toString());
			break;
		case R.id.persons:
			String path2 = "http://192.168.0.102:8080/JsonProject/servlet/JsonAction?action_flag=persons";
			String jsonString2 = httpUtils.HttpUtils.getJsonContent(path2);
			List<Person> list2 = JsonTools.getPersons("persons", jsonString2);
			Log.i(TAG, list2.toString());
			break;
		case R.id.liststring:
			String path3 = "http://192.168.0.102:8080/JsonProject/servlet/JsonAction?action_flag=liststring";
			String jsonString3 = httpUtils.HttpUtils.getJsonContent(path3);
			List<String> list3 = JsonTools.getList("liststring", jsonString3);
			Log.i(TAG, list3.toString());
			break;
		case R.id.listmap:
			String path4 = "http://127.0.0.1:8080/JsonProject/servlet/JsonAction?action_flag=listmap";
			String jsonString4 = httpUtils.HttpUtils.getJsonContent(path4);
			List<Map<String, Object>> list4 = JsonTools.listKeyMaps("listmap",
					jsonString4);
			Log.i(TAG, list4.toString());
			break;
		}
	}
}