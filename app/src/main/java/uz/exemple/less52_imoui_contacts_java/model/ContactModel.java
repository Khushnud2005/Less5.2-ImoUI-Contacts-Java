package uz.exemple.less52_imoui_contacts_java.model;

public class ContactModel  {
    private int profile;
    private String fullName;
    private int icon;
    private String quality = null;

    public ContactModel(int profile, String fullName, int icon,String quality) {
        this.profile = profile;
        this.fullName = fullName;
        this.icon = icon;
        this.quality = quality;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullName() {
        return fullName;
    }

    public int getIcon() {
        return icon;
    }

    public String getQuality() {
        return quality;
    }
}
