package com.example.amirmaharjan.rssofliverpool.activities;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import com.example.amirmaharjan.rssofliverpool.AsyncTasks.ReadRss;
import com.example.amirmaharjan.rssofliverpool.R;
import com.example.amirmaharjan.rssofliverpool.adapters.MyFragmentPagerAdapter;
import com.example.amirmaharjan.rssofliverpool.fragments.Latest_newsFeed;
import com.example.amirmaharjan.rssofliverpool.fragments.Media_watch;
import com.example.amirmaharjan.rssofliverpool.fragments.Most_Recent_Videos;
import com.example.amirmaharjan.rssofliverpool.fragments.Ticket_News;
import com.example.amirmaharjan.rssofliverpool.helper.UrlHelper;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,TabHost.OnTabChangeListener{

    TabHost tabHost;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabHost();
        initViewpager();
    }

    private void initTabHost()
    {
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        String[] tabNames = {"Latest News","Media Watch","Ticket News","Recent News"};
        for(int i=0;i<tabNames.length;i++)
        {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new Fakecontent(getApplicationContext()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            tabHost.setCurrentTab(position);
        //    String urls = url.getUrl(position);
        //   networktask.execute(urls)
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
        int selectedPage = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedPage);
 //       String urls = url.getUrl(selectedPage);
  //      networktask.execute(urls);

    }

    public class Fakecontent implements TabHost.TabContentFactory{
        Context context;
        public Fakecontent(Context mcontext){
            context = mcontext;

        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);

            return fakeView;
        }

    }

    private void initViewpager()
    {
        List<Fragment> listfragments =new ArrayList<Fragment>();
        listfragments.add(new Latest_newsFeed());
        listfragments.add(new Media_watch());
        listfragments.add(new Most_Recent_Videos());
        listfragments.add(new Ticket_News());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),listfragments);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.addOnPageChangeListener(this);



    }
}
