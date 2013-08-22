/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * auther：xiaoying
 * date：2013-8-21
 * version：v1.0
 */
package com.opensource.sqlitetool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 
 * @author xiaoying
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	
	private static DBHelper mDbHelper = null;

	public DBHelper(Context context) {
		super(context, "test.db", null, 1);
		// TODO Auto-generated constructor stub
	}
	
	public static synchronized DBHelper getInstance(Context context) {
		if(mDbHelper == null) {
			mDbHelper = new DBHelper(context);
		}
		return mDbHelper;
	}
	
	public static synchronized SQLiteDatabase getReadableDatabase(Context context) {
		return getInstance(context).getReadableDatabase();
	}
	
	public static synchronized SQLiteDatabase getWritableDatabase(Context context) {
		return getInstance(context).getWritableDatabase();
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL("create table if not exists test(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
