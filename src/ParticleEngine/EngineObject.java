package ParticleEngine;

import java.awt.*;

public abstract class EngineObject implements IDraw
{
    private int x = 0;
    private int y = 0;
    private boolean active = true;
    private Renderer renderer;

    public int getX()
    {
        return x;
    }

    public void setX(int value)
    {
        x = value;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int value)
    {
        y = value;
    }

    public Point getLocation()
    {
        return new Point(x, y);
    }

    public void setLocation(Point value)
    {
        x = value.x;
        y = value.y;
    }

    public void setLocation(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean value)
    {
        active = value;
    }

    public Renderer getRenderer()
    {
        return renderer;
    }

    public EngineObject(Renderer renderer)
    {
        this.renderer = renderer;
    }
}
