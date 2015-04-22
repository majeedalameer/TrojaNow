package edu.usc.trojanow.thought;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.sensor.TemperatureInfo;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 4/21/15.
 */
public class WallRefreshListener implements View.OnClickListener {


    public ListView wallview;
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.refreshbtn) {
            wallview = (ListView)v.getTag(R.id.thoughtslistView);
            CreateWallTask task = new CreateWallTask();
            task.execute(v);
        }
    }

    private void populateWallToGUI(Wall wall, ListView listview) {
        //TODO: use the thought inside the wall instead of the dummy data
        //        ArrayList<Thought> thoughts = wall.getThoughts();

        ArrayList<Thought> thoughts = new ArrayList<Thought>(4);
        thoughts.add(new Thought("this is a thought",new LocationInfo(123421,43244,null),
                new TemperatureInfo(120.0f,'F',new Date()), new User("user1","John","Doe",new Email("Jong","google.com"))));
        thoughts.add(new Thought("this is a second thought",new LocationInfo(2342345,43554,null),
                new TemperatureInfo(110.0f,'F',new Date()), new User("user12","Mark","Alice",new Email("Mark","google.com"))));

        System.out.println("now populating data");
    }


    public class CreateWallTask extends AsyncTask<View, Void, Wall>{

        @Override
        protected Wall doInBackground(View... views) {
            LocationInfo location = new LocationHelper(views[0].getContext()).getCurrentLocationFromAPI();
            float range = Float.parseFloat(((EditText) views[0].getTag(R.id.RangeText)).getText().toString());
            System.out.println("range is "+range);
            for (int i = 0; i < 20; i++) {
                System.out.println("This is done in background!!");
                try{Thread.sleep(500);}catch (Exception e){};
            }
            Wall wall = new Wall(location,range);
            return wall;
        }

        @Override
        protected void onPostExecute(Wall result) {
            populateWallToGUI(result, wallview);
        }
    }
}
