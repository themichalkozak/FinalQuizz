package com.example.themichalkozak.finalquiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary_activity);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String[] summary = extras.getStringArray("String_Array");
        String skillChoice = summary[0];
        String nameEditText_string = summary[1];
        String sexChoise = summary[2];
        String description = summary[3];


        TextView namEditText = findViewById(R.id.name_edit_text_summary);
        namEditText.setText(nameEditText_string);

        int quantityOfPoints = extras.getInt("NUMER_OF_POINTS");
        TextView quantityOfPointsTextView = findViewById(R.id.quantity_points);
        quantityOfPointsTextView.setText(quantityOfPoints + " /10");
        Log.i("SummaryPoints", "" + quantityOfPoints);


        TextView sexChoiseTextview = findViewById(R.id.sex_choise_text_view);
        sexChoiseTextview.setText(sexChoise);
        Log.i("SexChoiceSummary", sexChoise);

        TextView skillChoiceTextview = findViewById(R.id.level_of_cooking_summary_text_view);
        skillChoiceTextview.setText(skillChoice);

        TextView descriptionTextView = findViewById(R.id.description_text_view);
        descriptionTextView.setText(description);

        ImageView summaryImageView = findViewById(R.id.summary_ImageView);
        if (quantityOfPoints > 5) summaryImageView.setImageResource(R.drawable.cheflike);
        else summaryImageView.setImageResource(R.drawable.zmywak);

    }


    public void returnReply(View view) {

        Intent replyIntent = new Intent();
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}