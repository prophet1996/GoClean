package in.swatcchindia.goclean.Screens;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;

import in.swatcchindia.goclean.CardAdapter;
import in.swatcchindia.goclean.Config;
import in.swatcchindia.goclean.GetBitmap;
import in.swatcchindia.goclean.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private Config config;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View root = (View) inflater.inflate(R.layout.fragment_home, container, false);
        recyclerview = (RecyclerView) root.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(layoutManager);
        getData();
      /*  Card card = new Card(getContext());
        CardHeader header = new CardHeader(getContext());
        card.addCardHeader(header);
        CardViewNative cardview = (CardViewNative) root.findViewById(R.id.carddemo);
        cardview.setCard(card);
        RecyclerView rcv = (RecyclerView) root.findViewById(R.id.rcv);

        */
        return root;
    }


    public void getData() {
        class GetData extends AsyncTask<Void, Void, String> {
            ProgressDialog progressdialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressdialog = ProgressDialog.show(getContext(), "Fetching Data ", "Please Wait..", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressdialog.dismiss();
                parseJSON(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(Config.GET_URL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + '\n');

                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }

            }
        }
        GetData gd = new GetData();
        gd.execute();
    }

    public void showData() {
        adapter = new CardAdapter(Config.names, Config.urls, Config.bitmaps);
        recyclerview.setAdapter(adapter);

    }
    public void parseJSON(String json){
       try {
           JSONObject jsonObject = new JSONObject(json);
           JSONArray array = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
           config = new Config(array.length());
           for (int i = 0; i < array.length(); i++) {
               JSONObject j = array.getJSONObject(i);
               Config.names[i] = getName(j);
               Config.urls[i] = getURL(j);
           }
       }catch(JSONException j){j.printStackTrace();
           Log.d("HI","JSON NOT WORKING");}
        GetBitmap gb=new GetBitmap(getContext(),new HomeFragment(),Config.urls);
       // gb.execute();



    }

    private String getName(JSONObject j){
        String name = null;
        try {
            name = j.getString(Config.TAG_IMAGE_NAME);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }

    private String getURL(JSONObject j){
        String url = null;
        try {
            url = j.getString(Config.TAG_IMAGE_URL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return url;
    }

}
