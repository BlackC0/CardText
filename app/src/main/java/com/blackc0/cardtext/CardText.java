package com.blackc0.cardtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardText extends LinearLayout {
    private CardView cardView = null;
    private LinearLayout linearLayout = null;
    private TextView textView = null;
    private int textColorNormal;
    private int textColorPressed;
    private Drawable backGroundDrawable;
    private float textSize;
    private int cardViewColorNormal;
    private int cardViewColorPressed;
    private boolean isChecked;

    public CardText(Context context) {
        super(context);
    }

    public CardText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.card_text, this);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardText);
        initTyped(typedArray);
    }

    /**
     * @param typedArray
     */
    private void initTyped(TypedArray typedArray) {
        textView = (TextView) findViewById(R.id.card_text);
        String text = typedArray.getString(R.styleable.CardText_text);
        textColorNormal = typedArray.getColor(R.styleable.CardText_textColorNormal, 0xff333333);
        textColorPressed = typedArray.getColor(R.styleable.CardText_textColorPressed, 0xffffffff);
        textSize = typedArray.getDimensionPixelSize(R.styleable.CardText_text_size, 14);

        textView.setText(text);
        textView.setTextColor(textColorNormal);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        backGroundDrawable = typedArray.getDrawable(R.styleable.CardText_backGroundDrawable);
        if (backGroundDrawable != null) {
            linearLayout.setBackground(backGroundDrawable);
        }

        cardView = (CardView) findViewById(R.id.cardView);
        cardViewColorNormal = typedArray.getColor(R.styleable.CardText_CardViewColorNormal, 0xffffffff);
        cardViewColorPressed = typedArray.getColor(R.styleable.CardText_CardViewColorPressed, 0xff03bf01);
        cardView.setCardBackgroundColor(cardViewColorNormal);

        typedArray.recycle();
    }

    //    //设置文字内容
    private void setText(String text) {
        textView.setText(text);
    }


    //设置文字颜色  
    private void setTextColor(int colorValue) {
        textView.setTextColor(colorValue);
    }

    //设置文字大小  
    private void setTextSize(int size) {
        textView.setTextSize(size);
    }

    public CardView getCardView() {
        return cardView;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
        if (isChecked) {
            textView.setTextColor(textColorPressed);
            cardView.setCardBackgroundColor(cardViewColorPressed);
            return;
        }

        textView.setTextColor(textColorNormal);
        cardView.setCardBackgroundColor(cardViewColorNormal);

    }

    public boolean isChecked() {
        return isChecked;
    }

}