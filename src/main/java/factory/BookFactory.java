package factory;

import pojo.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookFactory {
    private static List<Book> books = new ArrayList<Book>();

    public static List<Book> getBooks() {
        if (books.isEmpty()) {
            /*
            name;
    private String author;
    private String desc;
    private double value;
    private long publicationTime
             */
            Book book;
            book = new Book("张三自传", "张三",
                    "记录张三的传奇一生", 20.00, new Date().getTime());
            books.add(book);
            book = new Book("日月前事", "佚名",
                    "记录一段莫名其妙的历史", 20.00, new Date().getTime());
            books.add(book);
            book = new Book("提瓦特游览指南", "爱丽丝",
                    "魔女的异世界行记", 90.00, new Date().getTime());
            books.add(book);

        }
        return books;
    }

}
