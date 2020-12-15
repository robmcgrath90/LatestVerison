package com.example.ca2android.Adapaters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ca2android.Model.ClientModel;
import com.example.ca2android.R;
import com.example.ca2android.UI.EditClient;
import com.example.ca2android.UI.MainActivity;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    List<ClientModel> clientList;
    Context context;


    //reference video time 43.40 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s

    public RecyclerAdapter(List<ClientModel> clientList, Context context) {
        this.clientList = clientList;
        this.context = context;
    }

    //reference video time 44.50 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvWeight;
        TextView tvActive;
        TextView tvID;
        ConstraintLayout parentLayout;

        //reference video time 46.21 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvActive = itemView.findViewById(R.id.tvActive);
            tvID = itemView.findViewById(R.id.tvID);
            parentLayout = itemView.findViewById(R.id.oneclientrow);
        }
    }


    //reference video time 47.43 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.clientrow,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    //reference video time 47.43 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(String.valueOf(clientList.get(position).getName()));
        holder.tvWeight.setText(String.valueOf(clientList.get(position).getWeight()));
        holder.tvActive.setText(clientList.get(position).isActive() == true ? "Yes":"No");
        holder.tvID.setText(String.valueOf(clientList.get(position).getId()));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // reference video time 1:19:20 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
               Intent intent = new Intent(context, EditClient.class);
               intent.putExtra("id", clientList.get(position).getId());
               context.startActivity(intent);

            }
        });


    }

    //reference video time 47.43 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
    @Override
    public int getItemCount() {
        return clientList.size();
    }
}
