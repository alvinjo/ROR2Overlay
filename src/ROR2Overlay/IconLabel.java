package ROR2Overlay;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IconLabel extends JLabel {

    public IconLabel(ImageIcon imageIcon){
        super(imageIcon);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IconHolder.clearOverlay();
                if(ImageManager.getInstance().selectedIcons.contains(imageIcon)){
                    ImageManager.getInstance().selectedIcons.remove(imageIcon);
                }else{
                    ImageManager.getInstance().selectedIcons.add(imageIcon);
                }
                IconHolder.startOverlay(ImageManager.getInstance().selectedIcons);
            }
        });
    }

}
