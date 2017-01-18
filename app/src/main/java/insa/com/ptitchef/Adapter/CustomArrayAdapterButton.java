package insa.com.ptitchef.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import insa.com.ptitchef.Pojo.CustomDataButton;
import insa.com.ptitchef.R;

/** An array adapter that knows how to render views when given CustomData classes */
public class CustomArrayAdapterButton extends ArrayAdapter<CustomDataButton> {
    private LayoutInflater mInflater;
    private ChatMessageAdapter mAdapter;

    public CustomArrayAdapterButton(Context context, CustomDataButton[] values,ChatMessageAdapter Adapter) {
        super(context, R.layout.custom_data_button_view, values);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mAdapter=Adapter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {

                // Inflate the view since it does not exist
                convertView = mInflater.inflate(R.layout.custom_data_button_view, parent, false);

                // Create and save off the holder in the tag so we get quick access to inner fields
                // This must be done for performance reasons
                holder = new Holder();
                holder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
                final Button buttonMenu = (Button) convertView.findViewById(R.id.buttonMenu);
                buttonMenu.setOnClickListener(new ButtonOnClickListener(mAdapter,"Menu"));
                final Button buttonMap = (Button) convertView.findViewById(R.id.buttonMap);
                buttonMap.setOnClickListener(new ButtonOnClickListener(mAdapter,"Localisation"));
                holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
                holder.textView1= (TextView) convertView.findViewById(R.id.textView1);
                holder.imageView= (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);

        }else {
            holder = (Holder) convertView.getTag();
        }

        // Populate the text

        holder.textViewTitle.setText(getItem(position).getmTextTitle());
        holder.textView1.setText(getItem(position).getmText1());
        holder.textView2.setText(getItem(position).getmText2());
        holder.imageView.setImageDrawable(getContext().getResources().getDrawable(getItem(position).getMpicId()));
         return convertView;
    }

    /** View holder for the views we need access to */
    private static class Holder {
        public TextView textViewTitle;
        public TextView textView1;
        public TextView textView2;
        public ImageView imageView;
    }
}
