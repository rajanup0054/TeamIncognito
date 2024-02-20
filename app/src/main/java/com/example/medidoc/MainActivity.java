package com.example.medidoc;

// MainActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);

        // Create fade-in animation for the ImageView
        AlphaAnimation fadeInImage = new AlphaAnimation(0.0f, 1.0f);
        fadeInImage.setDuration(1500); // Adjust the duration as needed

        // Create slide-in and fade-in animation for the TextView
        TranslateAnimation slideInText = new TranslateAnimation(-1000f, 0f, 0f, 0f);
        AlphaAnimation fadeInText = new AlphaAnimation(0.0f, 1.0f);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(slideInText);
        animationSet.addAnimation(fadeInText);
        animationSet.setDuration(2000); // Adjust the duration as needed

        // Set animation listeners
        fadeInImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Do nothing
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Make the TextView visible after the ImageView animation ends
                textView.setVisibility(TextView.VISIBLE);
                textView.startAnimation(animationSet);

                // Start the delay and transition to HomeActivity
                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {
                                Intent intent = new Intent(MainActivity.this, Home.class);
                                startActivity(intent);
                                finish(); // Close the splash screen activity
                            }
                        },
                        2500 // Delay in milliseconds (adjust as needed)
                );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Do nothing
            }
        });

        // Start the animations
        imageView.startAnimation(fadeInImage);
    }
}
