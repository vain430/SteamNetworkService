package kr.ana.hyper.SNS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.File;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class SteamCrawler {
    private static String html;
    public  static Document document;
    private static boolean isWork;
    private SteamCrawler(){
        isWork=false;
    }
    public static boolean isWorking()
    {
        return isWork;
    }


    public static void init() {
        try {
            File input = new File("qwe.html");

            document = Jsoup.parse(input, "euc-kr", "http://steamcommunity.com/id/430vain/home/");

        }
        catch (Exception e)
        {

        }
        isWork=true;
    }

    public static Elements getBlotterBlock()
    {
        return document.select(".blotter_day");
    }

}
