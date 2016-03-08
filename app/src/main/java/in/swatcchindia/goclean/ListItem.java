package in.swatcchindia.goclean;

import android.graphics.Bitmap;

/**
 * Created by PROPHET on 06-03-2016.
 */
public class ListItem {
    private String name;private String url;
    private Bitmap image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
