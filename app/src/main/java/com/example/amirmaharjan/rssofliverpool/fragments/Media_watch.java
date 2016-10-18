package com.example.amirmaharjan.rssofliverpool.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amirmaharjan.rssofliverpool.AsyncTasks.ReadRss;
import com.example.amirmaharjan.rssofliverpool.R;
import com.example.amirmaharjan.rssofliverpool.helper.UrlHelper;

/**
 * Created by Amir Maharjan on 10/17/2016.
 */

public class Media_watch extends Fragment {
    ReadRss networktask;
    UrlHelper url;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mediawatch,container,false);
        return v;

    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        networktask=new ReadRss();
        url  = new UrlHelper();
        String urls = url.getUrl(1);
        networktask.execute(urls);
    }
}
