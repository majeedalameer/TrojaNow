package edu.usc.trojanow.eventlisteners;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import edu.usc.trojanow.R;
import edu.usc.trojanow.messages.DirectMessage;
import edu.usc.trojanow.thought.Thought;

/**
 * Created by abdulmajeed on 4/29/15.
 */
public class SendMessageListener implements View.OnClickListener{
    Context mContext;
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.sendBtn) {
            mContext = v.getContext();
            SendMessageTask task = new SendMessageTask();
            task.execute(v);

        }
    }



    public class SendMessageTask extends AsyncTask<View, Void, Boolean> {

        @Override
        protected Boolean doInBackground(View... views) {
            Button sendBtn = (Button) views[0];
            String username = (String) sendBtn.getTag(R.id.username);
            EditText messageText = (EditText)sendBtn.getTag(R.id.messagetext);
            EditText recieverText = (EditText)sendBtn.getTag(R.id.recievertext);

            DirectMessage message = new DirectMessage(username,
                    recieverText.getText().toString(),messageText.getText().toString());
            message.send();
            //TODO: remove this
            for (int i = 0; i < 10; i++) {
                try{Thread.sleep(500);}catch (Exception e){};
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            CharSequence text;
            if(success.booleanValue())
                text = "Message sent successfully !";
            else
                text = "sending message failed !";

            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(mContext, text, duration);
            toast.show();

        }
    }
}
