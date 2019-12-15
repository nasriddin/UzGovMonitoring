package uz.com.uzgovmonsys.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uz.com.uzgovmonsys.R;
import uz.com.uzgovmonsys.madel.Organizaions;

public class OrganizationsAdapter extends RecyclerView.Adapter<OrganizationsAdapter.ViewHolder> {

    List<Organizaions> list;
    OnItemClickListenerOrganization listener;

    public OrganizationsAdapter(List<Organizaions> list, OnItemClickListenerOrganization listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.companiy_list_item, viewGroup, false);
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

    public void setOrganization(List<Organizaions> organizaions) {
        list.clear();
        list.addAll(organizaions);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.organizationTitle)
        TextView compName;
        @BindView(R.id.regionsTitle)
        TextView regionTitle;

        @BindView(R.id.organizationsItem)
        LinearLayout organizationItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Organizaions organizaions) {
            compName.setText(organizaions.getName());
            this.regionTitle.setText(organizaions.getRegion().getName());
            Log.e("name", organizaions.getName());

            organizationItem.setOnClickListener(v -> {
                listener.onItemClick();
            });
        }


    }

    public interface OnItemClickListenerOrganization {
        public void onItemClick();
    }
}
