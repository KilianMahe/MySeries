package com.naroner.myseries;

import java.io.InputStream;
import java.util.ArrayList;

import com.naroner.classe.OneSerieAll;
import com.naroner.classe.StoreSerie;
import com.naroner.classe.episode;
import com.naroner.dao.DaoStoreSerie;
import com.naroner.myseries.SearchActivity.Networking;
import com.naroner.parsing.ContainerData;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class OneSerieActivity extends Activity{
	ImageView image;
	ImageView image_fan_art;
	TextView textViewOverview;
	TextView textview_nomber_saisonactual;
	TextView textview_number_rating;
	TextView textview_genre;
	Button button_add;
	RatingBar ratingbar;
	ArrayList<OneSerieAll> Series;

	public void setSeries(ArrayList<OneSerieAll> series) {
		Series = series;
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_serie);
        Intent intent = getIntent();
        String url = "http://thetvdb.com/api/B75C3058A1A2B71F/series/"+intent.getStringExtra("IdSerie")+"/all";
		Networking networkrequest = new Networking();
        networkrequest.execute(url);
        image = (ImageView)findViewById(R.id.image_serie);
        image_fan_art = (ImageView)findViewById(R.id.image_fan_art);
        textViewOverview = (TextView)findViewById(R.id.textview_overflow);
        textview_nomber_saisonactual = (TextView)findViewById(R.id.textview_nomber_saisonactual);
        textview_number_rating = (TextView)findViewById(R.id.textview_number_rating);
        textview_genre = (TextView)findViewById(R.id.textview_genre);
        button_add = (Button)findViewById(R.id.button_add);
        ratingbar = (RatingBar)findViewById(R.id.ratingbar);
        
        button_add.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				dialogueAddSerie();
			}
		});
        
        new DownloadImageTask((ImageView) findViewById(R.id.image_serie))
        .execute("http://thetvdb.com/banners/"+intent.getStringExtra("BannerSerie"));
        textViewOverview.setText(intent.getStringExtra("OverviewSerie"));
        
    }
	
	public void dialogueAddSerie(){
		final Context context = this;
		Drawable background = this.getResources().getDrawable(R.drawable.background_popup);
		
		//Creation nouvelle alerte dialogue
		AlertDialog.Builder DialogueComp = new AlertDialog.Builder(this);
		DialogueComp.setCancelable(true);
	    
		DialogueComp.setTitle(R.string.text_add);
	    
	    //Creation d'un layout
	    LinearLayout layout = new LinearLayout(this);
	    layout.setOrientation(LinearLayout.VERTICAL);
	    layout.setPadding(10, 10, 10, 10);
	    setRes(layout, background);
	    
	    //Creation champ
	    TextView textview_explication = new TextView(this);
	    textview_explication.setText("Please select the last episode you watched");
	    
	    final Spinner spinner_saison = new Spinner(this);
	    ArrayList<String> spinnerArray = new ArrayList<String>();
	    for(int i = 0; i < Integer.parseInt(Series.get(0).get_nombre_saison()); i++){
	    	spinnerArray.add("Season " + (i + 1));
	    }
	    ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
	    spinner_saison.setAdapter(spinnerArrayAdapter);
	    
	    final Spinner spinner_episode = new Spinner(this);
	    final ArrayList<String> spinnerArrayEpisode = new ArrayList<String>();
	    for(int a = 0; a < Series.get(0).get_nombre_episodes_on_saison(1); a++){
	    	spinnerArrayEpisode.add("Episode " + (a + 1));
	    }
	    ArrayAdapter<String> spinnerArrayAdapterEpisode = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArrayEpisode);
	    spinner_episode.setAdapter(spinnerArrayAdapterEpisode);
	    
	    //Ajout des champs au layout
	    layout.addView(textview_explication);
	    layout.addView(spinner_saison);
	    layout.addView(spinner_episode);
	    
	    //Ajout du layout a l'alerte dialogue
	    DialogueComp.setView(layout);
	    
	    //Bouton
	    DialogueComp.setPositiveButton(R.string.text_confirm,
	            new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int id) {
	        	final DaoStoreSerie Dao_Series = new DaoStoreSerie(context);
	        	Dao_Series.open();
	            if(Dao_Series.getById(Integer.parseInt(Series.get(0).get_id())) == null){
	            	StoreSerie serie = new StoreSerie(Integer.parseInt(Series.get(0).get_id()),
	            													   Series.get(0).get_SeriesName(), 
	            													   Series.get(0).get_poster(), 
	            													   Series.get(0).get_date_of_next_episode(
	            															   Integer.toString(spinner_saison.getSelectedItemPosition() + 1), 
	            															   Integer.toString(spinner_episode.getSelectedItemPosition() + 1)), 
	            													   spinner_saison.getSelectedItemPosition() + 1, 
	            													   spinner_episode.getSelectedItemPosition() + 1);
	            	Dao_Series.insertObject(serie);
	            }
	            Dao_Series.close();
	            Intent intent = new Intent(OneSerieActivity.this, MainActivity.class);
			    startActivity(intent);
	            dialog.cancel();
	        }
	    });
	    DialogueComp.setNegativeButton(R.string.text_dismiss,
	            new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int id) {
	            dialog.cancel();
	        }
	    });
	    
	    spinner_saison.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Log.e("spinner", "selected "+position);
				spinnerArrayEpisode.clear();
				for(int a = 0; a < Series.get(0).get_nombre_episodes_on_saison(position + 1); a++){
			    	spinnerArrayEpisode.add("Episode " + (a + 1));
			    }
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				Log.e("spinner", "nothing ");
			}

	    });
	
	    //Creation et affichage
	    AlertDialog alert11 = DialogueComp.create();
	    alert11.show();
	}
	
	//Fonction pour le background de l'alertdialog en fonction du SDK
		@SuppressWarnings("deprecation")
		private void setRes(LinearLayout iv,Drawable drawable){
		    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
		        //iv.setBackground(drawable);
		    }else{
		        iv.setBackgroundDrawable(drawable);
		    }
		}
	
	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
	    ImageView bmImage;

	    public DownloadImageTask(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	    	image.setImageBitmap(result);
	    }
	}
	
	private class DownloadImageTaskFanArt extends AsyncTask<String, Void, Bitmap> {
	    ImageView bmImage;

	    public DownloadImageTaskFanArt(ImageView bmImage) {
	        this.bmImage = bmImage;
	    }

	    protected Bitmap doInBackground(String... urls) {
	        String urldisplay = urls[0];
	        Bitmap mIcon11 = null;
	        try {
	            InputStream in = new java.net.URL(urldisplay).openStream();
	            mIcon11 = BitmapFactory.decodeStream(in);
	        } catch (Exception e) {
	            Log.e("Error", e.getMessage());
	            e.printStackTrace();
	        }
	        return mIcon11;
	    }

	    protected void onPostExecute(Bitmap result) {
	    	image_fan_art.setImageBitmap(result);
	    }
	}
	
	public class Networking extends AsyncTask<String,String,String>{
		ProgressDialog progDailog = new ProgressDialog(OneSerieActivity.this);
			
			@Override
			protected String doInBackground(String... params) {
				ArrayList<OneSerieAll> _Series = null;
				ArrayList<episode> _Episodes = null;
				_Series = ContainerData.getFeedsAll(params[0]);
				_Episodes = ContainerData.getFeedsAllEpisode(params[0]);
				for(int i = 0; i <_Series.size(); i++){
					_Series.get(i).set_episode(_Episodes);
				}
				setSeries(_Series);
				String statut = "finish";
				return statut;
			}
			
			@Override
			   protected void onPostExecute(String result) {
				 for(int i = 0; i < Series.size(); i++){
					 float rating = Float.parseFloat(Series.get(i).get_Rating());
					 ratingbar.setRating(rating);
					 setTitle(Series.get(i).get_SeriesName());
					 textview_nomber_saisonactual.setText("Number of seasons : "+Series.get(i).get_nombre_saison());
					 textview_number_rating.setText(Series.get(i).get_RatingCount()+" votes ("+Series.get(i).get_Rating()+")");
					 String genres = Series.get(i).get_Genre();
					 genres = genres.substring(1, genres.length()-1); 
					 genres = genres.replace("|", ", ");
					 textview_genre.setText("Genres : "+genres);
					 new DownloadImageTaskFanArt((ImageView) findViewById(R.id.image_fan_art))
				        .execute("http://thetvdb.com/banners/_cache/"+Series.get(i).get_fanart());
				 }
				 progDailog.dismiss();
			   }
			
			@Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            progDailog.setMessage("Loading...");
	            progDailog.setIndeterminate(false);
	            progDailog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	            progDailog.setCancelable(true);
	            progDailog.show();
	        }
	
		}

}
