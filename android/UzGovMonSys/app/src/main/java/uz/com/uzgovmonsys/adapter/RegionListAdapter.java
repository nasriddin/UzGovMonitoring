package uz.com.uzgovmonsys.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.RegionsResponse;

public class RegionListAdapter extends RecyclerView.Adapter<RegionListAdapter.ViewHolder> {

    List<RegionsResponse> list;

    RegionItemSelected listener;

    public RegionListAdapter(RegionItemSelected listener, List<RegionsResponse> list) {
        this.listener = listener;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.region_list_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.selectedItemView)
        LinearLayout selectedItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(RegionsResponse regionsResponse) {
            this.title.setText(regionsResponse.getName());
            selectedItemView.setOnClickListener(v -> {
                listener.selectedItem(regionsResponse.getName(), regionsResponse.getId()+"");
            });
        }
    }

    public interface RegionItemSelected {
        void selectedItem(String title, String id);

    }
}
