package uz.com.uzgovmonsys.ui.auth;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {


    public Context context;
    public AuthActivityListener authActivitylistener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.authActivitylistener = (AuthActivityListener) context;
    }
}
