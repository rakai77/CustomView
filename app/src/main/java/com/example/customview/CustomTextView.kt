package com.example.customview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class CustomTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private lateinit var title: String
    private var textStyle: Boolean = false

    init {
        val typedArray =  context.obtainStyledAttributes(attrs, R.styleable.CustomTextView,0,0)
        val count = typedArray.indexCount

        try {
            for (i in 0 until count){
                val index  = typedArray.getIndex(i)
                if (index == R.styleable.CustomTextView_title) {
                    title = typedArray.getString(index).toString()
                    setTitle()
                } else if (index == R.styleable.CustomTextView_style)  {
                    textStyle = typedArray.getBoolean(index, false)
                    setTextStyle()
                }
            }
        } finally {
            typedArray.recycle()
        }
    }

    private fun setTitle() {
        text = this.title
    }

    private fun setTextStyle() {
        textSize = 15f
        setTextColor(Color.RED)
    }
}