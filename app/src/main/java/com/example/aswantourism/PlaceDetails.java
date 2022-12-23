package com.example.aswantourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);
        TextView nameView = findViewById(R.id.name);
        TextView brief = findViewById(R.id.brief);
        ImageView imageView = findViewById(R.id.imageView);

        Intent i = getIntent();
        String placeName = i.getStringExtra("name");
        String placeBrief = getString(i.getIntExtra("briefId",0));
        Drawable image = getDrawable(i.getIntExtra("imageId",0));
        String location = "geo:"+i.getStringExtra("location")+"?q="+placeName;

        nameView.setText(placeName);
        brief.setText(placeBrief);
        imageView.setImageDrawable(image);

        Button btnDirections = findViewById(R.id.btn);
        btnDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


    }
}