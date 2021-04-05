package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 9 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView
        String data = null;
        String action = intent.getAction();

        switch (action) {
            case Constants.ACTION_INTEGER:
                data = Integer.toString(intent.getIntExtra(Constants.DATA, 0));
                break;
            case Constants.ACTION_STRING:
                data = intent.getStringExtra(Constants.DATA);
                break;
            case Constants.ACTION_ARRAY_LIST:
                data = intent.getStringArrayListExtra(Constants.DATA).toString();
                break;
        }

        if (messageTextView != null) {
            messageTextView.setText(String.format("%s\n%s", messageTextView.getText().toString(), data));
        }
        // TODO: exercise 9 - restart the activity through an intent
        // if the messageTextView is not available
    }
}
