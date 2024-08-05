package com.srijit.fincept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button in the layout and set an OnClickListener
        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
    }

    public void openMaps() {
        // Coordinates for Kolkata, India: 22.5839° N, 88.3434° E
        double latitude = 22.5839;
        double longitude = 88.3434;

        // Create a URI with the coordinates
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);

        // Create an intent to launch Google Maps
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        // Verify if there is an app available to handle the intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            // Start the activity if Google Maps is installed
            startActivity(mapIntent);
        } else {
            // Display a toast message if Google Maps is not installed
            Toast.makeText(this, "Google Maps Opening", Toast.LENGTH_SHORT).show();
        }
    }
}
