package ru.vaseba.yoursportyourrules.myex;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.UUID;
import ru.vaseba.yoursportyourrules.datebase.MyExesDBHelper;

public class ExesCursorWrapper extends CursorWrapper {

    public ExesCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public MyExes getExes() {
        String uuidString = getString(getColumnIndex(MyExesDBHelper.UUID));
        String name = getString(getColumnIndex(MyExesDBHelper.NAME));
        String detail = getString(getColumnIndex(MyExesDBHelper.DETAIL));

        MyExes exes = new MyExes(UUID.fromString(uuidString));
        exes.setName(name);
        exes.setDetail(detail);

        return exes;
    }
}