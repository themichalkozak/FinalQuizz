package com.example.themichalkozak.finalquiz;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    public EditText nameEditText;
    public RadioButton firstRadioButton;
    public RadioButton secondRadioButton;
    public RadioButton thirdRadioButton;

    public static final int TEXT_REQUEST = 1;

    int page = 0;
    public int quantityPoints = 0;
    public String choseSex;
    public String chosesSkill;
    public String description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editText_main);

        firstRadioButton = findViewById(R.id.first_radio_button);
        secondRadioButton = findViewById(R.id.second_radio_button);
        thirdRadioButton = findViewById(R.id.third_radio_button);

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent questionIntent = new Intent(MainActivity.this,QPageActivity.class);
                questionIntent.putExtra("PAGE",page);
                questionIntent.putExtra("Test", "Test");
                startActivityForResult(questionIntent,TEXT_REQUEST);
                page++;
            }
        });
    }
            public String onRadioButtonClicked(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (view.getId()) {
                    case R.id.first_radio_button:
                        if (checked)
                            chosesSkill = getResources().getString(R.string.dishwasher_text_view);
                        Log.i("choseSkill", "" + chosesSkill);
                        break;
                    case R.id.second_radio_button:
                        if (checked)
                            chosesSkill = getResources().getString(R.string.cook_text_view);
                        break;

                    case R.id.third_radio_button:
                        if (checked)
                            chosesSkill = getResources().getString(R.string.chef_text_view);
                        break;
                }
                return chosesSkill;
            }

            public void onSexRadioButton(View view) {
                // Is the button now checked?
                boolean checked = ((RadioButton) view).isChecked();

                // Check which radio button was clicked
                switch (view.getId()) {
                    case R.id.men_radiobutton:
                        if (checked)
                            choseSex = getResources().getString(R.string.Womman_sex_choice);
                        break;
                    case R.id.woman_radiobutton:
                        if (checked)
                            choseSex = getResources().getString(R.string.sex_choise_text_view);
                        Log.i("RadioSexButton", "jest git");
                        break;
                }
            }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();
            if(extras!= null){
                quantityPoints = extras.getInt("POINTS");
                Log.i("Main Activity", "" + quantityPoints);
                lunchSummaryActivity();
            }
        }
    }

    public void lunchSummaryActivity(){

        String nameEditText_String = nameEditText.getText().toString();

        Intent intentSummary = new Intent(this, SummaryActivity.class);

        Bundle extra = new Bundle();

        String[] summary = {chosesSkill,nameEditText_String,choseSex,description};

        if (quantityPoints>5){
            summary [3] = getResources().getString(R.string.GoodDescription);
        }
        else summary [3] = getResources().getString(R.string.BadDescription);

        if(nameEditText_String.isEmpty()){
            nameEditText_String = "No name ;)";
            summary [1] = nameEditText_String;
        }
        else if (chosesSkill.isEmpty()){
            chosesSkill = "You don't choose your skill level";
            summary [0] = chosesSkill;
        }
        else if (choseSex.isEmpty()){
            choseSex = "Are you gender,\n Next time chose your sex";
            summary[2] = choseSex;
        }

        extra.putStringArray("String_Array", summary);
        extra.putInt("NUMER_OF_POINTS", quantityPoints);
        intentSummary.putExtras(extra);
        startActivityForResult(intentSummary, TEXT_REQUEST);


    }
}