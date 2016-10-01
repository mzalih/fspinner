package com.zalih.fspinner;/***
 * Spinner
 * <p/>
 * Author                : toobler- MZALIH(salih@toobler.com)
 * Company               : Toobler
 * Email:                : info@toobler.com
 * Web site              : http://www.toobler.com
 * Created               : 01/10/16
 * Description           : FSpinner .
 * ==============================================================================================
 * Change History:
 * ----------------------------------------------------------------------------------------------
 * Sl.No.  Date   			Author    		Description
 * ----------------------------------------------------------------------------------------------
 */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/***
 * Spinner
 */
public class FSpinner extends LinearLayout {
    Button com_fspinner_button;
    Spinner com_fspinner;
    String preSelectedString;
    AdapterView.OnItemSelectedListener changeListener;

    public Boolean getSelected() {
        return isSelected;
    }

    Boolean isSelected = false;

    public FSpinner(Context context) {
        super(context);
        initView();
    }

    public void setPreSelectedString(String preSelectedString) {
        if (com_fspinner_button != null) {
            com_fspinner_button.setText(preSelectedString);
        }
        this.preSelectedString = preSelectedString;
    }

    public FSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public FSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public int getCount() {
        if (com_fspinner.getAdapter() != null) {
            return com_fspinner.getAdapter().getCount();
        } else {
            return 0;
        }
    }

    public void setAdapter(SpinnerAdapter adapter) {
        if (com_fspinner != null) {
            com_fspinner.setAdapter(adapter);
        }
    }

    public void initView() {
        setBackgroundColor(Color.RED);
        LayoutInflater mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater.inflate(getView(), this, true);
        com_fspinner = (Spinner) findViewById(R.id.com_fspinner);
        com_fspinner_button = (Button) findViewById(R.id.com_fspinner_button);
        com_fspinner_button.setText(preSelectedString);
        com_fspinner_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getCount() == 0) {
                    if(changeListener != null){
                        changeListener.onNothingSelected(null);
                    }
                  //  Toast.makeText(getContext(), "No more Items Available", Toast.LENGTH_LONG).show();
                } else {
                    isSelected = true;
                    com_fspinner.performClick();
                }
            }
        });

        com_fspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if(changeListener != null){
                                changeListener.onItemSelected(parent,view,position,id);
                            }
                            if(isSelected)
                        com_fspinner_button.setText(parent.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if(changeListener != null){
                    changeListener.onNothingSelected(parent);
                }
            }
        });
    }

    public int getView(){
            return R.layout.fspinner;
    }
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener changeListener) {
        this.changeListener = changeListener;
        }
}
