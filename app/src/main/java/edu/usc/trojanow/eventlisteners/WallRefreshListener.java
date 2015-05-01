package edu.usc.trojanow.eventlisteners;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.serverconnector.ServerConnector;
import edu.usc.trojanow.thought.Thought;
import edu.usc.trojanow.thought.Wall;

/**
 * Created by abdulmajeed on 4/21/15.
 */
public class WallRefreshListener implements View.OnClickListener {


    public ListView wallView;
    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.refreshbtn) {
            wallView = (ListView)v.getTag(R.id.thoughtslistView);
            CreateWallTask task = new CreateWallTask();
            task.execute(v);
        }
    }

    private void populateWallToGUI(Wall wall, ListView listview) {
        ArrayList<Thought> thoughts = wall.getThoughts();

        System.out.println("now populating data");


        // create the grid item mapping
        String[] col_value = new String[] {"col_1", "col_2", "col_3"};
        int[] col_id = new int[] { R.id.txtA, R.id.txtB , R.id.txtC };

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < thoughts.size(); i++){
            HashMap<String, String> map = new HashMap<String, String>();
            if(thoughts.get(i).getCreatedBy() != null) {
                map.put("col_1", thoughts.get(i).getCreatedBy().getUserName());
            }
            map.put("col_2", thoughts.get(i).getText());
            if(thoughts.get(i).getTemperature() != null) {
                map.put("col_3", "Temp: " + thoughts.get(i).getTemperature().toString());
            }
            fillMaps.add(map);
        }

        // fill in the grid_item layout
        SimpleAdapter adapter = new SimpleAdapter(listview.getContext(), fillMaps, R.layout.thought_list_layout, col_value, col_id);
        listview.setAdapter(adapter);

    }


    public class CreateWallTask extends AsyncTask<View, Void, Wall>{

        @Override
        protected Wall doInBackground(View... views) {
            LocationInfo location = new LocationHelper(views[0].getContext()).getCurrentLocationFromAPI();
            float range;
            try {
                range = Float.parseFloat(((EditText) views[0].getTag(R.id.RangeText)).getText().toString());
            }catch (Exception e){
                // failed to scan the range use 100 as default
                range = 100;
            }
            System.out.println("range is "+range);
            //TODO: replace or remove this
            for (int i = 0; i < 10; i++) {
                System.out.println("This is done in background!!");
                //ServerConnector connector=new ServerConnector();
              //  ArrayList<Thought> allThoughts = connector.getThoughts();
                //if(allThoughts!=null)
                   // System.out.println(allThoughts.get(0).getCreatedBy().getUserName());
            }
            Wall wall = new Wall(location,range);
            return wall;
        }

        @Override
        protected void onPostExecute(Wall result) {
            populateWallToGUI(result, wallView);
        }
    }
}
