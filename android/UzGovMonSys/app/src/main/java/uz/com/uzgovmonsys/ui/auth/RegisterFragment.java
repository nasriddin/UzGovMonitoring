package uz.com.uzgovmonsys.ui.auth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.UserRegister;
import uz.com.uzgovmonsys.utils.ValidationUtils;

import static uz.com.uzgovmonsys.constants.Constants.COUNTRY_CODE;
import static uz.com.uzgovmonsys.constants.Constants.PHONE_NUMBER_REGEX_FULL;
import static uz.com.uzgovmonsys.utils.UtilsClass.hideKeyboard;
import static uz.com.uzgovmonsys.utils.UtilsClass.showKeyboard;

public class RegisterFragment extends BaseFragment {
    public static final String TAG = RegisterFragment.class.getName();
    @BindView(R.id.enter_phone)
    TextInputEditText enter_phone;
    @BindView(R.id.phone_text_input)
    TextInputLayout phoneNumberTextInput;
    @BindView(R.id.name_inputlayout)
    TextInputLayout name;
    @BindView(R.id.enter_Name)
    TextInputEditText enterName;

    @BindView(R.id.password_textInput)
    TextInputLayout passwordInput;
    @BindView(R.id.enter_password)
    TextInputEditText enterPssword;

    @BindView(R.id.back)
    ImageView backIcon;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.textRegister)
    TextView textRegis;
    Unbinder unbinder;
    private ValidationUtils phoneNumberValidate;
    private ValidationUtils nameValidate;
    private ValidationUtils passwordrValidate;
    private String phoneNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.register_fragment, container, false);
        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        backIcon.setOnClickListener(v -> {
            hideKeyboard(enterName);
            getActivity().onBackPressed();
        });
        phoneNumberValidate = new ValidationUtils(phoneNumberTextInput, enter_phone);
        nameValidate = new ValidationUtils(name, enterName);
        passwordrValidate = new ValidationUtils(passwordInput, enterPssword);
        enter_phone.setText(COUNTRY_CODE);
        enter_phone.setSelection(COUNTRY_CODE.length());
        showKeyboard(context, enterName);
        toolbar_title.setText(context.getResources().getString(R.string.registration));

        textRegis.setOnClickListener(v -> getActivity().onBackPressed());
    }


    @OnClick(R.id.btn)
    public void onClick() {
        phoneNumber = enter_phone.getText().toString().trim();
        String name = enterName.getText().toString().trim();
        String password = enterPssword.getText().toString().trim();

        if (name.isEmpty()) {
            nameValidate.setErrorMsg("Bo'sh maydon");
            return;

        }
        if (!phoneNumber.matches(PHONE_NUMBER_REGEX_FULL)) {
            phoneNumberValidate.setErrorMsg("Noto'g'ri format");
            return;
        }
        if (password.isEmpty()) {
            passwordrValidate.setErrorMsg("password bo'sh");
            return;
        }
        if (password.length() < 6) {
            passwordrValidate.setErrorMsg("min 6 ta belgi");
            return;
        }

        Log.e("register", "registred");

        hideKeyboard(enter_phone);
        authActivitylistener.register(new UserRegister(name, phoneNumber, password));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
