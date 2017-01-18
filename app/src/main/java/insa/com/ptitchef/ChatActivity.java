package insa.com.ptitchef;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import insa.com.ptitchef.Adapter.ButtonAdapter;
import insa.com.ptitchef.Adapter.ChatMessageAdapter;
import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.MessageType;

public class ChatActivity extends AppCompatActivity {
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
        mimicOtherMessage("Pas de Problème ! \n Un resto de quel type ?", MessageType.BOT_MESSAGE);
        String[] buttonNames={
            "Universitaire",
                    "Classe",
                    "Snack",
                    "Retour",

        };
        mAdapter.setButtonNames(buttonNames);
        mimicOtherMessage("",MessageType.LIST_MESSAGE);



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

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getBaseContext(), ChatActivity.class);
        startActivity(i);
    }

}
