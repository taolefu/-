package learn.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import learn.recycleview.bean.MyMessage;
import learn.recycleview.service.XMLParseService;
import learn.recycleview.utils.RandomUtils;

public class MainActivity extends AppCompatActivity {

    private List<MyMessage> messageList = new ArrayList<MyMessage>();
    private XMLParseService service;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new XMLParseService(MainActivity.this);
        messageList = service.getData();
        recyclerView = this.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MessgaeBaseAdapter adapter = new MessgaeBaseAdapter(messageList);
        recyclerView.setAdapter(adapter);

    }

    public class MessgaeBaseAdapter extends RecyclerView.Adapter<MessgaeBaseAdapter.ViewHolder>{

        private List<MyMessage> messageList;

        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView icon;
            TextView title;
            TextView content;
            TextView time;

            public ViewHolder(View view) {
                super(view);
                icon = (ImageView) view.findViewById(R.id.icon);
                title = (TextView) view.findViewById(R.id.title);
                content = (TextView) view.findViewById(R.id.content);
                time = (TextView) view.findViewById(R.id.time);

            }
        }

        public MessgaeBaseAdapter(List<MyMessage> messagesList) {
            this.messageList = messagesList;
        }
        //加载item 的布局  创建ViewHolder实例
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        //对RecyclerView子项数据进行赋值
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MyMessage message = messageList.get(position);

            int value = RandomUtils.getValue();

            if(value == 0){
                holder.icon.setImageResource(R.drawable.pic1);
            }else if(value == 1){
                holder.icon.setImageResource(R.drawable.pic2);
            }else if(value == 2){
                holder.icon.setImageResource(R.drawable.pic3);
            }else if(value == 3){
                holder.icon.setImageResource(R.drawable.pic4);
            }else if(value == 4){
                holder.icon.setImageResource(R.drawable.pic1);
            }else if(value == 5){
                holder.icon.setImageResource(R.drawable.pic6);
            }else if(value == 6){
                holder.icon.setImageResource(R.drawable.pic7);
            }else{
                holder.icon.setImageResource(R.drawable.pic1);
            }

            holder.title.setText(message.getTitle());
            holder.content.setText(message.getContent());
            holder.time.setText(message.getTime());
        }

        //返回子项个数
        @Override
        public int getItemCount() {
            return messageList.size();
        }
    }


}
