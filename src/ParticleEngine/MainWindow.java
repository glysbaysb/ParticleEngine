package ParticleEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame
{
    private JPanel rootPanel;
    private Renderer renderer;
    public JRadioButton emitterRB;
    public JRadioButton positiveMassRB;
    public JRadioButton negativeMassRB;

    public MainWindow()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        setTitle("MainWindow");
        setSize(700, 500);
        setBackground(Color.BLUE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        final MainWindow wnd = new MainWindow();

        wnd.renderer.init(wnd);

        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                wnd.renderer.act();
            }
        };

        new Timer(32, listener).start();

        wnd.setVisible(true);
    }
}
