package com.example.wheresmystuff.presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDatabase.
 */
public class ItemDatabase extends SQLiteOpenHelper {

	  /** The Constant TABLE_NAME_1. */
  	public static final String TABLE_NAME_1 = "items";
	  
  	/** The Constant TABLE_NAME_2. */
  	public static final String TABLE_NAME_2 = "users";
	  
	  /** The Constant COLUMN_ID_0. */
  	public static final String COLUMN_ID_0 = "_id";
	  
  	/** The Constant COLUMN_ID_1. */
  	public static final String COLUMN_ID_1 = "name";
	  
  	/** The Constant COLUMN_ID_2. */
  	public static final String COLUMN_ID_2 = "description";
	  
  	/** The Constant COLUMN_ID_3. */
  	public static final String COLUMN_ID_3 = "category";
	  
  	/** The Constant COLUMN_ID_4. */
  	public static final String COLUMN_ID_4 = "location";
	  
  	/** The Constant COLUMN_ID_5. */
  	public static final String COLUMN_ID_5 = "date";
	  
  	/** The Constant COLUMN_ID_6. */
  	public static final String COLUMN_ID_6 = "contact";
	  
  	/** The Constant COLUMN_ID_7. */
  	public static final String COLUMN_ID_7 = "number";
	  
  	/** The Constant COLUMN_ID_8. */
  	public static final String COLUMN_ID_8 = "email";
	  
  	/** The Constant COLUMN_ID_9. */
  	public static final String COLUMN_ID_9 = "user_id";
	  
  	/** The Constant COLUMN_ID_A. */
  	public static final String COLUMN_ID_A = "username";
	  
  	/** The Constant COLUMN_ID_B. */
  	public static final String COLUMN_ID_B = "password";
	  
  	/** The Constant COLUMN_ID_C. */
  	public static final String COLUMN_ID_C = "user_android_id";
	  
  	/** The Constant COLUMN_ID_D. */
  	public static final String COLUMN_ID_D = "admin";
	  
  	/** The Constant COLUMN_ID_E. */
  	public static final String COLUMN_ID_E = "locked";

	  /** The Constant DATABASE_NAME. */
  	private static final String DATABASE_NAME = "item.db";
	  
  	/** The Constant DATABASE_VERSION. */
  	private static final int DATABASE_VERSION = 1;
	  
	  /** The Constant DATABASE_CREATE_1. */
  	private static final String DATABASE_CREATE_1 = "create table "
		      + TABLE_NAME_1 + "(" + COLUMN_ID_0
		      + " integer primary key autoincrement, " + COLUMN_ID_1
		      + " text, " + COLUMN_ID_2 + " text, " + COLUMN_ID_3
		      + " int, " + COLUMN_ID_4 + " text, " + COLUMN_ID_5
		      + " int, " + COLUMN_ID_6 + " text, " + COLUMN_ID_7
		      + " text, " + COLUMN_ID_8 + " text, " + COLUMN_ID_9
		      + " int );";
	  
	  /** The Constant DATABASE_CREATE_2. */
  	private static final String DATABASE_CREATE_2 = "create table "
		      + TABLE_NAME_2 + "(" + COLUMN_ID_0
		      + " integer primary key autoincrement, " + COLUMN_ID_A
		      + " text, " + COLUMN_ID_B + " text, " + COLUMN_ID_C
		      + " text, " + COLUMN_ID_D + " int, " + COLUMN_ID_E
		      + " int );";
	  
	/**
	 * Instantiates a new item database.
	 *
	 * @param context the context
	 */
	public ItemDatabase(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE_1);
		database.execSQL(DATABASE_CREATE_2);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
	    Log.w(ItemDatabase.class.getName(),
	            "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
	        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
	        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
	        onCreate(database);
		
	}
}
