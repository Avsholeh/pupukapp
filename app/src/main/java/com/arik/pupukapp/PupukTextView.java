package com.arik.pupukapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;


@SuppressLint("ViewConstructor")
public class PupukTextView extends android.support.v7.widget.AppCompatTextView
{
    public PupukTextView(Context context, boolean title) {
        super(context);
        setPadding(5,5,5,5);
        setBackgroundResource(R.drawable.shape);
        if (title) setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        else setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        setGravity(Gravity.CENTER);
    }

}
