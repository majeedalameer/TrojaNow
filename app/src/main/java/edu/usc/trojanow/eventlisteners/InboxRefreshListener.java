package edu.usc.trojanow.eventlisteners;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.usc.trojanow.R;
import edu.usc.trojanow.messages.DirectMessage;
import edu.usc.trojanow.messages.Inbox;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 4/23/15.
 */
public class InboxRefreshListener implements View.OnClickListener {


    public ListView messagesView;
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.refreshInboxBtn) {
            messagesView = (ListView)v.getTag(R.id.dmView);
            CreateInboxTask task = new CreateInboxTask();
            task.execute(v);
        }
    }

    private void populateInboxToGUI(Inbox inbox, ListView listview) {
        ArrayList<DirectMessage> directMessages = inbox.getDirectMessages();

        System.out.println("now populating data");

        // create the grid item mapping
        String[] col_value = new String[] {"col_1", "col_2"};
        int[] col_id = new int[] { R.id.txt1, R.id.txt2 };

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < directMessages.size(); i++){
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("col_1", directMessages.get(i).getSender().getUserName());
            map.put("col_2", directMessages.get(i).getMessageText());
            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(listview.getContext(), fillMaps, R.layout.list_layout, col_value, col_id);
        listview.setAdapter(adapter);

    }


    public class CreateInboxTask extends AsyncTask<View, Void, Inbox> {

        //TODO: update this to call server and retrieve DMs
        @Override
        protected Inbox doInBackground(View... views) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Downloading messages .. this is done in background!!");
                try{Thread.sleep(500);}catch (Exception e){};
            }
            Inbox inbox = new Inbox(new User("user12","Mark","Alice",new Email("Mark","google.com")));
            return inbox;
        }

        @Override
        protected void onPostExecute(Inbox result) {
            System.out.println(result);
            populateInboxToGUI(result, messagesView);
        }
    }
}
