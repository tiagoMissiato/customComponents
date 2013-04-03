package br.com.rigolas.customelements.custom;

import java.io.IOException;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import br.com.rigolas.customelements.activity.R;

public class TrTextView extends TextView{

  public TrTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.TrTextView);
		String font = a.getString(R.styleable.TrTextView_mTvFontFamily);
		
		AssetManager mg = getResources().getAssets();
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
