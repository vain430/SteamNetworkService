package kr.ana.hyper.SNS.sequence.timeline;

import kr.ana.hyper.SNS.SteamCrawler;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.util.EmptyStackException;

/**
 * Created by 415 on 2014-12-10.
 */
public class ChangeRightPanel {

    public static JPanel run(TimelineCell c, int index) {

        Element e = SteamCrawler.getBlotterBlock(c.getBaseIndex());
        String type = SteamCrawler.getType(e);


        if (type.equals("")) {
            throw new EmptyStackException();
        } else if (type.equals("blotter_daily_rollup")) {
            blotter_daily_rollup b = new blotter_daily_rollup();
            for (Element rline : e.children()) {
                if (rline.className().contains("groups")) {//groups
                    b.addAsGroup(rline);
                } else {
                    b.add(rline);
                }
            }
        } else if (type.equals("blotter_userstatus")) {
            if (e.children().first().className().contains("blotter_author_block"))
            {

            }
            else
            {

            }
        } else if (type.equals("blotter_daily_rollup")) {

        } else if (type.equals("blotter_screenshot_fullscreen")) {
            blotter_screenshot_fullscreen b = new blotter_screenshot_fullscreen();
            b.add(e);
            return b.getPanel();
        } else if (type.equals("blotter_gamepurchase")) {

        } else {
            System.out.println("Exception for type " + type);
            throw new EmptyStackException();
        }

        return new JPanel();
    }
}