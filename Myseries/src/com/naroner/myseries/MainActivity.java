package com.naroner.myseries;

import java.util.ArrayList;
import com.naroner.adapter.Adapter_Store_Series;
import com.naroner.classe.StoreSerie;
import com.naroner.dao.DaoStoreSerie;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	Button buttonAdd;
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
        Dao_Series.close();
        
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
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
        
        buttonAdd.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
			    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
			    startActivity(intent);
			}
		});
    }
}
