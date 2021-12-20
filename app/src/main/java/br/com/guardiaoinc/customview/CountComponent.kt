package br.com.guardiaoinc.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.guardiaoinc.customview.databinding.CountComponentBinding


class CountComponent : LinearLayout {

    private lateinit var binding: CountComponentBinding

    var incrementColor: Int = 0
        set(value) {
            binding.incrementButton.setBackgroundColor(value)
            field = value
        }

    var decrementColor: Int = 0
        set(value) {
            binding.decrementButton.setBackgroundColor(value)
            field = value
        }

    var initialValue: Int = 0
        set(value) {
            binding.valueDisplayed.text = value.toString()
            field = value
        }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        R.style.CountComponent_Primary
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {


        binding = CountComponentBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )


        val typedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CountComponent,
            defStyleAttr,
            defStyleRes
        )
        incrementColor = typedArray.getColor(R.styleable.CountComponent_incrementColor, 0)
        decrementColor = typedArray.getColor(R.styleable.CountComponent_decrementColor, 0)
        initialValue = typedArray.getInt(R.styleable.CountComponent_initialValue, 0)
        typedArray.recycle()
        configClickListeners()

    }

    private fun configClickListeners(){
        binding.incrementButton.setOnClickListener {
            initialValue++
        }
        binding.decrementButton.setOnClickListener {
            initialValue--
        }
    }
}