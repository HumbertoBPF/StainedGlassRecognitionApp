package com.example.reconnaissancevitrauxuploader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class DisplayResults extends AppCompatActivity {

    private TextView artistDisplay;
    private TextView yearBirthDisplay;
    private TextView yearPassingDisplay;
    private TextView artistReferenceDisplay;
    private TextView glassDateDisplay;
    private TextView dateReferenceDisplay;
    private TextView iconographyDisplay;
    private TextView churchNameDisplay;
    private TextView urlDisplay;
    private TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_results);

        this.errorMessage = findViewById(R.id.space1);
        this.artistDisplay = findViewById(R.id.artistDisplay);
        this.yearBirthDisplay = findViewById(R.id.yearBirthDisplay);
        this.yearPassingDisplay = findViewById(R.id.yearPassingDisplay);
        this.artistReferenceDisplay = findViewById(R.id.artistReferenceDisplay);
        this.glassDateDisplay = findViewById(R.id.glassDateDisplay);
        this.dateReferenceDisplay = findViewById(R.id.dateReferenceDisplay);
        this.iconographyDisplay = findViewById(R.id.iconographyDisplay);
        this.churchNameDisplay = findViewById(R.id.churchNameDisplay);
        this.urlDisplay = findViewById(R.id.urlDisplay);

        Intent contentToDisplay = getIntent();
        String contentJSON = contentToDisplay.getStringExtra("contentToDisplay");

        try {
            JSONObject reader = new JSONObject(contentJSON);

            StainedGlass stainedGlass = new StainedGlass();
            stainedGlass.setArtist(reader.getString("artist"));
            stainedGlass.setYearBirth(reader.getString("year of birth"));
            stainedGlass.setYearPassing(reader.getString("year of passing"));
            stainedGlass.setArtistRef(reader.getString("artist reference"));
            stainedGlass.setGlassDate(reader.getString("glass date"));
            stainedGlass.setDateRef(reader.getString("date reference"));
            stainedGlass.setIconography(reader.getString("iconography"));
            stainedGlass.setChurchName(reader.getString("church name"));

            artistDisplay.setText("Artist : "+stainedGlass.getArtist());

            yearBirthDisplay.setText("Artist's year of birth : "+stainedGlass.getYearBirth());

            yearPassingDisplay.setText("Artist's year of death : "+stainedGlass.getYearPassing());

            artistReferenceDisplay.setText("Artist reference : "+stainedGlass.getArtistRef());

            glassDateDisplay.setText("Glass date : "+stainedGlass.getGlassDate());

            dateReferenceDisplay.setText("Date reference : "+stainedGlass.getDateRef());

            iconographyDisplay.setText("Iconography : "+stainedGlass.getIconography());

            churchNameDisplay.setText("Church name : "+stainedGlass.getChurchName());

            urlDisplay.setText("URL : "+reader.getString("url"));
        } catch (JSONException e) {
            e.printStackTrace();
            errorMessage.setText("Error during the processing, try again");
        }

    }
}