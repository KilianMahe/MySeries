package com.naroner.dao;

import android.database.Cursor;

public interface Daobase<T> {

	T getById(int id);
	Cursor getAll();
	long insertObject(T out);
	int updateObject(int id, T object);
	int removeById(int id);


}
