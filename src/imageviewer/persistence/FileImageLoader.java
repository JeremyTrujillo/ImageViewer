package imageviewer.persistence;

import imageviewer.model.ImageExtensions;
import imageviewer.model.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;


public class FileImageLoader implements ImageLoader {

    private final File[] images;
    
    public FileImageLoader(File folder) {
        this.images = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                for (ImageExtensions ext : ImageExtensions.values()) {
                    if (name.toLowerCase().endsWith(ext.name())) return true;
                    
                }
                /*for (String ext : Extensions) {
                }*/
                return false;
            }
        });
    }
    
    
    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return images[i].getName();
            }

            @Override
            public byte[] data() {
                try {
                    FileInputStream stream = new FileInputStream(images[i]);
                    return read(stream);
                } catch (IOException ex) {
                    return new byte[0];
                }
            }

            @Override
            public Image prev() {
                if (i <= 0){
                    return imageAt(images.length-1);
                } else {
                    return imageAt(i-1);
                }
            }

            @Override
            public Image next() {
                if (i >= images.length-1){
                    return imageAt(0);
                } else {
                    return imageAt(i+1);
                }
            }

            private byte[] read(FileInputStream stream) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                while (true){
                    int length = stream.read(buffer);
                    if (length < 0 ) break;
                    output.write(buffer, 0, length);
                }
                return output.toByteArray();
            }
        };
    }    
}
