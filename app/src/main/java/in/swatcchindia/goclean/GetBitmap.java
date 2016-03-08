package in.swatcchindia.goclean;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import in.swatcchindia.goclean.Screens.HomeFragment;

/**
 * Created by PROPHET on 06-03-2016.
 */
public class GetBitmap extends AsyncTask<Void, Void, Void> {
    private Context context;
    private HomeFragment homeFragment;
    private ProgressDialog dialog;
    public String[] urls;

    public GetBitmap(Context context, HomeFragment homeFragment, String[] urls) {
        this.context = context;
        this.homeFragment = homeFragment;
        this.urls = urls;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(context, "Loading Images", "Please Wait...", false, false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        dialog.dismiss();
        homeFragment.showData();
    }

    @Override
    protected Void doInBackground(Void... params) {
        for (int i = 0; i < urls.length; ++i) {
            Config.bitmaps[i] = getImage(urls[i]);
        }
        return null;
    }

    public Bitmap getImage(String bitmapUrl) {
        URL url;
        Bitmap image = null;
        try {
            url = new URL(bitmapUrl);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
