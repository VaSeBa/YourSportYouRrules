package ru.vaseba.yoursportyourrules.myex;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercises implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "detail")
    public String detail;

    public Exercises() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercises exercises = (Exercises) o;

        if (uId != exercises.uId) return false;
        if (name != null ? !name.equals(exercises.name) : exercises.name != null) return false;
        return detail != null ? detail.equals(exercises.detail) : exercises.detail == null;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }

    protected Exercises(Parcel in) {
        uId = in.readInt();
        name = in.readString();
        detail = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(uId);
        dest.writeString(name);
        dest.writeString(detail);
    }
}
