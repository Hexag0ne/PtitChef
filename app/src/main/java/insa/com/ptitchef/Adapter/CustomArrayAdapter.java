package insa.com.ptitchef.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import insa.com.ptitchef.Pojo.CustomData;
import insa.com.ptitchef.R;

/** An array adapter that knows how to render views when given CustomData classes */
public class CustomArrayAdapter extends ArrayAdapter<CustomData> {
    private LayoutInflater mInflater;

    public CustomArrayAdapter(Context context, CustomData[] values) {
        super(context, R.layout.custom_data_view, values);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {

                // Inflate the view since it does not exist
                convertView = mInflater.inflate(R.layout.custom_data_view, parent, false);

                // Create and save off the holder in the tag so we get quick access to inner fields
                // This must be done for performance reasons
                holder = new Holder();
                holder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
                holder.textView1 = (TextView) convertView.findViewById(R.id.textView1);
                holder.textView2 = (TextView) convertView.findViewById(R.id.textView2);
                holder.textView3= (TextView) convertView.findViewById(R.id.textView3);
                holder.imageView= (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);


        }else {
            holder = (Holder) convertView.getTag();
        }

        // Populate the text

        holder.textViewTitle.setText(getItem(position).getmTextTitle());
        holder.textView1.setText(getItem(position).getmText1());
        holder.textView2.setText(getItem(position).getmText2());
        holder.textView3.setText(getItem(position).getmText3());
        holder.imageView.setImageDrawable(getContext().getResources().getDrawable(getItem(position).getMpicId()));
         return convertView;
    }

    /** View holder for the views we need access to */
    private static class Holder {
        public TextView textViewTitle;
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public ImageView imageView;
    }
}
