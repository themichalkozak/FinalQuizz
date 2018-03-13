package com.example.themichalkozak.finalquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
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

import org.w3c.dom.Text;

import java.util.ArrayList;


public class QPageActivity extends AppCompatActivity {

    public int quantityOfPoints;

    String[] currentArray;
    String correctAnserw;
    Drawable questionDrawable;
    Question question;

    String colorGradle;

    String [] colorArray;

    ImageView questionImage;

    RadioButton selectedRadiobutton;
    RadioGroup radioGroupGradle;

    private LinearLayout gradleLayout;
    TextView gradleTv;

    boolean choosenAnserw;

    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_page);

        if (savedInstanceState != null) {
            String [] colorArrayTest = savedInstanceState.getStringArray("TEST");
            int pageTest = savedInstanceState.getInt("PAGE");
            Log.i(" pageTest", " " + pageTest);

            if(colorArrayTest.length != 0){

            for(int i=0;i<page;i++){
                gradleTv = findViewById(i);
                if(colorArrayTest [i].equals("red")){
                    gradleTv.setBackground(getDrawable(R.drawable.cirrcle_incorect));
                }else{
                    gradleTv.setBackground(getDrawable(R.drawable.circle_correct));
                }
            }
            }
        }



            gradleLayout = findViewById(R.id.gradle_layout);


            for (int i = 0; i < 10; i++) {

                gradleLayout.addView(creatNewGradleTv(i));


            }


            Intent reciveIntent = new Intent();

//       int  page = getIntent().getExtras().getInt("PAGE");

            final TextView questionTextview = findViewById(R.id.firstQ_text_view);

            final RadioButton firstAnserwRadioButton = findViewById(R.id.odp1_1_radio_button);
            final RadioButton secondAnserwRadioButton = findViewById(R.id.odp1_2_radio_button);
            final RadioButton thirdAnserwRadioButton = findViewById(R.id.odp1_3_radio_button);
            final RadioButton fourthAnserwRadioButton = findViewById(R.id.odp1_4_radio_button);


            gradleTv = new TextView(QPageActivity.this);


            questionImage = (ImageView) findViewById(R.id.QPage_Image_View);


            final ArrayList<Question> questionArrayList = new ArrayList<Question>();

            questionArrayList.add(new Question(getDrawable(R.drawable.pizza), getResources().getStringArray(R.array.PacketOne), getResources().getStringArray(R.array.PacketOne)[3]));
            questionArrayList.add(new Question(getDrawable(R.drawable.homar), getResources().getStringArray(R.array.PacketTwo), getResources().getStringArray(R.array.PacketTwo)[4]));
            questionArrayList.add(new Question(getDrawable(R.drawable.pitaya), getResources().getStringArray(R.array.PacketThree), getResources().getStringArray(R.array.PacketThree)[3]));
            questionArrayList.add(new Question(getDrawable(R.drawable.karmel), getResources().getStringArray(R.array.PacketFour), getResources().getStringArray(R.array.PacketFour)[1]));
            questionArrayList.add(new Question(getDrawable(R.drawable.kuchniafrancuska), getResources().getStringArray(R.array.PacketFive), getResources().getStringArray(R.array.PacketFive)[2]));
            questionArrayList.add(new Question(getDrawable(R.drawable.czekolada), getResources().getStringArray(R.array.PacketSix), getResources().getStringArray(R.array.PacketSix)[4]));
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

            colorArray = new String[10];


            Log.i("PageQpageactivity", "" + page);

            Log.i("QPageActivity", "quantity of points " + quantityOfPoints);

            findViewById(R.id.nextQ_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button nextPage = findViewById(R.id.nextQ_button);
                    if (page == 9) {
                        nextPage.setText("Summary");
                    }

                    gradleTv = findViewById(page);

//
                    page++;

                    if (page < 10) {

                        if (selectedRadiobutton.getText().equals(correctAnserw)) {
                            gradleTv.setBackground(getDrawable(R.drawable.circle_correct));
                            colorGradle = "green";

                        } else {
                            gradleTv.setBackground(getDrawable(R.drawable.cirrcle_incorect));
                            colorGradle = "red";
                        }


                        colorArray[page - 1] = colorGradle;

                        Bundle bundle = new Bundle();
                        bundle.putStringArray("GRADLE", colorArray);

                        onSaveInstanceState(bundle);

                        question = questionArrayList.get(page);
                        currentArray = question.getQuestion();
                        correctAnserw = question.getCorrectAnserw();
                        questionImage.setImageDrawable(question.getImage());
                        questionTextview.setText(currentArray[0]);

                        firstAnserwRadioButton.setText(currentArray[1]);
                        secondAnserwRadioButton.setText(currentArray[2]);
                        thirdAnserwRadioButton.setText(currentArray[3]);
                        fourthAnserwRadioButton.setText(currentArray[4]);
//
//                    ArrayList<TextView> gradleArray = new ArrayList<TextView>();
//                    gradleArray.add(gradleTv);
//                    int licznik =0;
//                    TextView pelson = gradleArray.get(licznik);
//                    licznik++;
//                    Log.i("pelson","" + pelson.getText().toString());
//
//                    Bundle bundle = new Bundle();
//
//                    bundle.putSerializable("GRADLE",gradleArray);
//
//                    onSaveInstanceState(bundle);

                        Log.i("Selected RadioButton", " " + selectedRadiobutton.getText().toString());


                    } else finish();

                    Log.i("nextQ_button", "" + page);
                }
            });


            radioGroupGradle = findViewById(R.id.radioanserwgroup);

            radioGroupGradle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {

                    checkedId = radioGroupGradle.getCheckedRadioButtonId();

                    selectedRadiobutton = findViewById(checkedId);

                }
            });

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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String [] arrayTest2 = new String[] {"green","green","green","green","green","green","green","green","green","green"};

        outState.putStringArray("TEST",arrayTest2);

        outState.putInt("PAGE",page);

        Log.i("ColorArray", " " + colorArray[page-1]);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String [] colorArrayTest = savedInstanceState.getStringArray("TEST");
        Log.i("onRestoreInstance"," "+ colorArrayTest.length);
        int pageTest = savedInstanceState.getInt("PAGE");

    }
}

