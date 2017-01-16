package insa.com.ptitchef;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import insa.com.ptitchef.Adapter.ChatMessageAdapter;
import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.MessageType;

public class ChatActivity extends AppCompatActivity {
    // TODO List, Map, Menu, Slider, Text
    // TODO Splash Screen
    // TODO Tutorial
    // TODO Charte graphique
    private ListView mListView;
    private FloatingActionButton mButtonSend;
    private EditText mEditTextMessage;
    private ImageView mImageView;
    private ChatMessageAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mListView = (ListView) findViewById(R.id.listView);
        mButtonSend = (FloatingActionButton) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message);
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);
        mimicOtherMessage("Salut !!", MessageType.BOT_MESSAGE);
        mimicOtherMessage("Je suis là pour t'aider !!", MessageType.BOT_MESSAGE);
        //code for sending the message
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();
                sendMessage(message);
                mEditTextMessage.setText("");
                mListView.setSelection(mAdapter.getCount() - 1);
            }
        });
    }
    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, MessageType.MY_MESSAGE);
        mAdapter.add(chatMessage);

        MessageType type = null;
        String response = null;
        switch (message) {
            case "Hello":
                response = "Hello you !";
                type = MessageType.BOT_MESSAGE;
                break;
            case "Salut":
                response = "Salut toi!";
                type = MessageType.BOT_MESSAGE;
                break;
        }
        Log.d("res", response);
        Log.d("t", type.toString());
        Log.d("m", message);
        mimicOtherMessage(response, type);
    }

    private void mimicOtherMessage(String message, MessageType type) {
        ChatMessage chatMessage = new ChatMessage(message, type);
        mAdapter.add(chatMessage);
    }
}
