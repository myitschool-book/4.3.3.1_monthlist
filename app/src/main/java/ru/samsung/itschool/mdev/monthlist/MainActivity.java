package ru.samsung.itschool.mdev.monthlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyMonth[] arr = new MyMonth[12];
        String[] myArr = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
        // Среднесуточная температура
        double[] tempArr = {-12.7, -11.3, -4.5, 7.7, 19.3, 23.9, 23.5, 22.8, 16.0, 5.2, -0.3, -9.3};
        // Количество дней
        int[] dayArr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Нравится/Не нравится
        boolean[] likeArr = {true, true, false, false, true, true, true, false, false, false, true, true};

        for (int i = 0; i < myArr.length; i++) {
            MyMonth month = new MyMonth(myArr[i],tempArr[i],dayArr[i],likeArr[i]);
            arr[i] = month;
        }

        // из обычного массива в ArrayList
        ArrayList<MyMonth> months =  new ArrayList<>(Arrays.asList(arr));

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(months);
        recyclerView.setAdapter(adapter);

    }

}