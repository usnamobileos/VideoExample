package mobileos.usna.edu.videoexample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMediaPlayer(View v){
        Intent i = new Intent(this, MediaPlayerActivity.class);
        startActivity(i);     
    }

    public void launchVideoView(View v){
        Intent i = new Intent(this, VideoViewActivity.class);
        startActivity(i);
    }
}
