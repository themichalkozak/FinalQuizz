package com.example.themichalkozak.finalquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class QPageActivity extends AppCompatActivity {

    public RadioGroup.OnCheckedChangeListener anserwListener = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            checkedId = radioGroupGradle.getCheckedRadioButtonId();

            selectedRadioButton = findViewById(checkedId);


            if(selectedRadioButton.getText().toString().equals(correctAnserw)){
                choosenAnserw=true;
            }else choosenAnserw=false;
        }
    };



    int[] goodAnswers = new int[10];

    public int quantityOfPoints;

    String[] currentArray;
    String correctAnserw;
    Drawable questionDrawable;
    Question question;

    ImageView questionImage;

    private LinearLayout gradleLayout;
    TextView gradleTv;

    private RadioGroup radioGroupGradle;
    private RadioButton selectedRadioButton;

    boolean choosenAnserw;

    int page = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_page);

        if(savedInstanceState != null){
            page = savedInstanceState.getInt("PAGE");
        }


        final TextView questionTextview = (TextView) findViewById(R.id.firstQ_text_view);

        final RadioButton firstAnserwRadioButton = (RadioButton) findViewById(R.id.odp1_1_radio_button);
        final RadioButton secondAnserwRadioButton = (RadioButton) findViewById(R.id.odp1_2_radio_button);
        final RadioButton thirdAnserwRadioButton = (RadioButton) findViewById(R.id.odp1_3_radio_button);
        final RadioButton fourthAnserwRadioButton = (RadioButton) findViewById(R.id.odp1_4_radio_button);


        gradleLayout = (LinearLayout) findViewById(R.id.gradle_layout);

        gradleTv = new TextView(QPageActivity.this);

        for(int i=0;i<10;i++){

            gradleLayout.addView(creatNewGradleTv(i));
            goodAnswers[i] = 2;
        }

        questionImage = (ImageView) findViewById(R.id.QPage_Image_View);




        final ArrayList<Question> questionArrayList = new ArrayList<Question>();

        questionArrayList.add(new Question(getDrawable(R.drawable.pizza), getResources().getStringArray(R.array.PacketOne), getResources().getStringArray(R.array.PacketOne)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.homar), getResources().getStringArray(R.array.PacketTwo), getResources().getStringArray(R.array.PacketTwo)[4]));
        questionArrayList.add(new Question(getDrawable(R.drawable.pitaya), getResources().getStringArray(R.array.PacketThree), getResources().getStringArray(R.array.PacketThree)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.karmel), getResources().getStringArray(R.array.PacketFour), getResources().getStringArray(R.array.PacketFour)[1]));
        questionArrayList.add(new Question(getDrawable(R.drawable.kuchniafrancuska), getResources().getStringArray(R.array.PacketFive), getResources().getStringArray(R.array.PacketFive)[2]));
        questionArrayList.add(new Question(getDrawable(R.drawable.czekolada), getResources().getStringArray(R.array.PacketSix), getResources().getStringArray(R.array.PacketSix)[4]));
        questionArrayList.add(new Question(getDrawable(R.drawable.kalorie), getResources().getStringArray(R.array.PacketSeven), getResources().getStringArray(R.array.PacketSeven)[1]));
        questionArrayList.add(new Question(getDrawable(R.drawable.zielonaherbata), getResources().getStringArray(R.array.PacketEight), getResources().getStringArray(R.array.PacketEight)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.guzikseczuanski), getResources().getStringArray(R.array.PacketNine), getResources().getStringArray(R.array.PacketNine)[1]));
        questionArrayList.add(new Question(getDrawable(R.drawable.whitechocolate), getResources().getStringArray(R.array.PacketTen), getResources().getStringArray(R.array.PacketTen)[3]));

        question = questionArrayList.get(page);

        currentArray = question.getQuestion();
        correctAnserw = question.getCorrectAnserw();
        questionDrawable = question.getImage();
        questionImage.setImageDrawable(questionDrawable);

        questionTextview.setText(currentArray[0]);
        firstAnserwRadioButton.setText(currentArray[1]);
        secondAnserwRadioButton.setText(currentArray[2]);
        thirdAnserwRadioButton.setText(currentArray[3]);
        fourthAnserwRadioButton.setText(currentArray[4]);

        radioGroupGradle = findViewById(R.id.radioanserwgroup);
        radioGroupGradle.setOnCheckedChangeListener(anserwListener);

        Log.i("PageQpageactivity", "" + page);

        Log.i("QPageActivity", "quantity of points " + quantityOfPoints);




        findViewById(R.id.nextQ_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button nextPage = (Button) findViewById(R.id.nextQ_button);
                if(page==9){
                    nextPage.setText("Summary");
                }

                gradleTv = (TextView) findViewById(page);

                if(choosenAnserw){
                    gradleTv.setBackground(getDrawable(R.drawable.circle_correct));
                    goodAnswers[page] = 1;
                    quantityOfPoints++;
                }else {
                    gradleTv.setBackground(getDrawable(R.drawable.cirrcle_incorect));
                    goodAnswers[page] = 0;
                }

                Log.i("chosen Anserw ", " " + choosenAnserw);

                page++;

                if (page<10) {

                    question = questionArrayList.get(page);
                    currentArray = question.getQuestion();
                    correctAnserw = question.getCorrectAnserw();
                    questionImage.setImageDrawable(question.getImage());
                    questionTextview.setText(currentArray[0]);

                    firstAnserwRadioButton.setText(currentArray[1]);
                    secondAnserwRadioButton.setText(currentArray[2]);
                    thirdAnserwRadioButton.setText(currentArray[3]);
                    fourthAnserwRadioButton.setText(currentArray[4]);

                        selectedRadioButton.setChecked(false);

                }else finish();


                Log.i("nextQ_button", "" + page);
            }
        });


