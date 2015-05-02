package edu.usc.trojanow.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.usc.trojanow.R;
import edu.usc.trojanow.eventlisteners.WallRefreshListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThoughtsWallFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThoughtsWallFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThoughtsWallFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThoughtsWallFragment newInstance(String param1, String param2) {
        ThoughtsWallFragment fragment = new ThoughtsWallFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ThoughtsWallFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View wallView = inflater.inflate(R.layout.fragment_thoughts_wall, container, false);
        Button refreshBtn = (Button)wallView.findViewById(R.id.refreshbtn);

        refreshBtn.setTag(R.id.RangeText,wallView.findViewById(R.id.RangeText));
        refreshBtn.setTag(R.id.thoughtslistView,wallView.findViewById(R.id.thoughtslistView));

        refreshBtn.setOnClickListener(new WallRefreshListener());


        return wallView;
    }


}
