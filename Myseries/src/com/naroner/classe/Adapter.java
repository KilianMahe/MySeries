package com.naroner.classe;

import java.util.ArrayList;

import com.naroner.myseries.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adapter extends ArrayAdapter<OneSerie> {
    public Adapter(Context context, ArrayList<OneSerie> series) {
       super(context, R.layout.custom_row, series);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Get the data item for this position
    	OneSerie user = getItem(position);    
       // Check if an existing view is being reused, otherwise inflate the view
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent, false);
       }
       // Lookup view for data population
       TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
       TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
       // Populate the data into the template view using the data object
       tvName.setText(user.get_SeriesName());
       tvHome.setText(user.get_Overview());
       // Return the completed view to render on screen
       return convertView;
   }
}