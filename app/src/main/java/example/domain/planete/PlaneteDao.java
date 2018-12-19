package example.domain.planete;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import android.database.sqlite.*;

import example.domain.planete.bdd.FeedReaderContract;
import example.domain.planete.bdd.FeedReaderDbHelper;

public class PlaneteDao {
    private Context ctx;

    public PlaneteDao(Context ctx) {
        this.ctx = ctx;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public List<Planete> planeteList(){
        FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(getCtx());
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                FeedReaderContract.FeedEntry.COLUMN_NAME_NOM,
                FeedReaderContract.FeedEntry.COLUMN_NAME_DISTANCE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_IMAGE
        };


        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );
        List<Planete> planetes = new ArrayList<Planete>();
        while(cursor.moveToNext()){
            Planete planete = new Planete(cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_DISTANCE)),
                    cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_IMAGE)));
            planetes.add(planete);
        }
        return planetes;
    }
}
