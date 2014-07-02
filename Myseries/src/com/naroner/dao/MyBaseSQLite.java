package com.naroner.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyBaseSQLite extends SQLiteOpenHelper {

	private static final String CREATE_SERIE = 
								"CREATE TABLE serie " +
								"(id INTEGER NOT NULL," +
								"seriename TEXT NOT NULL," +
								"fanart BLOB NOT NULL," +
								"nextepisode TEXT NOT NULL," +
								"airstime TEXT NOT NULL," +
								"actualseasonuser INTEGER NOT NULL," +
								"actualepisodeuser INTEGER NOT NULL,"+
								"numberavailableepisode INTEGER NOT NULL,"+
								"numberavailableepisodeuserseen INTEGER NOT NULL);";

	

	public MyBaseSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_SERIE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE serie;");
		onCreate(db);
	}
}