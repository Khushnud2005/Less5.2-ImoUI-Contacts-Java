package uz.exemple.less52_imoui_contacts_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import uz.exemple.less52_imoui_contacts_java.adapter.ContactTopAdapter;
import uz.exemple.less52_imoui_contacts_java.adapter.ImoAdapter;
import uz.exemple.less52_imoui_contacts_java.model.ChatModel;
import uz.exemple.less52_imoui_contacts_java.model.ContactModel;
import uz.exemple.less52_imoui_contacts_java.model.ContactTopModel;
import uz.exemple.less52_imoui_contacts_java.model.GroupModel;
import uz.exemple.less52_imoui_contacts_java.model.ImoModel;
import uz.exemple.less52_imoui_contacts_java.model.ProfileModel;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    RecyclerView recyclerView;
    BottomNavigationView bn_view;
    ArrayList<ImoModel> imoModels;

    LinearLayoutManager linearLayoutManager;
    Context context = this;

    private boolean isUserScrolling = false;
    private boolean isListGoingUp = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    void initViews(){
        tabLayout = findViewById(R.id.tab_layout);
        recyclerView = findViewById(R.id.recyclerView);
        bn_view = findViewById(R.id.bottom_navigation_view);

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);



        //ViewGroup tabs = (ViewGroup) tabLayout.getChildAt(0);
        imoModels = getImoLists();
        for (int i = 0;i<4;i++) {
            tabLayout.addTab(tabLayout.newTab());
            //tabLayout.getTabAt(i).setIcon(imoModels.get(i).getIcon());
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imoModels.get(i).getIcon());
            tabLayout.getTabAt(i).setCustomView(imageView);

        }
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                isUserScrolling = false ;
                int position = tab.getPosition();
                if(position==0){
                    recyclerView.smoothScrollToPosition(0);
                    bn_viewOff();
                }else if(position==1){
                    recyclerView.smoothScrollToPosition(1);
                    bn_viewOff();
                }else if(position==2){
                    recyclerView.smoothScrollToPosition(2);
                    bn_viewOff();
                }
                else if(position==3){
                    recyclerView.smoothScrollToPosition(3);
                    bn_viewOn();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    isUserScrolling = true;
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int itemPosition = linearLayoutManager.findFirstVisibleItemPosition();


                if(isUserScrolling){
                    if (itemPosition == 0) { //  item position of uses
                        TabLayout.Tab tab = tabLayout.getTabAt(0);
                        tab.select();
                        bn_viewOff();
                    } else if (itemPosition == 1) {//  item position of side effects
                        TabLayout.Tab tab = tabLayout.getTabAt(1);
                        tab.select();
                        bn_viewOff();
                    } else if (itemPosition == 2) {//  item position of how it works
                        TabLayout.Tab tab = tabLayout.getTabAt(2);
                        tab.select();
                        bn_viewOff();
                    }else if (itemPosition == 3) {//  item position of how it works
                        TabLayout.Tab tab = tabLayout.getTabAt(3);
                        tab.select();
                        bn_viewOn();
                    }
                }



            }
        });
        refreshAdapter(imoModels);
    }
    private void refreshAdapter(ArrayList<ImoModel> imoModels){
        ImoAdapter adapter = new ImoAdapter(context,imoModels);
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<ImoModel> getImoLists(){
        ArrayList<ImoModel> imoModels = new ArrayList<>();
        ArrayList<ProfileModel> profileModels = new ArrayList<>();
        ArrayList<ChatModel> chatModels = new ArrayList<>();
        ArrayList<GroupModel> groupModels = new ArrayList<>();
        ArrayList<ContactModel> contactModels = getContactLists();
        imoModels.add(new ImoModel("profile",R.drawable.profile,profileModels));
        imoModels.add(new ImoModel("chat",R.drawable.chat,chatModels));
        imoModels.add(new ImoModel("group",R.drawable.group,groupModels));
        imoModels.add(new ImoModel("contacts",R.drawable.contacts, contactModels));
        return imoModels;
    }

    public ArrayList<ContactModel> getContactLists(){
        ArrayList<ContactModel> contactModels = new ArrayList<>();
        contactModels.add(new ContactModel(R.drawable.mark_chanel,"Каналы Java",R.drawable.ic_right_24,null));
        contactModels.add(new ContactModel(R.drawable.photo3,"Kamolaxon Nematjonova",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo2,"Barnoxon Kabirova",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo4,"Abdullatif Nematjonov",R.drawable.ic_phone_24,"[HD Quality]"));
        contactModels.add(new ContactModel(R.drawable.photo1,"Xushnud Boymurodov",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo3,"Kamolaxon Nematjonova",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo2,"Barnoxon Kabirova",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo4,"Abdullatif Nematjonov",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo1,"Xushnud Boymurodov",R.drawable.ic_phone_24,"[HD Quality]"));
        contactModels.add(new ContactModel(R.drawable.photo3,"Kamolaxon Nematjonova",R.drawable.ic_phone_24,null));
        contactModels.add(new ContactModel(R.drawable.photo2,"Barnoxon Kabirova",R.drawable.ic_phone_24,null));



        return contactModels;
    }

    void bn_viewOn(){
        bn_view.setVisibility(View.VISIBLE);
    }
    void bn_viewOff(){
        bn_view.setVisibility(View.GONE);
    }


}