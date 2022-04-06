package com.brainyful.unicornfart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    private val sounds: MutableList<MediaPlayer> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sound1 = MediaPlayer.create(this, R.raw.fartingdeflate3052)
        val sound2 = MediaPlayer.create(this, R.raw.fartsound2891)
        val sound3 = MediaPlayer.create(this, R.raw.sparklefart3052)
        val sound4= MediaPlayer.create(this, R.raw.sparklefart3050)
        sounds.add(sound1)
        sounds.add(sound2)
        sounds.add(sound3)
        sounds.add(sound4)

        val unicornButton = findViewById<ImageButton>(R.id.playButton)
        unicornButton.setOnClickListener { playSound(it)}


    }

    private fun playSound(view: View){
        if (mediaPlayer == null) {
            mediaPlayer = sounds.random()
            mediaPlayer!!.isLooping = false
            mediaPlayer!!.start()
        } else if(mediaPlayer?.isPlaying == false)
            mediaPlayer= sounds.random()
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