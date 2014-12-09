package kr.ana.hyper.SNS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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

            document = Jsoup.parse(input, "UTF-8", "http://steamcommunity.com/id/430vain/home/");

        }
        catch (Exception e)
        {

        }
        isWork=true;
    }

    public static Elements getBlotterBlocks()
    {
        return document.select(".blotter_day .blotter_block");
    }

    public static int getBlotterBlockCount() { return document.select(".blotter_day").size();}

    public static String getBlotterBlockHead(Element BlotterBlock)
    {
        return BlotterBlock.select(".blotter_author_block div").get(2).text();
    }
    public static String getBlotterBlockName(Element BlotterBlock)
    {
        return BlotterBlock.select(".blotter_author_block div").get(3).text();
    }
}
