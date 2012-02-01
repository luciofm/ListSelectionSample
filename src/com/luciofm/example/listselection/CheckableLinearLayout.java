package com.luciofm.example.listselection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout implements Checkable {

	private boolean mChecked = false;
	private Drawable mSelectedBackground;
	private Drawable mNormalBackground;

	public CheckableLinearLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CheckableLinearLayout, defStyle, R.style.CheckableLinearLayoutStyle);
		mSelectedBackground = a.getDrawable(R.styleable.CheckableLinearLayout_selected_background);
		mNormalBackground = a.getDrawable(R.styleable.CheckableLinearLayout_normal_background);

		if (isChecked())
			setBackgroundDrawable(mSelectedBackground);
		else
			setBackgroundDrawable(mNormalBackground);
	}

	public CheckableLinearLayout(Context context, AttributeSet attrs) {
		this(context, attrs, R.attr.background_style);
	}
	
	public CheckableLinearLayout(Context context) {
		this(context, null);
	}

	@Override
	public boolean isChecked() {
		return mChecked;
	}

	@Override
	public void setChecked(boolean checked) {
		mChecked = checked;
		setBackground();
	}

	@Override
	public void toggle() {
		mChecked = !mChecked;
		setBackground();
	}

	private void setBackground() {
		if (isChecked())
			setBackgroundDrawable(mSelectedBackground);
		else
			setBackgroundDrawable(mNormalBackground);
	}
}
