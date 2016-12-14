package com.pringstudio.caribuku.buku.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pringstudio.caribuku.R;
import com.pringstudio.caribuku.buku.entity.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author       : sucipto
 * Created date : 12/14/16 22:01
 * Github       : @showcheap
 * Website      : http://sucipto.net
 */

public class BukuListAdapter  extends RecyclerView.Adapter<BukuListAdapter.BukuHolder>{

    List<Book> bookList = new ArrayList<>();

    public BukuListAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BukuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_buku,parent,false);

        return new BukuHolder(view);
    }

    @Override
    public void onBindViewHolder(BukuHolder holder, int position) {
        Book book = bookList.get(position);

        holder.setJudul(book.getBookDetail().getTitle());
//        holder.setDesc(book.getBookDetail());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BukuHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_text_judul)
        TextView mTextJudul;
        @BindView(R.id.item_text_desc)
        TextView mTextDesc;

        public BukuHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(itemView);
        }

        public void setJudul(String judul){
            mTextJudul.setText(judul);
        }

        public void setDesc(String desc){
            mTextDesc.setText(desc);
        }
    }
}
