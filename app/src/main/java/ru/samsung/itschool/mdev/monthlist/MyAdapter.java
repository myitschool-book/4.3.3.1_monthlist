package ru.samsung.itschool.mdev.monthlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<String> data;
    // передаем список через конструктор
    MyAdapter(ArrayList<String> d) {
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
        String value = data.get(position);
        holder.myTextView.setText(value);
    }
    // определяем размер списка
    @Override
    public int getItemCount() {
        return data.size();
    }

    // помогает сделать прокрутку списка плавной,
    // сохраняет ссылки на элементы списка, чтобы адаптер мог их переиспользовать
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView myTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvItem);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),myTextView.getText()+"; "+getAdapterPosition(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
