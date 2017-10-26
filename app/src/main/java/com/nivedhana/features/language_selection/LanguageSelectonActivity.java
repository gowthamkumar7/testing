package com.nivedhana.features.language_selection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.nivedhana.R;
import com.nivedhana.base.BaseActivity;
import com.nivedhana.features.login.LoginActivity;
import com.nivedhana.utils.Constants;

/**
 * Shows selection of language
 */
public class LanguageSelectonActivity extends BaseActivity implements View.OnClickListener {

  private TextView tv_English;
  private TextView tv_Telugu;
  private TextView tv_Hindi;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_language_selecton);
    findViews();
    bindClikcListners();
  }

  private void findViews() {
    tv_English = (TextView) findViewById(R.id.id_tv_english);
    tv_Telugu = (TextView) findViewById(R.id.id_tv_telugu);
    tv_Hindi = (TextView) findViewById(R.id.id_tv_hindi);
  }

  private void bindClikcListners() {
    tv_English.setOnClickListener(this);
    tv_Telugu.setOnClickListener(this);
    tv_Hindi.setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    if (view.getId() == R.id.id_tv_english) {
      navigateToLoginScreen(Constants.ENGLISH);
    } else if (view.getId() == R.id.id_tv_telugu) {
      navigateToLoginScreen(Constants.TELUGU);
    } else {
      navigateToLoginScreen(Constants.HINDI);
    }
  }

  //Navigate user to next screen
  private void navigateToLoginScreen(String language) {
    startActivity(new Intent(LanguageSelectonActivity.this, LoginActivity.class).putExtra(
        Constants.SELECTED_LANGUAGE_KEY, language));
    finish();
  }
}
