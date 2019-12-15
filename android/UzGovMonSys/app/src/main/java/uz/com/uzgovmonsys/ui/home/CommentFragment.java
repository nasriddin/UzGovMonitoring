package uz.com.uzgovmonsys.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import uz.com.uzgovmonsys.R;

public class CommentFragment extends BaseFragment {


    public static final String TAG =CommentFragment.class.getName() ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.comment_fragment, container, false);
        return itemView;
    }
}
