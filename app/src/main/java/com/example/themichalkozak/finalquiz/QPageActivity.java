package com.example.themichalkozak.finalquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    public int quantityOfPoints;

    String[] currentArray;
    String correctAnserw;
    Drawable questionDrawable;
    Question question;

    ImageView questionImage;

    private LinearLayout gradleLayout;
    TextView gradleTv;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_page);


        Intent reciveIntent = new Intent();

//       int  page = getIntent().getExtras().getInt("PAGE");

        final TextView questionTextview = findViewById(R.id.firstQ_text_view);

        final RadioButton firstAnserwRadioButton = findViewById(R.id.odp1_1_radio_button);
        final RadioButton secondAnserwRadioButton = findViewById(R.id.odp1_2_radio_button);
        final RadioButton thirdAnserwRadioButton = findViewById(R.id.odp1_3_radio_button);
        final RadioButton fourthAnserwRadioButton = findViewById(R.id.odp1_4_radio_button);

        gradleLayout = findViewById(R.id.gradle_layout);

        gradleTv = new TextView(QPageActivity.this);

        for(int i=1;i<10;i++){

            gradleLayout.addView(creatNewGradleTv(page));

        }


        questionImage = (ImageView) findViewById(R.id.QPage_Image_View);
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
        questionImage.setImageDrawable(questionDrawable);

        questionTextview.setText(currentArray[0]);
        firstAnserwRadioButton.setText(currentArray[1]);
        secondAnserwRadioButton.setText(currentArray[2]);
        thirdAnserwRadioButton.setText(currentArray[3]);
        fourthAnserwRadioButton.setText(currentArray[4]);

        Log.i("PageQpageactivity", "" + page);


        questionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.odp1_1_radio_button:
                        if (firstAnserwRadioButton.getText().toString().equals(correctAnserw)){


                            quantityOfPoints += 1;

                        Log.i("Radiobutton", "is Checked");
                        }
                        break;
                    case R.id.odp1_2_radio_button:
                        if (secondAnserwRadioButton.getText().toString().equals(correctAnserw)) {
                            quantityOfPoints += 1;

                        }

                        break;
                    case R.id.odp1_3_radio_button:
                        if (thirdAnserwRadioButton.getText().toString().equals(correctAnserw)) {
                            quantityOfPoints++;
                            Log.i("Radio button 1.3 ", "" + quantityOfPoints);
                        }
                        Log.i("" + thirdAnserwRadioButton.getText(), correctAnserw);
                        break;
                    case R.id.odp1_4_radio_button:
                        if (fourthAnserwRadioButton.getText().toString().equals(correctAnserw)) {
                            quantityOfPoints += 1;

                        }
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
                questionTextview.setText(currentArray[0]);
                firstAnserwRadioButton.setText(currentArray[1]);
                secondAnserwRadioButton.setText(currentArray[2]);
                thirdAnserwRadioButton.setText(currentArray[3]);
                fourthAnserwRadioButton.setText(currentArray[4]);

                page++;
                Log.i("nextQ_button", "" + page);
            }
        });

        if (page == 10) {
            finish();
        }

        Log.i("Page", "" + page);
    }

    public TextView creatNewGradleTv (int IdIndex){


        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView gradleTv = new TextView(QPageActivity.this);
        gradleTv.setLayoutParams(layoutParams);
        gradleTv.setText("Q");
        gradleTv.setId(IdIndex);
        gradleTv.setBackground(getDrawable(R.drawable.circle_checked));

        return gradleTv;

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

