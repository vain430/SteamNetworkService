package kr.ana.hyper.SNS.sequence.timeline;

import org.jsoup.nodes.Element;

import javax.swing.*;

/**
 * Created by 415 on 2014-12-10.
 */
public class BaseCase {
    public JPanel panel;

    public BaseCase() {
        panel = new JPanel();
    }

    public void add(Element e) {
    }

    public JPanel getPanel() {
        return panel;
    }

}
