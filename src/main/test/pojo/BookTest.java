package pojo;

import dao.HistoryDao;
import factory.BookFactory;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class BookTest {

    // @Test
    public void reduseTest() {
        List<Book> books = BookFactory.getBooks();
        books.forEach(System.out::println);
        int reduce = IntStream.range(1, 20).reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    // @Test
    public void fontTest() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        JList fontNames = new JList(ge.getAvailableFontFamilyNames());
        int response = JOptionPane.showConfirmDialog(null, new JScrollPane(fontNames));
        Object selectedFont = fontNames.getSelectedValue();
        if (response == JOptionPane.YES_OPTION && selectedFont != null)
            System.out.println("选择了 " + selectedFont);
        else
            System.out.println("取消了或没作出选择");

    }

    @Test
    public void dbTest() {
//        CustomDao.createTable();
//        Custom custom = new Custom("13843468583", "战三", 10000, 10000, "100-10", "");
//        CustomDao.insertCustom(custom);
//        List<Custom> customs = CustomDao.selectCustomByPhone("138");
//        System.out.println(customs);
        if (!HistoryDao.exists()) {
            HistoryDao.createTable();
        }
        History history = new History();
        history.setId(1);
        history.setName("张三");
        history.setPhone("10000000000");
        history.setMoney(1000);
        history.setSubject("剪发");
        history.setDate(new Date().getTime());
        history.setRemark("会员");

        HistoryDao.insertHistory(history);
    }
}
