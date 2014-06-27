package com.naroner.myseries;

import java.util.ArrayList;

import com.naroner.classe.ContainerData;
import com.naroner.classe.OneSerie;
import com.naroner.classe.adapter;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity  extends Activity {
	Button buttonSearch;
	EditText edittext;
	ListView listviewResult;
	ArrayList<OneSerie> Series;
	adapter _adapter;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        buttonSearch = (Button)findViewById(R.id.buttonSearch);
        edittext = (EditText)findViewById(R.id.searchEditView);
        listviewResult = (ListView)findViewById(R.id.listviewResult);
        Series = new ArrayList<OneSerie>();
        _adapter = new adapter(getApplicationContext(), Series);
        listviewResult.setAdapter(_adapter);
        
        buttonSearch.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				String searchtext = edittext.getText().toString();
				searchtext = searchtext.replace(" ", "+");
				String url = "http://thetvdb.com/api/GetSeries.php?seriesname="+searchtext;
				Networking networkrequest = new Networking();
		        networkrequest.execute(url);
			}
		});
    }
	
	public class Networking extends AsyncTask<String,String,String>{
		
		@Override
		protected String doInBackground(String... params) {
			Series = ContainerData.getFeeds(params[0]);
			String statut = "finish";
			return statut;
		}
		
		@Override
		   protected void onPostExecute(String result) {
		      _adapter.notifyDataSetChanged();
		      for(int i =0; i < Series.size(); i++){
		    	  Log.e("returnrequest", Series.get(i).toString());
		      }
		   }

	}

}
