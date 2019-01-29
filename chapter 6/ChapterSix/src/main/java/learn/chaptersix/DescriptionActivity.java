package learn.chaptersix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private TextView title;
    private String value = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        value = this.getIntent().getStringExtra("value");
        title = this.findViewById(R.id.description);
        if(value.equals("1")){
            title.setText("this is the description of video1....content: 11111111");
        }else if(value.equals("2")){
            title.setText("this is the description of video2....content: 222222222");
        }else if(value.equals("3")){
            title.setText("this is the description of video3....content: 33333333");
        }else if(value.equals("4")){
            title.setText("this is the description of video4....content: 444444444");
        }else if(value.equals("5")){
            title.setText("this is the description of video5....content: 55555555");
        }else if(value.equals("6")){
            title.setText("this is the description of video6....content: 66666666");
        }else if(value.equals("7")){
            title.setText("this is the description of video7....content: 77777777");
        }
    }

    public void playVideo(View v){

        Intent intent1 = new Intent(DescriptionActivity.this, PlayActivity.class);
        intent1.putExtra("value", value);
        this.startActivity(intent1);

    }
}
