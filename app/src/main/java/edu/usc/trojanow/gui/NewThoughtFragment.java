package edu.usc.trojanow.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import edu.usc.trojanow.R;
import edu.usc.trojanow.eventlisteners.PostThoughtListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewThoughtFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewThoughtFragment extends Fragment {

    private String userName = "unknown";


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param username Parameter 1.
     * @return A new instance of fragment NewThoughtFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewThoughtFragment newInstance(String username) {
        NewThoughtFragment fragment = new NewThoughtFragment();
        Bundle args = new Bundle();
        args.putString(LoginActivity.USERNAME_MESSAGE, username);
        fragment.setArguments(args);
        return fragment;
    }

    public NewThoughtFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userName = getArguments().getString(LoginActivity.USERNAME_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_thought, container, false);

        EditText et = (EditText) v.findViewById(R.id.thoughtText);

        /* TODO: remove this testing code...
        FallbackLocationTracker locationTracker = new FallbackLocationTracker(this.getActivity(), ProviderLocationTracker.ProviderType.GPS);
        locationTracker.start();
        if(locationTracker.hasLocation())
            et.setText("location is:" + locationTracker.getLocation().getLatitude()+","+locationTracker.getLocation().getLongitude());
        else if(locationTracker.hasPossiblyStaleLocation())
            et.setText("stale location is:" + locationTracker.getPossiblyStaleLocation().getLatitude()+","+locationTracker.getPossiblyStaleLocation().getLongitude());
        else
            et.setText("location is not available");
        SensorHelper sh = new SensorHelper(this.getActivity());
        sh.start();
        et.setText(et.getText()+"\nWelcome "+userName+" !! current temp = "+sh.getCurrentTemperatureFromAPI().toString());
        */
        // TODO: remove this testing code

        Button postBtn = (Button)v.findViewById(R.id.postbutton);
        postBtn.setTag(R.id.thoughtText, v.findViewById(R.id.thoughtText));
        postBtn.setTag(R.id.tempCheckbox, v.findViewById(R.id.tempCheckbox));
        postBtn.setTag(R.id.anonyCheckBox, v.findViewById(R.id.anonyCheckBox));
        postBtn.setTag(R.id.username,userName);
        postBtn.setOnClickListener(new PostThoughtListener());


        return v;
    }


}
