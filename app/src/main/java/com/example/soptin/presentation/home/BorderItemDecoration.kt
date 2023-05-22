package com.example.soptin.presentation.home

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soptin.R

class BorderItemDecoration(context: Context, private val borderWidth: Int) : RecyclerView.ItemDecoration() {
    private val borderPaint: Paint = Paint()

    init {
        borderPaint.color = ContextCompat.getColor(context, R.color.gray_50)
        borderPaint.style = Paint.Style.STROKE
        borderPaint.strokeWidth = borderWidth.toFloat()
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val itemCount = parent.adapter?.itemCount ?: return
        for (i in 0 until itemCount) {
            val child: View? = parent.getChildAt(i)
            child?.let {
                val params: RecyclerView.LayoutParams = child.layoutParams as RecyclerView.LayoutParams
                val left = child.left - params.leftMargin
                val right = child.right + params.rightMargin
                val top = child.top - params.topMargin
                val bottom = child.bottom + params.bottomMargin

                // 테두리 그리기
                c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), borderPaint)
            }
        }
    }
}
