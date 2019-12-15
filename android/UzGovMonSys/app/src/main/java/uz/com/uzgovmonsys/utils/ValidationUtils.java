package uz.com.uzgovmonsys.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ValidationUtils implements TextWatcher {

    private TextInputLayout textInputLayout;
    private EditText editText;
    private boolean isErrorShown;

    public ValidationUtils(TextInputLayout textInputLayout, TextInputEditText editText) {

        this.textInputLayout = textInputLayout;
        this.editText = editText;
        clearErrorMsg();
        editText.addTextChangedListener(this);
    }

    public void setErrorMsg(String errorMessage) {
        editText.setActivated(true);
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(errorMessage);
        isErrorShown = true;
    }

    public void clearErrorMsg() {
        editText.setActivated(false);
        textInputLayout.setError(null);
        textInputLayout.setErrorEnabled(false);
        isErrorShown = false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isErrorShown) {
            clearErrorMsg();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
