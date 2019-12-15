package uz.com.uzgovmonsys.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;

public class MainActivity extends MvpAppCompatActivity implements MainCallback, MainActvityListener {


    SortFragment fragment;
    @BindView(R.id.backIcon)
    ImageView backIcon;

    @BindView(R.id.showLayout)
    FrameLayout showLayout;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showLOading();
        backIcon.setOnClickListener(v -> {
            onBackPressed();
        });
        presenter.getRegions();
    }


    @Override
    public void onBackPressed() {


        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();

        } else if (count == 1) {
            finish();
        } else {
            Log.d("back", "onBackPressed");
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public void setRegions(List<RegionsResponse> regions) {
        fragment = SortFragment.newInstance(regions);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).addToBackStack(SortFragment.TAG).commit();

    }

    @Override
    public void hideLoading() {
        showLayout.setVisibility(View.GONE);
    }

    @Override
    public void showLOading() {
        showLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void organizations(List<Organizaions> organizaions) {
        fragment.setOrganizaions(organizaions);
    }


    @Override
    public void organizations() {
        presenter.getOrganizations();
    }

    @Override
    public void organizationsById(String id) {
        presenter.getOrganizationsByID(id);
    }

    @Override
    public void commetFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new CommentFragment()).addToBackStack(CommentFragment.TAG).commit();

    }
}
