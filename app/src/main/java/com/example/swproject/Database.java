package com.example.swproject;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userdata.db";
    private static final int DATABASE_VERSION = 1;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Members");

        sqLiteDatabase.execSQL("create table Members (mID integer primary key autoincrement, Name text, Age integer);");

        sqLiteDatabase.execSQL("INSERT INTO Members VALUES (1,'Jam',20);");
        sqLiteDatabase.execSQL("INSERT INTO Members VALUES (2,'Sub',30);");
        sqLiteDatabase.execSQL("INSERT INTO Members VALUES (3,'Min',40);");
        sqLiteDatabase.execSQL("INSERT INTO Members VALUES (3,'Won',50);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<String> getMemberNames (){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Name FROM Members",null);
        ArrayList<String> result = new ArrayList<>();
        while (cursor.moveToNext()) {
            result.add(cursor.getString(0));
        }
        cursor.close();
        return result;
    }

}