package com.pringstudio.caribuku.buku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pringstudio.caribuku.R;
import com.pringstudio.caribuku.buku.adapter.BukuListAdapter;
import com.pringstudio.caribuku.buku.entity.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BukuActivity extends AppCompatActivity implements View.OnClickListener, BukuContract.View{

    @BindView(R.id.editText)
    EditText mEditText;
    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.main_recycler)
    RecyclerView mMainRecycler;

    // Book List Adapter
    BukuListAdapter bookListAdapter;
    List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initView();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void updateBookList(List<Book> books) {
        bookList.clear();
        bookList.addAll(books);

        bookListAdapter.notifyDataSetChanged();
    }

    private void initView(){
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);

        // Init Adapter
        bookListAdapter = new BukuListAdapter(bookList);
        // Init recyclerView
        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}
