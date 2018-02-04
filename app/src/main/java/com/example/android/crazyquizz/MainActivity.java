package com.example.android.crazyquizz;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import static com.example.android.crazyquizz.R.id.pager;

public class MainActivity extends FragmentActivity implements ScreenSlidePagerFragmentTwo.OnButtonPress {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 14;
    int score = 0;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */

    private PagerAdapter mPagerAdapter;
//calculates the score on the base of number of correct answers


    public void countScore() {
        score += +1;
        Log.v("MainActivity", "Score:" + score);
    }
//    get the final score

    public int displayScore() {
        int result = score;
        return result;
    }

    public void goToNextPage() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
        }, 700);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



/**Instantiate a viewpager and a PagerAdapter
 **/
        mPager = (ViewPager) findViewById(pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOffscreenPageLimit(1);
    }

    //    @Override
//
//    public void onBackPressed() {
//        if (mPager.getCurrentItem() == 0) {
//
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//
//            super.onBackPressed();
//        } else {
//
//            // Otherwise, select the previous step.
//
//            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//        }
//    }
//
//    @Override
    public void onButtonPress(int position) {

    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */

    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {

        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {

            return NUM_PAGES;
        }


        @Override
        public Fragment getItem(int position) {

//            we have our custom view pager declared in a separate class. we call the viewpager here and check
//            if the position is other than 0 AND bigger than 1 - we disable swiping for that condition.

            CustomViewPager yourCustomViewPager = (CustomViewPager) findViewById(R.id.pager);
            if (position != 0 && position > 1) {
                yourCustomViewPager.setPagingEnabled(true);
            }
            switch (position) {
                case 0:
                    return new ScreenSlidePageFragment();

                case 1:
                    return new ScreenSlidePagerFragmentTwo();
                case 2:
                    return new ScreenSlidePagerFragmentThree();
                case 3:
                    return new ScreenSlidePagerFragmentFour();
                case 4:
                    return new ScreenSlidePagerFragmentFive();
                case 5:
                    return new ScreenSlidePagerFragmentSix();
                case 6:
                    return new ScreenSlidePagerFragmentSeven();
                case 7:
                    return new ScreenSlidePagerFragmentEight();
                case 8:
                    return new ScreenSlidePagerFragmentNine();
                case 9:
                    return new ScreenSlidePagerFragmentTen();
                case 10:
                    return new ScreenSlidePagerFragmentEleven();
                case 11:
                    return new ScreenSlidePagerFragmentTwelve();
                case 12:
                    return new ScreenSlidePagerFragmentThirteen();
                case 13:
                    return new FinalScreen();
                default:
                    return null;
            }
        }

    }
}


























