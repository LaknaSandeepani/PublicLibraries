package lk.viva.publiclibraries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.myViewHolder> {

    Context context;
    ArrayList<Books>list;

    public BooksAdapter(Context context, ArrayList<Books> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Books books = list.get(position);
//        holder.bookimage.setText(books.getBookimage());
        //Loading image from Glide library.
        Glide.with(context).load(books.getBookimage()).into(holder.bookimage);
        holder.title.setText(books.getTitle());
        holder.publisher.setText(books.getPublisher());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView title, publisher;
        ImageView bookimage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimage = (ImageView) itemView.findViewById(R.id.imgbook);
            title = (TextView) itemView.findViewById(R.id.BookTitle);
            publisher = (TextView) itemView.findViewById(R.id.publisher);

        }
    }


}
