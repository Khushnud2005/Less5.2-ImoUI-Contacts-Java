package uz.exemple.less52_imoui_contacts_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less52_imoui_contacts_java.R;
import uz.exemple.less52_imoui_contacts_java.model.ContactModel;
import uz.exemple.less52_imoui_contacts_java.model.ContactTopModel;
import uz.exemple.less52_imoui_contacts_java.model.ImoModel;

public class ImoAdapter extends RecyclerView.Adapter<ImoAdapter.ViewHolder> {

    private ArrayList<ImoModel> imoModels;
    Context context;

    public ImoAdapter(Context context, ArrayList<ImoModel> imoModels)  {
        this.imoModels = imoModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imo,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImoModel imomodel = imoModels.get(position);

        ContactAdapter contactAdapter;
        contactAdapter = new ContactAdapter(imoModels.get(position).arrayList,context);
        holder.rv_contacts.setLayoutManager(new GridLayoutManager(context,1));
        holder.rv_contacts.setAdapter(contactAdapter);
        //contactAdapter.notifyDataSetChanged();



    }

    @Override
    public int getItemCount() {
        return imoModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rv_contacts;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_contacts = itemView.findViewById(R.id.rv_contacts);

        }
    }

}
