package ParticleEngine;

import java.awt.*;

public class Particle implements IDraw, IAct
{
    public Vector2F pos = new Vector2F();
    public Vector2F force = new Vector2F();
    public Vector2F velocity = new Vector2F();
    public float mass = 1;
    public float life = 0.3f * 10;
    public float damping = 0.995f;
    public Color color = Color.YELLOW;
    public boolean immortal = true;
    public boolean alive = true;
    private Renderer renderer;

    public Particle(Renderer renderer)
    {
        this.renderer = renderer;
    }

    public Renderer getRenderer()
    {
        return renderer;
    }

    @Override
    public void act()
    {
        final float dt = 1f / Renderer.FPS;

        velocity.add(force.scaleInv(mass / dt));
        pos.add(force.scale(velocity, dt));

        force.setAll(0);

        velocity.scale(damping);

        if (!immortal)
        {
            life -= 0.01;
        }

        if (life <= 0 || pos.x < 0 || pos.y < 0 || pos.x > renderer.getWidth() || pos.y > renderer.getHeight())
        {
            alive = false;
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect((int)pos.x, (int)pos.y, 1, 1);
    }
}
