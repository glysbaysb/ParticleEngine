package ParticleEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Emitter extends EngineObject implements IAct
{
    private int amount = 100;

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public Emitter(Renderer renderer)
    {
        super(renderer);
    }

    @Override
    public void act()
    {
        if (isActive())
        {
            Random rng = new Random();
            Renderer renderer = getRenderer();
            ArrayList<Particle> list = new ArrayList<Particle>(amount);

            for (int i = 0; i < amount; i++)
            {
                Particle p = new Particle(renderer);

                p.pos.set(getX(), getY());

                p.velocity.x = 0.01f + rng.nextFloat() * 100;
                p.velocity.x *= rng.nextInt(2) == 0 ? 1 : -1;

                p.velocity.y = 0.01f + rng.nextFloat() * 100;
                p.velocity.y *= rng.nextInt(2) == 0 ? 1 : -1;

                list.add(p);
            }

            renderer.addParticles(list);
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.drawOval(getX() - 7, getY() - 7, 14, 14);
        g.setColor(Color.CYAN);
        g.fillRect(getX() - 1, getY() - 1, 3, 3);
    }
}
