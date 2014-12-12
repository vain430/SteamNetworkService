package kr.ana.hyper.SNS.sequence.timeline;

import kr.ana.hyper.SNS.ui.ScalablePane;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 415 on 2014-12-10.
 */
public class BaseCase extends JPanel{

    public BaseCase() {
        super();
    }

    public BaseCase(LayoutManager l) {
        super(l);
    }

    public void add(Element e) {
    }

    public JPanel getPanel() {
        return this;
    }

}
