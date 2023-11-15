package com.example.calisthenicsapp
import android.os.Bundle
import android.widget.VideoView
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calisthenicsapp.R
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var overlayTitle: TextView
    private lateinit var continueButton: Button
    private val videos = mapOf("pull_up" to "Pullup", "jump_rope" to "Jump Rope", "handstand" to "Handstand","crunches" to "Crunches","bodyweight_squats" to "Bodyweight Squat", "bodyweight_row" to "Bodyweight Row")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        overlayTitle = findViewById(R.id.overlayTitle)
        continueButton = findViewById(R.id.continueButton)
        val myImageView: ImageView = findViewById(R.id.myImageView)
        myImageView.bringToFront()
        continueButton.bringToFront()
        overlayTitle.bringToFront()
        continueButton.setOnClickListener {
            overlayTitle.visibility = View.INVISIBLE
            val parentLayout = continueButton.parent as? ViewGroup
            parentLayout?.removeView(continueButton)
            parentLayout?.removeView(myImageView)

        }
        val videoView = findViewById<VideoView>(R.id.videoView)
        val playButton = findViewById<Button>(R.id.button)
        val excersizename: TextView = findViewById(R.id.excersizename)
        val randomVideo = videos.keys.toList().random()
        val videoPath = "android.resource://${packageName}/raw/$randomVideo"
        videoView.setVideoPath(videoPath)
        videoView.start()
        excersizename.text = videos[randomVideo]
        playButton.setOnClickListener {
            // Get a random video from the list
            val randomVideo = videos.keys.toList().random()
            // Set the video sources
            val videoPath = "android.resource://${packageName}/raw/$randomVideo"
            videoView.setVideoPath(videoPath)

            // Start playing the video
            videoView.start()
            excersizename.text = videos[randomVideo]
        }
    }
}
