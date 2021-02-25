package ru.vaseba.yoursportyourrules.myex;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Entity
public class Exercises implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "detail")
    public String detail;

    @ColumnInfo(name = "history1")
    public String history1;

    @ColumnInfo(name = "history2")
    public String history2;

    @ColumnInfo(name = "history3")
    public String history3;

    @ColumnInfo(name = "history4")
    public String history4;

    @ColumnInfo(name = "history5")
    public String history5;

    @ColumnInfo(name = "history6")
    public String history6;

    @ColumnInfo(name = "history7")
    public String history7;

    @ColumnInfo(name = "history8")
    public String history8;

    @ColumnInfo(name = "history9")
    public String history9;

    @ColumnInfo(name = "history10")
    public String history10;

    @ColumnInfo(name = "history11")
    public String history11;

    @ColumnInfo(name = "history12")
    public String history12;

    @ColumnInfo(name = "history13")
    public String history13;

    @ColumnInfo(name = "history14")
    public String history14;

    @ColumnInfo(name = "history15")
    public String history15;

    @ColumnInfo(name = "history16")
    public String history16;

    @ColumnInfo(name = "history17")
    public String history17;

    @ColumnInfo(name = "history18")
    public String history18;

    @ColumnInfo(name = "history19")
    public String history19;

    @ColumnInfo(name = "history20")
    public String history20;

    public Exercises() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercises exercises = (Exercises) o;

        if (uId != exercises.uId) return false;
        if (name != null ? !name.equals(exercises.name) : exercises.name != null) return false;
        if (detail != null ? !detail.equals(exercises.detail) : exercises.detail != null)
            return false;
        if (history1 != null ? !history1.equals(exercises.history1) : exercises.history1 != null)
            return false;
        if (history2 != null ? !history2.equals(exercises.history2) : exercises.history2 != null)
            return false;
        if (history3 != null ? !history3.equals(exercises.history3) : exercises.history3 != null)
            return false;
        if (history4 != null ? !history4.equals(exercises.history4) : exercises.history4 != null)
            return false;
        if (history5 != null ? !history5.equals(exercises.history5) : exercises.history5 != null)
            return false;
        if (history6 != null ? !history6.equals(exercises.history6) : exercises.history6 != null)
            return false;
        if (history7 != null ? !history7.equals(exercises.history7) : exercises.history7 != null)
            return false;
        if (history8 != null ? !history8.equals(exercises.history8) : exercises.history8 != null)
            return false;
        if (history9 != null ? !history9.equals(exercises.history9) : exercises.history9 != null)
            return false;
        if (history10 != null ? !history10.equals(exercises.history10) : exercises.history10 != null)
            return false;
        if (history11 != null ? !history11.equals(exercises.history11) : exercises.history11 != null)
            return false;
        if (history12 != null ? !history12.equals(exercises.history12) : exercises.history12 != null)
            return false;
        if (history13 != null ? !history13.equals(exercises.history13) : exercises.history13 != null)
            return false;
        if (history14 != null ? !history14.equals(exercises.history14) : exercises.history14 != null)
            return false;
        if (history15 != null ? !history15.equals(exercises.history15) : exercises.history15 != null)
            return false;
        if (history16 != null ? !history16.equals(exercises.history16) : exercises.history16 != null)
            return false;
        if (history17 != null ? !history17.equals(exercises.history17) : exercises.history17 != null)
            return false;
        if (history18 != null ? !history18.equals(exercises.history18) : exercises.history18 != null)
            return false;
        if (history19 != null ? !history19.equals(exercises.history19) : exercises.history19 != null)
            return false;
        return history20 != null ? history20.equals(exercises.history20) : exercises.history20 == null;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (history1 != null ? history1.hashCode() : 0);
        result = 31 * result + (history2 != null ? history2.hashCode() : 0);
        result = 31 * result + (history3 != null ? history3.hashCode() : 0);
        result = 31 * result + (history4 != null ? history4.hashCode() : 0);
        result = 31 * result + (history5 != null ? history5.hashCode() : 0);
        result = 31 * result + (history6 != null ? history6.hashCode() : 0);
        result = 31 * result + (history7 != null ? history7.hashCode() : 0);
        result = 31 * result + (history8 != null ? history8.hashCode() : 0);
        result = 31 * result + (history9 != null ? history9.hashCode() : 0);
        result = 31 * result + (history10 != null ? history10.hashCode() : 0);
        result = 31 * result + (history11 != null ? history11.hashCode() : 0);
        result = 31 * result + (history12 != null ? history12.hashCode() : 0);
        result = 31 * result + (history13 != null ? history13.hashCode() : 0);
        result = 31 * result + (history14 != null ? history14.hashCode() : 0);
        result = 31 * result + (history15 != null ? history15.hashCode() : 0);
        result = 31 * result + (history16 != null ? history16.hashCode() : 0);
        result = 31 * result + (history17 != null ? history17.hashCode() : 0);
        result = 31 * result + (history18 != null ? history18.hashCode() : 0);
        result = 31 * result + (history19 != null ? history19.hashCode() : 0);
        result = 31 * result + (history20 != null ? history20.hashCode() : 0);
        return result;
    }

    protected Exercises(Parcel in) {
        uId = in.readInt();
        name = in.readString();
        detail = in.readString();
        history1 = in.readString();
        history2 = in.readString();
        history3 = in.readString();
        history4 = in.readString();
        history5 = in.readString();
        history6 = in.readString();
        history7 = in.readString();
        history8 = in.readString();
        history9 = in.readString();
        history10 = in.readString();
        history11 = in.readString();
        history12 = in.readString();
        history13 = in.readString();
        history14 = in.readString();
        history15 = in.readString();
        history16 = in.readString();
        history17 = in.readString();
        history18 = in.readString();
        history19 = in.readString();
        history20 = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uId);
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeString(history1);
        dest.writeString(history2);
        dest.writeString(history3);
        dest.writeString(history4);
        dest.writeString(history5);
        dest.writeString(history6);
        dest.writeString(history7);
        dest.writeString(history8);
        dest.writeString(history9);
        dest.writeString(history10);
        dest.writeString(history11);
        dest.writeString(history12);
        dest.writeString(history13);
        dest.writeString(history14);
        dest.writeString(history15);
        dest.writeString(history16);
        dest.writeString(history17);
        dest.writeString(history18);
        dest.writeString(history19);
        dest.writeString(history20);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Exercises> CREATOR = new Creator<Exercises>() {
        @Override
        public Exercises createFromParcel(Parcel in) {
            return new Exercises(in);
        }

        @Override
        public Exercises[] newArray(int size) {
            return new Exercises[size];
        }
    };
}
