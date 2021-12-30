package com.example.design

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Checkable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class WeightSelectable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr), Checkable {

    private var checkState: Boolean = false

    private var mainHeadingText: String
    private var subHeadingText: String
    private var priceText: String
    private var currencyText: String

    private lateinit var mainHeadingTV: TextView
    private lateinit var subHeadingTV: TextView
    private lateinit var priceTV: TextView
    private lateinit var currencyTV: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.weight_selectable, this, true)
        context.theme.obtainStyledAttributes(attrs, R.styleable.WeightSelectable, 0, 0).apply {

            try {
                isEnabled = this.getBoolean(R.styleable.WeightSelectable_android_enabled, isEnabled)
                mainHeadingText =
                    this.getString(R.styleable.WeightSelectable_mainHeading).toString()
                subHeadingText = this.getString(R.styleable.WeightSelectable_subHeading).toString()
                priceText = this.getString(R.styleable.WeightSelectable_price).toString()
                currencyText = this.getString(R.styleable.WeightSelectable_currency).toString()
            } finally {
                recycle()
            }

        }
        isClickable = true
        isFocusable = true
        isClickable = true
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        mainHeadingTV = findViewById(R.id.buttonMainTV)
        subHeadingTV = findViewById(R.id.buttonSubTV)
        priceTV = findViewById(R.id.priceTV)
        currencyTV = findViewById(R.id.currencyTV)

        mainHeadingTV.text = mainHeadingText
        subHeadingTV.text = subHeadingText
        priceTV.text = priceText
        currencyTV.text = currencyText


    }

    private fun handleChanges(checked: Boolean) {
        if (checked) {
            setBackgroundColor(ContextCompat.getColor(context, R.color.purple_1))
            mainHeadingTV.setTextColor(ContextCompat.getColor(context, R.color.white))
            subHeadingTV.setTextColor(ContextCompat.getColor(context, R.color.white))
            priceTV.setTextColor(ContextCompat.getColor(context, R.color.white))
            currencyTV.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            mainHeadingTV.setTextColor(ContextCompat.getColor(context, android.R.color.black))
            subHeadingTV.setTextColor(ContextCompat.getColor(context, android.R.color.black))
            priceTV.setTextColor(ContextCompat.getColor(context, android.R.color.black))
            currencyTV.setTextColor(ContextCompat.getColor(context, android.R.color.black))
        }
    }

    override fun setChecked(checked: Boolean) {
        checkState = checked
        handleChanges(checkState)
    }

    override fun isChecked(): Boolean {
        return checkState
    }

    override fun toggle() {
        isChecked = !checkState
    }

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

}