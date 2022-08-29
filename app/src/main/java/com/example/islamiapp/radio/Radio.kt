package com.example.islamiapp.radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.islamiapp.R
import com.example.islamiapp.api.ApiManager
import kotlinx.coroutines.launch

class radio : Fragment() {
    lateinit var play: ImageView
    lateinit var nex: ImageView
    lateinit var bre: ImageView
    lateinit var suraName: TextView
    lateinit var progressBar: ProgressBar
    var pos: Int = 0
    var isPlaying = false
    var mediaPlayer: MediaPlayer? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()


    }

    override fun onPause() {
        super.onPause()
        isPlaying = false
        mediaPlayer?.stop()
        mediaPlayer?.release()

    }


    fun initView() {
        play = requireView().findViewById(R.id.play)
        nex = requireView().findViewById(R.id.next)
        bre = requireView().findViewById(R.id.back)
        suraName = requireView().findViewById(R.id.quran_radio)
        progressBar = requireView().findViewById(R.id.progress)

        play.setOnClickListener {
            lifecycleScope.launch {
                progressBar.isVisible = true
                play()
            }
        }
        nex.setOnClickListener {
            lifecycleScope.launch {
                next()
            }

        }
        bre.setOnClickListener {
            lifecycleScope.launch {
                bre()

            }

        }


    }

    suspend fun playChannel(pos: Int) {

        try {
            val item = ApiManager.getApi().getRadioList().radios
            progressBar.isVisible = false
            suraName.text = item?.get(pos)?.name

            val url = item?.get(pos)?.uRL // your URL here
            mediaPlayer = MediaPlayer().apply {
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(url)
                prepare() // might take long! (for buffering, etc)
                start()
            }

        } catch (ex: Exception) {
            Toast.makeText(requireContext(), ex.localizedMessage, Toast.LENGTH_SHORT).show()
        }


    }

    suspend fun play() {
        if (!isPlaying) {
            isPlaying = true
            playChannel(pos)
            play.setImageResource(R.drawable.ic_pause)
        } else {
            progressBar.isVisible = false
            isPlaying = false
            mediaPlayer?.stop()
            play.setImageResource(R.drawable.icon_play)

        }

    }

    suspend fun next() {
        pos++
        if (isPlaying) {
            isPlaying = false
            mediaPlayer?.stop()
            mediaPlayer?.release()

        }
        if (pos >= 0) {
            isPlaying = true
            playChannel(pos)
        }
    }

    suspend fun bre() {
        pos--
        if (isPlaying) {
            isPlaying = false
            mediaPlayer?.stop()
            mediaPlayer?.release()

        }
        if (pos >= 0) {
            isPlaying = true
            playChannel(pos)

        }


    }
}



