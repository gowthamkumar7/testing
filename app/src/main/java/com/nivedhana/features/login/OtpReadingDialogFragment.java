package com.nivedhana.features.login;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.nivedhana.R;

/**
 * Created by gowtham pr on 10/26/2017.
 */

public class OtpReadingDialogFragment extends DialogFragment {

  private View mView;
  /*First otp charter*/
  private EditText mFirstOTPChar;
  /*Second otp charter*/
  private EditText mSecondOTPChar;
  /*Third otp charter*/
  private EditText mThirdOTPChar;
  /*Fourth otp charter*/
  private EditText mFourthOTPChar;

  private ImageView mCloseDialog;
  private TextView mOTPVerficationAcknowledgement;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    mView = inflater.inflate(R.layout.dialog_read_otp, container, false);
    findViews();
    addTextWatchersToEditTexts();
    return mView;
  }

  /*Add watchers to shift cursor to next edit text*/
  private void addTextWatchersToEditTexts() {
    mFirstOTPChar.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        changeFocustToNextEdiText(mFirstOTPChar, mSecondOTPChar);
      }

      @Override public void afterTextChanged(Editable editable) {

      }
    });
    mSecondOTPChar.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        changeFocustToNextEdiText(mSecondOTPChar, mThirdOTPChar);
      }

      @Override public void afterTextChanged(Editable editable) {

      }
    });
    mThirdOTPChar.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        changeFocustToNextEdiText(mThirdOTPChar, mFourthOTPChar);
      }

      @Override public void afterTextChanged(Editable editable) {

      }
    });
    mFourthOTPChar.addTextChangedListener(new TextWatcher() {
      @Override public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

      }

      @Override public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        verifyActualOTP();
      }

      @Override public void afterTextChanged(Editable editable) {

      }
    });
  }

  private void verifyActualOTP() {
    if (isOTPValid()) {
      String otp = mFirstOTPChar.getText().toString()
          + mSecondOTPChar.getText().toString()
          + mThirdOTPChar.getText().toString()
          + mFourthOTPChar.getText().toString();
    } else {
      mOTPVerficationAcknowledgement.setVisibility(View.VISIBLE);
    }

    //todo verify actual otp with user entered otp
  }

  private boolean isOTPValid() {
    return ((mFirstOTPChar.getText().toString().length() > 0)
        && (mSecondOTPChar.getText()
        .toString()
        .length() > 0)
        && (mThirdOTPChar.getText().toString().length() > 0)
        && (mFourthOTPChar.getText().toString().length() > 0));
  }

  /*Change the focus to next edit text*/
  private void changeFocustToNextEdiText(EditText currentFocusedEditext,
      EditText nextFocusedEditext) {
    if (currentFocusedEditext.getText().toString().length() == 1) {
      currentFocusedEditext.clearFocus();
      nextFocusedEditext.requestFocus();
    }
  }

  private void findViews() {
    mFirstOTPChar = mView.findViewById(R.id.id_ed_first_otp_char);
    mSecondOTPChar = mView.findViewById(R.id.id_ed_second_otp_char);
    mThirdOTPChar = mView.findViewById(R.id.id_ed_third_otp_char);
    mFourthOTPChar = mView.findViewById(R.id.id_ed_fourth_otp_char);
    mCloseDialog = mView.findViewById(R.id.id_close_dialog);
    mOTPVerficationAcknowledgement = mView.findViewById(R.id.id_otp_verfication_acknowlegement);
    mCloseDialog.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        getDialog().dismiss();
      }
    });
  }

  @Override public void onStart() {
    super.onStart();
    try {
      Dialog dialog = getDialog();
      if (dialog != null) {
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setLayout(width, height);
      }
    } catch (NullPointerException exc) {
      getDialog().dismiss();
    }
  }
}
