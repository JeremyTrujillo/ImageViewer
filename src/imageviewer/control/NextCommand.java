package imageviewer.control;

import imageviewer.view.ImageDisplay;


public class NextCommand implements Command {

    private final ImageDisplay display;

    public NextCommand(ImageDisplay display) {
        this.display = display;
    }
    
    @Override
    public void execute() {
        display.display(display.currentImage().next());
    }

    @Override
    public String name() {
        return "Next";
    }
    
}
