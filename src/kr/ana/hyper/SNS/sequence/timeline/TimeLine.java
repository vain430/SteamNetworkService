package kr.ana.hyper.SNS.sequence.timeline;

import kr.ana.hyper.SNS.SUtil;
import kr.ana.hyper.SNS.SteamCrawler;
import kr.ana.hyper.SNS.sequence.Parent;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.EmptyStackException;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class TimeLine extends JPanel {

    private Parent parent;
    private DefaultListModel timelistModel;

    private JPanel right;

    public TimeLine(Parent p) {
        super();
        parent = p;
        setLayout(new BorderLayout());
        parent.getFrame().setSize(800, 600);
        SUtil.moveToCenter(p);

        if (!SteamCrawler.isWorking()) {
            SteamCrawler.init();
        }

        timelistModel = new DefaultListModel();
        initTimelinePanel();
        JList list = new JList(timelistModel);
        JScrollPane scrollPane = new JScrollPane(list);

        Dimension d = list.getPreferredSize();
        d.width = 435;
        scrollPane.setPreferredSize(d);
        list.setCellRenderer(new TimelineRenderer(2));

        right = new JPanel(new FlowLayout());
        add(right, BorderLayout.CENTER);

        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.print("First index: " + e.getFirstIndex());
                System.out.print(", Last index: " + e.getLastIndex());
                boolean adjust = e.getValueIsAdjusting();
                System.out.println(", Adjusting? " + adjust);
                if (!adjust) {
                    JList list = (JList) e.getSource();
                    int selections[] = list.getSelectedIndices();
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++) {
                        if (i == 0) {
                            System.out.print("  Selections: ");
                        }
                        System.out.print(selections[i] + "/" + selectionValues[i] + " ");
                        right.removeAll();
                        right = ChangeRightPanel.run((TimelineCell) selectionValues[i],
                                selections[i]);

                    }
                    System.out.println();
                }
            }
        });

        add(scrollPane, BorderLayout.WEST);
    }

    private void initTimelinePanel() {
        Elements e = SteamCrawler.getBlotterBlocks();
        String blockname = "";
        String blockimg = "";
        String blockactive = "";
        for (int i = 0; i < e.size(); i++) {
            Element block = e.get(i);

            String type = SteamCrawler.getType(block);

            if (type.equals("")) {
                continue;
            } else if (type.equals("blotter_daily_rollup")) {
                addTimelineCell("RollupActive", "여러롤업액티비티", "qwe.jpeg", i);
                continue;
            } else if (type.equals("blotter_userstatus")) //그냥 글이거나 그룹공지
            {
                //그냥 글은 통과 그룹은 따로 지정
                if (block.children().first().className().contains("blotter_author_block")) {

                } else {
                    addTimelineCell("GroupNotice", "그룹공지입니다.", "qwe.jpeg", i);
                    continue;
                }
            } else {
                blockname = SteamCrawler.getBlotterBlockName(block);
                blockimg = SteamCrawler.getBlotterBlockImgPath(block);
                blockactive = SteamCrawler.getBlotterBlockActive(block);
            }
            addTimelineCell(SteamCrawler.getBlotterBlockName(block),
                    SteamCrawler.getBlotterBlockActive(block),
                    SteamCrawler.getBlotterBlockImgPath(block), i);
        }

    }

    private void addTimelineCell(String name, String active, String path, int b) {
        TimelineCell cell = new TimelineCell(name, active, path, b);
        timelistModel.addElement(cell);
    }
}