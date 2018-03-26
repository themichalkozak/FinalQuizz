package com.example.themichalkozak.finalquiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class SummaryActivity extends AppCompatActivity {

    int rate;

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
        quantityOfPointsTextView.setText(quantityOfPoints + " /9");
        Log.i("SummaryPoints", "" + quantityOfPoints);


        TextView sexChoiseTextview = findViewById(R.id.sex_choise_text_view);
        sexChoiseTextview.setText(sexChoise);
        Log.i("SexChoiceSummary", sexChoise);

        TextView skillChoiceTextview = findViewById(R.id.level_of_cooking_summary_text_view);
        skillChoiceTextview.setText(skillChoice);

        TextView descriptionTextView = findViewById(R.id.description_text_view);
        descriptionTextView.setText(description);

//        ImageView summaryImageView = findViewById(R.id.summary_ImageView);
//        if (quantityOfPoints > 5) summaryImageView.setImageResource(R.drawable.cheflike);
//        else summaryImageView.setImageResource(R.drawable.zmywak);


        final CheckBox checkBox1 = findViewById(R.id.checkbox_1);
        final CheckBox checkBox2 = findViewById(R.id.checkbox_2);
        final CheckBox checkBox3 = findViewById(R.id.checkbox_3);
        final CheckBox checkBox4 = findViewById(R.id.checkbox_4);
        final CheckBox checkBox5 = findViewById(R.id.checkbox_5);

        findViewById(R.id.checkbox_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()){
                    rate=1;
                }else rate = 0;
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
            }
        });


        findViewById(R.id.checkbox_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked()){
                    rate=2;
                }else rate = 1;
                checkBox1.setChecked(true);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
            }
        });

        findViewById(R.id.checkbox_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox3.isChecked()){
                    rate=3;
                }else rate = 2;
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox4.setChecked(false);
                checkBox5.setChecked(false);
            }
        });
        findViewById(R.id.checkbox_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox4.isChecked()){
                    rate=4;
                }else rate = 3;
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox5.setChecked(false);
            }
        });
        findViewById(R.id.checkbox_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox5.isChecked()){
                    rate=5;
                }else rate = 4;
                checkBox1.setChecked(true);
                checkBox2.setChecked(true);
                checkBox3.setChecked(true);
                checkBox4.setChecked(true);
            }
        });

        findViewById(R.id.rate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText descriptionEditText = findViewById(R.id.rate_editText);
                String description = descriptionEditText.getText().toString();

                if(description.length() > 0){

                TextView rateDescription = findViewById(R.id.rate_description);
                rateDescription.setText("Your rate is: " + rate);
                }
            }
        });

    }


    public void returnReply(View view) {

        Intent replyIntent = new Intent();
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}