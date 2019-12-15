package uz.com.uzgovmonsys.ui.auth;

import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
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
import butterknife.Unbinder;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.Login;
import uz.com.uzgovmonsys.utils.ValidationUtils;

import static uz.com.uzgovmonsys.constants.Constants.COUNTRY_CODE;
import static uz.com.uzgovmonsys.constants.Constants.PHONE_NUMBER_REGEX_FULL;
import static uz.com.uzgovmonsys.utils.UtilsClass.hideKeyboard;

public class LoginFragment extends BaseFragment {


    public static final String TAG = LoginFragment.class.getName();
    @BindView(R.id.enter_phone)
    TextInputEditText enterPhone;
    @BindView(R.id.phone_text_input)
    TextInputLayout phoneTextInput;

    @BindView(R.id.pasword_input)
    TextInputLayout paswordInput;
    @BindView(R.id.enter_password)
    TextInputEditText enterPassword;

    @BindView(R.id.textRegister)
    TextView text;
    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.back)
    ImageView back;

    private ValidationUtils phoneNumberValidateUtil, passwordValidateUtil;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.login_fragment, container, false);

        return itemView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        unbinder = ButterKnife.bind(this, view);

        phoneNumberValidateUtil = new ValidationUtils(phoneTextInput, enterPhone);
        passwordValidateUtil = new ValidationUtils(paswordInput, enterPassword);
        enterPhone.setMinEms(4);
        enterPhone.setText(COUNTRY_CODE);
        enterPhone.setSelection(COUNTRY_CODE.length());
        toolbar_title.setText(context.getResources().getString(R.string.login));
        back.setOnClickListener(v -> getActivity().onBackPressed());

    }


    @OnClick({R.id.btn, R.id.textRegister})
    void onClck(View view) {

        switch (view.getId()) {
            case R.id.btn: {

                String phoneNumber = enterPhone.getText().toString().trim();
                String password = enterPassword.getText().toString().trim();
                if (!phoneNumber.matches(PHONE_NUMBER_REGEX_FULL)) {
                    phoneNumberValidateUtil.setErrorMsg("Noto'g'ri format");
                    return;
                }

                if (password.isEmpty()) {
                    passwordValidateUtil.setErrorMsg("Empty password");
                    return;
                }
                if (password.length() < 6) {
                    passwordValidateUtil.setErrorMsg("password min 6 characters");
                    return;
                }
                hideKeyboard(enterPhone);
                authActivitylistener.login(new Login(phoneNumber, password));
                return;
            }
            case R.id.textRegister: {
                hideKeyboard(enterPassword);
                authActivitylistener.createAuth();
                return;
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
