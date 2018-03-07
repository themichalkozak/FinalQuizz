package com.example.themichalkozak.finalquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class QPageActivity extends AppCompatActivity {

    public int quantityOfPoints;

    String[] currentArray;
    String correctAnserw;
    Drawable questionDrawable;
    Question question;

    ImageView questionImage;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_page);


        Intent reciveIntent = new Intent();

//       int  page = getIntent().getExtras().getInt("PAGE");

        TextView questionTextview = findViewById(R.id.firstQ_text_view);
        final RadioButton firstAnserwRadioButton = findViewById(R.id.odp1_1_radio_button);
        final RadioButton secondAnserwRadioButton = findViewById(R.id.odp1_2_radio_button);
        final RadioButton thirdAnserwRadioButton = findViewById(R.id.odp1_3_radio_button);
        final RadioButton fourthAnserwRadioButton = findViewById(R.id.odp1_4_radio_button);

        TextView graddle1 = findViewById(R.id.graddle1);
        TextView graddle2 = findViewById(R.id.graddle2);
        TextView graddle3 = findViewById(R.id.graddle3);
        TextView graddle4 = findViewById(R.id.graddle4);
        TextView graddle5 = findViewById(R.id.graddle5);
        TextView graddle6 = findViewById(R.id.graddle6);
        TextView graddle7 = findViewById(R.id.graddle7);
        TextView graddle8 = findViewById(R.id.graddle8);
        TextView graddle9 = findViewById(R.id.graddle9);
        TextView graddle10 = findViewById(R.id.graddle10);


        RadioGroup questionRadioGroup = (RadioGroup) findViewById(R.id.radioanserwgroup);
        questionRadioGroup.clearCheck();

        final ArrayList<Question> questionArrayList = new ArrayList<Question>();

        questionArrayList.add(new Question(getDrawable(R.drawable.pizza), getResources().getStringArray(R.array.PacketOne), getResources().getStringArray(R.array.PacketOne)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.homar), getResources().getStringArray(R.array.PacketTwo), getResources().getStringArray(R.array.PacketTwo)[4]));
        questionArrayList.add(new Question(getDrawable(R.drawable.pitaya), getResources().getStringArray(R.array.PacketThree), getResources().getStringArray(R.array.PacketThree)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.karmel), getResources().getStringArray(R.array.PacketFour), getResources().getStringArray(R.array.PacketFour)[1]));
        questionArrayList.add(new Question(getDrawable(R.drawable.kuchniafrancuska), getResources().getStringArray(R.array.PacketFive), getResources().getStringArray(R.array.PacketFive)[2]));
        questionArrayList.add(new Question(getDrawable(R.drawable.czekolada), getResources().getStringArray(R.array.PacketSix), getResources().getStringArray(R.array.PacketSix)[2]));
        questionArrayList.add(new Question(getDrawable(R.drawable.kalorie), getResources().getStringArray(R.array.PacketSeven), getResources().getStringArray(R.array.PacketSeven)[4]));
        questionArrayList.add(new Question(getDrawable(R.drawable.zielonaherbata), getResources().getStringArray(R.array.PacketEight), getResources().getStringArray(R.array.PacketEight)[3]));
        questionArrayList.add(new Question(getDrawable(R.drawable.guzikseczuanski), getResources().getStringArray(R.array.PacketNine), getResources().getStringArray(R.array.PacketNine)[1]));
        questionArrayList.add(new Question(getDrawable(R.drawable.whitechocolate), getResources().getStringArray(R.array.PacketTen), getResources().getStringArray(R.array.PacketTen)[3]));

        question = questionArrayList.get(page);
        currentArray = question.getQuestion();
        correctAnserw = question.getCorrectAnserw();
        questionDrawable = question.getImage();

        Log.i("PageQpageactivity", "" + page);

        questionImage = (ImageView) findViewById(R.id.QPage_Image_View);
        questionImage.setImageDrawable(questionDrawable);


        questionTextview.setText(currentArray[0]);
        firstAnserwRadioButton.setText(currentArray[1]);
        secondAnserwRadioButton.setText(currentArray[2]);
        thirdAnserwRadioButton.setText(currentArray[3]);
        fourthAnserwRadioButton.setText(currentArray[4]);


        questionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.odp1_1_radio_button:
                        if (firstAnserwRadioButton.getText().toString().equals(correctAnserw))
                            quantityOfPoints += 1;
                        Log.i("Radiobutton", "is Checked");
                        break;
                    case R.id.odp1_2_radio_button:
                        if (secondAnserwRadioButton.getText().toString().equals(correctAnserw))
                            quantityOfPoints += 1;
                        break;
                    case R.id.odp1_3_radio_button:
                        if (thirdAnserwRadioButton.getText().toString().equals(correctAnserw)) {
                            quantityOfPoints++;
                            Log.i("Radio button 1.3 ", "" + quantityOfPoints);
                        }
                        Log.i("" + thirdAnserwRadioButton.getText(), correctAnserw);
                        break;
                    case R.id.odp1_4_radio_button:
                        if (fourthAnserwRadioButton.getText().toString().equals(correctAnserw))
                            quantityOfPoints += 1;
                        break;
                }
            }
        });

        Log.i("QPageActivity", "quantity of points " + quantityOfPoints);


        findViewById(R.id.nextQ_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                question = questionArrayList.get(page);
                currentArray = question.getQuestion();
                correctAnserw = question.getCorrectAnserw();
                questionDrawable = question.getImage();

                questionImage.setImageDrawable(questionDrawable);

                page++;
                Log.i("nextQ_button", "" + page);
            }
        });


        final ArrayList<TextView> graddleArray = new ArrayList<TextView>();

        graddleArray.add(graddle1);
        graddleArray.add(graddle2);
        graddleArray.add(graddle3);
        graddleArray.add(graddle4);
        graddleArray.add(graddle5);
        graddleArray.add(graddle5);
        graddleArray.add(graddle6);
        graddleArray.add(graddle7);
        graddleArray.add(graddle8);
        graddleArray.add(graddle9);
        graddleArray.add(graddle10);


        TextView currentGraddle = graddleArray.get(page);
        currentGraddle.setBackground(getDrawable(R.drawable.circle_checked));

        if (page == 10) {
            finish();
        }

        Log.i("Page", "" + page);
    }

    @Override
    public void finish() {

        if (page > 9) {

            Log.i("page>10", "inside");
            Intent questionIntent = new Intent();

            questionIntent.putExtra("POINTS", quantityOfPoints);

            setResult(RESULT_OK, questionIntent);
            super.finish();

        } else {
            Intent nextQuestionPage = new Intent(QPageActivity.this, QPageActivity.class);
            page++;
            nextQuestionPage.putExtra("PAGE", page);
            startActivity(nextQuestionPage);
        }
    }
}

