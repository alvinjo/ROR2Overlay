package ROR2Overlay;

import javax.swing.*;
import java.awt.*;

import static ROR2Overlay.ImagePaths.mercenaryIconPaths;

public class ROR2Overlay {

    private static ImageManager imageManager = ImageManager.getInstance();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("RiskOfRain2Overlay");
        frame.setLayout(new GridLayout(2, 1));
        frame.setSize(1050, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        //add white icons
        JPanel white = new JPanel();
        white.setLayout(new GridLayout());
        for (ImageIcon imageIcon : imageManager.getWhiteIcons()) {
            IconLabel ll = new IconLabel(imageIcon);
            white.add(ll);
        }
        white.setVisible(true);
        white.setBackground(Color.BLACK);

        //add green icons
        JPanel green = new JPanel();
        green.setLayout(new GridLayout());
        for (ImageIcon imageIcon : imageManager.getGreenIcons()) {
            IconLabel ll = new IconLabel(imageIcon);
            green.add(ll);
        }
        green.setVisible(false);
        green.setBackground(Color.BLACK);

        //add panels to iconholder panel
        JPanel iconHolder = new JPanel();
        iconHolder.setLayout(new FlowLayout());
        iconHolder.add(white);
        iconHolder.add(green);
        iconHolder.setBackground(Color.BLACK);

        //button holder panel
        JPanel buttonHolder = new JPanel();
        buttonHolder.setBackground(Color.BLACK);

        //show white icons button
        JButton whiteToggle = new JButton("white");
        whiteToggle.addActionListener(e -> {
            white.setVisible(true);
            green.setVisible(false);
        });
        buttonHolder.add(whiteToggle);

        //show green icons button
        JButton greenToggle = new JButton("green");
        greenToggle.addActionListener(e -> {
            white.setVisible(false);
            green.setVisible(true);
        });
        buttonHolder.add(greenToggle);

        //overlay button
        JButton overlayButton = new JButton("merc");
        overlayButton.addActionListener(e -> {
            IconHolder.clearOverlay();
            ImageManager.getInstance().selectedIcons.clear();
            ImageManager.getInstance().selectedIcons.addAll(imageManager.scaleImage(mercenaryIconPaths));
            IconHolder.startOverlay(ImageManager.getInstance().selectedIcons);
        });
        buttonHolder.add(overlayButton);

        JButton clearIcons = new JButton("clear");
        clearIcons.addActionListener(e -> {
            IconHolder.clearOverlay();
            ImageManager.getInstance().selectedIcons.clear();
        });
        buttonHolder.add(clearIcons);

        //exit button
        JButton exit = new JButton("exit");
        exit.addActionListener(e -> {
            IconHolder.clearOverlay();
            frame.dispose();
        });
        buttonHolder.add(exit);

        frame.add(iconHolder);
        frame.add(buttonHolder);
        frame.setVisible(true);

    }

}
