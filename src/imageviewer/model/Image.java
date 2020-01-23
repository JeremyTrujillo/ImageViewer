package imageviewer.model;

public interface Image {
    public String name();
    public byte[] data();
    public Image prev();
    public Image next();   
}
