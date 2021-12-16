package Views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class BaseWindow extends JFrame{

    public BaseWindow(){
        setTitle("SnakeGame - By Gugu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon("src/Assets/icon.png").getImage());
    }
    
}
