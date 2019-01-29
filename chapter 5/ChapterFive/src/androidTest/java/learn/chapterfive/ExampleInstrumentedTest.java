package learn.chapterfive;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Date;
import java.util.List;

import learn.chapterfive.bean.Note;
import learn.chapterfive.service.NoteService;

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

        assertEquals("learn.chapterfive", appContext.getPackageName());
    }

    @Test
    public void save(){

        Context appContext = InstrumentationRegistry.getTargetContext();
        NoteService service = new NoteService(appContext);

        for(int i=0; i<25; i++){

            Note note = new Note();
            note.setTitle("this is title"+i);
            note.setTime(new Date().toString());
            note.setContent("content "+i);
            service.save(note);
        }
    }

    @Test
    public void getAll(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        NoteService service = new NoteService(appContext);
        List<Note> notelist = service.getAll();
        for(Note n : notelist){
            Log.i("hello", n.toString());
        }
    }
}
