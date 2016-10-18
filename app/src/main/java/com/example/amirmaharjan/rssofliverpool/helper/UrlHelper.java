package com.example.amirmaharjan.rssofliverpool.helper;

/**
 * Created by Amir Maharjan on 10/18/2016.
 */

public class UrlHelper {
    private String latest_news = "http://www.liverpoolfc.com/news.rss";
    private String media_watch = "http://www.liverpoolfc.com/news/media-watch.rss";
    private String most_recent = "http://www.liverpoolfc.com/video/xml/most_recent.xml";
    private String ticket_news = "http://www.liverpoolfc.com/news/tickets.rss";

    public String getUrl(int i)
    {   String url;
        switch(i)
        {
            case 0:
                url = latest_news;
                break;
            case 1:
                url = media_watch;
                break;
            case 2:
                url = ticket_news;
                break;
            case 3:
                url = most_recent;
                break;
            default:
                url = latest_news;
                break;
        }
        return url;
    }
}
