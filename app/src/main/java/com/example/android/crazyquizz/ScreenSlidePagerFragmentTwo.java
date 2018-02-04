package com.example.android.crazyquizz;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.R.color.white;
import static com.example.android.crazyquizz.R.layout.activity_main3;
//I changed ScreenSlidePagerFragment to Fragment


public class ScreenSlidePagerFragmentTwo extends ScreenSlidePageFragment {

    CheckBox checkBox;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;

    // Container Activity must implement this interface

    private int position;
    private View btnNext;
    private OnButtonPress callback;

    public static ScreenSlidePageFragment getInstance(int position) {
        ScreenSlidePagerFragmentTwo f = new ScreenSlidePagerFragmentTwo();
        Bundle args = new Bundle();
        args.putInt("POSITION", position);
        f.setArguments(args);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(activity_main3, container, false);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (OnButtonPress) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if (view != null) {
            view.findViewById(R.id.question_text_view);
        }

        displayQuestions();
        displayAnswers();
    }
//to get the text view from a layout belonging to a fragment activity we needed to invoke a method
//    onActivityCreated with a superclass and then check if the view does not equal to null the view
//    will be set to that textview from a fragment activity. otherwise the findviewbyid method doesnt
//    see the textview because its in the main layout and the setContentView in MainActivity.java is set to activity_main.

    public void displayQuestions() {
        TextView questionTextView = (TextView) getView().findViewById(R.id.question_text_view);
        QuestionGenerator questionGenerator = QuestionGenerator.get(this);
        List<String> questions = questionGenerator.getQuestions();
        questionTextView.setText(questions.get(0));

    }


    public void displayAnswers() {
        Resources res = getResources();
        final TextView questionTextView = (TextView) getView().findViewById(R.id.question_text_view);
//        ViewGroup Layout = (LinearLayout) getActivity().findViewById(R.id.activity_screen_slide_pager_fragment_two);
        //        declaring what should be a correct answer
        final RadioButton rbOne = (RadioButton) getView().findViewById(R.id.button_answer_one);
        final RadioButton rbTwo = (RadioButton) getView().findViewById(R.id.button_answer_two);
        final RadioButton rbThree = (RadioButton) getView().findViewById(R.id.button_answer_three);
        final RadioButton rbFour = (RadioButton) getView().findViewById(R.id.button_answer_four);

        final EditText editText = new EditText(getActivity());
        editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        editText.setTextColor(getResources().getColor(white));
        RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.radio_group);

