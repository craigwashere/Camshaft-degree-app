package com.beaubien.cam_degree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


/**
 * Created by Beaubien on 7/1/2017.
 */

public class custom_adapter extends BaseAdapter {
    private Context c;
    private String[] labels;
    private String[] values;

    private float intake_duration, intake_centerline, exhaust_duration, exhaust_centerline,
            lobe_separation, overlap;

    public custom_adapter(Context ctx, String[] labels, String[] values)
    {
        this.c = ctx;

        this.labels = labels;
        this.values = values;
    }

    @Override
    public Object getItem(int pos)
    {   return values[pos];}

    @Override
    public int getCount()
    {   return labels.length;   }

    @Override
    public long getItemId(int pos)
    {   return pos; }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.field, null);
        }

        return convertView;
    }
}
