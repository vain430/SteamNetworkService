package kr.ana.hyper.SNS.sequence.timeline;


import kr.ana.hyper.SNS.ui.ScalablePane;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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

            JPanel spi = new ScalablePane(ImageIO.read(url));
            spi.setSize(getSize().width,getSize().height-200);
            add(spi, BorderLayout.NORTH);

        } catch (Exception exc) {
            System.out.println(exc);
        }

        JPanel bottom = new JPanel(new BorderLayout());

        JPanel bottomF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel bottomS = new JPanel((new FlowLayout((FlowLayout.LEFT))));
        JLabel votedpeople = new JLabel();
        JButton up = new JButton("좋아요");
        JButton down = new JButton();

        String votedPerson="";
        Elements vpe = e.select(".blotter_voters_names");
        if(!vpe.isEmpty())
        {
            votedPerson=vpe.get(0).text();
        }
        votedpeople.setText(votedPerson);

        try {
            up.setIcon(new ImageIcon(ImageIO.read(new File("up_b.png"))));
            down.setIcon(new ImageIcon(ImageIO.read(new File("do_b.png"))));
        }
        catch (Exception exc)
        {
            System.out.println(exc);
        }
        bottomF.add(up);
        bottomF.add(down);
        bottomF.add(votedpeople);


        JPanel commentp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextArea ta = new JTextArea("여기에 댓글을 써주세요.");
   //     ta.setMaximumSize(new Dimension(1000,100));

        ta.setLineWrap(true);
        ta.setSize(700,400);
        JScrollPane sp = new JScrollPane(ta);

        JButton submit = new JButton("등록");

        submit.setSize(100,300);
        commentp.add(sp);
        commentp.add(submit);

        bottom.add(bottomF, BorderLayout.CENTER);
        bottom.add(commentp, BorderLayout.SOUTH);
        add(bottom, BorderLayout.SOUTH);
    }
}
