package edu.usc.trojanow.gui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.usc.trojanow.R;
import edu.usc.trojanow.eventlisteners.SendMessageListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewMessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewMessageFragment extends Fragment {

    private String userName = "unknown";


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param username Parameter 1.
     * @return A new instance of fragment NewMessageFragment.
     */
    public static NewMessageFragment newInstance(String username) {
        NewMessageFragment fragment = new NewMessageFragment();
        Bundle args = new Bundle();
        args.putString(LoginActivity.USERNAME_MESSAGE, username);
        fragment.setArguments(args);
        return fragment;
    }

    public NewMessageFragment() {
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
        View v = inflater.inflate(R.layout.fragment_new_message, container, false);
        Button sendBtn = (Button)v.findViewById(R.id.sendBtn);
        sendBtn.setTag(R.id.messagetext, v.findViewById(R.id.messagetext));
        sendBtn.setTag(R.id.recievertext, v.findViewById(R.id.recievertext));
        sendBtn.setTag(R.id.username,userName);
        sendBtn.setOnClickListener(new SendMessageListener());

        return v;
    }


}
