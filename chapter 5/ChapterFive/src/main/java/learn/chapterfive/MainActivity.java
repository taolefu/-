package learn.chapterfive;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import learn.chapterfive.bean.Note;
import learn.chapterfive.service.NoteService;
import learn.chapterfive.utils.SharedpreferenceServcie;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private NoteService Noteservice;
    private List<Note> noteList;
    private MyAdapter adapter;
    private SharedpreferenceServcie servcie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servcie = new SharedpreferenceServcie(MainActivity.this);

        Noteservice = new NoteService(MainActivity.this);
        if(!"true".equals(servcie.read("isINit"))){
            valueInit();
            servcie.save("isINit", "true");
        }

        listview = (ListView) this.findViewById(R.id.listView);
        noteList = new ArrayList<Note>();
        noteList = Noteservice.getAll();
        adapter = new MyAdapter(noteList);
        listview.setAdapter(adapter);

    }

    private  void valueInit(){
        for(int i=0; i<25; i++){
           Note note = new Note();
           note.setTitle("this is title"+i);
           note.setTime(new Date().toString());
           note.setContent("content "+i);
           Noteservice.save(note);
        }
    }

    public void add(View v){

        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.add_layout,null);
        customizeDialog.setTitle("add note");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        EditText addTitle =(EditText) dialogView.findViewById(R.id.addTitle);
                        EditText addContent =(EditText) dialogView.findViewById(R.id.addContent);

                        Note addNote = new Note();
                        addNote.setTitle(addTitle.getText().toString());
                        addNote.setTime(new Date().toString());
                        addNote.setContent(addContent.getText().toString());

                        Noteservice.save(addNote);
                        noteList.add(addNote);
                        adapter.notifyDataSetChanged();
                    }
                });
        customizeDialog.setNegativeButton("cancel",  null);
        customizeDialog.show();

    }

    private class MyAdapter extends BaseAdapter
    {
        private List<Note> dataList;

        public MyAdapter(List<Note> dataList) {
            this.dataList = dataList;
        }

        public int getCount() {
            return dataList.size();
        }

        public Object getItem(int position) {
            return dataList.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            View view = null;
            if(convertView == null)
            {
                view = getLayoutInflater().inflate(R.layout.listview_item, null);
            }else
            {
                view = convertView;
            }

            final ImageView select = view.findViewById(R.id.update);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView time = (TextView) view.findViewById(R.id.time);
            final ImageView delete = view.findViewById(R.id.delete);


            title.setText(dataList.get(position).getTitle());
            time.setText(dataList.get(position).getTime());

            select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "updated "+dataList.get(position).toString(), Toast.LENGTH_SHORT).show();
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteList.remove(position);
                    Noteservice.delete(dataList.get(position).getId());
                    adapter.notifyDataSetChanged();
                }
            });

            return view;
        }

    }
}
