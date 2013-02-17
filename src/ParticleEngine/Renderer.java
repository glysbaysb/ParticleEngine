package ParticleEngine;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;

public class Renderer extends JPanel implements MouseInputListener
{
    public final static int FPS = 30;
    private final int NUM_FPS_VALUES = 10;
    private final int MAX_FRAME_SKIPS = 5;

    private Emitter mouseEmitter;
    private ArrayList<Emitter> emitters;
    private ArrayList<Modifier> modifiers;
    private ArrayList<Particle> particles;

    private long frameCount = 0;
    private long skippedFrames = 0;
    private double fpsValues[];
    private double avgFPS = 0;
    private long lastTime;

    public Renderer()
    {
        addMouseListener(this);
        addMouseMotionListener(this);

        emitters = new ArrayList<Emitter>();
        modifiers = new ArrayList<Modifier>();
        particles = new ArrayList<Particle>();

        fpsValues = new double[NUM_FPS_VALUES];
        lastTime = System.nanoTime();

        mouseEmitter = new Emitter(this);
        mouseEmitter.setActive(false);
    }

    public void addParticles(Collection<Particle> c)
    {
        particles.addAll(c);
    }

    public void act()
    {
        updateStats();
        updateGame();

        if (avgFPS > FPS - 2 || skippedFrames >= MAX_FRAME_SKIPS)
        {
            repaint();
            skippedFrames = 0;
        }
        else
        {
            skippedFrames++;
        }
    }

    private void updateStats()
    {
        double fps, totalFPS;
        long now = System.nanoTime();

        fps = 1000000000f / (now - lastTime);
        lastTime = now;

        fpsValues[(int)frameCount % NUM_FPS_VALUES] = fps;

        totalFPS = 0;
        for (int i = 0; i < NUM_FPS_VALUES; i++)
        {
            totalFPS += fpsValues[i];
        }

        avgFPS = totalFPS / NUM_FPS_VALUES;
        frameCount++;
    }

    private void updateGame()
    {
        for (Modifier m : modifiers)
        {
            m.apply(particles);
        }

        for (Emitter e : emitters)
        {
            e.act();
        }

        mouseEmitter.act();

        for (int i = 0; i < particles.size(); i++)
        {
            Particle p = particles.get(i);

            p.act();

            if (!p.alive)
            {
                particles.remove(i--);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        // super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (Particle p : particles)
        {
            p.draw(g);
        }

        for (Emitter e : emitters)
        {
            e.draw(g);
        }

        for (Modifier m : modifiers)
        {
            m.draw(g);
        }

        mouseEmitter.draw(g);

        g.setColor(Color.WHITE);
        g.drawString("FPS: " + (int)avgFPS, 10, 20);
        g.drawString("Frames: " + frameCount, 10, 35);
        g.drawString("Particles: " + particles.size(), 10, 50);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            if (e.isControlDown())
            {
                Graviton g = new Graviton(this);
                g.setLocation(e.getPoint());

                modifiers.add(g);
            }
            else
            {
                mouseEmitter.setActive(true);
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3)
        {
            if (e.isControlDown())
            {
                modifiers.clear();
            }
            else
            {
                particles.clear();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            mouseEmitter.setActive(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    int count = 0;

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseMoved(e);

        if (e.isControlDown() && ++count > 10)
        {
            Graviton g = new Graviton(this);
            g.setLocation(e.getPoint());

            modifiers.add(g);
            count = 0;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseEmitter.setLocation(e.getPoint());
    }
}
