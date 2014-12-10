package kr.ana.hyper.SNS.sequence;

import kr.ana.hyper.SNS.SUtil;
import kr.ana.hyper.SNS.SteamCrawler;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Created by *KvOID on 2014-11-24.
 * Email vain430@gmail.com
 * Twitter @vain430
 */
public class TimeLine extends JPanel {

    private Parent parent;
    private DefaultListModel timelistModel;
    public TimeLine(Parent p) {
        super();
        parent = p;
        setLayout(new BorderLayout());
        parent.getFrame().setSize(600,480);
        SUtil.moveToCenter(p);

        if(!SteamCrawler.isWorking()) {
            SteamCrawler.init();
        }

        timelistModel = new DefaultListModel();
    //    timelistModel.setSize(5);
        initTimelinePanel();
        JList list = new JList(timelistModel);
        JScrollPane scrollPane = new JScrollPane(list);

        Dimension d = list.getPreferredSize();
        d.width = 250;
        scrollPane.setPreferredSize(d);
        list.setCellRenderer(new TimelineRenderer(2));
        add(scrollPane, BorderLayout.WEST);



    }

    private void initTimelinePanel()
    {
        Elements e=SteamCrawler.getBlotterBlocks();
        String blockname="";
        for(int i = 0; i<e.size();i++) {
            Element block  = e.get(i);

            String type = SteamCrawler.getType(block);

            if(type.equals(""))
            {
                continue;
            }
            else if(type.equals("blotter_daily_rollup"))

            {
                continue;
            }
            else if(type.equals("blotter_userstatus")) //그냥 글이거나 그룹공지
            {
                //그냥 글은 통과 그룹은 따로 지정
                if(block.children().first().className().contains("blotter_author_block"))
                {

                }
                else
                {
                    continue;
                }
            }
            else
            {
                blockname=SteamCrawler.getBlotterBlockName(block);
            }
            addTimelineCell(blockname, "qwe.jpeg");
        }

    }

    private void addTimelineCell(String text, String path) {
        TimelineCell cell = new TimelineCell(text, path);
        timelistModel.addElement(cell);
    }
}

class TimelineCell {
    private final String title;
    private final String imagePath;
    private Image image;

    public TimelineCell(String title, String imagePath ) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }


    public Image getImage() {
        if (image == null) {
            String pattern = "^(https?):\\/\\/.*"; // 맨앞이 http:// 또는 http://
            if(imagePath.matches(pattern))
            {
                try {
                    URL url = new URL(imagePath);
                    image = ImageIO.read(url);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

            }
            else {
                try {
                    File file = new File(imagePath);
                    image = ImageIO.read(file);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
        return image;
    }

    // Override standard toString method to give a useful result
    public String toString() {
        return title;
    }
}

class TimelineRenderer extends JLabel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private Border insideBorder;

    public TimelineRenderer() {
        this(0, 0, 0, 0);
        setIconTextGap(12);
    }

    public TimelineRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TimelineRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        TimelineCell entry = (TimelineCell) value;
        setText(entry.getTitle());
        setIcon(new ImageIcon(entry.getImage()));
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);

        }

        Border outsideBorder;

        if (isSelected) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}