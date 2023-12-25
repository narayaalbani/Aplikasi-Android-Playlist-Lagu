package com.narayaalbani.playlistlagu.song

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.narayaalbani.playlistlagu.R

class DescriptionSong : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_song)
        val actionBar = supportActionBar
        actionBar!!.title = "Detail Lagu"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val tvSetTitle: TextView = findViewById(R.id.tv_set_title)
        val tvSetArtist: TextView = findViewById(R.id.tv_set_artist)
        val imgSetCover: ImageView = findViewById(R.id.img_item_cover)
        val tvDetail: TextView = findViewById(R.id.textView)
        val tvRelease: TextView = findViewById(R.id.releaseView)

        val tTitle = intent.getStringExtra(EXTRA_TITLE)
        val tArtist = intent.getStringExtra(EXTRA_ARTIST)
        val tCover = intent.getIntExtra(EXTRA_COVER, 0)
        val tDetail = intent.getStringExtra(EXTRA_DETAIL)
        val tRelease = intent.getStringExtra(EXTRA_RELEASE)

        tvSetTitle.text = tTitle
        tvSetArtist.text = tArtist
        imgSetCover.setImageResource(tCover)
        tvDetail.text = tDetail
        tvRelease.text = tRelease
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_ARTIST = "extra_artist"
        const val EXTRA_COVER = "extra_cover"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_RELEASE = "extra_release"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}