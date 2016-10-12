package in.swatcchindia.goclean.Screens;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.swatcchindia.goclean.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    ImageView img;



    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View v=inflater.inflate(R.layout.fragment_post,container,false);

        return v;


    }
    public sendJSON(){}


}
