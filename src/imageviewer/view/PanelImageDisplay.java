package imageviewer.view;

import imageviewer.model.Image;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelImageDisplay extends JPanel implements ImageDisplay {
    private Image image;
    
    @Override
    public Image currentImage(){
        return image;
    }
    public PanelImageDisplay() {
        super(new BorderLayout());
    }
    
    @Override
    public void display(Image image) {
        this.image = image;
        this.removeAll();
        this.updateUI();
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(bitmap(), 0, 0,this.getWidth(), this.getHeight(),null);
    }
    private java.awt.Image bitmap(){
        try {
            return ImageIO.read(new ByteArrayInputStream(image.data()));
        } catch (IOException ex) {
            return null;
        }
    } 
}
