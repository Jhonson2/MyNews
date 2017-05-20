package com.example.dellc.mynews;

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
import android.widget.TextView;

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
 * Created by dellc on 2017/5/18.
 */

public class NewsFragment extends Fragment {
    private static final int MSG_GET_NEWS = 1001;
    private int mType;

   // private TextView txtContent;
    private String text;
    private RecyclerView mRecyclerView;
    private List<NewsData.ResultBean.NewsBean> mNewsList=new ArrayList<>();
    private NewsAdapter mNewsAdapter;
    private final String URL_TOP="http://v.juhe.cn/toutiao/index?type=top&key=4b1bbc3ff3acc7cb8ff624afa6aa9c03";
    private final String URL_TIYU="http://v.juhe.cn/toutiao/index?type=tiyu&key=4b1bbc3ff3acc7cb8ff624afa6aa9c03";
    private final String URL_YULE="http://v.juhe.cn/toutiao/index?type=yule&key=4b1bbc3ff3acc7cb8ff624afa6aa9c03";
    private final String URL_SHEHUI="http://v.juhe.cn/toutiao/index?type=shehui&key=4b1bbc3ff3acc7cb8ff624afa6aa9c03";
    private final String URL_KEJI="http://v.juhe.cn/toutiao/index?type=keji&key=4b1bbc3ff3acc7cb8ff624afa6aa9c03";

    private Handler mHandler;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("NEWSTYPE");

        initHandler();
        getNewsFromJuhe();
    }

    private void getNewsFromJuhe() {
        OkHttpClient client=new OkHttpClient();
        Request request;
        switch (mType){
            case 1:
                request=new Request.Builder().url(URL_TOP).build();
                break;

            case 2:
                request=new Request.Builder().url(URL_YULE).build();
                break;


            case 3:
                request=new Request.Builder().url(URL_TIYU).build();
                break;

            case 4:
                request=new Request.Builder().url(URL_KEJI).build();
                break;



            default:
                request=new Request.Builder().url(URL_SHEHUI).build();
                break;
        }

        Call call=client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("AAA", "GET DATA FAILED");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson=new Gson();
                NewsData newsData = gson.fromJson(response.body().string(),NewsData.class);
                mNewsList=newsData.getResult().getData();
                mHandler.sendEmptyMessage(MSG_GET_NEWS);
            }
        });
    }

    private void initHandler() {
        mHandler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what== MSG_GET_NEWS){
                    mNewsAdapter.changData(mNewsList);
                    return  true;
                }
                return false;
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frangment_news, container, false);

      /*  txtContent = (TextView) view.findViewById(R.id.txt_content);
        txtContent.setText(text);*/

        mRecyclerView= (RecyclerView) view.findViewById(R.id.news_listview);
        mNewsAdapter=new NewsAdapter(mNewsList);
        mRecyclerView.setAdapter(mNewsAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void setTxtContent(String text) {
        if (text != null) {
            this.text = text;
        }
    }


}
