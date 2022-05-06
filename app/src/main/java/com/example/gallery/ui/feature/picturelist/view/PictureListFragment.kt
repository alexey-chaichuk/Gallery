package com.example.gallery.ui.feature.picturelist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.gallery.R

class PictureListFragment : Fragment(R.layout.fragment_picture_list) {

    val randomPicsList = listOf(
        "https://picsum.photos/800/300?random=1",
        "https://picsum.photos/800/500?random=2",
        "https://picsum.photos/800/600?random=3",
        "https://picsum.photos/800/400?random=4",
        "https://picsum.photos/800/500?random=5",
        "https://picsum.photos/800/600?random=6",
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picsSrl: SwipeRefreshLayout = view.findViewById(R.id.pics_srl)
        val picListRv: RecyclerView = view.findViewById(R.id.pics_list_rv)
        with(picListRv) {
            adapter = PictureListAdapter()
            (adapter as PictureListAdapter).bindPics(randomPicsList)
        }

        with(picsSrl) {
            setOnRefreshListener {
                (picListRv.adapter as PictureListAdapter).bindPics(randomPicsList)
                isRefreshing = false
            }
        }
    }

}