package com.example.android.crazyquizz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.example.android.crazyquizz.R.layout.activity_main3;


public class ScreenSlidePagerFragmentSeven extends ScreenSlidePagerFragmentTwo {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup secondScreen = (ViewGroup) inflater.inflate(activity_main3, container, false);
        return secondScreen;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        View view1 = getView();
        if (view != null) {
            view.findViewById(R.id.question_text_view);
        }
        if (view1 == null) {
            view1.findViewById(R.id.input_answer);
        }
        displayQuestions();
    }


    public void displayQuestions() {
        QuestionGenerator questionGenerator = QuestionGenerator.get(this);
        List<String> questions = questionGenerator.getQuestions();
        TextView questionTextView = (TextView) getView().findViewById(R.id.question_text_view);
        questionTextView.setText(questions.get(5));


    }

}
