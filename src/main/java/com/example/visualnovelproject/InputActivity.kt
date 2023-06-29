package com.example.visualnovelproject

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.visualnovelproject.databinding.ActivityInputBinding
import com.example.visualnovelproject.util.Utils

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding
    private lateinit var viewModel: ScenarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[ScenarioViewModel::class.java]

        viewModel.switchPage(this, Utils.pages.lastElement())
        viewModel.background.observe(this) { binding.layout.background = it }
        viewModel.question.observe(this) { binding.tvQuestion.text = it }
        viewModel.hint.observe(this) { binding.edtInput.hint = it }
        viewModel.model.observe(this) { binding.ivModel.background = it }
        viewModel.choices.observe(this) { binding.btnAccept.text = it[0].name }

        binding.btnAccept.setOnClickListener {
            if (binding.edtInput.text != null) {
                val intent = Intent(this@InputActivity, SceneActivity::class.java)
                intent.putExtra(Utils.NAME, binding.edtInput.text.toString())
                Utils.pageTracker(this, 0)
                startActivity(intent)
                finish()
            }
        }
        playAnimation()
    }

    private fun playAnimation() {

        binding.ivModel.alpha = 0f
        binding.tvQuestion.alpha = 0f
        binding.edtLayout.alpha = 0f
        binding.btnAccept.alpha = 0f

        val model = ObjectAnimator.ofFloat(binding.ivModel, View.ALPHA, 1f).setDuration(500)
        val question = ObjectAnimator.ofFloat(binding.tvQuestion, View.ALPHA, 1f).setDuration(500)
        val input = ObjectAnimator.ofFloat(binding.edtLayout, View.ALPHA, 1f).setDuration(500)
        val button = ObjectAnimator.ofFloat(binding.btnAccept, View.ALPHA, 1f).setDuration(500)

        AnimatorSet().apply {
            playSequentially(model, question, input, button)
            startDelay = 500
        }.start()
    }
}