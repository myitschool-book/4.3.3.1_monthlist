package ru.samsung.itschool.mdev.monthlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<MyMonth> data;
    // передаем список через конструктор
    MyAdapter(ArrayList<MyMonth> d) {
        this.data = d;
    }
    // формируем разметку для каждой строки
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);

    }
    // связываем данные с TextView в каждой строке
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        MyMonth value = data.get(position);
        holder.myMonthText.setText(value.getMonth());
        holder.myTempText.setText(Double.toString(value.getTemp()));
        holder.myDayText.setText(Integer.toString(value.getDays()));
        if(position>=0 && position <=2) {
            holder.myImgView.setImageResource(R.drawable.winter);
        } else if(position>=3 && position <=5) {
            holder.myImgView.setImageResource(R.drawable.spring);
        }else if(position>=6 && position<=8) {
            holder.myImgView.setImageResource(R.drawable.summer);
        } else {
            holder.myImgView.setImageResource(R.drawable.autumn);
        }
        holder.myCheckBox.setChecked(value.isLike());
    }
    // определяем размер списка
    @Override
    public int getItemCount() {
        return data.size();
    }

    // помогает сделать прокрутку списка плавной,
    // сохраняет ссылки на элементы списка, чтобы адаптер мог их переиспользовать
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView myMonthText, myTempText, myDayText;
        private ImageView myImgView;
        private CheckBox myCheckBox;
        public ViewHolder(View itemView) {
            super(itemView);
            myImgView = itemView.findViewById(R.id.imageView);
            myMonthText = itemView.findViewById(R.id.tvMonth);
            myTempText = itemView.findViewById(R.id.tvTemp);
            myDayText = itemView.findViewById(R.id.tvDays);
            myCheckBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
