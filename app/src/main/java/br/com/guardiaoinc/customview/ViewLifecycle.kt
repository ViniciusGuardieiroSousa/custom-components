package br.com.guardiaoinc.customview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View

class ViewLifecycle : View {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    private var order = 0

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        logOrder("onAttachedToWindow")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        logOrder("onMeasure")
    }

    override fun layout(l: Int, t: Int, r: Int, b: Int) {
        super.layout(l, t, r, b)
        logOrder("layout")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        logOrder("onLayout")
    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        logOrder("dispatchDraw")
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        logOrder("draw")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        logOrder("onDraw")
    }

    fun logOrder(funcao : String){
        Log.d("CustomViewLifeCycle", "$funcao: $order")
        order++
    }

}