package com.nivedhana.features.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.nivedhana.R;
import com.nivedhana.features.language_selection.LanguageSelectonActivity;

/**
 * Shows splash for a while and navigate
 */
public class SplashScreen extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    showSplashScreen();
  }

  //Navigate user to next screen
  private void showSplashScreen() {
    new Thread(new Runnable() {
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        startActivity(new Intent(SplashScreen.this, LanguageSelectonActivity.class));
        finish();
      }
    }).start();
  }
}
