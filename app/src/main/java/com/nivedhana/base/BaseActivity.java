package com.nivedhana.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by gowtham pr on 10/26/2017.
 * Base class for all the child activities.
 */

public abstract class BaseActivity extends AppCompatActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void attachBaseContext(Context context) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(context));
  }

  public void showToast(@NonNull String message, int toastType) {
    Toast.makeText(BaseActivity.this, message, toastType).show();
  }
}
