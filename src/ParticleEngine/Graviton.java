package ParticleEngine;

import java.awt.*;
import java.util.Collection;

public class Graviton extends Modifier
{
    private float mass = -5.972e15f;

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

        if (isGlobal())
        {
            for (Particle p : c)
            {
            }
        }
        else
        {
            for (Particle p : c)
            {
                Vector2F force = new Vector2F(mass * p.mass);
                Vector2F distance = new Vector2F(getX(), getY()).sub(p.pos);

                float d3 = distance.magnitude();
                d3 = d3 * d3 * d3;

                force.scaleInv(d3).scale(G).multiply(distance);

                p.force.add(force);
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
