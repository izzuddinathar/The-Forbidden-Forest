package com.example.visualnovelproject

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.visualnovelproject.databinding.ActivitySceneBinding
import com.example.visualnovelproject.util.Utils

class SceneActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySceneBinding
    private lateinit var viewModel: ScenarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySceneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ScenarioViewModel::class.java]

        setInitialContent()

        binding.btnFirst.setOnClickListener {
            Utils.pageTracker(this, 0)
            pageContent()
        }
        binding.btnSecond.setOnClickListener {
            Utils.pageTracker(this, 1)
            pageContent()
        }
    }

    private fun pageContent() {
        when (val page = Utils.pages.lastElement()) {
            4, 5, 7, 9, 12, 13, 15, 16, 18, 20, 21, 23 -> {
                setContentTwoChoices(page)
            }
            6, 19-> {
                setContentOneChoice(page)
            }
            8, 10, 11, 14, 17, 22, 24, 25 -> {
                val intent = Intent(this@SceneActivity, StartActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave)
                finish()
            }
        }
    }

    private fun setInitialContent() {
        val name = intent.getStringExtra(Utils.NAME).toString()
        viewModel.switchPage(this, Utils.pages.lastElement())
        viewModel.question.observe(this) {
            binding.question.text = String.format(it, name)
        }
        viewModel.choices.observe(this) { choice ->
            binding.btnFirst.text = choice[0].name
            binding.btnSecond.text = choice[1].name
        }
        viewModel.model.observe(this) { binding.ivHunter.background = it }
        viewModel.background.observe(this) { binding.layout.background = it }

        playAnimation(1)
    }

    private fun setContentTwoChoices(page: Int) {
        viewModel.switchPage(this, page)

        viewModel.background.observe(this) { binding.layout.background = it }
        viewModel.question.observe(this) { binding.question.text = it }
        viewModel.choices.observe(this) { choice ->
            binding.btnFirst.text = choice[0].name
            binding.btnSecond.text = choice[1].name
        }

        if (binding.ivHunter.visibility == View.VISIBLE) binding.ivHunter.visibility = View.GONE

        playAnimation(2)
    }

    private fun setContentOneChoice(page: Int) {
        viewModel.switchPage(this, page)

        viewModel.background.observe(this) { binding.layout.background = it }
        viewModel.question.observe(this) { binding.question.text = it }
        viewModel.choices.observe(this) { choice ->
            binding.btnFirst.text = choice[0].name
        }

        if (binding.btnSecond.visibility == View.VISIBLE) binding.btnSecond.visibility = View.GONE
        if (binding.ivHunter.visibility == View.VISIBLE) binding.ivHunter.visibility = View.GONE

        playAnimation(3)
    }

    private fun playAnimation(type: Int) {
        when(type) {
            1 -> {
                binding.layout.alpha = 1f
                binding.question.alpha = 0f
                binding.btnFirst.alpha = 0f
                if (binding.btnSecond.visibility == View.VISIBLE) binding.btnSecond.alpha = 0f
                if (binding.ivHunter.visibility == View.VISIBLE) binding.ivHunter.alpha = 0f

                val layout = ObjectAnimator.ofFloat(binding.layout, View.ALPHA, 1f).setDuration(100)
                val model = ObjectAnimator.ofFloat(binding.ivHunter, View.ALPHA, 1f).setDuration(500)
                val question =
                    ObjectAnimator.ofFloat(binding.question, View.ALPHA, 1f).setDuration(500)
                val btnFirst =
                    ObjectAnimator.ofFloat(binding.btnFirst, View.ALPHA, 1f).setDuration(500)
                val btnSecond =
                    ObjectAnimator.ofFloat(binding.btnSecond, View.ALPHA, 1f).setDuration(500)

                AnimatorSet().apply {
                    playSequentially(model, question, btnFirst, btnSecond)
                    startDelay = 500
                }.start()
            }
            2 -> {
                binding.layout.alpha = 1f
                binding.question.alpha = 0f
                binding.btnFirst.alpha = 0f
                binding.btnSecond.alpha = 0f

                val animation = AnimationUtils.loadAnimation(this, R.anim.animation_enter)
                animation.duration = 500
                binding.layout.startAnimation(animation)

                val layout = ObjectAnimator.ofFloat(binding.layout, View.ALPHA, 1f).setDuration(100)
                val question =
                    ObjectAnimator.ofFloat(binding.question, View.ALPHA, 1f).setDuration(500)
                val btnFirst =
                    ObjectAnimator.ofFloat(binding.btnFirst, View.ALPHA, 1f).setDuration(500)
                val btnSecond =
                    ObjectAnimator.ofFloat(binding.btnSecond, View.ALPHA, 1f).setDuration(500)

                AnimatorSet().apply {
                    playSequentially(question, btnFirst, btnSecond)
                    startDelay = 500
                }.start()
            }
            3 -> {
                binding.layout.alpha = 1f
                binding.question.alpha = 0f
                binding.btnFirst.alpha = 0f

                val animation = AnimationUtils.loadAnimation(this, R.anim.animation_enter)
                animation.duration = 500
                binding.layout.startAnimation(animation)

                val layout = ObjectAnimator.ofFloat(binding.layout, View.ALPHA, 1f).setDuration(100)
                val question =
                    ObjectAnimator.ofFloat(binding.question, View.ALPHA, 1f).setDuration(500)
                val btnFirst =
                    ObjectAnimator.ofFloat(binding.btnFirst, View.ALPHA, 1f).setDuration(500)

                AnimatorSet().apply {
                    playSequentially(question, btnFirst)
                    startDelay = 500
                }.start()
            }
        }

    }
}