package com.naroner.myseries;

import java.util.ArrayList;

import com.naroner.classe.ContainerData;
import com.naroner.classe.OneSerie;
import com.naroner.classe.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
        
        listviewResult.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
            	Intent intent = new Intent(SearchActivity.this, OneSerieActivity.class);
            	Bundle mBundle = new Bundle();
            	String id_serie_selectesd = Series.get(position).get_seriesid();
            	String name_serie_selectesd = Series.get(position).get_SeriesName();
            	String overview_serie_selectesd = Series.get(position).get_Overview();
            	String banner_serie_selectesd = Series.get(position).get_banner();
            	Log.e("msg", id_serie_selectesd);
            	mBundle.putString("IdSerie", id_serie_selectesd);
            	mBundle.putString("NameSerie", name_serie_selectesd);
            	mBundle.putString("OverviewSerie", overview_serie_selectesd);
            	mBundle.putString("BannerSerie", banner_serie_selectesd);
            	intent.putExtras(mBundle);
            	startActivity(intent);
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
