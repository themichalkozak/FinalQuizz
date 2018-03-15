package com.example.themichalkozak.finalquiz;


import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {


    public EditText nameEditText;
    public RadioButton firstRadioButton;
    public RadioButton secondRadioButton;
    public RadioButton thirdRadioButton;
    public RadioGroup sexRadioGruop;
    public RadioGroup skillRadioGroup;

    public static final int TEXT_REQUEST = 1;

    int page = 0;
    public int quantityPoints = 0;
    public String choseSex = "null";
    public String chosesSkill = "null";
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

                Intent questionIntent = new Intent(MainActivity.this, QPageActivity.class);
                questionIntent.putExtra("PAGE", page);
                questionIntent.putExtra("Test", "Test");
                startActivityForResult(questionIntent, TEXT_REQUEST);
                page++;
            }
        });

        sexRadioGruop = findViewById(R.id.sex_radio_group);
        sexRadioGruop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                checkedId = sexRadioGruop.getCheckedRadioButtonId();

                if (checkedId == R.id.woman_radiobutton) {
                    choseSex = "woman";
                } else choseSex = "man";
            }
        });

        skillRadioGroup = findViewById(R.id.level_of_cooking_radio_button);

        skillRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.first_radio_button) {
                    chosesSkill = getResources().getString(R.string.dishwasher_text_view);
                } else if (checkedId == R.id.second_radio_button) {
                    chosesSkill = getResources().getString(R.string.cook_text_view);
                } else {
                    chosesSkill = getResources().getString(R.string.chef_text_view);
                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TEXT_REQUEST && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                quantityPoints = extras.getInt("POINTS");
                Log.i("Main Activity", "" + quantityPoints);
                lunchSummaryActivity();
            }
        }
    }

    public void lunchSummaryActivity() {


        String nameEditText_String = nameEditText.getText().toString();

        Intent intentSummary = new Intent(this, SummaryActivity.class);

        Bundle extra = new Bundle();

        String[] summary = {chosesSkill, nameEditText_String, choseSex, description};

        if (quantityPoints > 5) {
            summary[3] = getResources().getString(R.string.GoodDescription);
        } else summary[3] = getResources().getString(R.string.BadDescription);

        if (nameEditText_String.isEmpty()) {
            nameEditText_String = "No name ;)";
            summary[1] = nameEditText_String;
        }

        Log.i("Lunch", choseSex);


        extra.putStringArray("String_Array", summary);
        extra.putInt("NUMER_OF_POINTS", quantityPoints);
        intentSummary.putExtras(extra);
        startActivityForResult(intentSummary, TEXT_REQUEST);


    }
}