package ru.vaseba.yoursportyourrules.myex;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExesLab {

    private static ExesLab sExesLab;
    private List<MyExes> mExes;

    public static ExesLab get(Context context) {
        if (sExesLab == null) {
            sExesLab = new ExesLab(context);
        }
        return sExesLab;
    }

    private ExesLab(Context context) {
        mExes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MyExes exes = new MyExes();
            exes.setName("Комплекс #" + i);
            mExes.add(exes);
        }
    }

    public List<MyExes> getExes() {
        return mExes;
    }

    public MyExes getExe(UUID id) {
        for (MyExes exes : mExes) {
            if (exes.getId().equals(id)) {
                return exes;
            }
        }
        return null;
    }

}
