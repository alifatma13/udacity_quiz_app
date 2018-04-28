package com.example.fali10.gotquizapp;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Variables declared
    private int score;
    private RadioButton mRadioButtonAnswer1;
    private RadioButton mRadioButtonAnswer2;
    private RadioButton mRadioButtonAnswer3;
    private RadioButton mRadioButtonAnswer4;
    private RadioButton mRadioButtonAnswer5;
    private RadioGroup mRadioGroupQuestion1;
    private RadioGroup mRadioGroupQuestion2;
    private RadioGroup mRadioGroupQuestion3;
    private RadioGroup mRadioGroupQuestion4;
    private RadioGroup mRadioGroupQuestion5;
    private CheckBox mCheckBoxRob;
    private CheckBox mCheckBoxJohn;
    private CheckBox mCheckBoxArya;
    private CheckBox mCheckBoxBran;
    private CheckBox mCheckBoxSansa;
    private EditText mMotherOfDragon;
    private String mMotherOfDrangonAns1;
    private String mMotherOfDrangonAns2;
    private Button submit;
    private Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables initialized
        mRadioGroupQuestion1 = findViewById(R.id.radio_question1);
        mRadioGroupQuestion2 = findViewById(R.id.radio_question2);
        mRadioGroupQuestion3 = findViewById(R.id.radio_question3);
        mRadioGroupQuestion4 = findViewById(R.id.radio_question4);
        mRadioGroupQuestion5 = findViewById(R.id.radio_question5);
        mRadioButtonAnswer1 = findViewById(R.id.question_1_option_2_ans);
        mRadioButtonAnswer2 = findViewById(R.id.question_2_option_3_ans);
        mRadioButtonAnswer3 = findViewById(R.id.question_3_option_3_ans);
        mRadioButtonAnswer4 = findViewById(R.id.question_4_option_1_ans);
        mRadioButtonAnswer5 = findViewById(R.id.question_5_option_4_ans);
        mCheckBoxRob = findViewById(R.id.question_6_option_1);
        mCheckBoxJohn = findViewById(R.id.question_6_option_2);
        mCheckBoxArya = findViewById(R.id.question_6_option_3);
        mCheckBoxBran = findViewById(R.id.question_6_option_4);
        mCheckBoxSansa = findViewById(R.id.question_6_option_5);
        mMotherOfDragon = findViewById(R.id.answer_7);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        submit.setOnClickListener(this);
        reset.setOnClickListener(this);
        mMotherOfDrangonAns1 = getString(R.string.answer_7_a);
        mMotherOfDrangonAns2 = getString(R.string.answer_7_b);
    }


    public void onClick(View v) {

        String totalScore;
        switch (v.getId()) {
            // To check whether correct radio button or check box is clicked. Also to match the textView answer and increment the score on click of SUBMIT button
            case R.id.submit:
                score = 0;
                if (mRadioButtonAnswer1.isChecked()) {
                    score++;
                }
                if (mRadioButtonAnswer2.isChecked()) {
                    score++;
                }
                if (mRadioButtonAnswer3.isChecked()) {
                    score++;
                }
                if (mRadioButtonAnswer4.isChecked()) {
                    score++;
                }
                if (mRadioButtonAnswer5.isChecked()) {
                    score++;
                }
                if (mCheckBoxRob.isChecked() && mCheckBoxSansa.isChecked() && mCheckBoxArya.isChecked() && mCheckBoxBran.isChecked() && !mCheckBoxJohn.isChecked() ) {
                    score++;
                }
                if (mMotherOfDragon.getText().toString().equalsIgnoreCase(mMotherOfDrangonAns1) || mMotherOfDragon.getText().toString().equalsIgnoreCase(mMotherOfDrangonAns2)) {
                    score++;
                }

                totalScore = getString(R.string.totalScore, score);
                Toast.makeText(MainActivity.this, totalScore, Toast.LENGTH_LONG).show();
                break;

            // To reset the selection of the answers on click of Reset
            case R.id.reset:
                mRadioGroupQuestion1.clearCheck();
                mRadioGroupQuestion2.clearCheck();
                mRadioGroupQuestion3.clearCheck();
                mRadioGroupQuestion4.clearCheck();
                mRadioGroupQuestion5.clearCheck();
                mCheckBoxRob.setChecked(false);
                mCheckBoxSansa.setChecked(false);
                mCheckBoxArya.setChecked(false);
                mCheckBoxBran.setChecked(false);
                mCheckBoxJohn.setChecked(false);
                mMotherOfDragon.setText("");
                score = 0;
                break;
        }
    }


    // In order to change the background according to screen orientation
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Drawable john = getResources().getDrawable(R.drawable.john);
        Drawable johnCopy = getResources().getDrawable(R.drawable.johncopy);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            findViewById(R.id.main).setBackground(john);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            findViewById(R.id.main).setBackground(johnCopy);
        }
    }
}
