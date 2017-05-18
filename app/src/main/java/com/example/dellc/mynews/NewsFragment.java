package com.example.dellc.mynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dellc on 2017/5/18.
 */

public class NewsFragment extends Fragment {
    private TextView txtContent;
    private String text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frangment_news, container, false);

        txtContent = (TextView) view.findViewById(R.id.txt_content);
        txtContent.setText(text);
        return view;
    }

    public void setTxtContent(String text) {
        if (text != null) {
            this.text = text;
        }
    }
}