        if (questionTextView.getText().equals("The most famous, legendary martial artist?")) {
            ViewGroup parent = (ViewGroup) radioGroup.getParent();
            int index = parent.indexOfChild(radioGroup);
            parent.removeView(radioGroup);
            parent.addView(editText, index);

        } else if (questionTextView.getText().equals("Pick two of the weapons used in sport version of Eskrima - combat kalaki?")) {
            ViewGroup parent = (ViewGroup) radioGroup.getParent();
            int index = parent.indexOfChild(radioGroup);
            parent.removeView(radioGroup);
            for (int i = 0; i < 4; i++) {
                checkBox = new CheckBox(getActivity());
                checkBox.setText("Solo Baston");
                checkBox.setTextColor(getResources().getColor(white));
                parent.addView(checkBox, index);
                i = i + 1;
                checkBox1 = new CheckBox(getActivity());
                checkBox1.setText("Double Baston");
                checkBox1.setTextColor(getResources().getColor(white));
                parent.addView(checkBox1, index);
                i = i + 2;
                checkBox2 = new CheckBox(getActivity());
                checkBox2.setText("Tomahawk");
                checkBox2.setTextColor(getResources().getColor(white));
                parent.addView(checkBox2, index);
                i = i + 2;
                checkBox3 = new CheckBox(getActivity());
                checkBox3.setText("Balisong");
                checkBox3.setTextColor(getResources().getColor(white));
                parent.addView(checkBox3, index);
                i = i + 2;
            }

        }






/*IN THESE IF STATEMENTS I DECIPHER WHAT QUESTION HAS BEEN DISPLAYED AND ASSIGN RESPECTIVE ANSWERS BASED ON THAT QUESTION
* */
        if (questionTextView.getText().equals("What is the name of the national sport and martial art of the Philippines?")) {

            String[] answersArrayOne = res.getStringArray(R.array.answers_array_one);

            List<String> list = Arrays.asList(answersArrayOne);
//maybe a for loop here?
            Collections.shuffle(list);
            rbOne.setText(list.get(0));
            rbOne.isChecked();
            rbTwo.setText(list.get(1));
            rbTwo.isChecked();
            rbThree.setText(list.get(2));
            rbThree.isChecked();
            rbFour.setText(list.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("What do you call the fighting stick used in FMA(Filipino Martial Arts?")) {
            String[] answersArrayTwo = res.getStringArray(R.array.answers_array_two);

            List<String> list = Arrays.asList(answersArrayTwo);

            Collections.shuffle(list);
            rbOne.setText(list.get(0));
            rbOne.isChecked();
            rbTwo.setText(list.get(1));
            rbTwo.isChecked();
            rbThree.setText(list.get(2));
            rbThree.isChecked();
            rbFour.setText(list.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("Who was the first Spaniard to document Filipino Martial Arts origins?")) {
            String[] answersArrayThree = res.getStringArray(R.array.answers_array_three);

            List<String> listOne = Arrays.asList(answersArrayThree);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("How many angles of attack are there in Kali?")) {
            String[] answersArrayFour = res.getStringArray(R.array.answers_array_four);

            List<String> listOne = Arrays.asList(answersArrayFour);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("What is the most famous Filipino weapon known to the western world?")) {
            String[] answersArrayFive = res.getStringArray(R.array.answers_array_five);

            List<String> listOne = Arrays.asList(answersArrayFive);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("If you practice Filipino Martial Arts, what is most likely to get bruised the most?")) {
            String[] answersArraySix = res.getStringArray(R.array.answers_array_six);

            List<String> listOne = Arrays.asList(answersArraySix);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("What does Espada y daga mean?")) {
            String[] answersArraySeven = res.getStringArray(R.array.answers_array_seven);

            List<String> listOne = Arrays.asList(answersArraySeven);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("Which of the following Filipino martial arts is empty hand only (ie. no weapons)?")) {
            String[] answersArrayEight = res.getStringArray(R.array.answers_array_eight);

            List<String> listOne = Arrays.asList(answersArrayEight);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("Students usually refer to their Filipino instructors as:")) {
            String[] answersArrayNine = res.getStringArray(R.array.answers_array_nine);

            List<String> listOne = Arrays.asList(answersArrayNine);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        } else if (questionTextView.getText().equals("Historically, which famous explorer was killed by a Filipino fighter?")) {
            String[] answersArrayTen = res.getStringArray(R.array.answers_array_ten);

            List<String> listOne = Arrays.asList(answersArrayTen);

            Collections.shuffle(listOne);
            rbOne.setText(listOne.get(0));
            rbOne.isChecked();
            rbTwo.setText(listOne.get(1));
            rbTwo.isChecked();
            rbThree.setText(listOne.get(2));
            rbThree.isChecked();
            rbFour.setText(listOne.get(3));
            rbFour.isChecked();
        }


        Button submitAnswer = (Button) getView().findViewById(R.id.submit_answer);
        submitAnswer.setOnClickListener(new OnClickListener() {
            @Override

            public void onClick(View v) {

                RadioGroup radioGroup = (RadioGroup) getView().findViewById(R.id.radio_group);

                String correctAnswer = "";
                String correctAnswerOne = "Kali";
                String correctAnswerTwo = "Eskrima";
                String correctAnswerThree = "Antonio Pigafetta";
                String correctAnswerFour = "12";
                String correctAnswerFive = "Balisong";
                String correctAnswerSix = "Hands and Arms";
                String correctAnswerSeven = "Sword and Dagger";
                String correctAnswerEight = "Panantukan";
                String correctAnswerNine = "Guro";
                String correctAnswerTen = "Ferdinand Magellan";
                String correctAnswerEleven = "BRUCE LEE";


                if (questionTextView.getText().equals("What is the name of the national sport and martial art of the Philippines?")) {
                    correctAnswer = correctAnswerOne;
                } else if (questionTextView.getText().equals("What do you call the fighting stick used in FMA(Filipino Martial Arts?")) {
                    correctAnswer = correctAnswerTwo;
                } else if (questionTextView.getText().equals("Who was the first Spaniard to document Filipino Martial Arts origins?")) {
                    correctAnswer = correctAnswerThree;
                } else if (questionTextView.getText().equals("How many angles of attack are there in Kali?")) {
                    correctAnswer = correctAnswerFour;
                } else if (questionTextView.getText().equals("What is the most famous Filipino weapon known to the western world?")) {
                    correctAnswer = correctAnswerFive;
                } else if (questionTextView.getText().equals("If you practice Filipino Martial Arts, what is most likely to get bruised the most?")) {
                    correctAnswer = correctAnswerSix;
                } else if (questionTextView.getText().equals("What does Espada y daga mean?")) {
                    correctAnswer = correctAnswerSeven;
                } else if (questionTextView.getText().equals("Which of the following Filipino martial arts is empty hand only (ie. no weapons)?")) {
                    correctAnswer = correctAnswerEight;
                } else if (questionTextView.getText().equals("Students usually refer to their Filipino instructors as:")) {
                    correctAnswer = correctAnswerNine;
                } else if (questionTextView.getText().equals("Historically, which famous explorer was killed by a Filipino fighter?")) {
                    correctAnswer = correctAnswerTen;
                } else if (questionTextView.getText().equals("The most famous, legendary martial artist?"))
                    correctAnswer = correctAnswerEleven;


//                If the answer is checked and is correct show this toast and go to the next page
//
                if (radioGroup == null && questionTextView.getText().equals("Pick two of the weapons used in sport version of Eskrima - combat kalaki?")) {
                    if (checkBox.isChecked() && checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked()) {
                        Toast toast = Toast.makeText(getContext(), "CORRECT!", Toast.LENGTH_SHORT);
                        toast.show();
                        ((MainActivity) getActivity()).goToNextPage();
                        ((MainActivity) getActivity()).countScore();
                    } else if (!checkBox.isChecked() || !checkBox1.isChecked() && checkBox2.isChecked()
                            || checkBox3.isChecked() || !checkBox2.isChecked() || !checkBox3.isChecked()) {
                        Toast toast = Toast.makeText(getContext(), "WRONG:(", Toast.LENGTH_SHORT);
                        toast.show();
                        ((MainActivity) getActivity()).goToNextPage();
                    }
                }


////
                if (radioGroup == null && questionTextView.getText().equals("The most famous, legendary martial artist?")) {
                    if (editText.getText().toString().contentEquals(correctAnswer)) {
                        Toast toast = Toast.makeText(getContext(), "CORRECT!", Toast.LENGTH_SHORT);
                        toast.show();
                        ((MainActivity) getActivity()).goToNextPage();
                        ((MainActivity) getActivity()).countScore();
                    } else if (!editText.getText().toString().contentEquals(correctAnswer)) {
                        Toast toast = Toast.makeText(getContext(), "WRONG:(", Toast.LENGTH_SHORT);
                        toast.show();
                        ((MainActivity) getActivity()).goToNextPage();
                    }
                }

//


                if (radioGroup != null) {
                    if (rbOne.isChecked() && rbOne.getText().toString().contentEquals(correctAnswer)
                            || rbTwo.isChecked() && rbTwo.getText().toString().contentEquals(correctAnswer)
                            || rbThree.isChecked() && rbThree.getText().toString().contentEquals(correctAnswer)
                            || rbFour.isChecked() && rbFour.getText().toString().contentEquals(correctAnswer)) {
                        Toast toast = Toast.makeText(getContext(), "CORRECT!", Toast.LENGTH_SHORT);
                        toast.show();
                        ((MainActivity) getActivity()).goToNextPage();
                        ((MainActivity) getActivity()).countScore();
//                    if the answer is checked and is wrong show this toast

                    }
                }
                if (radioGroup != null) {
                    if (rbOne.isChecked() && !rbOne.getText().toString().contentEquals(correctAnswer)
                            || rbTwo.isChecked() && !rbTwo.getText().toString().contentEquals(correctAnswer)
                            || rbThree.isChecked() && !rbThree.getText().toString().contentEquals(correctAnswer)
                            || rbFour.isChecked() && !rbFour.getText().toString().contentEquals(correctAnswer)) {
                    Toast toast = Toast.makeText(getContext(), "WRONG:(", Toast.LENGTH_SHORT);
                    toast.show();
                    ((MainActivity) getActivity()).goToNextPage();

                    }
                }
                if (radioGroup != null) {
                    if (!rbOne.isChecked() && !rbTwo.isChecked() && !rbThree.isChecked() && !rbFour.isChecked()) {
                        Toast toast = Toast.makeText(getContext(), "CHOOSE AN ANSWER", Toast.LENGTH_SHORT);
                        toast.show();

                    }
                }

            }


        });
    }


    public interface OnButtonPress {

        void onButtonPress(int position);

    }
}


