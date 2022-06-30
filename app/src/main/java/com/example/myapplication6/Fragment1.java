package com.example.myapplication6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
<<<<<<< HEAD

import java.util.ArrayList;

=======
//juseok
>>>>>>> 255416224c878908344dc9332df43364462f8f6f
public class Fragment1 extends Fragment {
    private ListView m_oListView = null;


    public static Fragment1 newInstance(int number) {
        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putInt("number", number);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            int num = getArguments().getInt("number");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        String[] strName = {"박강우", "김기현", "김성혁", "김성애"};
        String[] strPhone = {"010-1234-5678", "010-2345-6789", "010-4455-6677", "010-3941-9805"};
        int nDatCnt=0;
        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i=0; i<60; ++i)
        {
            ItemData oItem = new ItemData();
            oItem.Name = strPhone[nDatCnt];
            oItem.PhoneNumber = strName[nDatCnt++];
            oData.add(oItem);
            if (nDatCnt >= strName.length) nDatCnt = 0;
        }

        m_oListView = (ListView) view.findViewById(R.id.listView);
        ListAdapter oAdapter = new ListAdapter(oData);
        m_oListView.setAdapter(oAdapter);

        return view;
    }

}
