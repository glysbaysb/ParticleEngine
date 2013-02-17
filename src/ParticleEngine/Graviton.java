package ParticleEngine;

import java.awt.*;
import java.util.Collection;

public class Graviton extends Modifier
{
    private float mass = 5.972e15f;

    public float getMass()
    {
        return mass;
    }

    public void setMass(float value)
    {
        mass = value;
    }

    public Graviton(Renderer renderer)
    {
        super(renderer);
    }

    @Override
    public void apply(Collection<Particle> c)
    {
        final float G = 6.674e-11f;

        if (!isActive())
        {
            return;
        }

        if (isGlobal())
        {
        }
        else
        {
            for (Particle p : c)
            {
                Vector2F distance = new Vector2F(getX(), getY()).sub(p.pos);

                float d = distance.magnitude();
                d = (d * d * d) / G;

                p.force.add(new Vector2F(mass * p.mass).scaleInv(d).multiply(distance));
            }
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillOval(getX() - 7, getY() - 7, 14, 14);
        g.setColor(Color.WHITE);
        g.drawOval(getX() - 7, getY() - 7, 14, 14);
    }
}
