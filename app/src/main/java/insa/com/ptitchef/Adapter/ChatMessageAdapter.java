package insa.com.ptitchef.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.MessageType;
import insa.com.ptitchef.R;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    public ChatMessageAdapter(Context context, List<ChatMessage> data) {
        super(context, R.layout.item_mine_message, data);
    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage item = getItem(position);
        return item.getType().ordinal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        Log.d("vt", ""+viewType);
        switch (viewType) {
            case 0: //MessageType.MY_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                break;
            case 1: //MessageType.BOT_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bot_message, parent, false);
                break;
            case 2: //MessageType.LIST_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                break;
            case 3: //MessageType.MAP_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                break;
            case 4: //MessageType.MENU_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                break;
            case 5: //MessageType.SLIDER_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                break;
        }
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(getItem(position).getContent());
        convertView.findViewById(R.id.chatMessageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "onClick", Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}

