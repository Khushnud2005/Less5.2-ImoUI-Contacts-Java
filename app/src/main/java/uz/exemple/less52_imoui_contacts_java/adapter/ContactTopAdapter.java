package uz.exemple.less52_imoui_contacts_java.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less52_imoui_contacts_java.R;
import uz.exemple.less52_imoui_contacts_java.model.ContactTopModel;

public class ContactTopAdapter extends RecyclerView.Adapter<ContactTopAdapter.ViewHolder> {
    private ArrayList<ContactTopModel> arrayList;
    private Context context;


    public ContactTopAdapter(ArrayList<ContactTopModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts_top,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactTopModel item = arrayList.get(position);
        holder.icon.setImageResource(item.getIcon());
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title_CIT);
            icon = itemView.findViewById(R.id.iv_icon_TIC);
        }
    }
}
