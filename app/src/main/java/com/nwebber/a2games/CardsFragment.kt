package com.nwebber.a2games


import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageButton
import com.nwebber.a2games.model.Card
import com.nwebber.a2games.model.CardModel
import android.widget.Toast
import androidx.core.animation.addListener

class CardsFragment : AppCompatActivity() {
    private lateinit var cardLeft: ImageButton
    private lateinit var cardRight: ImageButton
    private lateinit var cardCenter: ImageButton

    private lateinit var playButton: Button
    private lateinit var resetButton: Button

    private lateinit var aceCard: Card

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardLeft = findViewById(R.id.card_left)
        cardRight = findViewById(R.id.card_right)
        cardCenter = findViewById(R.id.card_center)

        playButton = findViewById(R.id.button_play)
        resetButton = findViewById(R.id.button_reset)

        resetButton.isEnabled = false
        playButton.isEnabled = true
        cardLeft.isEnabled = false
        cardRight.isEnabled = false
        cardCenter.isEnabled = false

        aceCard = Card.randomCard()

        cardCenter.setImageResource(R.drawable.red_back)
        cardLeft.setImageResource(R.drawable.red_back)
        cardRight.setImageResource(R.drawable.red_back)

        playButton.setOnClickListener {
            resetButton.isEnabled = true
            playButton.isEnabled = false
            cardLeft.isEnabled = true
            cardRight.isEnabled = true
            cardCenter.isEnabled = true
            showCards()
        }

        resetButton.setOnClickListener {
            resetButton.isEnabled = false
            playButton.isEnabled = true
            cardLeft.isEnabled = false
            cardRight.isEnabled = false
            cardCenter.isEnabled = false
            aceCard = Card.randomCard()
            resetCards()
        }

        cardLeft.setOnClickListener {
            //Toast.makeText(this, "Clicked Left Card!", Toast.LENGTH_SHORT).show()
            flipLeft()
        }
        cardRight.setOnClickListener {
            //Toast.makeText(this, "Clicked Right Card!", Toast.LENGTH_SHORT).show()
            flipRight()
        }
        cardCenter.setOnClickListener {
            //Toast.makeText(this, "Clicked Center Card!", Toast.LENGTH_SHORT).show()
            flipCenter()
        }
    }

    private fun showCards() {
        val sliderLeft = ValueAnimator.ofFloat(0f, -600f)
        sliderLeft.addUpdateListener {
            val value = it.animatedValue as Float
            cardLeft.translationX = value
        }
        sliderLeft.interpolator = LinearInterpolator()
        sliderLeft.duration = CARD_SLIDE_DURATION

        val sliderRight = ValueAnimator.ofFloat(0f, 600f)
        sliderRight.addUpdateListener {
            val value = it.animatedValue as Float
            cardRight.translationX = value
        }

        sliderRight.interpolator = LinearInterpolator()
        sliderRight.duration = CARD_SLIDE_DURATION
        sliderLeft.start()
        sliderRight.start()
    }

    private fun resetCards() {
        val sliderLeft = ValueAnimator.ofFloat(-600f, 0f)
        sliderLeft.addUpdateListener {
            val value = it.animatedValue as Float
            cardLeft.translationX = value
        }
        sliderLeft.interpolator = LinearInterpolator()
        sliderLeft.duration = CARD_RESET_DURATION

        val sliderRight = ValueAnimator.ofFloat(600f, 0f)
        sliderRight.addUpdateListener {
            val value = it.animatedValue as Float
            cardRight.translationX = value
        }

        sliderRight.interpolator = LinearInterpolator()
        sliderRight.duration = CARD_RESET_DURATION
        sliderLeft.start()
        sliderRight.start()
        cardCenter.setImageResource(R.drawable.red_back)
        cardLeft.setImageResource(R.drawable.red_back)
        cardRight.setImageResource(R.drawable.red_back)
        cardLeft.isEnabled = false
        cardRight.isEnabled = false
        cardCenter.isEnabled = false
    }

    private fun flipCenter(){
        val flipShrink = ObjectAnimator.ofFloat(cardCenter, "scaleX", 1f, 0f)
        flipShrink.interpolator = LinearInterpolator()
        flipShrink.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {
                when(aceCard){
                    Card.CENTER -> cardCenter.setImageResource(R.drawable.ace_spades)
                    else -> cardCenter.setImageResource(R.drawable.card_blank)
                }
            }
        })
        val flipGrow = ObjectAnimator.ofFloat(cardCenter, "scaleX", 0f, 1f)
        flipGrow.interpolator = LinearInterpolator()
        val set = AnimatorSet()
        set.play(flipShrink).before(flipGrow)
        set.duration = CARD_FLIP_DURATION
        set.start()
        cardCenter.isEnabled = false
    }

    private fun flipLeft(){
        val flipShrink = ObjectAnimator.ofFloat(cardLeft, "scaleX", 1f, 0f)
        flipShrink.interpolator = LinearInterpolator()
        flipShrink.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {
                when(aceCard){
                    Card.LEFT -> cardLeft.setImageResource(R.drawable.ace_spades)
                    else -> cardLeft.setImageResource(R.drawable.card_blank)
                }
            }
        })
        val flipGrow = ObjectAnimator.ofFloat(cardLeft, "scaleX", 0f, 1f)
        flipGrow.interpolator = LinearInterpolator()
        val set = AnimatorSet()
        set.play(flipShrink).before(flipGrow)
        set.duration = CARD_FLIP_DURATION
        set.start()
        cardLeft.isEnabled = false
    }

    private fun flipRight(){
        val flipShrink = ObjectAnimator.ofFloat(cardRight, "scaleX", 1f, 0f)
        flipShrink.interpolator = LinearInterpolator()
        flipShrink.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {}
            override fun onAnimationCancel(animation: Animator?) {}
            override fun onAnimationRepeat(animation: Animator?) {}
            override fun onAnimationEnd(animation: Animator?) {
                when(aceCard){
                    Card.RIGHT -> cardRight.setImageResource(R.drawable.ace_spades)
                    else -> cardRight.setImageResource(R.drawable.card_blank)
                }
            }
        })
        val flipGrow = ObjectAnimator.ofFloat(cardRight, "scaleX", 0f, 1f)
        flipGrow.interpolator = LinearInterpolator()
        val set = AnimatorSet()
        set.play(flipShrink).before(flipGrow)
        set.duration = CARD_FLIP_DURATION
        set.start()
        cardRight.isEnabled = false
    }

    companion object {
        const val CARD_SLIDE_DURATION = 500L
        const val CARD_RESET_DURATION = 200L
        const val CARD_FLIP_DURATION = 200L
    }
}
