package uz.exemple.less52_imoui_contacts_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import uz.exemple.less52_imoui_contacts_java.R;
import uz.exemple.less52_imoui_contacts_java.model.ContactModel;
import uz.exemple.less52_imoui_contacts_java.model.ContactTopModel;
import uz.exemple.less52_imoui_contacts_java.model.ImoModel;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<ContactModel> contactModels;
    Context context;
    RecyclerView rv_contactsTop;



    public ContactAdapter(ArrayList arrayList, Context context) {
        this.contactModels = arrayList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacts,parent,false);

        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contact = contactModels.get(position);
        ArrayList<ContactTopModel> contactTopModels = getItemsList();
        holder.profile.setImageResource(contact.getProfile());
        holder.fullname.setText(contact.getFullName());
        holder.icon_phone.setImageResource(contact.getIcon());
        if(contact.getQuality()!=null ){
            holder.quality.setVisibility(View.VISIBLE);
            holder.quality.setText(contact.getQuality());
        }

        if (position == 0){

            ContactTopAdapter contactTopAdapter = new ContactTopAdapter(contactTopModels,context);
            holder.rv_contactsTop.setLayoutManager(new GridLayoutManager(context,1));
            holder.rv_contactsTop.setAdapter(contactTopAdapter);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(0, 0, 0, 16);

            holder.rv_contactsTop.setLayoutParams(layoutParams);
            holder.yellow_marker.setVisibility(View.GONE);

        }


    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private TextView fullname;
        private TextView yellow_marker;
        private TextView quality;
        private ImageView icon_phone;
        private RecyclerView rv_contactsTop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_contactsTop = itemView.findViewById(R.id.rv_contacts_top);
            profile = itemView.findViewById(R.id.iv_profile_contactItem);
            fullname = itemView.findViewById(R.id.tv_fullName_contactItem);
            yellow_marker = itemView.findViewById(R.id.tv_marker_yellow);
            quality = itemView.findViewById(R.id.tv_quality);
            icon_phone = itemView.findViewById(R.id.iv_iconPhone_contactItem);
        }
    }


    public ArrayList<ContactTopModel> getItemsList(){
        ArrayList<ContactTopModel> items = new ArrayList<>();
        items.add(new ContactTopModel(R.drawable.ic_add_contact_24,"Новыие контакты"));
        items.add(new ContactTopModel(R.drawable.ic_list_24,"Журнал звонков"));
        items.add(new ContactTopModel(R.drawable.ic_groups_24,"Новый группавой чат"));

        return items;
    }

}
