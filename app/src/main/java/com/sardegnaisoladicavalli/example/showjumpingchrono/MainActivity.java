package com.sardegnaisoladicavalli.example.showjumpingchrono;

import android.content.Context;
import android.os.SystemClock;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int coursePens;
    int timePens;
    int totalPens;
    int coursePens2;
    int timePens2;
    int totalPens2;
    int totalTeamPens;
    final int COURSE_PENS = 4;
    final int TIME_PEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();

    }

    /*Displaying course penalties of rider 1*/

    public void displayCoursePens (int coursePens){
        TextView courseView = (TextView) findViewById(R.id.course_pens);
        courseView.setText(String.valueOf(coursePens));
    }

    /*Displaying course penalties of rider 2*/

    public void displayCoursePens2 (int coursePens2){
        TextView courseView2 = (TextView) findViewById(R.id.course_pens2);
        courseView2.setText(String.valueOf(coursePens2));
    }

    /*Displaying time penalties of rider 1*/

    public void displayTimePens (int timePens){
        TextView timeViewPens = (TextView) findViewById(R.id.time_pens);
        timeViewPens.setText(String.valueOf(timePens));
    }

    /*Displaying time penalties of rider 2*/

    public void displayTimePens2 (int timePens2){
        TextView timeViewPens2 = (TextView) findViewById(R.id.time_pens2);
        timeViewPens2.setText(String.valueOf(timePens2));
    }

    /*Displaying total penalties of rider 1*/

    public void displayTotalPens () {
        TextView totalView = (TextView) findViewById(R.id.total_pens);
        totalPens = timePens + coursePens;
        totalView.setText(String.valueOf(totalPens));
    }

    /*Displaying total penalties of rider 2*/

    public void displayTotalPens2 () {
        TextView totalView2 = (TextView) findViewById(R.id.total_pens2);
        totalPens2 = timePens2 + coursePens2;
        totalView2.setText(String.valueOf(totalPens2));
    }

    /*Summing the penalty points of the two riders as a team*/

    public void displayTeamPens (){
        TextView teamPens = (TextView) findViewById(R.id.total_TeamPens);
        totalTeamPens = totalPens + totalPens2;
        teamPens.setText(String.valueOf(totalTeamPens));
    }

    /*Attributing 4 penalty points to the rider 1 dropping a pole, or whose horse refuses to jump a fence*/

    public void addCoursePens (View view) {
        coursePens = coursePens + COURSE_PENS;
        displayCoursePens(coursePens);
        displayTotalPens();
        displayTeamPens();

    }

    /*Attributing 4 penalty points to the rider 2 dropping a pole, or whose horse refuses to jump a fence*/

    public void addCoursePens2 (View view) {
        coursePens2 = coursePens2 + COURSE_PENS;
        displayCoursePens2(coursePens2);
        displayTotalPens2();
        displayTeamPens();

    }

    /*Attributing 1 penalty point to the rider 1, overcoming the maximum time allowed for completing the course*/

    public void addTimePens (View view) {
        timePens = timePens + TIME_PEN;
        displayTimePens(timePens);
        displayTotalPens();
        displayTeamPens();

    }

    /*Attributing 1 penalty point to the rider 2, overcoming the maximum time allowed for completing the course*/

    public void addTimePens2 (View view) {
        timePens2 = timePens2 + TIME_PEN;
        displayTimePens2(timePens2);
        displayTotalPens2();
        displayTeamPens();

    }

    /*Reset all penalties. Ready to another course/team*/

    public void resetAll (View view) {
        coursePens = 0;
        timePens = 0;
        totalPens = 0;
        coursePens2 = 0;
        timePens2 = 0;
        totalPens2 = 0;
        totalTeamPens = 0;
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("coursePens", coursePens);
        savedInstanceState.putInt("timePens", timePens);
        savedInstanceState.putInt("totalPens", totalPens);
        savedInstanceState.putInt("coursePens2", coursePens2);
        savedInstanceState.putInt("timePens2", timePens2);
        savedInstanceState.putInt("totalPens2", totalPens2);
        savedInstanceState.putInt("totalTeamPens", totalTeamPens);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        coursePens = savedInstanceState.getInt("coursePens");
        timePens = savedInstanceState.getInt("timePens");
        totalPens = savedInstanceState.getInt("totalPens");
        coursePens2 = savedInstanceState.getInt("coursePens2");
        timePens2 = savedInstanceState.getInt("timePens2");
        totalPens2 = savedInstanceState.getInt("totalPens2");
        totalTeamPens = savedInstanceState.getInt("totalTeamPens");
        displayCoursePens(coursePens);
        displayCoursePens2(coursePens2);
        displayTimePens(timePens);
        displayTimePens2(timePens2);
        displayTotalPens();
        displayTotalPens2();
        displayTeamPens();
    }

}