package imageviewer.control;

import imageviewer.view.ImageDisplay;


public class PrevCommand implements Command {

    private final ImageDisplay display;

    public PrevCommand(ImageDisplay display) {
        this.display = display;
    }
    
    
    @Override
    public void execute() {
        display.display(display.currentImage().prev());
    }

    @Override
    public String name() {
        return "Previous";
    }
    
}
