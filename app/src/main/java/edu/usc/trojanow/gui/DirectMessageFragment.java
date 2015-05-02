package edu.usc.trojanow.gui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.usc.trojanow.R;
import edu.usc.trojanow.eventlisteners.InboxRefreshListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DirectMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DirectMessageFragment extends Fragment {

    private String userName = "unknown";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param username Parameter 1.
     * @return A new instance of fragment DirectMessageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DirectMessageFragment newInstance(String username) {
        DirectMessageFragment fragment = new DirectMessageFragment();
        Bundle args = new Bundle();
        args.putString(LoginActivity.USERNAME_MESSAGE, username);
        fragment.setArguments(args);
        return fragment;
    }

    public DirectMessageFragment() {
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
        View inboxView =  inflater.inflate(R.layout.fragment_direct_message, container, false);

        Button refreshBtn = (Button)inboxView.findViewById(R.id.refreshInboxBtn);
        refreshBtn.setTag(R.id.dmView,inboxView.findViewById(R.id.dmView));
        refreshBtn.setTag(R.id.username,userName);
        System.out.println("from Fragment"+userName);
        refreshBtn.setOnClickListener(new InboxRefreshListener());
        return inboxView;
    }

}
