package com.pringstudio.caribuku.buku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pringstudio.caribuku.App;
import com.pringstudio.caribuku.R;
import com.pringstudio.caribuku.buku.adapter.BukuListAdapter;
import com.pringstudio.caribuku.buku.entity.Book;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

    // Presenter
    BukuPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ((App) getApplication()).getAppComponent().inject(this);

        this.initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                String keyword = mEditText.getText().toString();
                mPresenter.performSearch(keyword);

                break;
        }
    }

    @Override
    public void updateBookList(List<Book> books) {
        bookList.clear();
        bookList.addAll(books);

        bookListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        mPresenter.unbind();
        super.onDestroy();
    }

    private void initView(){
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);

        // Init Adapter
        bookListAdapter = new BukuListAdapter(bookList);
        // Init recyclerView
        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMainRecycler.setAdapter(bookListAdapter);

        // Bind View
        mPresenter.bind(this);
    }

    @Inject
    public void setPresenter(BukuPresenter presenter){
        this.mPresenter = presenter;
    }
}
