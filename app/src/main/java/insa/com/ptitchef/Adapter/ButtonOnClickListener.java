package insa.com.ptitchef.Adapter;

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

        mimicOtherMessage(buttonText, MessageType.MY_MESSAGE);
        switch(buttonText){
            case "Universitaire":
                mimicOtherMessage("Voici les restos que j'ai dénichés pour toi !", MessageType.BOT_MESSAGE);
                mimicOtherMessage("",MessageType.SLIDER_BUTTON_MESSAGE);
                break;
            case "Menu":
                mimicOtherMessage("",MessageType.SLIDER_MESSAGE);
                mimicOtherMessage("Souhaites-tu d'autres infos sur ce resto ?", MessageType.BOT_MESSAGE);
                String[] buttonNames={
                        "Localisation",
                        "Non",
                        "Retour",
                 };
                mAdapter.setButtonNames(buttonNames);
                mimicOtherMessage("",MessageType.LIST_MESSAGE);
                break;
            case "Localisation":
                mimicOtherMessage("",MessageType.MAP_MESSAGE);
                break;
            case "Trouver un resto":
                mimicOtherMessage("Pas de Problème ! \n Un resto de quel type ?", MessageType.BOT_MESSAGE);
                String[] buttonNames1={
                        "Universitaire",
                        "Classe",
                        "Snack",
                        "Retour",

                };
                mAdapter.setButtonNames(buttonNames1);
                mimicOtherMessage("",MessageType.LIST_MESSAGE);
                break;

        }
    }

    private void mimicOtherMessage(String message, MessageType type) {
        ChatMessage chatMessage = new ChatMessage(message, type);
        mAdapter.add(chatMessage);
    }

}
