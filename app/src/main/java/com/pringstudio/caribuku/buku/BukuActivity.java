package com.pringstudio.caribuku.buku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pringstudio.caribuku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BukuActivity extends AppCompatActivity implements View.OnClickListener, BukuContract.View{

    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.button)
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initView();
    }

    @Override
    public void onClick(View view) {

    }

    private void initView(){
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
    }
}
