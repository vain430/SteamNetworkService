package kr.ana.hyper.SNS.sequence.timeline;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * Created by 415 on 2014-12-10.
 */

public class TimelineCell {
    private final String name;
    private final String imagePath;
    private final String active;
    private int baseIndex;
    private Image image;

    public TimelineCell(String name, String active, String imagePath, int baseIndex) {
        this.name = name;
        this.imagePath = imagePath;
        this.active = active;
        this.baseIndex = baseIndex;
    }

    public String getName() {
        return name;
    }

    public int getBaseIndex() {
        return baseIndex;
    }

    public String getActive() {
        return active;
    }


    public Image getImage() {
        if (image == null) {
            String pattern = "^(https?):\\/\\/.*"; // 맨앞이 http:// 또는 http://
            if (imagePath.matches(pattern)) {
                try {
                    URL url = new URL(imagePath);
                    image = ImageIO.read(url);
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
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
        return name;
    }
}