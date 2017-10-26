package com.nivedhana;

import android.app.Application;
import timber.log.Timber;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by gowtham pr on 10/26/2017.
 */

public class Nivendhana extends Application {

  @Override public void onCreate() {
    super.onCreate();
    CalligraphyConfig.initDefault(
        new CalligraphyConfig.Builder().setDefaultFontPath("fonts/roboto-regular.ttf")
            .setFontAttrId(R.attr.fontPath)
            .build());
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}
