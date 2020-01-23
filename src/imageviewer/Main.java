package imageviewer;

import imageviewer.control.NextCommand;
import imageviewer.control.PrevCommand;
import imageviewer.persistence.FileImageLoader;
import imageviewer.persistence.ImageLoader;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.add(new PrevCommand(frame.getDisplay()));
        frame.add(new NextCommand(frame.getDisplay()));
            ImageLoader loader = new FileImageLoader(new File("D:\\Documentos\\NetBeansProjects\\ImageViewer\\Images"));
        frame.getDisplay().display(loader.load());
    }
    
}
