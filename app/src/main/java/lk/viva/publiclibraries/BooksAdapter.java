package lk.viva.publiclibraries;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.myViewHolder>{

    Context context;
    static ArrayList<Books>list;


    public BooksAdapter(Context context, ArrayList<Books> list) {
        this.context = context;
        this.list = list;

    }

//    public static void setFilteredList(ArrayList<Books> filteredList) {
//        this.list = filteredList;
//        notifyDataSetChanged();
//
//    }

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
//        holder.description.setText(books.getDescription());
        holder.bookimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ClickviewActivity.class);
                i.putExtra("bookimage",books.getBookimage());
//                i.putExtra("description", books.getDescription());
                i.putExtra("title", books.getTitle());
                context.startActivity(i);

//                Log.e("TEST","GO");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public static class myViewHolder extends RecyclerView.ViewHolder{
        TextView title, publisher,description;
        ImageView bookimage;
        CardView cardView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            bookimage = (ImageView) itemView.findViewById(R.id.imgbook);
            title = (TextView) itemView.findViewById(R.id.BookTitle);
            publisher = (TextView) itemView.findViewById(R.id.publisher);
            cardView = itemView.findViewById(R.id.book_container);
//            description =(TextView) itemView.findViewById(R.id.txt_description);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(view.getContext(), ClickviewActivity.class);
//                    i.putExtra("title", (Parcelable) list.get(getAbsoluteAdapterPosition()));
//                    view.getContext().startActivity(i);
//
//                }
//            });
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (listener != null){
//                        int pos = getAbsoluteAdapterPosition();
//
//                        if (pos != RecyclerView.NO_POSITION){
//                       listener.onItemClicked(pos);
//                   }
//                }
//                }
//            });

        }
    }


}
