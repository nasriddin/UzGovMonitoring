package uz.com.uzgovmonsys.ui.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {


    public Context context;
    public   MainActvityListener mainActvityListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        this.mainActvityListener= (MainActvityListener) context;
    }
}
