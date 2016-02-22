package in.swatcchindia.goclean;

import android.os.Bundle;

import com.firebase.client.Firebase;

/**
 * Created by PROPHET on 20-02-2016.
 */
public class MainApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
