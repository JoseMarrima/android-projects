package com.example.josemarrima.changana;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        final ArrayList<Numbers> numbersArrayList = new ArrayList<Numbers>();
        numbersArrayList.add(new Numbers("One","Um", R.drawable.numbers, R.raw.lundi));
        numbersArrayList.add(new Numbers("Two","Dois"));
        numbersArrayList.add(new Numbers("Three","Tres"));
        numbersArrayList.add(new Numbers("Four","Quatro"));
        numbersArrayList.add(new Numbers("Five","Cinco"));
        numbersArrayList.add(new Numbers("Six","Seis"));
        numbersArrayList.add(new Numbers("Seven","Set"));
        numbersArrayList.add(new Numbers("Eight","Oito"));
        numbersArrayList.add(new Numbers("Nine","Nove"));
        numbersArrayList.add(new Numbers("Ten","Dez"));

        NumbersAdapter numbersAdapter = new NumbersAdapter(this, numbersArrayList);
        ListView numbersListView = (ListView) findViewById(R.id.numbersList);
        numbersListView.setAdapter(numbersAdapter);



        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //release media player if exists cuz we going to play a different sound
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Numbers numbers = numbersArrayList.get(position);

                //request audiofocus in order to play the audio file
                //we request audio focus with short time to play AUDIOFOCUS_GAIN_TRANSIENT
                int audioFocusResult = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (audioFocusResult == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, numbers.getmAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer(){
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }

    }
}
