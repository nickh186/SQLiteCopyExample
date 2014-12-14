package com.nhanna.example.sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class SQLiteHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "my_database";
	private static final int DB_VERSION = 1;
	
	private static final String TABLE_NAME = "test_table";
	private static final String COLUMN_NAME_KEY = "key";
	private static final String COLUMN_NAME_VALUE = "value";
	
	private static final String DB_CREATE_STATEMENT = "CREATE TABLE "+TABLE_NAME+
													  "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
													   COLUMN_NAME_KEY+" TEXT, "+
													   COLUMN_NAME_VALUE+" TEXT);";
	
	public SQLiteHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_CREATE_STATEMENT);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP "+TABLE_NAME);
		onCreate(db);
	}
	
	public long addPlaceholderData() {
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUMN_NAME_KEY, "Hello Key!");
		values.put(COLUMN_NAME_VALUE, "Hello Value!");
		return db.insert(TABLE_NAME, null, values);
	}
}
