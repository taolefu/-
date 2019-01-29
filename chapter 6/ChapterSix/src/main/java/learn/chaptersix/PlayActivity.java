package learn.chaptersix;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class PlayActivity extends Activity {

    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private String  path;
    private String value = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        value = this.getIntent().getStringExtra("value");

        surfaceView = this.findViewById(R.id.surface);
        mediaPlayer = new MediaPlayer();
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().setFixedSize(176, 144);
        surfaceView.getHolder().setKeepScreenOn(true);

    }

    public void playMethod(View v){

        switch (v.getId()){
            case R.id.play:

                String filePath = "";
                if(value.equals(1)){
                    filePath = "/mnt/sdcard/video1.mp4";
                }else if(value.equals("2")){
                    filePath = "/mnt/sdcard/video2.mp4";
                }else if(value.equals("3")){
                    filePath = "/mnt/sdcard/video3.mp4";
                }else if(value.equals("4")){
                    filePath = "/mnt/sdcard/video4.mp4";
                }else if(value.equals("5")){
                    filePath = "/mnt/sdcard/video1.mp4";
                }else if(value.equals("6")){
                    filePath = "/mnt/sdcard/video2.mp4";
                }else if(value.equals("7")){
                    filePath = "/mnt/sdcard/video3.mp4";
                }

                play(0);
                File file = new File(filePath);
                if(file.exists())
                {
                    path = file.getAbsolutePath();
                    play(0);
                }
                else
                {
                    path = null;
                    Toast.makeText(getApplicationContext(), "文件不存在", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.replay:
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.seekTo(0);
                }else {
                    if(path != null) {
                        play(0);
                    }
                }
                break;
            case R.id.stop:
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
                break;
        }

    }

    private void play(int i) {

        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.setDisplay(surfaceView.getHolder());
            mediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
