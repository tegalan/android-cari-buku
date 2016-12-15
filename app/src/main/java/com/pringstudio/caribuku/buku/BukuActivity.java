package com.pringstudio.caribuku.buku;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.buku_text_notfound)
    TextView mTextNotFound;

    // Book List Adapter
    BukuListAdapter bookListAdapter;
    List<Book> bookList = new ArrayList<>();

    // Presenter
    BukuContract.Presenter mPresenter;

    // Progressbar
    ProgressDialog dialog;

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

        mTextNotFound.setVisibility(View.GONE);
        mMainRecycler.setVisibility(View.VISIBLE);

        bookListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        mButton.setEnabled(false);
        mEditText.setEnabled(false);

        dialog.setMessage("Mencari...");
        dialog.show();
    }

    @Override
    public void hideLoading() {
        mButton.setEnabled(true);
        mEditText.setEnabled(true);

        dialog.dismiss();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNotFound(String message) {
        mTextNotFound.setVisibility(View.VISIBLE);
        mMainRecycler.setVisibility(View.GONE);

        mTextNotFound.setText(message);
    }

    @Override
    protected void onDestroy() {
        mPresenter.unbind();
        super.onDestroy();
    }

    private void initView(){
        setContentView(R.layout.activity_buku);
        ButterKnife.bind(this);

        mButton.setOnClickListener(this);

        // Init Adapter
        bookListAdapter = new BukuListAdapter(bookList);
        // Init recyclerView
        mMainRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMainRecycler.setAdapter(bookListAdapter);

        // Bind View
        mPresenter.bind(this);

        // Dialog
        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
    }

    @Inject
    public void setPresenter(BukuPresenter presenter){
        this.mPresenter = presenter;
    }
}
