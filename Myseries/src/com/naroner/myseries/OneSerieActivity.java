package com.naroner.myseries;

import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OneSerieActivity extends Activity{
	ImageView image;
	TextView textViewTitre;
	TextView textViewOverview;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_serie);
        Intent intent = getIntent();
        image = (ImageView)findViewById(R.id.image_serie);
        textViewTitre = (TextView)findViewById(R.id.textview_titre);
        textViewOverview = (TextView)findViewById(R.id.textview_overflow);
        
        new DownloadImageTask((ImageView) findViewById(R.id.image_serie))
        .execute("http://thetvdb.com/banners/"+intent.getStringExtra("BannerSerie"));
        textViewTitre.setText(intent.getStringExtra("NameSerie"));
        textViewOverview.setText(intent.getStringExtra("OverviewSerie"));
        
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

}
