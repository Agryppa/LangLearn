package com.example.langlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Chapter>{
    private final Context context;
    private final ArrayList<Chapter> values;

    public ListAdapter(Context context, ArrayList<Chapter> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.chapter_line, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.chapterName);
        ImageView imageView=rowView.findViewById(R.id.chapter_icon);
        textView.setText(values.get(position).getName());
        imageView.setImageResource(values.get(position).getIcon());



        return rowView;
    }
}
