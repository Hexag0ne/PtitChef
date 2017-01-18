package insa.com.ptitchef.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.List;

import insa.com.ptitchef.Pojo.ChatMessage;
import insa.com.ptitchef.Pojo.CustomData;
import insa.com.ptitchef.Pojo.CustomDataButton;
import insa.com.ptitchef.R;
import insa.com.ptitchef.Utility.MyGridview;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {

    private HorizontalListView mHlvCustomListWithDividerAndFadingEdge;
    private CustomData[] mCustomData = new CustomData[] {
            new CustomData(R.drawable.vegetarian, "Végétarien","Entrée: salade","Plat: Bobun au Tofu","Dessert: île flottante"),
            new CustomData(R.drawable.vegetarian, "Végétarien","Entrée: salade","Plat: Bobun au Tofu","Dessert: île flottante"),
            new CustomData(R.drawable.vegetarian, "Végétarien","Entrée: salade","Plat: Bobun au Tofu","Dessert: île flottante"),
    };
    private CustomDataButton[] mCustomDataButton = new CustomDataButton[] {
            new CustomDataButton(R.drawable.restaurant_universitaire, "Restaurant Universitaire","Horaires 12h-14h","File d'attente 7min"),
            new CustomDataButton(R.drawable.restaurant_universitaire, "Restaurant Universitaire","Horaires 12h-14h","File d'attente 7min"),
            new CustomDataButton(R.drawable.restaurant_universitaire, "Restaurant Universitaire","Horaires 12h-14h","File d'attente 7min"),
    };

    public String[] getButtonNames() {
        return buttonNames;
    }

    public void setButtonNames(String[] buttonNames) {
        this.buttonNames = buttonNames;
    }

    private String[] buttonNames;

    public ChatMessageAdapter(Context context, List<ChatMessage> data) {
        super(context, R.layout.item_mine_message, data);
    }


    @Override
    public int getViewTypeCount() {
        return 90;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage item = getItem(position);
        return item.getType().ordinal();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        TextView textView=null;

        switch (viewType) {
            case 0: //MessageType.MY_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);
                textView = (TextView) convertView.findViewById(R.id.text);
                textView.setText(getItem(position).getContent());
                break;
            case 1: //MessageType.BOT_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_bot_message, parent, false);
                textView = (TextView) convertView.findViewById(R.id.text);
                textView.setText(getItem(position).getContent());
                break;
            case 2: //MessageType.LIST_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_message, parent, false);
                MyGridview gridview = (MyGridview) convertView.findViewById(R.id.gridview);
                ButtonAdapter btnAdapter = new ButtonAdapter(getContext(),this);
                btnAdapter.setButtonNames(buttonNames);
                gridview.setAdapter(btnAdapter);

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getContext(), "" + position,
                                Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 3: //MessageType.MAP_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_map_message, parent, false);
                break;
            case 4: //MessageType.MENU_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_data_buttons_view, parent, false);
                Button buttonResto = (Button) convertView.findViewById(R.id.buttonResto);
                buttonResto.setOnClickListener(new ButtonOnClickListener(this,(String)buttonResto.getText()));
                Button buttonAmis = (Button) convertView.findViewById(R.id.buttonAmis);
                buttonAmis.setOnClickListener(new ButtonOnClickListener(this,(String)buttonAmis.getText()));
                Button button = (Button) convertView.findViewById(R.id.buttonVite);
                button.setOnClickListener(new ButtonOnClickListener(this,(String)button.getText()));
                break;
            case 5: //MessageType.SLIDER_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_slider_message, parent, false);
                mHlvCustomListWithDividerAndFadingEdge = (HorizontalListView) convertView.findViewById(R.id.hlvCustomListWithDividerAndFadingEdge);
                setupCustomLists();
                break;
            case 6: //MessageType.SLIDER_BUTTON_MESSAGE
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_slider_message, parent, false);
                mHlvCustomListWithDividerAndFadingEdge = (HorizontalListView) convertView.findViewById(R.id.hlvCustomListWithDividerAndFadingEdge);
                setupCustomListsButton();
                break;

        }

        return convertView;
    }

    private void setupCustomLists() {
        // Make an array adapter using the built in android layout to render a list of strings
        CustomArrayAdapter adapter = new CustomArrayAdapter(getContext(), mCustomData);

        // Assign adapter to HorizontalListView
        mHlvCustomListWithDividerAndFadingEdge.setAdapter(adapter);
    }

    private void setupCustomListsButton() {
        // Make an array adapter using the built in android layout to render a list of strings
        CustomArrayAdapterButton adapter = new CustomArrayAdapterButton(getContext(), mCustomDataButton,this);

        // Assign adapter to HorizontalListView
        mHlvCustomListWithDividerAndFadingEdge.setAdapter(adapter);
    }
}

