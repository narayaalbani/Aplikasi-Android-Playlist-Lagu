package com.narayaalbani.playlistlagu.song

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.narayaalbani.playlistlagu.R


class ListSongAdapter(private val listSong: ArrayList<Song>) : RecyclerView.Adapter<ListSongAdapter.ListViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListSongAdapter.ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_song, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listSong.size
    }

    override fun onBindViewHolder(holder: ListSongAdapter.ListViewHolder, position: Int) {
        val (title, artist, cover, detail, release) = listSong[position]

        holder.imgCover.setImageResource(cover)
        holder.tvTitle.text = title
        holder.tvArtist.text = artist

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DescriptionSong::class.java)
            moveDetail.putExtra(DescriptionSong.EXTRA_TITLE, title)
            moveDetail.putExtra(DescriptionSong.EXTRA_ARTIST, artist)
            moveDetail.putExtra(DescriptionSong.EXTRA_COVER, cover)
            moveDetail.putExtra(DescriptionSong.EXTRA_DETAIL, detail)
            moveDetail.putExtra(DescriptionSong.EXTRA_RELEASE, release)

            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCover: ImageView = itemView.findViewById(R.id.img_item_cover)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvArtist: TextView = itemView.findViewById(R.id.tv_item_artist)
    }
}