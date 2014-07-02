package com.naroner.adapter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.naroner.classe.Series;
import com.naroner.classe.StoreSerie;
import com.naroner.myseries.R;

public class Adapter_Store_Series extends ArrayAdapter<StoreSerie> {
	ImageView image;
	Context _context;
	public Adapter_Store_Series(Context context, ArrayList<StoreSerie> series) {
	       super(context, R.layout.my_series_custom_row, series);
	       _context = context;
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
	       TextView TextView_Next_Episode = (TextView) convertView.findViewById(R.id.TextView_Next_Episode);
	       ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
	       // Populate the data into the template view using the data object
	       /*new DownloadImageTaskFanArt((ImageView) convertView.findViewById(R.id.ImageView_FanArt))
	        .execute(image, "http://thetvdb.com/banners/_cache/"+serie.get_FanArt());*/
	       byte[] outImage= serie.get_FanArt();
	       ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
	       Bitmap theImage = BitmapFactory.decodeStream(imageStream);
	       image.setImageBitmap(theImage);
	       tvName.setText(serie.get_SerieName());
	       tvActual_Season.setText("Season : " + Integer.toString(serie.get_actual_season_user()));
	       tvActual_Episode.setText("Episode : " + Integer.toString(serie.get_actual_episode_user()));
	   	   String dateInString = serie.get_NextEpisode();
	   	   if(!dateInString.equals("Unknow")){
			   try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				   	String dateInString1 = serie.get_NextEpisode();
			   		Date date = formatter.parse(dateInString1);
			   		Calendar nowDate = Calendar.getInstance();
			   		long millisecondsNext = date.getTime();; 
			   		long millisecondsToday = nowDate.getTimeInMillis();
			   		long diff = millisecondsNext - millisecondsToday;
			   		long diffDays = diff / (24 * 60 * 60 * 1000); 
			   		if(diffDays > 0){
				   		TextView_Next_Episode.setText("Next episode in " + diffDays + " days");
			   		}else{
			   			if(diffDays == 0){
			   				TextView_Next_Episode.setText("Episode available today at " + serie.get_Airs_Time());
			   			}else{
			   				TextView_Next_Episode.setText("Next episode already available");
			   			}
			   		}
			    
			   } catch (java.text.ParseException e) {
			   		e.printStackTrace();
			   }
	   	   }else{
	   		TextView_Next_Episode.setText("Next episode : " + dateInString);
	   	   }
	   	progressBar.setMax(serie.get_Number_available_episode());
	   	progressBar.setProgress(serie.get_Number_available_episode_user_seen());
	   	progressBar.setSecondaryProgress(serie.get_Number_available_episode());
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
	    
	    public static int calculateDifference(Date a, Date b)
	    {
	        int tempDifference = 0;
	        int difference = 0;
	        Calendar earlier = Calendar.getInstance();
	        Calendar later = Calendar.getInstance();

	        if (a.compareTo(b) < 0)
	        {
	            earlier.setTime(a);
	            later.setTime(b);
	        }
	        else
	        {
	            earlier.setTime(b);
	            later.setTime(a);
	        }

	        while (earlier.get(Calendar.YEAR) != later.get(Calendar.YEAR))
	        {
	            tempDifference = 365 * (later.get(Calendar.YEAR) - earlier.get(Calendar.YEAR));
	            difference += tempDifference;

	            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
	        }

	        if (earlier.get(Calendar.DAY_OF_YEAR) != later.get(Calendar.DAY_OF_YEAR))
	        {
	            tempDifference = later.get(Calendar.DAY_OF_YEAR) - earlier.get(Calendar.DAY_OF_YEAR);
	            difference += tempDifference;

	            earlier.add(Calendar.DAY_OF_YEAR, tempDifference);
	        }

	        return difference;
	    }
}
