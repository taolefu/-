package learn.chaptersix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void videoMethod(View v){

        switch (v.getId()){

            case R.id.video1:

                Intent intent1 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent1.putExtra("value", "1");
                this.startActivity(intent1);


                break;
            case R.id.video2:

                Intent intent2 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent2.putExtra("value", "2");
                this.startActivity(intent2);

                break;
            case R.id.video3:
                Intent intent3 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent3.putExtra("value", "3");
                this.startActivity(intent3);

                break;
            case R.id.video4:

                Intent intent4 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent4.putExtra("value", "4");
                this.startActivity(intent4);

                break;
            case R.id.video5:
                Intent intent5 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent5.putExtra("value", "5");
                this.startActivity(intent5);

                break;
            case R.id.video6:

                Intent intent6 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent6.putExtra("value", "6");
                this.startActivity(intent6);
                break;
            case R.id.video7:

                Intent intent7 = new Intent(MainActivity.this, DescriptionActivity.class);
                intent7.putExtra("value", "7");
                this.startActivity(intent7);
                break;
        }

    }
}
