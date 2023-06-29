package com.example.visualnovelproject

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProvider
import com.example.visualnovelproject.databinding.ActivityStartBinding
import com.example.visualnovelproject.util.Utils

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    private lateinit var viewModel: ScenarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ScenarioViewModel::class.java]

        setContent(Utils.pages.lastElement())

        binding.btnStart.setOnClickListener {
            Utils.pageTracker(this, 0)
            val page = Utils.pages.lastElement()

            if (page == 2) {
                val intent = Intent(this@StartActivity, InputActivity::class.java)
                val optionsCompat: ActivityOptionsCompat =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,
                        Pair(binding.layout, "layout_1")
                    )
                startActivity(intent, optionsCompat.toBundle())
            } else {
                setContent(page)
            }

        }
        playAnimation()
    }

    private fun setContent(page: Int) {
        viewModel.switchPage(this, page)
        viewModel.background.observe(this) { binding.layout.background = it }
        viewModel.question.observe(this) { binding.tvHeader.text = it }
        viewModel.choices.observe(this) {
            binding.btnStart.text = it[0].name
        }
    }

    private fun playAnimation() {
        binding.tvHeader.alpha = 0F
        binding.btnStart.alpha = 0F

        val header = ObjectAnimator.ofFloat(binding.tvHeader, View.ALPHA, 1F).setDuration(500)
        val choice = ObjectAnimator.ofFloat(binding.btnStart, View.ALPHA, 1F).setDuration(500)

        AnimatorSet().apply {
            playSequentially(header, choice)
            startDelay = 500
        }.start()
    }
}