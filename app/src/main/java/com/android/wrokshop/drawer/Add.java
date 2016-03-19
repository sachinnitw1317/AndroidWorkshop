package com.android.wrokshop.drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by A on 3/18/2016.
 */
public class Add extends android.support.v4.app.Fragment {
    EditText num1=null,num2=null;
    Button b1;
    TextView answer;
    int num_1=0,num_2=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        num1= (EditText) getActivity().findViewById(R.id.num1);
        num2= (EditText) getActivity().findViewById(R.id.num2);
        answer= (TextView) getActivity().findViewById(R.id.textView);
        b1= (Button) getActivity().findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_1=Integer.parseInt(num1.getText().toString());
                num_2=Integer.parseInt(num2.getText().toString());
                int x=num_1+num_2;
                answer.setText("Answer : "+x);
            }
        });
    }
}
