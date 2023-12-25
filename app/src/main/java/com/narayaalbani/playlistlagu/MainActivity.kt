package com.narayaalbani.playlistlagu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.narayaalbani.playlistlagu.about.About
import com.narayaalbani.playlistlagu.song.DetailSong
import com.narayaalbani.playlistlagu.song.Song
import com.narayaalbani.playlistlagu.song.ListSongAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var rvSong: RecyclerView
    private var list: ArrayList<Song> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.title = "Playlist Lagu"

        rvSong = findViewById(R.id.rv_songs)
        rvSong.setHasFixedSize(true)

        list.addAll(DetailSong.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvSong.layoutManager = LinearLayoutManager(this)
        val listSongAdapter = ListSongAdapter(list)
        rvSong.adapter = listSongAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about -> {
                val iAbout = Intent(this@MainActivity, About::class.java)
                startActivity(iAbout)
            }
        }
    }
}