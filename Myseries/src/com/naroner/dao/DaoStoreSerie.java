package com.naroner.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.naroner.classe.StoreSerie;

public class DaoStoreSerie implements Daobase<StoreSerie>{

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "MySerie.db";
	private static SQLiteDatabase bdd;
	private MyBaseSQLite maBaseSQLite;

	public DaoStoreSerie(Context context){
		maBaseSQLite = new MyBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
	}

	public void open(){
		bdd = maBaseSQLite.getWritableDatabase();
	}

	public void close(){
		bdd.close();
	}

	public SQLiteDatabase getBDD(){
		return bdd;
	}

	@Override
	public StoreSerie getById(int id) {
		boolean isNewDb = false;
		//if (!bdd.isOpen()) {
			this.open();	
			isNewDb = true;
		//}
		Cursor c = bdd.query("serie",
				new String[] {"id", "seriename", "fanart", "nextepisode", "airstime", "actualseasonuser", "actualepisodeuser" , "numberavailableepisode" , "numberavailableepisodeuserseen"},
				"id" + " = " + id , null, null, null, null);

		StoreSerie result = cursorToSerie(c);
		if (isNewDb == true && bdd.isOpen()) {
		}

		return result;
	}

	@Override
	public Cursor getAll() {
		return bdd.query("serie", new String[]{"id", "seriename", "fanart", "nextepisode", "airstime", "actualseasonuser", "actualepisodeuser", "numberavailableepisode", "numberavailableepisodeuserseen"}, null, null, null, null, null, null);

	}

	@Override
	public long insertObject(StoreSerie out) {
		ContentValues values = new ContentValues();
		values.put("id", out.get_id());
		values.put("seriename", out.get_SerieName());
		values.put("fanart", out.get_FanArt());
		values.put("nextepisode", out.get_NextEpisode());
		values.put("airstime", out.get_Airs_Time());
		values.put("actualseasonuser", out.get_actual_season_user());
		values.put("actualepisodeuser", out.get_actual_episode_user());
		values.put("numberavailableepisode", out.get_Number_available_episode());
		values.put("numberavailableepisodeuserseen", out.get_Number_available_episode_user_seen());
		return bdd.insert("serie", null, values);
	}

	@Override
	public int updateObject(int id, StoreSerie object) {
		ContentValues values = new ContentValues();
		values.put("seriename", object.get_SerieName());
		values.put("fanart", object.get_FanArt());
		values.put("nextepisode", object.get_NextEpisode());
		values.put("airstime", object.get_Airs_Time());
		values.put("actualseasonuser", object.get_actual_season_user());
		values.put("actualepisodeuser", object.get_actual_episode_user());
		values.put("numberavailableepisode", object.get_Number_available_episode());
		values.put("numberavailableepisodeuserseen", object.get_Number_available_episode_user_seen());
		return bdd.update("serie", values, "id" + " = " +id, null);
	}

	@Override
	public int removeById(int id) {
		return bdd.delete("serie", "id" + " = " +id, null);

	}

	private static StoreSerie cursorToSerie(Cursor c){
		if (c.getCount() == 0)
			return null;
		c.moveToFirst();
		StoreSerie serie = new StoreSerie();
		serie.set_id(c.getInt(0));
		serie.set_SerieName(c.getString(1));
		serie.set_FanArt(c.getBlob(2));
		serie.set_NextEpisode(c.getString(3));
		serie.set_Airs_Time(c.getString(4));
		serie.set_actual_season_user(c.getInt(5));
		serie.set_actual_episode_user(c.getInt(6));
		serie.set_Number_available_episode(c.getInt(7));
		serie.set_Number_available_episode_user_seen(c.getInt(8));
 
		return serie;
	}
	
	public ArrayList<StoreSerie> cursorToArraySerie(){
		Cursor c = bdd.query("serie", new String[]{"id", "seriename", "fanart", "nextepisode", "airstime", "actualseasonuser", "actualepisodeuser", "numberavailableepisode", "numberavailableepisodeuserseen"}, null, null, null, null, null, null);
		if (c.getCount() == 0){
			return null;
		}
		else
		{
			c.moveToFirst();
			ArrayList<StoreSerie> storeSeries = new ArrayList<StoreSerie>();
			for (int i = 0; i < c.getCount(); i++) {
				StoreSerie serie = new StoreSerie();
				serie.set_id(c.getInt(0));
				serie.set_SerieName(c.getString(1));
				serie.set_FanArt(c.getBlob(2));
				serie.set_NextEpisode(c.getString(3));
				serie.set_Airs_Time(c.getString(4));
				serie.set_actual_season_user(c.getInt(5));
				serie.set_actual_episode_user(c.getInt(6));
				serie.set_Number_available_episode(c.getInt(7));
				serie.set_Number_available_episode_user_seen(c.getInt(8));
				storeSeries.add(serie);
				c.moveToNext();
			}
			return storeSeries;
		}
	}

}