package uz.com.uzgovmonsys.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.adapter.OrganizationsAdapter;
import uz.com.uzgovmonsys.adapter.RegionListAdapter;
import uz.com.uzgovmonsys.madel.Organizaions;
import uz.com.uzgovmonsys.madel.RegionsResponse;
import uz.com.uzgovmonsys.utils.RegionsDialog;

public class SortFragment extends BaseFragment {


    public static final String TAG = SortFragment.class.getName();
    @BindView(R.id.selectRegion)
    LinearLayout selectRegion;
    @BindView(R.id.selectText)
    TextView selectText;
    @BindView(R.id.companiyName)
    RecyclerView compList;

    List<Organizaions> organizaions;
    OrganizationsAdapter adapter;

    OrganizationsAdapter.OnItemClickListenerOrganization onItemClickListener= () -> {
mainActvityListener.commetFragment();
    };
    private static List<RegionsResponse> regionsResponse;
    private Unbinder unbinder;
    RegionsDialog dialog;
    RegionListAdapter.RegionItemSelected listener = (title, id) -> {
        selectText.setTextColor(context.getResources().getColor(R.color.color_white));
        mainActvityListener.organizationsById(id);
        selectText.setText(title);
        dialog.dismiss();

    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.sort_view, container, false);

        return itemView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        organizaions = new ArrayList<>();
        adapter = new OrganizationsAdapter(organizaions,onItemClickListener);
        compList.setAdapter(adapter);
        compList.setLayoutManager(new LinearLayoutManager(context));
        mainActvityListener.organizations();


    }


    public void setOrganizaions(List<Organizaions> organizaions) {
        adapter.setOrganization(organizaions);

    }

    @OnClick(R.id.selectRegion)
    public void onCLick() {
        dialog = new RegionsDialog(context, listener, regionsResponse);
        dialog.show();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public static SortFragment newInstance(List<RegionsResponse> regions) {

        Bundle args = new Bundle();
        regionsResponse = regions;
        SortFragment fragment = new SortFragment();
        return fragment;
    }


}
