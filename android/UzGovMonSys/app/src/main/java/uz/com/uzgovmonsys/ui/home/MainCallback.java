package uz.com.uzgovmonsys.ui.home;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;

public interface MainCallback extends MvpView {
    void setRegions(List<RegionsResponse> regions);

    void hideLoading();

    void showLOading();

    void organizations(List<Organizaions> organizaions);
}
