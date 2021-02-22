package ru.vaseba.yoursportyourrules.myex;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ru.vaseba.yoursportyourrules.datebase.MyExesDBHelper;
import ru.vaseba.yoursportyourrules.datebase.MyExesDBSchema;
import ru.vaseba.yoursportyourrules.datebase.MyExesDBSchema.ExesTable;

public class ExesLab {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static ExesLab sExesLab;
//    private List<MyExes> mExes;

    public static ExesLab get(Context context) {
        if (sExesLab == null) {
            sExesLab = new ExesLab(context);
        }
        return sExesLab;
    }

    private ExesLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new MyExesDBHelper(mContext).getWritableDatabase();
//        mExes = new ArrayList<>();

//        for (int i = 0; i < 100; i++) {
//            MyExes exes = new MyExes();
//            exes.setName("Комплекс #" + i);
//            mExes.add(exes);
//        }
    }

    public List<MyExes> getExes() {
        return new ArrayList<>();
    }

    public MyExes getExe(UUID id) {
//        for (MyExes exes : mExes) {
//            if (exes.getId().equals(id)) {
//                return exes;
//            }
//        }
        return null;
    }

    private static ContentValues getContentValues(MyExes exes) {
        ContentValues values = new ContentValues();
        values.put(ExesTable.Cols.UUID, exes.getId().toString());
        values.put(ExesTable.Cols.NAME, exes.getName());
        values.put(ExesTable.Cols.DETAIL, exes.getDetail());

        return values;
    }

    public void addExes(MyExes e){
        ContentValues values = getContentValues(e);
        mDatabase.insert(ExesTable.NAME, null, values);
    }

}
