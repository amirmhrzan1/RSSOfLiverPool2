package com.example.amirmaharjan.rssofliverpool.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.amirmaharjan.rssofliverpool.Messages.Messages;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.io.InputStream;
import java.net.HttpURLConnection;


import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Amir Maharjan on 10/17/2016.
 */

public class ReadRss extends AsyncTask<String,Void,Void>{


    @Override
    protected Void doInBackground(String... params) {
        String downloadUrl = params[0];
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            processXML(inputStream);
        } catch (Exception e) {
            Messages.log("Error",e+"");
        }
        return null;
    }

    private void processXML(InputStream inputStream) throws  Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document xmlDocument = documentBuilder.parse(inputStream);
        Element rootelement = xmlDocument.getDocumentElement();
        Log.d("Message",""+rootelement.getTagName());
        NodeList itemslist = rootelement.getElementsByTagName("item");
        NodeList itemChildren = null;
        Node currentitem = null;
        Node currentchild = null;

        for(int i=0;i<itemslist.getLength();i++)
        {
            currentitem = itemslist.item(i);
            itemChildren = currentitem.getChildNodes();
            for(int j=0;i<itemChildren.getLength();i++)
            {
                currentchild = itemChildren.item(j);
                Log.d("currentchild",""+currentchild.getNodeName());
            }
        }
    }
}
