package com.kei.githubfirstsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kei.githubfirstsubmission.data.model.Users
import com.kei.githubfirstsubmission.databinding.ActivityDetailBinding

class  DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding  : ActivityDetailBinding
    private lateinit var users: Users


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        users = intent.getParcelableExtra<Users>(EXTRA_USER) as Users

        showDetail()
    }

    private fun showDetail() {
        Glide.with(this).load(users.avatar).circleCrop().into(detailBinding.ivUserDetail)
        detailBinding.tvFollowersDetail.text = users.follower.toString()
        detailBinding.tvFollowingDetail.text = users.following.toString()
        detailBinding.tvNameUserDetail.text = users.username
        detailBinding.tvCompanyUserDetail.text = users.company
        detailBinding.tvLocationUserDetail.text = users.location

    }

    companion object{
        const val EXTRA_USER = "extra_user"
    }
}