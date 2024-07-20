package com.example.restaurantapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {
    List<RestaurantModel> list=new ArrayList<RestaurantModel>();
    ListView listView;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        String cat=getIntent().getStringExtra("cat");
        TextView textView=findViewById(R.id.txtview);
        textView.setText(cat+" Food Truck List");
        listView=findViewById(R.id.listview);

        if (cat.equals("Perlis")) {
            addRestaurants("Food Truck Kuala Perlis", "Pekan Kuala Perlis, 02000 Kuala Perlis, Perlis", R.drawable.kuala, "012-3456789", "Fri-Sun: 5:00 PM - 12:00 AM", "Mon-Thur");
            addRestaurants("Foodtruck Jagung Mango Waffle Uncle Rem", "Jalan Besar, Felda Chuping, 02500 Kangar, Perlis", R.drawable.jagung, "013-204 6533", "Mon-Sun: 3:00 PM - 11:00 PM", "None");
            addRestaurants("Chapee Kopi Claypot Perlis HQ Food", "Jalan Kuala Perlis, Pekan Kuala Perlis, 02000, 01000 Kangar, Perlis", R.drawable.chapee , "014-5678901", "Mon-Sun: 10:00 AM - 12:00 AM", "Tuesday");
            addAdapter();
        }


        if (cat.equals("Selangor")) {
            addRestaurants("Food Truck Sentral", "Section 9, 40100 Shah Alam, Selangor", R.drawable.sentral, "012-3456789", "Mon-Sat: 8:00 PM - 12:00 AM", "Sun");
            addRestaurants("Food Truck Kompleks Sukan Pandamaran", "Kompleks Sukan Pandamaran, Klang Selangor, Pandamaran, 41200 Klang, Selangor", R.drawable.kompleks, "019-233 6803", "Fri-Sun: 5:00 PM - 12:00 PM", "Mon-Thur");
            addRestaurants("Foodtruck caca pulut mangga", "Selangor, Shah Alam Section 18 Lot1-8-18 Grd Flr,Ole ole shopping centre, No 7, Jalan Pinang A 18/A", R.drawable.caca , "019-655 5339", "Mon-Sun: 10:00 AM - 10:00 PM", "Wednesday");
            addAdapter();
        }
//
        if (cat.equals("Johor")) {
            addRestaurants("Tebrau Food Truck Park", "Jln Harmonium 24/1, Taman Desa Tebrau, 81100 Johor Bahru, Johor", R.drawable.tebrau, "013-3446799", "Mon-Sun: 5:00 PM - 11:30 PM", "None");
            addRestaurants("Food Truck Sentral JB", "7, Jalan Tenteram, Tanjung Puteri, 80300 Johor Bahru, Johor", R.drawable.jb, "012-790 9521", "Fri-Sat: 6:00 PM - 11:30 PM", "Sunday");
            addRestaurants("Jobox Food Truck Park", "Plaza Angsana, Padang C, 81200 Johor Bahru, Johor", R.drawable.jobox , "011-6368 6709", "Tue-Sun: 6:00 PM - 12:00 AM", "Monday");
            addAdapter();
        }

        if (cat.equals("Sabah")) {
            addRestaurants("Food Truck Zone Kampung Air", "Kampung Air, 88000 Kota Kinabalu, Sabah", R.drawable.kampungair, "010-932 0707", "Mon-Sun: 5:00 PM - 12:00 AM", "None");
            addRestaurants("Medan Food Truck", "Bandar Tawau, 91000 Tawau, Sabah", R.drawable.medan, "014-890 7721", "Mon-Sun: 5:00 PM - 11:00 PM", "None");
            addRestaurants("Boboi Fried Chicken Damai Food Truck", "Jalan Damai, Taman Damai, 88300 Kota Kinabalu, Sabah", R.drawable.boboi , "012-833 7201", "Mon-Sun: 12:00 PM - 9:30 PM", "None");
            addAdapter();
        }



    }

        void addRestaurants(String name, String address, int imageResId, String phoneNumber, String workingTime, String closingDay  ) {
        RestaurantModel restaurantModel = new RestaurantModel(name, address, imageResId, phoneNumber, workingTime, closingDay);
        list.add(restaurantModel);
    }

    void addAdapter(){
        RestaurantAdapter restaurantAdapter=new RestaurantAdapter(RestaurantActivity.this,
                R.layout.list_layout,list);
        Log.e("list size ",list.size()+"");
        listView.setAdapter(restaurantAdapter);
    }
}