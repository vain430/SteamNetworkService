package kr.ana.hyper.SNS.sequence.timeline;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by 415 on 2014-12-10.
 */

public class TimelineRenderer extends JPanel implements ListCellRenderer {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private Border insideBorder;
    private static final int LIST_CELL_ICON_SIZE = 36;

    private JLabel titleLabel;
    private JLabel textLabel;
    private JLabel imageLabel;

    public TimelineRenderer() {
        this(0, 0, 0, 0);
    }

    public TimelineRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TimelineRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
        titleLabel = new JLabel(" ");
        textLabel = new JLabel(" ");
        imageLabel = new JLabel();

        Font f = new Font(null,Font.PLAIN,12);
        textLabel.setFont(f);

        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        imageLabel.setBackground(Color.WHITE);
        int imageSize = LIST_CELL_ICON_SIZE + 4;
        imageLabel.setBorder(new CompoundBorder(
                new LineBorder(Color.BLACK, 1),
                new EmptyBorder(1, 1, 1, 1)));


        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        GroupLayout.SequentialGroup hg = layout.createSequentialGroup();
        layout.setHorizontalGroup(hg);
        hg.
                addComponent(imageLabel, imageSize, imageSize, imageSize).
                addGroup(layout.createParallelGroup().
                        addComponent(titleLabel,450,450,450).
                        addComponent(textLabel, 450, 450, 450));

        GroupLayout.ParallelGroup vg = layout.createParallelGroup();
        layout.setVerticalGroup(vg);
        vg.
                addComponent(imageLabel, GroupLayout.Alignment.CENTER, imageSize, imageSize, imageSize).
                addGroup(layout.createSequentialGroup().
                        addComponent(titleLabel).
                        addComponent(textLabel));

        layout.linkSize(SwingConstants.VERTICAL, imageLabel);

    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        TimelineCell entry = (TimelineCell) value;
        String title = entry.getName();
        String text = entry.getActive();

        if (title == null) {
            title = " ";
        }
        if (text == null) {
            text = " ";
        }
        titleLabel.setText(title);
        textLabel.setText(text);


        //  imageLabel.setIcon(getImageIcon(entry, LIST_CELL_ICON_SIZE));
        imageLabel.setIcon(new ImageIcon(entry.getImage()));


        /*
        setText(entry.getName());
        setIcon(new ImageIcon(entry.getImage()));*/

        if (isSelected) {
            adjustColors(list.getSelectionBackground(),
                    list.getSelectionForeground(), this, titleLabel, textLabel);

          /*  setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);*/
        } else {
            adjustColors(list.getBackground(),
                    list.getForeground(), this, titleLabel, textLabel);

           /* setBackground(Color.white);
            setForeground(Color.black);*/
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
    private void adjustColors(Color bg, Color fg, Component...components) {
        for (Component c : components) {
            c.setForeground(fg);
            c.setBackground(bg);
        }
    }

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}