package com.naroner.adapter;

import java.io.InputStream;
import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.naroner.classe.StoreSerie;
import com.naroner.myseries.R;

public class Adapter_Store_Series extends ArrayAdapter<StoreSerie> {
	ImageView image;
	public Adapter_Store_Series(Context context, ArrayList<StoreSerie> series) {
	       super(context, R.layout.my_series_custom_row, series);
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	       // Get the data item for this position
	    	StoreSerie serie = getItem(position);    
	       // Check if an existing view is being reused, otherwise inflate the view
	       if (convertView == null) {
	          convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_series_custom_row, parent, false);
	       }
	       // Lookup view for data population
	       image = (ImageView) convertView.findViewById(R.id.ImageView_FanArt);
	       TextView tvName = (TextView) convertView.findViewById(R.id.TextView_Name);
	       TextView tvActual_Season = (TextView) convertView.findViewById(R.id.TextView_Actual_season);
	       TextView tvActual_Episode = (TextView) convertView.findViewById(R.id.TextView_Actual_episode);
	       // Populate the data into the template view using the data object
	       new DownloadImageTaskFanArt((ImageView) convertView.findViewById(R.id.ImageView_FanArt))
	        .execute(image, "http://thetvdb.com/banners/_cache/"+serie.get_FanArt());
	       tvName.setText(serie.get_SerieName());
	       tvActual_Season.setText("Season : " + Integer.toString(serie.get_actual_season_user()));
	       tvActual_Episode.setText("Episode : " + Integer.toString(serie.get_actual_episode_user()));
	       // Return the completed view to render on screen
	       return convertView;
	   }
	    
	    private class DownloadImageTaskFanArt extends AsyncTask<Object, Void, Bitmap> {
		    private ImageView bmImage;

		    public DownloadImageTaskFanArt(ImageView bmImage) {
		        this.bmImage = bmImage;
		    }

		    protected Bitmap doInBackground(Object... urls) {
		        String urldisplay = (String)urls[1];
		        bmImage = (ImageView) urls[0];
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
		    		bmImage.setImageBitmap(result);
		    }
		}
}
