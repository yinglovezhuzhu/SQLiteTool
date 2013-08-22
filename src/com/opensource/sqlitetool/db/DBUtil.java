package com.opensource.sqlitetool.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBUtil {

	
	public static void insert(Context context, int count) throws SQLiteException {
		SQLiteDatabase db = DBHelper.getWritableDatabase(context);
		ContentValues values = new ContentValues();
		for (int i = 0; i < count; i++) {
			values.clear();
			values.put("name", System.currentTimeMillis());
			db.insert("test", "", values);
		}
		db.close();
	}
	
	
	public static void udpate(Context context) throws SQLiteException {
		SQLiteDatabase db = DBHelper.getWritableDatabase(context);
		ContentValues values = new ContentValues();
		values.put("name", System.currentTimeMillis());
		db.update("test", values, null, null);
		db.close();
	}
	
	public static void delete(Context context) throws SQLiteException {
		SQLiteDatabase db = DBHelper.getWritableDatabase(context);
		db.delete("test", null, null);
		db.close();
	}
	
}
