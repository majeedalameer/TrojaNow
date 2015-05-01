package edu.usc.trojanow.eventlisteners;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import edu.usc.trojanow.R;
import edu.usc.trojanow.location.LocationHelper;
import edu.usc.trojanow.location.LocationInfo;
import edu.usc.trojanow.thought.Thought;
import edu.usc.trojanow.user.Email;
import edu.usc.trojanow.user.User;

/**
 * Created by abdulmajeed on 4/29/15.
 */
public class PostThoughtListener implements View.OnClickListener{


    public Context mContext;
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.postbutton) {
            mContext = v.getContext();
            PostThoughTask task = new PostThoughTask();
            task.execute(v);

        }
    }



    public class PostThoughTask extends AsyncTask<View, Void, Boolean> {


        @Override
        protected Boolean doInBackground(View... views) {
            Button postBtn = (Button) views[0];
            CheckBox isAnonymous = (CheckBox) postBtn.getTag(R.id.anonyCheckBox);
            CheckBox isTemp = (CheckBox) postBtn.getTag(R.id.tempCheckbox);
            String username = (String) postBtn.getTag(R.id.username);
            EditText thoughtText = (EditText)postBtn.getTag(R.id.thoughtText);


            Thought thought = new Thought(thoughtText.getText().toString(), username , isAnonymous.isChecked(), isTemp.isChecked(),mContext );
            thought.postToServer();

            //TODO: replace or remove this
            for (int i = 0; i < 3; i++) {
                System.out.println("This is done in background!! location is:" + thought.getLocation());
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            CharSequence text = "";
            if(success.booleanValue())
                text = "Thought posted successfully!";
            else
                text = "Thought post failed !";

            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(mContext, text, duration);
            toast.show();

        }
    }

}
