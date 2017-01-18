package insa.com.ptitchef;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import insa.com.ptitchef.Adapter.ButtonAdapter;
import insa.com.ptitchef.Adapter.ChatMessageAdapter;
import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.MessageType;

public class ChatActivity extends Activity {
    // TODO List, Map, Menu, Slider
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
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);
        mimicOtherMessage("Salut Patrick !!", MessageType.BOT_MESSAGE);
        mimicOtherMessage("Je suis là pour t'aider !!", MessageType.BOT_MESSAGE);
        mimicOtherMessage("",MessageType.MENU_MESSAGE);

    }


    private void mimicOtherMessage(String message, MessageType type) {
        ChatMessage chatMessage = new ChatMessage(message, type);
        mAdapter.add(chatMessage);
    }


    private void setGridView(Context context){
        GridView gridview = (GridView) findViewById(R.id.gridview);
        System.out.println(context);
        gridview.setAdapter(new ButtonAdapter(context,mAdapter));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(ChatActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateChat() {
        mListView.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                mListView.setSelection(mAdapter.getCount() - 1);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getBaseContext(), ChatActivity.class);
        startActivity(i);
    }

}
