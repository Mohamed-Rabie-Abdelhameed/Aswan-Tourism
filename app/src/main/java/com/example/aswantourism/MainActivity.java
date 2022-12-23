package com.example.aswantourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.names_listView);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Abu Simble Temple", R.drawable.abusimble, R.string.abusimble, "22.33756049736236, 31.625735643199235"));
        places.add(new Place("Kom Ombo Temple", R.drawable.komombo, R.string.komombo, "24.452387114004466, 32.928464083512274"));
        places.add(new Place("Philae Temple", R.drawable.philae, R.string.philae, "24.02580891914479, 32.884080618115235"));
        places.add(new Place("Edfu Temple", R.drawable.edfu, R.string.edfu, "24.976992442183903, 32.87292705468693"));
        places.add(new Place("Nubian Museum", R.drawable.nubian, R.string.nubian, "24.079630583902414, 32.88918562583491"));
        places.add(new Place("Aga Khan Mausoleum", R.drawable.agakhan, R.string.agakhan, "24.088172577915667, 32.87896633592344"));
        places.add(new Place("Ferial Park", R.drawable.ferial, R.string.ferial, "24.08895254912165, 32.899736290186176"));
        places.add(new Place("Gharb Soheil", R.drawable.gharb, R.string.gharb, "24.061278003948093, 32.86423767008516"));

        MyAdapter adapter = new MyAdapter(this, places);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Place place = (Place) adapter.getItem(i);
                String name = place.getName();
                int brief =place.getBrief();
                int image = place.getImage();
                String location = place.getLocation();

                Intent intent = new Intent(MainActivity.this, PlaceDetails.class);
                intent.putExtra("name", name);
                intent.putExtra("briefId", brief);
                intent.putExtra("imageId", image);
                intent.putExtra("location", location);

                startActivity(intent);
            }
        });

    }
}