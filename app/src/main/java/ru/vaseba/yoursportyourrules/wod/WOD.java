package ru.vaseba.yoursportyourrules.wod;

import ru.vaseba.yoursportyourrules.R;

public class WOD {
    private String name;
    private String detail;
    private int img;

    public static final WOD[] wods = {
            new WOD("Почтальон", "3 раунда на время:\n" +
                    "30 Выпады\n" +
                    "20 Подъемы корпуса на пресс\n" +
                    "30 Выпады\n" +
                    "20 Махи гири - 1,5/1 Пуда", R.drawable.wod2),
            new WOD("HotHead", "Выполни как можно больше раундов за 12 минут:\n" +
                    "5 Подтягивания\n" +
                    "7 Махи гири - 1,5/1 Пуда\n" +
                    "9 Бёрпи", R.drawable.wod4),
            new WOD("Roses", "На время:\n" +
                    "30 Отжимания\n" +
                    "25-25 Рывок гири - 1,5/1 Пуда\n" +
                    "70 Выпады\n" +
                    "90 Подъемы корпуса на пресс\n" +
                    "110 Попрыгунчик", R.drawable.wod2),
            new WOD("Home Training 4th day", "4 раунда на время:\n" +
                    "20 Бёрпи\n" +
                    "15 Складка\n" +
                    "10 Отжимания с отрывом ладоней в нижней позиции", R.drawable.wod),
            new WOD("WOD-5454676", "7 раундов на время:\n" +
                    "7 Подтягивания\n" +
                    "14 Бёрпи\n" +
                    "21 Приседания \"Воздушные\"\n" +
                    "for PRO\n", R.drawable.wod1),
            new WOD("Appeal", "3 раунда на время:\n" +
                    "90 Попрыгунчик\n" +
                    "30 Махи гири - 1,5/1 Пуда\n" +
                    "90 Подъемы корпуса на пресс\n" +
                    "60 Попрыгунчик\n" +
                    "20 Махи гири - 1,5/1 Пуда\n" +
                    "60 Подъемы корпуса на пресс\n" +
                    "30 Попрыгунчик\n" +
                    "10 Махи гири - 1,5/1 Пуда\n" +
                    "30 Подъемы корпуса на пресс\n"
                    , R.drawable.wod2),
            new WOD("Lay Me Down", "5 раундов на время:\n" +
                    "30 Махи гири - 1,5/1 Пуда\n" +
                    "30 Подъемы корпуса на пресс\n" +
                    "15-15 Вращение гири - 1,5/1 Пуда", R.drawable.wod2),
            new WOD("Monday BOO", "3 раунда на время: 21-15-9 \n" +
                    "Выбросы одной гири двумя руками - 1,5/1 Пуда\n" +
                    "Отжимания с отрывом ладоней в нижней позиции\n" +
                    "Пресс (Ситап-пресс) с отягощением - 20/12 фунта", R.drawable.wod2),
    };

    public WOD(String name, String detail, int img) {
        this.name = name;
        this.detail = detail;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getImg() {
        return img;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
