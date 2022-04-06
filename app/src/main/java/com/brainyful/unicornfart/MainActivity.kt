package com.brainyful.unicornfart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val unicornButton = findViewById<ImageButton>(R.id.playButton)
        unicornButton.setOnClickListener { playSound(it)}
    }

    private fun playSound(view: View){
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.fartsound2891)
            mediaPlayer!!.isLooping = false
            mediaPlayer!!.start()
        } else if(mediaPlayer?.isPlaying == false)
            mediaPlayer!!.isLooping = false
            mediaPlayer!!.start()
    }

    // Destroys the MediaPlayer instance when the app is closed
    override fun onStop() {
        super.onStop()
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }
}