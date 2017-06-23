package com.example.dellc.mynews.fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dellc.mynews.R;
import com.example.dellc.mynews.adapter.JokeViewAdapter;
import com.example.dellc.mynews.data.JokeData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dellc on 2017/6/23.
 */

public class JokeFragment extends Fragment {
    private static final int MSG_GET_JOKE = 1001 ;
    private RecyclerView joke_view;
    private JokeViewAdapter mJokeAdapter;
    private List<JokeData.ResultBean.DataBean> jokeList = new ArrayList<>();
    private Handler mHandler;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler =  new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == MSG_GET_JOKE){
                    mJokeAdapter.changeData(jokeList);
                }
                return false;
            }
        });

        getJokeData();


    }

    private void getJokeData() {
        String url = "http://japi.juhe.cn/joke/content/list.from?key=7a979503b290b4ed8d3d30c219827280&page=2&pagesize=10&sort=asc&time=1418745237";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AAA", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                JokeData data =  gson.fromJson(response.body().string(), JokeData.class);
                jokeList = data.getResult().getData();
                mHandler.sendEmptyMessage(MSG_GET_JOKE);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        joke_view= (RecyclerView) view.findViewById(R.id.joke_view);
        mJokeAdapter=new JokeViewAdapter(jokeList);
        joke_view.setAdapter(mJokeAdapter);

        joke_view.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
