package com.kei.githubfirstsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kei.githubfirstsubmission.data.model.Users
import com.kei.githubfirstsubmission.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var users: Users


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        users = intent.getParcelableExtra<Users>(EXTRA_USER) as Users

        showDetail()
    }

    private fun showDetail() {
        detailBinding.apply {
            Glide.with(this.root).load(users.avatar).circleCrop().into(ivUserDetail)
            tvFollowersDetail.text = users.follower.toString()
            tvFollowingDetail.text = users.following.toString()
            tvNameUserDetail.text = users.name
            tvUsernameUserDetail.text = users.username
            tvCompanyUserDetail.text = users.company
            tvLocationUserDetail.text = users.location

        }


    }

    companion object {
        const val EXTRA_USER = "extra_user"
    }
}