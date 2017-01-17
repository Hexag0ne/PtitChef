package insa.com.ptitchef.Adapter;

import android.util.Log;
import android.view.View;

import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.MessageType;

/**
 * Created by user on 16/01/2017.
 */

public class ButtonOnClickListener implements View.OnClickListener {

    private final String buttonText;
    private ChatMessageAdapter mAdapter ;

    public ButtonOnClickListener(ChatMessageAdapter mAdapter, String buttonText)
    {
        this.buttonText = buttonText;
        this.mAdapter = mAdapter;

    }

    @Override
    public void onClick(View v)
    {
        Log.d("buttonclicked", ""+buttonText);
        ChatMessage chatMessage = new ChatMessage(buttonText, MessageType.MY_MESSAGE);
        mAdapter.add(chatMessage);
        /*switch(buttonText){
            case "Universitaire":

        }*/
    }

}
