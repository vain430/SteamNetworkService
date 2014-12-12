package kr.ana.hyper.SNS.sequence.timeline;


import kr.ana.hyper.SNS.ui.ScalablePane;
import org.jsoup.nodes.Element;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Created by 415 on 2014-12-10.
 */
public class blotter_screenshot_fullscreen extends BaseCase {
    public blotter_screenshot_fullscreen() {
        super(new BorderLayout());
    }

    @Override
    public void add(Element e) {

        String imagePath=e.select(".blotter_screenshot_image").select("img").get(0).attr("src");
        try {
            URL url = new URL(imagePath);
            add(new ScalablePane(ImageIO.read(url)), BorderLayout.CENTER);

        } catch (Exception exc) {
            System.out.println(exc);
        }

        JPanel bottom = new JPanel(new BorderLayout());
        JButton up = new JButton("좋아요");
        try {
            up.setIcon(new ImageIcon(ImageIO.read(new File("up_b.png"))));
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        bottom.add(up, BorderLayout.SOUTH);
        add(bottom,BorderLayout.SOUTH);

    }
}
