package com.example.themichalkozak.finalquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;


public class QPageActivity extends AppCompatActivity {

    public int anserw,correctAnserw,quantityOfPoints,orange=1;

    public static final String  EXTRA_REPLY =
            "com.example.android.QPageActivity.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_page);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        String arrayREceived[] = extras.getStringArray("String_Array");
        int numberArray[] = extras.getIntArray("Number_Array");


        orange = numberArray[0];
        correctAnserw = numberArray[1];
        quantityOfPoints = numberArray[2];

        ArrayList<Question> questionArrayList = new ArrayList<Question>();

        questionArrayList.add(new Question(getDrawable(R.drawable.pizza),getResources().getStringArray(R.array.PacketOne),5));

        Question question = questionArrayList.get(orange);

        String [] currentArray = question.getQuestion();


        Log.i("PageQpageactivity",""+orange);

        ImageView imageview = findViewById(R.id.QPage_Image_View);
        imageview.setImageResource(R.drawable.pizza);


        TextView questionTextview = findViewById(R.id.firstQ_text_view);
        questionTextview.setText(currentArray[0]);


        RadioButton firstAnserwRadioButton = findViewById(R.id.odp1_1_radio_button);
        firstAnserwRadioButton.setText(currentArray[1]);

        RadioButton secondAnserwRadioButton = findViewById(R.id.odp1_2_radio_button);
        secondAnserwRadioButton.setText(currentArray[2]);

        RadioButton thirdAnserwRadioButton = findViewById(R.id.odp1_3_radio_button);
        thirdAnserwRadioButton.setText(currentArray[3]);

        RadioButton fourthAnserwRadioButton = findViewById(R.id.odp1_4_radio_button);
        fourthAnserwRadioButton.setText(currentArray[4]);
//
//        TextView secondQuestionGradding = findViewById(R.id.q2_text_view);
//        TextView firstQuestionGradding = findViewById(R.id.q1_text_view);
//        TextView thirdQuestionGradding = findViewById(R.id.q3_text_view);
//        TextView fourthQuestionGradding = findViewById(R.id.q4_text_view);
//        TextView fifthQuestionGradding = findViewById(R.id.q5_text_view);
//        TextView sixthQuestionGradding = findViewById(R.id.q6_text_view);
//        TextView seventhQuestionGradding = findViewById(R.id.q7_text_view);
//        TextView eighthQuestionGradding = findViewById(R.id.q8_text_view);
//        TextView ninethQuestionGradding = findViewById(R.id.q9_text_view);
//        TextView tenthQuestionGradding = findViewById(R.id.q10_text_view);

//        switch (orange){
//
//            case 1: firstQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                Log.i("qpage",""+ orange);
//                break;
//            case 2: secondQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.homar);
//                break;
//            case 3: thirdQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.pitayatwo);
//                break;
//            case 4: fourthQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.karmel);
//                break;
//            case 5: fifthQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.kuchniafrancuska);
//                break;
//            case 6: sixthQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.czekolada);
//                break;
//            case 7: seventhQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.kalorie);
//                break;
//            case 8: eighthQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.zielonaherbata);
//                break;
//            case 9: ninethQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.guzikseczuanski);
//                break;
//            case 10: tenthQuestionGradding.setBackgroundResource(R.drawable.circlegradding);
//                imageview.setImageResource(R.drawable.whitechocolate);
//                break;
//
//        }

    }



    public void markAnserw(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.odp1_1_radio_button:
                if (checked)
                    anserw=1;
                break;
            case R.id.odp1_2_radio_button:
                if (checked)
                    anserw=2;
                Log.i("RadioButton","bro");
                break;

            case R.id.odp1_3_radio_button:
                if(checked)
                    anserw=3;
                break;
            case R.id.odp1_4_radio_button:
                if(checked)
                    anserw=4;
                break;
        }
    }

    public void nextPage(View view) {


        Intent replyIntent = new Intent();

        if (correctAnserw==anserw) {

            replyIntent.putExtra("EXTRA_CORRECT", true);
        }

        setResult(RESULT_OK, replyIntent);
        finish();


    }
}
