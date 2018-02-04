package com.example.android.crazyquizz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.android.crazyquizz.R.layout.activity_main4;


public class FinalScreen extends ScreenSlidePageFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup thirdScreen = (ViewGroup) inflater.inflate(activity_main4, container, false);
        return thirdScreen;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        displayFinalScore();
    }


    //method to display final score
    public void displayFinalScore() {
        TextView resultTextView = (TextView) getView().findViewById(R.id.result_text_view);
        String score = String.valueOf((((MainActivity) getActivity()).displayScore()));
        resultTextView.setText(score + "/12");

    }
}
























