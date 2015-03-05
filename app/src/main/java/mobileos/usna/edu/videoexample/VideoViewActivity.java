package mobileos.usna.edu.videoexample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;


public class VideoViewActivity extends ActionBarActivity {

    VideoView vv;
    String path="http://www.pepinonline.com/mcmap/tan/rearchoke.mp4";
    int position;

    ProgressBar progBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_videoview);

        vv = (VideoView) findViewById(R.id.video_content);

        Uri uri=Uri.parse(path);

        vv.setVideoURI(uri);
        vv.setMediaController(new MediaController(this));
        vv.requestFocus();
        vv.start();

        progBar = (ProgressBar) findViewById(R.id.progressBar);

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                progBar.setVisibility(View.GONE);
            }
        });

        vv.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            @Override
            public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
                // TODO Auto-generated method stub
                Toast.makeText(getBaseContext(),
                        "An Error Occurred.  Please Try Again.",
                        Toast.LENGTH_SHORT).show();
                finish();
                return false;
            }

        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if(vv.isPlaying()){
            vv.pause();
        }
        position = vv.getCurrentPosition();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(position > 0) {
            vv.seekTo(position);
            progBar.setVisibility(View.VISIBLE);
        }
    }

}
