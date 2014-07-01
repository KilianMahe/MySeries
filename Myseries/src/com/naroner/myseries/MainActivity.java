package com.naroner.myseries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import com.naroner.adapter.Adapter_Store_Series;
import com.naroner.classe.StoreSerie;
import com.naroner.dao.DaoStoreSerie;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	Button buttonAdd;
	Button button_all;
	Button button_late;
	Button button_up_to_date;
	ListView listViewSerie;
	Adapter_Store_Series _adapter;
	ArrayList<StoreSerie> store_Series = new ArrayList<StoreSerie>();

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //BDD
        final DaoStoreSerie Dao_Series = new DaoStoreSerie(this);
        Dao_Series.open();
        store_Series = Dao_Series.cursorToArraySerie();
        Collections.sort(store_Series, new SerieComparator());
        Dao_Series.close();
        
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        button_all = (Button)findViewById(R.id.button_all);
        button_late = (Button)findViewById(R.id.button_late);
        button_up_to_date = (Button)findViewById(R.id.button_up_to_date);
        setResButton(button_all, getResources().getDrawable(R.drawable.button_style_pressed));
        listViewSerie = (ListView)findViewById(R.id.listViewSerie);
        
        if(store_Series != null){
        	_adapter = new Adapter_Store_Series(getApplicationContext(), store_Series);
        	listViewSerie.setAdapter(_adapter);
        	
        	listViewSerie.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                        int position, long id) {
                	Intent intent = new Intent(MainActivity.this, StoreSerieActivity.class);
                	Bundle mBundle = new Bundle();
                	int id_serie_selected = store_Series.get(position).get_id();
                	mBundle.putString("IdSerie", Integer.toString(id_serie_selected));
                	intent.putExtras(mBundle);
                	startActivity(intent);
                }
            });
        }
        
        button_all.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!button_all.getBackground().equals(getResources().getDrawable(R.drawable.button_style_pressed))){
					setResButton(button_all, getResources().getDrawable(R.drawable.button_style_pressed));
					setResButton(button_late, getResources().getDrawable(R.drawable.button_add));
					setResButton(button_up_to_date, getResources().getDrawable(R.drawable.button_add));
					final DaoStoreSerie Dao_Series = new DaoStoreSerie(getApplicationContext());
			        Dao_Series.open();
			        store_Series = Dao_Series.cursorToArraySerie();
			        Collections.sort(store_Series, new SerieComparator());
			        Dao_Series.close();
			        if(store_Series != null){
			        	_adapter = new Adapter_Store_Series(getApplicationContext(), store_Series);
			        	listViewSerie.setAdapter(_adapter);
			        }
				}
			}
		});
        
        button_late.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!button_all.getBackground().equals(getResources().getDrawable(R.drawable.button_style_pressed))){
					setResButton(button_all, getResources().getDrawable(R.drawable.button_add));
					setResButton(button_late, getResources().getDrawable(R.drawable.button_style_pressed));
					setResButton(button_up_to_date, getResources().getDrawable(R.drawable.button_add));
					final DaoStoreSerie Dao_Series = new DaoStoreSerie(getApplicationContext());
			        Dao_Series.open();
			        store_Series = Dao_Series.cursorToArraySerie();
			        Collections.sort(store_Series, new SerieComparator());
			        Dao_Series.close();
			        ArrayList<StoreSerie> store_Series_filtred = new ArrayList<StoreSerie>();
			        for(int i = 0; i < store_Series.size(); i++){
			        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					   	String dateInString1 = store_Series.get(i).get_NextEpisode();
				   		Date date;
						try {
							date = formatter.parse(dateInString1);
							Calendar nowDate = Calendar.getInstance();
					   		long millisecondsNext = date.getTime();; 
					   		long millisecondsToday = nowDate.getTimeInMillis();
					   		long diff = millisecondsNext - millisecondsToday;
					   		long diffDays = diff / (24 * 60 * 60 * 1000); 
					   		if((diffDays < 0)){
					   			store_Series_filtred.add(store_Series.get(i));
					   		}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        if(store_Series_filtred != null){
			        	_adapter = new Adapter_Store_Series(getApplicationContext(), store_Series_filtred);
			        	listViewSerie.setAdapter(_adapter);
			        }
				}
			}
		});
        
        button_up_to_date.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!button_all.getBackground().equals(getResources().getDrawable(R.drawable.button_style_pressed))){
					setResButton(button_all, getResources().getDrawable(R.drawable.button_add));
					setResButton(button_late, getResources().getDrawable(R.drawable.button_add));
					setResButton(button_up_to_date, getResources().getDrawable(R.drawable.button_style_pressed));
					final DaoStoreSerie Dao_Series = new DaoStoreSerie(getApplicationContext());
			        Dao_Series.open();
			        store_Series = Dao_Series.cursorToArraySerie();
			        Collections.sort(store_Series, new SerieComparator());
			        Dao_Series.close();
			        ArrayList<StoreSerie> store_Series_filtred = new ArrayList<StoreSerie>();
			        for(int i = 0; i < store_Series.size(); i++){
			        	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					   	String dateInString1 = store_Series.get(i).get_NextEpisode();
				   		Date date;
						try {
							date = formatter.parse(dateInString1);
							Calendar nowDate = Calendar.getInstance();
					   		long millisecondsNext = date.getTime();; 
					   		long millisecondsToday = nowDate.getTimeInMillis();
					   		long diff = millisecondsNext - millisecondsToday;
					   		long diffDays = diff / (24 * 60 * 60 * 1000); 
					   		if((diffDays > 0)){
					   			store_Series_filtred.add(store_Series.get(i));
					   		}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			        if(store_Series_filtred != null){
			        	_adapter = new Adapter_Store_Series(getApplicationContext(), store_Series_filtred);
			        	listViewSerie.setAdapter(_adapter);
			        }
				}
			}
		});
        
        buttonAdd.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
			    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
			    startActivity(intent);
			}
		});
        
    }
	
	//Fonction pour le background de l'alertdialog en fonction du SDK
			@SuppressWarnings("deprecation")
			public void setResButton(Button iv,Drawable drawable){
			    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
			        iv.setBackground(drawable);
			    }else{
			        iv.setBackgroundDrawable(drawable);
			    }
			}
			
			public class SerieComparator implements Comparator<StoreSerie> {
				public int compare(StoreSerie StoreSerie1, StoreSerie StoreSerie2) {
					int result =  StoreSerie1.get_NextEpisode().compareTo(StoreSerie2.get_NextEpisode());
					if(result == 0){
						result = StoreSerie1.get_SerieName().compareTo(StoreSerie2.get_SerieName());
					}
					return result;
				}
			}
}
