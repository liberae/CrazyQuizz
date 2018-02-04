package com.example.android.crazyquizz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuestionGenerator {

    private static QuestionGenerator questionGenerator;
    private String[] questionsArray;
    private List<String> questions;

    private QuestionGenerator(ScreenSlidePagerFragmentTwo context) {
        questionsArray = context.getResources().getStringArray(R.array.questions_array);
        questions = Arrays.asList(questionsArray);
        Collections.shuffle(questions);
    }

    public static QuestionGenerator get(ScreenSlidePagerFragmentTwo context) {

        if (questionGenerator == null) {
            questionGenerator = new QuestionGenerator(context);
        }
        return questionGenerator;
    }

    public List<String> getQuestions() {

        return questions;
    }
}


