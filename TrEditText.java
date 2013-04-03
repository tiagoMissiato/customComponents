package br.com.rigolas.customelements.custom;

import java.io.IOException;

import br.com.rigolas.customelements.activity.R;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class TrEditText extends EditText{

  public TrEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.TrEditText);
		String font = a.getString(R.styleable.TrEditText_mTeFontFamily);
//		
		this.setText(font);
		AssetManager mg = context.getAssets();
		try {
			if(mg.open("fonts/"+font) != null){
				mg.close();
				Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/"+font);
			    this.setTypeface(myTypeface);
			}
		} catch (IOException e) {}
		a.recycle();
	}
	
}
