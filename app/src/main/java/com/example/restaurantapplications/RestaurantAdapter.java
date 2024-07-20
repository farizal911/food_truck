package com.example.restaurantapplications;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<RestaurantModel> {
    List<RestaurantModel> restaurantModelList;
    Context context;
    int res;

    public RestaurantAdapter(@NonNull Context context, int resource, List<RestaurantModel> list) {
        super(context, resource, list);
        this.res = resource;
        this.restaurantModelList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater l;
            l = LayoutInflater.from(context);
            v = l.inflate(res, null);
        }

        ImageView imageView = v.findViewById(R.id.restaurantImage);
        TextView textView = v.findViewById(R.id.txtview);
        TextView txtAddress = v.findViewById(R.id.txtAddress);
        TextView txtPhoneNumber = v.findViewById(R.id.txtPhoneNumber);
        TextView txtWorkingTime = v.findViewById(R.id.txtWorkingTime);
        TextView txtClosingDay = v.findViewById(R.id.txtClosingDay);

        RestaurantModel model = restaurantModelList.get(position);
        imageView.setImageResource(model.getImageResId());
        textView.setText(model.getName());
        txtAddress.setText(model.getAddress());
        txtPhoneNumber.setText("Phone: " + model.getPhoneNumber());
        txtWorkingTime.setText("Working Time: " + model.getWorkingTime());
        txtClosingDay.setText("Closing Day: " + model.getClosingDay());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, MapsActivity.class);
                i.putExtra("name", model.getName());
                i.putExtra("address", model.getAddress());
                i.putExtra("phoneNumber", model.getPhoneNumber());
                i.putExtra("workingTime", model.getWorkingTime());
                i.putExtra("closingDay", model.getClosingDay());
                context.startActivity(i);
            }
        });

        return v;
    }
}