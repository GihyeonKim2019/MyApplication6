package com.example.myapplication6;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.io.ByteArrayOutputStream;
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

                Bitmap b = m_oData.get(position).ProfileImage; // your bitmap
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
                b.compress(Bitmap.CompressFormat.PNG, 50, bs);
                intent.putExtra("image", bs.toByteArray());

                intent.putExtra("name",m_oData.get(position).Name);
                intent.putExtra("number",m_oData.get(position).PhoneNumber);
                //intent.putExtra("image",m_oData.get(position).ProfileImage);


                view.getContext().startActivity(intent);



            }
        });

        ImageView oImage = (ImageView) convertView.findViewById(R.id.profileimage);
        TextView oTextName = (TextView) convertView.findViewById(R.id.textTitle);
        TextView oTextPhone = (TextView) convertView.findViewById(R.id.textDate);


        Button button1 = (Button) convertView.findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), m_oData.get(position).Name + "님에게 전화 연결...", Toast.LENGTH_SHORT).show();

                Intent intentx = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+m_oData.get(position).PhoneNumber));
                view.getContext().startActivity(intentx);

            }
        });

        Button button2 = (Button) convertView.findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intenty = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"+m_oData.get(position).PhoneNumber));
                view.getContext().startActivity(intenty);

            }
        });


        oImage.setImageBitmap(m_oData.get(position).ProfileImage);
        oTextName.setText(m_oData.get(position).Name);
        oTextPhone.setText(m_oData.get(position).PhoneNumber);
        return convertView;
    }
}
