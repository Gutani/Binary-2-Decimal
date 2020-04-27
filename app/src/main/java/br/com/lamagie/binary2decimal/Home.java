package br.com.lamagie.binary2decimal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.stream.IntStream;

public class Home extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.mViewHolder.result = findViewById(R.id.resultConvert);
        this.mViewHolder.convert = findViewById(R.id.button);
        this.mViewHolder.clear = findViewById(R.id.clear);
        this.mViewHolder.buttonOne = findViewById(R.id.Button2);
        this.mViewHolder.buttonZero = findViewById(R.id.Button1);
        this.mViewHolder.binaryScreen = findViewById(R.id.binaryScreen);
        this.mViewHolder.convert.setOnClickListener(this);
        this.mViewHolder.buttonOne.setOnClickListener(this);
        this.mViewHolder.buttonZero.setOnClickListener(this);
        this.mViewHolder.clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear:
                mViewHolder.binaryScreen.setText("");
                mViewHolder.result.setText("");
                break;
            case R.id.Button2:
                //Must validate the quantity of numbers in the text view, shouldn't overcome eight
                mViewHolder.binaryScreen.setText(mViewHolder.binaryScreen.getText() + "0");
                break;
            case R.id.Button1:
                //Must validate the quantity of numbers in the text view, shouldn't overcome eight
                mViewHolder.binaryScreen.setText(mViewHolder.binaryScreen.getText() + "1");
                break;
            case R.id.button:
                String value = this.mViewHolder.binaryScreen.getText().toString();
                if (value.equals("")) {
                    Toast.makeText(this, "Enter Any Value In Binary To Convert", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    try {
                        //double number = Double.valueOf(value);
                        Integer text = Integer.parseInt(value,2);
                        String exit = String.valueOf(text);

                        mViewHolder.result.setText(exit);

                    } catch (NumberFormatException e) {

                    }


                    break;
                }
        }
    }

    public static class ViewHolder {
        TextView binaryScreen;
        TextView result;
        Button convert;
        Button clear;
        Button buttonOne;
        Button buttonZero;
    }
}
