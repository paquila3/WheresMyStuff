package com.example.wheresmystuff.presenter;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.example.wheresmystuff.model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemDatabase.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	  /** The Constant TABLE_NAME_1. */
  	public static final String TABLE_NAME_1 = "items";
	  
  	/** The Constant TABLE_NAME_2. */
  	public static final String TABLE_NAME_2 = "users";
	  
	  /** The Constant COLUMN_ID_0. */
  	public static final String COLUMN_ID_0 = "_id";
  	
  	public static final String COLUMN_ID_1 = "type";
	  
  	/** The Constant COLUMN_ID_1. */
  	public static final String COLUMN_ID_2 = "name";
	  
  	/** The Constant COLUMN_ID_2. */
  	public static final String COLUMN_ID_3 = "description";
	  
  	/** The Constant COLUMN_ID_3. */
  	public static final String COLUMN_ID_4 = "category";
	  
  	/** The Constant COLUMN_ID_4. */
  	public static final String COLUMN_ID_5 = "location";
	  
  	/** The Constant COLUMN_ID_5. */
  	public static final String COLUMN_ID_6 = "date";
	  
  	/** The Constant COLUMN_ID_6. */
  	public static final String COLUMN_ID_7 = "contact";
	  
  	/** The Constant COLUMN_ID_7. */
  	public static final String COLUMN_ID_8 = "number";
	  
  	/** The Constant COLUMN_ID_8. */
  	public static final String COLUMN_ID_9 = "email";
	  
  	/** The Constant COLUMN_ID_9. */
  	public static final String COLUMN_ID_10 = "user_id";
	  
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
	  
  	private static final int ITEM_TYPE_LOST=0, ITEM_TYPE_FOUND=1, ITEM_TYPE_DONATE=2;
	  /** The Constant DATABASE_CREATE_1. */
  	private static final String DATABASE_CREATE_1 = "create table "
		      + TABLE_NAME_1 + "(" + COLUMN_ID_0
		      + " integer primary key autoincrement, "+ COLUMN_ID_1+ " int, "
		      + COLUMN_ID_2 + " text, " + COLUMN_ID_3 + " text, " + COLUMN_ID_4
		      + " int, " + COLUMN_ID_5 + " text, " + COLUMN_ID_6
		      + " int, " + COLUMN_ID_7 + " text, " + COLUMN_ID_8
		      + " text, " + COLUMN_ID_9 + " text, " + COLUMN_ID_10
		      + " int );";
	  
	  /** The Constant DATABASE_CREATE_2. */
  	private static final String DATABASE_CREATE_2 = "create table "
		      + TABLE_NAME_2 + "(" + COLUMN_ID_0
		      + " integer primary key, " + COLUMN_ID_A
		      + " text, " + COLUMN_ID_B + " text, " + COLUMN_ID_C
		      + " text, " + COLUMN_ID_D + " int, " + COLUMN_ID_E
		      + " int );";
	  
	/**
	 * Instantiates a new item database.
	 *
	 * @param context the context
	 */
	public DatabaseHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {
		System.out.println("GFYSILH");
		database.execSQL(DATABASE_CREATE_1);
		database.execSQL(DATABASE_CREATE_2);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
	    Log.w(DatabaseHelper.class.getName(),
	            "Upgrading database from version " + oldVersion + " to "
	                + newVersion + ", which will destroy all old data");
	        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_1);
	        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_2);
	        onCreate(database);
		
	}
	
	public void addItem(Item item){
		SQLiteDatabase db=this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID_0, item.getID());
		values.put(COLUMN_ID_2, item.getName());
		values.put(COLUMN_ID_3, item.getDescription());
		values.put(COLUMN_ID_4, item.getCategory());
		values.put(COLUMN_ID_5, item.getLocation());
		values.put(COLUMN_ID_6, item.getDate());
		if (item instanceof LostItem){
			values.put(COLUMN_ID_1, ITEM_TYPE_LOST);
			values.put(COLUMN_ID_7, ((LostItem)item).getContact());
			values.put(COLUMN_ID_8, ((LostItem)item).getNumber());
			values.put(COLUMN_ID_9, ((LostItem)item).getEmail());
			
		}
		else{
			if (item instanceof FoundItem) values.put(COLUMN_ID_1, ITEM_TYPE_FOUND);
			else values.put(COLUMN_ID_1, ITEM_TYPE_DONATE);
			values.put(COLUMN_ID_7, "null");
			values.put(COLUMN_ID_8, "null");
			values.put(COLUMN_ID_9, "null");			
		}
		values.put(COLUMN_ID_10, item.getUserID());
		db.insert(TABLE_NAME_1, null, values);
		db.close();
	}
	
	public Item getItem(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor cursor = db.query(TABLE_NAME_1, new String[] {COLUMN_ID_0, COLUMN_ID_1, COLUMN_ID_2,COLUMN_ID_3, COLUMN_ID_4,COLUMN_ID_5, COLUMN_ID_6,COLUMN_ID_7, COLUMN_ID_8, COLUMN_ID_9}, COLUMN_ID_0+ "=?",new String[] {String.valueOf(id)}, null, null, null, null);
		if (cursor!=null){
			cursor.moveToFirst();
		}
		Item item=null;
		switch(cursor.getInt(1)){
		case(ITEM_TYPE_FOUND):
			item = new FoundItem(cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5),cursor.getLong(6),cursor.getInt(9), cursor.getInt(0));
			break;
		case(ITEM_TYPE_DONATE):
			item = new DonateItem(cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5),cursor.getLong(6),cursor.getInt(9), cursor.getInt(0));
			break;
		case(ITEM_TYPE_LOST):
			item = new LostItem(cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getString(5),cursor.getLong(6),cursor.getString(7), cursor.getString(8), cursor.getString(9),cursor.getInt(10), cursor.getInt(0));
			break;
		}

		db.close();
		return item;
	}
	
	public List<Item> getAllItem(){
		List<Item> items= new ArrayList<Item>();
		
		for(int i=0; i<this.getItemCount(); i++){
				items.add(this.getItem(i));
		}
		return items;
	}
	
	public int getItemCount(){
		String countQuery = "SELECT * FROM "+ TABLE_NAME_1;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count= cursor.getCount();
		db.close();
		return count;
	}
	
	public int updateItem(Item item){
		SQLiteDatabase db=this.getWritableDatabase();
	
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID_2, item.getName());
		values.put(COLUMN_ID_3, item.getDescription());
		values.put(COLUMN_ID_4, item.getCategory());
		values.put(COLUMN_ID_5, item.getLocation());
		values.put(COLUMN_ID_6, item.getDate());
		if (item instanceof LostItem){
			values.put(COLUMN_ID_1, ITEM_TYPE_LOST);
			values.put(COLUMN_ID_7, ((LostItem)item).getContact());
			values.put(COLUMN_ID_8, ((LostItem)item).getNumber());
			values.put(COLUMN_ID_9, ((LostItem)item).getEmail());
			
		}
		else{
			if (item instanceof FoundItem) values.put(COLUMN_ID_1, ITEM_TYPE_FOUND);
			else values.put(COLUMN_ID_1, ITEM_TYPE_DONATE);
			values.put(COLUMN_ID_7, "null");
			values.put(COLUMN_ID_8, "null");
			values.put(COLUMN_ID_9, "null");			
		}
		values.put(COLUMN_ID_10, item.getUserID());
		
		int ans=db.update(TABLE_NAME_1, values, COLUMN_ID_0 + " = ?", new String[] { String.valueOf(item.getID())});
		db.close();
		return ans;
	}
	
	public void deleteItem(Item item){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME_1, COLUMN_ID_0 + " = ?", new String[] {String.valueOf(item.getUserID())});
		db.close();
	}
	
	public void addUser(User user){
		SQLiteDatabase db=this.getWritableDatabase();
		System.out.println("hello");
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID_0, user.getUserID());
		values.put(COLUMN_ID_A, user.getUsername());
		values.put(COLUMN_ID_B, user.getPassword());
		values.put(COLUMN_ID_C, user.getUser_android_id());
		int locked=0;
		int admin=0;
		if (user.isLocked()) locked++;
		if (user.isAdmin()) admin++;
		values.put(COLUMN_ID_D, locked);
		values.put(COLUMN_ID_E, admin);
		db.insert(TABLE_NAME_2, null, values);
		db.close();
	}
	
	public User getUser(int id){
		SQLiteDatabase db= this.getReadableDatabase();
		System.out.println("HERPADERP");
		Cursor cursor = db.query(TABLE_NAME_2, new String[] {COLUMN_ID_0, COLUMN_ID_A, COLUMN_ID_B,COLUMN_ID_C, COLUMN_ID_D,COLUMN_ID_E}, COLUMN_ID_0 + "=?", new String[] { String.valueOf(id)}, null, null, null,null);
		if (cursor != null){
			cursor.moveToFirst();
		}
		User user = new User (cursor.getString(1), cursor.getString(2), cursor.getInt(0));
		user.setUser_android_id(cursor.getString(3));
		if (cursor.getInt(4)==1){
			user.setLocked(true);
		}
		if (cursor.getInt(5)==1){
			user.setAdmin(true);
		}
		db.close();
		return user;
	}
	
	public List<User> getAllUser(){
		List<User> users= new ArrayList<User>();
		System.out.println("HI");
		for(int i=0; i<this.getUserCount(); i++){
			System.out.println("adding user number" + i);
			User newUser= (this.getUser(i));
			System.out.println(newUser.toString());
			users.add(newUser);
		}
		return users;
	}
	
	public int getUserCount(){
		String countQuery = "SELECT * FROM "+ TABLE_NAME_2;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		int count = cursor.getCount();
		db.close();
		System.out.println(count);
		return count;
	}
	
	public int updateUser(User user){
		SQLiteDatabase db=this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID_0, user.getUserID());
		values.put(COLUMN_ID_A, user.getUsername());
		values.put(COLUMN_ID_B, user.getPassword());
		values.put(COLUMN_ID_C, user.getUser_android_id());
		int locked=0;
		int admin=0;
		if (user.isLocked()) locked++;
		if (user.isAdmin()) admin++;
		values.put(COLUMN_ID_D, locked);
		values.put(COLUMN_ID_E, admin);
		int ans= db.update(TABLE_NAME_2, values, COLUMN_ID_0 + " = ?", new String[] { String.valueOf(user.getUserID())});

		db.close();
		return ans;
	}
	
	public void deleteUser(User user){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NAME_2, COLUMN_ID_0 + " = ?", new String[] {String.valueOf(user.getUserID())});
		db.close();
	}
}
