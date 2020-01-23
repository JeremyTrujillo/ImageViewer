package imageviewer;

import imageviewer.control.Command;
import imageviewer.view.ImageDisplay;
import imageviewer.view.PanelImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private ImageDisplay display;
    private final Map<String,Command> commands = new HashMap<>();
    
    public MainFrame(){
        this.setTitle("ImageViewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(800, 800);
        this.add(display(),BorderLayout.CENTER);
        this.add(buttons(),BorderLayout.SOUTH);
        this.setVisible(true);
        
    }

    private Component display() {
        PanelImageDisplay display = new PanelImageDisplay();
        this.display = display;
        return display;
    }

    public ImageDisplay getDisplay() {
        return display;
    }
    
    public void add(Command command){
        commands.put(command.name(), command);
    }

    private Component buttons() {
        JPanel buttons = new JPanel();
        buttons.add(button("Previous"));
        buttons.add(button("Next"));
        return buttons;
    }

    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(name).execute();
            }
        });
        return button;
    }
}
