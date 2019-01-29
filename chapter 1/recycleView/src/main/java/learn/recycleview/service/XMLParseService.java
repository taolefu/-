package learn.recycleview.service;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import learn.recycleview.bean.MyMessage;

public class XMLParseService {

    private Context context;

    public XMLParseService(Context context) {
        this.context = context;
    }

    public List<MyMessage> getData(){

        List<MyMessage> messageList = null;
        MyMessage message = null;

        AssetManager manager = this.context.getAssets();

        try {
            InputStream stream = manager.open("data.xml");
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setInput(stream, "utf-8");
            int eventType = xmlPullParser.getEventType();

            while(eventType != xmlPullParser.END_DOCUMENT){

                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        messageList = new ArrayList<MyMessage>();
                        break;
                    case XmlPullParser.START_TAG:

                        if(xmlPullParser.getName().equals("message")){
                            message = new MyMessage();
//                            message.setId(eventType);
                            eventType = xmlPullParser.next();
                        }else if(xmlPullParser.getName().equals("title")){
                            String isOfficial = xmlPullParser.getAttributeValue(0);
                            message.setIsOfficial(isOfficial);
                            String title = xmlPullParser.nextText();
                            message.setTitle(title);
                            message.setIsOfficial(isOfficial);
                            eventType = xmlPullParser.next();
                        }else if(xmlPullParser.getName().equals("hashtag")){
                            String content = xmlPullParser.nextText();
                            message.setContent(content);
                            eventType = xmlPullParser.next();
                        }else if(xmlPullParser.getName().equals("time")){
                            String time = xmlPullParser.nextText();
                            message.setTime(time);
                            eventType = xmlPullParser.next();
                        }else if(xmlPullParser.getName().equals("icon")){
                            String icon = xmlPullParser.nextText();
                            message.setIcon(icon);
                            eventType = xmlPullParser.next();
                        }
                        break;

                    case XmlPullParser.END_TAG:

                        if(xmlPullParser.getName().equals("message")){
                            messageList.add(message);
                            message = null;
                        }

                        break;
                }

                eventType = xmlPullParser.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return messageList;

    }

}
