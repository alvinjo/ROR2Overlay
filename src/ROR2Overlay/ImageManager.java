package ROR2Overlay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ROR2Overlay.ImagePaths.greenIconPaths;
import static ROR2Overlay.ImagePaths.whiteIconPaths;

public class ImageManager {

    private static ImageManager imageManager;

    private List<ImageIcon> whiteIcons = new ArrayList<>();
    private List<ImageIcon> greenIcons = new ArrayList<>();

    public List<ImageIcon> selectedIcons = new ArrayList<>();

    public ImageManager(){
        buildIconImageList();
    }

    public static ImageManager getInstance(){
        if(imageManager == null){
            imageManager = new ImageManager();
            return imageManager;
        }
        return imageManager;
    }

    private void buildIconImageList(){
        for (String imagePath : whiteIconPaths) {
            ImageIcon img = scaleImage(imagePath);
            whiteIcons.add(img);
        }

        for (String imagePath : greenIconPaths) {
            ImageIcon img = scaleImage(imagePath);
            greenIcons.add(img);
        }
    }

    public ImageIcon scaleImage(String path){
        ImageIcon imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource(path));
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }

    public List<ImageIcon> scaleImage(List<String> paths){
        return paths.stream().map(p -> scaleImage(p)).collect(Collectors.toList());
    }

    public int getTotalWidth() {
        return (int) selectedIcons.stream().map(ImageIcon::getIconWidth).count()*20;
    }

    public List<ImageIcon> getWhiteIcons() {
        return whiteIcons;
    }

    public List<ImageIcon> getGreenIcons() {
        return greenIcons;
    }

}
