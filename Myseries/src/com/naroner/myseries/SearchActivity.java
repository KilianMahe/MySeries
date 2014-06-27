package com.naroner.myseries;

import java.util.ArrayList;

import com.naroner.classe.ContainerData;
import com.naroner.classe.OneSerie;
import com.naroner.classe.Adapter;

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
	Adapter _adapter;
	
	public ArrayList<OneSerie> getSeries() {
		return Series;
	}

	public void setSeries(ArrayList<OneSerie> series) {
		Series = series;
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autocomplete);
        buttonSearch = (Button)findViewById(R.id.buttonSearch);
        edittext = (EditText)findViewById(R.id.searchEditView);
        listviewResult = (ListView)findViewById(R.id.listviewResult);
        Series = new ArrayList<OneSerie>();
        
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
			setSeries(ContainerData.getFeeds(params[0]));
			String statut = "finish";
			return statut;
		}
		
		@Override
		   protected void onPostExecute(String result) {
			  _adapter = new Adapter(getApplicationContext(), Series);
			  listviewResult.setAdapter(_adapter);
		      for(int i =0; i < Series.size(); i++){
		    	  Log.e("returnrequest", Series.get(i).toString());
		      }
		   }

	}

}
