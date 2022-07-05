package com.example.myapplication6;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication6.ItemData;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter
{
    LayoutInflater inflater = null;
    private ArrayList<ItemData> m_oData = null;
    private int nListCnt = 0;

    public ListAdapter(ArrayList<ItemData> _oData)
    {
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount()
    {
        Log.i("TAG", "getCount");
        return nListCnt;
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            final Context context = parent.getContext();
            if (inflater == null)
            {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        View clickableItem = (View) convertView.findViewById(R.id.cmdArea);

        clickableItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ProfileActivity.class);

                intent.putExtra("name",m_oData.get(position).Name);
                intent.putExtra("number",m_oData.get(position).PhoneNumber);
                intent.putExtra("image",m_oData.get(position).ProfileImage);

                view.getContext().startActivity(intent);



            }
        });

        ImageView oImage = (ImageView) convertView.findViewById(R.id.profileimage);
        TextView oTextName = (TextView) convertView.findViewById(R.id.textTitle);
        TextView oTextPhone = (TextView) convertView.findViewById(R.id.textDate);













        oImage.setImageResource(m_oData.get(position).ProfileImage);

        oTextName.setText(m_oData.get(position).Name);
        oTextPhone.setText(m_oData.get(position).PhoneNumber);
        return convertView;
    }
}
