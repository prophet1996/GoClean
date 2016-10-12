package in.swatcchindia.goclean.model;

/**
 * Created by PROPHET on 09-10-2016.
 */

public class RespJSON {
   private String name;
    private String contact;
    private String url;
    private String address;

    public RespJSON(String name, String contact, String url, String address) {
        this.name = name;
        this.contact = contact;
        this.url = url;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
