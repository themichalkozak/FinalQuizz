package com.example.themichalkozak.finalquiz;

import android.content.Intent;
import android.content.res.Configuration;
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


    int page = 1;
    public int quantityPoints = 0;
    boolean checkAnserw;
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



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.q_page); // it will use .xml from /res/layout
        }
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.q_page); // it will use xml from /res/layout-land
        }
    }


    public String onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case  R.id.first_radio_button:
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


    public void nextPage(View view) {
        Log.d(LOG_TAG, "Button clicked!");


        int[] intArray = new int[3];
        intArray[0] = 1;
        intArray[1] = 3;
        intArray[2] = quantityPoints;

        Intent intent = new Intent(this, QPageActivity.class);
        Bundle extras = new Bundle();

        extras.putStringArray("String_Array", getResources().getStringArray(R.array.PacketOne));
        extras.putIntArray("Number_Array", intArray);
        intent.putExtras(extras);
        startActivityForResult(intent, TEXT_REQUEST);

    }


    public void onActivityResult(int requestCode, int resultCode,
                                 Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {


                data.getIntExtra(QPageActivity.EXTRA_REPLY, page);


                boolean check = data.getBooleanExtra("EXTRA_CORRECT", checkAnserw);

                Log.i("ReturnValue", "" + check);

                if (check) {

                    quantityPoints += 1;
                }
                Log.i("QuantityOfPoints", "" + quantityPoints);
                Log.i("Page", "" + page);
                page += 1;


                Intent intent = new Intent(this, QPageActivity.class);
                Bundle extras = new Bundle();

                switch (page) {

                    case 2:

                        int[] intSecondArray  = new int[3];
                        intSecondArray[0]=2;
                        intSecondArray[1]=4;
                        intSecondArray[2]=quantityPoints;

                        extras.putStringArray("String_Array", getResources().getStringArray(R.array.PacketTwo));
                        extras.putIntArray("Number_Array",intSecondArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 3:

                        int[] intThirdArray  = new int[3];
                        intThirdArray[0]=3;
                        intThirdArray[1]=3;
                        intThirdArray[2]=quantityPoints;

                        extras.putStringArray("String_Array", getResources().getStringArray(R.array.PacketThree));
                        extras.putIntArray("Number_Array",intThirdArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 4:
                        int[] intFourArray  = new int[3];
                        intFourArray[0]=4;
                        intFourArray[1]=1;
                        intFourArray[2]=quantityPoints;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketFour));
                        extras.putIntArray("Number_Array",intFourArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 5:
                        int[] intFiveArray  = new int[3];
                        intFiveArray[0]=5;
                        intFiveArray[1]=2;
                        intFiveArray[2]=quantityPoints;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketFive));
                        extras.putIntArray("Number_Array",intFiveArray);

                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 6:
                        int[] intSixArray  = new int[3];
                        intSixArray[0]=6;
                        intSixArray[1]=2;
                        intSixArray[2]=quantityPoints;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketSix));
                        extras.putIntArray("Number_Array",intSixArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 7:
                        int[] intSevenArray  = new int[3];
                        intSevenArray[0]=7;
                        intSevenArray[1]=4;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketSeven));
                        extras.putIntArray("Number_Array",intSevenArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;


                    case 8:
                        int[] intEightArray  = new int[3];
                        intEightArray[0]=8;
                        intEightArray[1]=3;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketEight));
                        extras.putIntArray("Number_Array",intEightArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 9:
                        int[] intNineArray  = new int[3];
                        intNineArray[0]=9;
                        intNineArray[1]=1;
                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketNine));
                        extras.putIntArray("Number_Array",intNineArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 10:
                        int[] intTenArray  = new int[3];
                        intTenArray[0]=10;
                        intTenArray[1]=3;

                        extras.putStringArray("String_Array",getResources().getStringArray(R.array.PacketTen));
                        extras.putIntArray("Number_Array",intTenArray);
                        intent.putExtras(extras);
                        startActivityForResult(intent, TEXT_REQUEST);
                        break;
                    case 11:


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

                        break;
                }
                if (page == 11) {
                    page=0;
                    quantityPoints=0;
                    Log.i("Points_Summary_intent", "" + quantityPoints);
                    Log.i("SexChoise", "" + choseSex);
                    Log.i("chosesSkill", "" + chosesSkill);

                }
            }
        }
    }
}