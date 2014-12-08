package kr.ana.hyper.SNS.sequence;

import kr.ana.hyper.SNS.SUtil;
import kr.ana.hyper.SNS.SteamCrawler;

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
    private JPanel rootPane;
    public TimeLine(Parent p) {
        super();
        parent = p;
        setLayout(null);
        parent.getFrame().setSize(600,480);
        SUtil.moveToCenter(p);

        if(!SteamCrawler.isWorking()) {
            SteamCrawler.init();
        }
        rootPane=new JPanel(new BorderLayout());


        JList list = new JList(timelistModel);
        JScrollPane scrollPane = new JScrollPane(list);

        list.setCellRenderer(new TimelineRenderer(2));

        rootPane.add(scrollPane, BorderLayout.EAST);

        add(rootPane);
        initTimelinePanel();

    }

    private void initTimelinePanel()
    {



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

    public TimelineCell(String title, String imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }


    public Image getImage() {
        if (image == null) {
            String pattern = "^(https?):\\/\\/"; // 맨앞이 http:// 또는 http://
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
        return this;
    }

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}