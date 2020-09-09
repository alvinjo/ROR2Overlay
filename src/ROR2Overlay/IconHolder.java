package ROR2Overlay;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class IconHolder {

    public static JFrame frame;

    public static void startOverlay(List<ImageIcon> selectedIcons){
        frame = new JFrame("RoR2Overlay");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2 - (ImageManager.getInstance().getTotalWidth()), 1);

        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.setAlwaysOnTop(true);
        frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
        frame.getContentPane().setLayout(new FlowLayout());

        for (ImageIcon imageIcon : selectedIcons) {
            frame.getContentPane().add(new JLabel(imageIcon));
        }

        frame.pack();
        frame.setVisible(true);
    }

    public static void clearOverlay(){
        if(frame != null){
            frame.dispose();
        }
    }

}