//        radioGroupGradle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                checkedId = radioGroupGradle.getCheckedRadioButtonId();
//
//                selectedRadioButton = findViewById(checkedId);
//
//
//                if(selectedRadioButton.getText().toString().equals(correctAnserw)){
//                    choosenAnserw=true;
//                }else choosenAnserw=false;
//            }
//        });



        Log.i("Page", "" + page);


    }

    public TextView creatNewGradleTv (int IdIndex){

        String QArray [] = getResources().getStringArray(R.array.numberQ);


        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4,0,4,0);
        final TextView gradleTv = new TextView(QPageActivity.this);
        gradleTv.setLayoutParams(layoutParams);
        gradleTv.setText(QArray[IdIndex]);
        gradleTv.setId(IdIndex);
        gradleTv.setBackground(getDrawable(R.drawable.circle_unchecked));
        gradleTv.setGravity(Gravity.CENTER);

        return gradleTv;

    }

    @Override
    public void finish() {

            Log.i("page>10", "inside");
            Intent questionIntent = new Intent();

            questionIntent.putExtra("POINTS", quantityOfPoints);

            setResult(RESULT_OK, questionIntent);
            super.finish();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putIntArray("ANSWERS", goodAnswers);
        outState.putInt("PAGE",page);
        outState.putInt("POINTS",quantityOfPoints);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        goodAnswers = savedInstanceState.getIntArray("ANSWERS");
        page = savedInstanceState.getInt("PAGE");
        quantityOfPoints = savedInstanceState.getInt("POINT");

        Log.i("PAGE ONRESTORE","" + page);

        for (int i=0 ;i<10;i++){
            ArrayList<TextView> gradleArrayTv = new ArrayList<>();
            TextView gradleTv = (TextView) findViewById(i);
            if(goodAnswers[i] == 1){
                gradleTv.setBackground(getDrawable(R.drawable.circle_correct));
            }else if(goodAnswers[i] == 0) {
                gradleTv.setBackground(getDrawable(R.drawable.cirrcle_incorect));
            } else {
                gradleTv.setBackground(getDrawable(R.drawable.circle_unchecked));
            }
            gradleArrayTv.add(gradleTv);
        }
    }
}



