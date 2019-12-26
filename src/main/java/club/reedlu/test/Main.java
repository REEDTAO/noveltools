package club.reedlu.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("http://www.qbiqu.com/xuanhuanxiaoshuo/")
                .timeout(4000)
                .ignoreContentType(true)
                .get();

        String body = document.body().toString();
        System.out.println(document.toString());
    }
}
