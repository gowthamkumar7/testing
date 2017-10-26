package com.nivedhana.features.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.nivedhana.R;
import com.nivedhana.base.BaseActivity;

public class LoginActivity extends BaseActivity {

  private Button mBtn_sendOtp;
  private EditText mEd_mobile_num;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    findViews();

    mBtn_sendOtp.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        if (isMobileNumberValid()) {
          mEd_mobile_num.setError(getString(R.string.not_valid_number_error));
        } else {
          readOTP();
        }
      }
    });
  }

  private void readOTP() {
    FragmentManager mFragmentManager = getSupportFragmentManager();
    new OtpReadingDialogFragment().show(mFragmentManager, "OTP");
  }

  //mobile number validation
  private boolean isMobileNumberValid() {
    String mobile_number = mEd_mobile_num.getText().toString();
    return mobile_number.length() < 10;
  }

  private void findViews() {
    mBtn_sendOtp = (Button) findViewById(R.id.id_btn_send_otp);
    mEd_mobile_num = (EditText) findViewById(R.id.id_ed_mobile_number);
  }
}
