package io.bachirio.custombuttons


import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button

/**
 * Created by bachiri on 12/13/17.
 */

class CustomButton : Button {

  private var btnWeight: Int = 0
  private var btnHeight: Int = 0
  private var pressedColor: Int = 0
  private var unPressedColor: Int = 0
  private var roundRadius: Int = 0
  private var btnRadius: Int = 0
  private var shapeType: Int = 0

  private var paint: Paint = Paint()
  private var rectF: RectF = RectF()

  constructor(context: Context) : super(context) 

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    init(context, attrs)
  }

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr) {
    init(context, attrs)
  }

  @Suppress("DEPRECATION")
  private fun init(context: Context, attrs: AttributeSet) {
    if (isInEditMode) {
      return
    }
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton)
    pressedColor = typedArray.getColor(R.styleable.CustomButton_pressed_color,
        resources.getColor(R.color.pressed_color))
    unPressedColor = typedArray.getColor(R.styleable.CustomButton_unpressed_color,
        resources.getColor(R.color.unpressed_color))
    shapeType = typedArray.getInt(R.styleable.CustomButton_btn_shape_type, 1)
    roundRadius = typedArray.getDimensionPixelSize(R.styleable.CustomButton_round_radius,
        resources.getDimensionPixelSize(R.dimen.round_radius))

    typedArray.recycle()
    paint.color = unPressedColor
    paint.style = Paint.Style.FILL
    paint.isAntiAlias = true
    this.setWillNotDraw(false)
    this.isDrawingCacheEnabled = true
    this.isClickable = true
    this.setBackgroundColor(resources.getColor(R.color.transparent))
  }

  override fun onSizeChanged(w: Int, h: Int, oldWidth: Int, oldHeight: Int) {
    super.onSizeChanged(w, h, oldWidth, oldHeight)
    btnWeight = w
    btnHeight = h
    btnRadius = btnWeight / 2
  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    if (paint == null) {
      return
    }
    if (shapeType == 0) {
      canvas.drawCircle((btnWeight / 2).toFloat(), (btnHeight / 2).toFloat(), btnRadius.toFloat(),
          paint)
    } else {
      rectF.set(0f, 0f, btnWeight.toFloat(), btnHeight.toFloat())
      canvas.drawRoundRect(rectF, roundRadius.toFloat(), roundRadius.toFloat(), paint)
    }
  }

  override fun onTouchEvent(event: MotionEvent): Boolean {
    when (event.action) {
      MotionEvent.ACTION_DOWN -> {
        paint.color = pressedColor
        invalidate()
      }

      MotionEvent.ACTION_UP -> {
        paint.color = unPressedColor
        invalidate()
      }
    }
    return super.onTouchEvent(event)
  }
  
}
