package uz.exemple.less52_imoui_contacts_java.model;

import java.util.ArrayList;

public class ImoModel<T> {
    private String title;
    private int icon;
    public ArrayList<T> arrayList;

    public ImoModel(String title, int icon, ArrayList<T> arrayList) {
        this.title = title;
        this.icon = icon;
        this.arrayList = arrayList;
    }

    public int getIcon() {
        return icon;
    }


}
