package lk.viva.publiclibraries;

import android.net.Uri;

public class Books {
    String title;
    String publisher;
    String date;
    String bookimage;

    public Books(String title, String publisher, String date, String bookimage) {
        this.title = title;
        this.publisher = publisher;
        this.date = date;
        this.bookimage = bookimage;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDate() {
        return date;
    }

    public String getBookimage() {
        return bookimage;
    }
}
