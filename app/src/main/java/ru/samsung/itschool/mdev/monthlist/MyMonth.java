package ru.samsung.itschool.mdev.monthlist;

public class MyMonth {
    private String month = ""; // Название месяца
    private double temp = 0.; // Средняя температура
    private int days = 0; // Количество дней
    private boolean like = true; // Нравится месяц

    public MyMonth(String month, double temp, int days, boolean like) {
        this.month = month;
        this.temp = temp;
        this.days = days;
        this.like = like;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }


}
