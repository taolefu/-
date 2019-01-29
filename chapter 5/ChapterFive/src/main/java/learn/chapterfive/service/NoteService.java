package learn.chapterfive.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import learn.chapterfive.bean.MySQLiteOpenHelper;
import learn.chapterfive.bean.Note;


public class NoteService {

    private Context context;
    private MySQLiteOpenHelper openHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public NoteService(Context context) {

        this.openHelper = new MySQLiteOpenHelper(context);
        this.writeSqLiteDatabase = this.openHelper.getWritableDatabase();
        this.readSqLiteDatabase = this.openHelper.getReadableDatabase();
    }

    public void save(Note note)
    {
        this.writeSqLiteDatabase.execSQL("insert into note(title, time, content) values(?,?,?)", new Object[] {note.getTitle(), note.getTime(), note.getContent()});
    }

    public void delete(long id)
    {
        this.writeSqLiteDatabase.execSQL("delete from note where id = ?", new Object[]{id});
    }

    public void update(Note note)
    {
        this.writeSqLiteDatabase.execSQL("update note set title = ?, time = ?, content = ? where id = ?", new Object[]{note.getTitle(), note.getTime(), note.getContent(), note.getId()});
    }

    public Note getById(long id)
    {
        Cursor cursor = this.readSqLiteDatabase.rawQuery("select * from note where id = ?", new String[] { id+""});
        Note b = new Note();

        if(cursor.moveToFirst())
        {
            int pid = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String content = cursor.getString(cursor.getColumnIndex("content"));

            b.setId(pid);
            b.setTitle(title);
            b.setTime(time);
            b.setContent(content);


        }
        cursor.close();
        return b;
    }

    public List<Note> getAll()
    {
        Cursor cursor = this.readSqLiteDatabase.rawQuery("select * from note", null);
        ArrayList<Note> studentList = new ArrayList<Note>();
        while(cursor.moveToNext())
        {
            int pid = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String content = cursor.getString(cursor.getColumnIndex("content"));

            Note b = new Note();
            b.setId(pid);
            b.setTitle(title);
            b.setTime(time);
            b.setContent(content);
            studentList.add(b);

        }
        cursor.close();

        return studentList;
    }


    public long getSize()
    {
        Cursor cursor = this.readSqLiteDatabase.rawQuery("select count(*) from note", null);
        cursor.moveToFirst();
        long size = cursor.getLong(0);
        cursor.close();
        return size;
    }
}
