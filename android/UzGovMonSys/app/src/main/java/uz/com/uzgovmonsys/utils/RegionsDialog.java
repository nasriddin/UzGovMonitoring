package uz.com.uzgovmonsys.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.adapter.RegionListAdapter;
import uz.com.uzgovmonsys.madel.RegionsResponse;

public class RegionsDialog extends BottomSheetDialog {

    @BindView(R.id.regionList)
    RecyclerView regionListView;
    Context context;
    RegionListAdapter.RegionItemSelected listener;
    List<RegionsResponse> regionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public RegionsDialog(@NonNull Context context, RegionListAdapter.RegionItemSelected listener, List<RegionsResponse> regionsList) {
        super(context);
        this.context = context;
        this.listener = listener;
        this.regionsList = regionsList;
        setContentView(R.layout.regions_dialog);
        ButterKnife.bind(this);
        Window window = getWindow();
        if (window == null) return;
        FrameLayout bottomSheet = window.findViewById(com.google.android.material.R.id.design_bottom_sheet);
        bottomSheet.setBackgroundResource(R.drawable.background_bottom_sheet_dialog);
        createList();
    }


    private void createList() {

        RegionListAdapter regionListAdapter = new RegionListAdapter(listener,regionsList);
        regionListView.setLayoutManager(new LinearLayoutManager(context));
        regionListView.setAdapter(regionListAdapter);
    }
}
