package mobileos.usna.edu.videoexample;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class MediaPlayerActivity extends ActionBarActivity implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder videoHolder;
    private SurfaceView videoSurface;
    String videoAddress = "http://www.pepinonline.com/mcmap/green/sidechoke.mp4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        videoSurface = (SurfaceView) findViewById(R.id.surfaceView);
        videoHolder = videoSurface.getHolder();
        videoHolder.addCallback(this);
    }
    
    @Override
    public void onDestroy(){
        super.onDestroy();
        
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Surface Holder Callback methods
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(videoHolder);
            mediaPlayer.setDataSource(videoAddress);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(this);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    // MediaPlayer On Prepared Listener method
    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
}
