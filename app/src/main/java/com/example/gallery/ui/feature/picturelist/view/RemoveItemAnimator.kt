package com.example.gallery.ui.feature.picturelist.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R

class RemoveItemAnimator(private val duration: Long) : DefaultItemAnimator() {
    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {

        holder?.itemView?.let { item ->
            item.animation = AnimationUtils.loadAnimation(
                item.context,
                R.anim.slide_out
            )
            item.animation.duration = duration
        }
        return super.animateRemove(holder)
    }

    override fun getRemoveDuration(): Long {
        return duration
    }
}