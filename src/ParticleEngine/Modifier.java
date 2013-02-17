package ParticleEngine;

import java.util.Collection;

public abstract class Modifier extends EngineObject
{
    private boolean global = false;

    public boolean isGlobal()
    {
        return global;
    }

    public void setGlobal(boolean value)
    {
        global = value;
    }

    public Modifier(Renderer renderer)
    {
        super(renderer);
    }

    public abstract void apply(Collection<Particle> c);
}
