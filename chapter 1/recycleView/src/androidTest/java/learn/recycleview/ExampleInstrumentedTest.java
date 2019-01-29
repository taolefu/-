package learn.recycleview;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import learn.recycleview.bean.MyMessage;
import learn.recycleview.service.XMLParseService;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("learn.recycleview", appContext.getPackageName());
    }


    @Test
    public void parseTest(){

        Context appContext = InstrumentationRegistry.getTargetContext();
        XMLParseService service = new XMLParseService(appContext);
        List<MyMessage> messageList = service.getData();
        for(MyMessage m : messageList){
            Log.i("hello", m.toString());
        }

    }
}
