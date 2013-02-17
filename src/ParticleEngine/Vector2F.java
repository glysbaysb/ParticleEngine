package ParticleEngine;

public class Vector2F
{
    public float x;
    public float y;

    public Vector2F()
    {
        x = 0;
        y = 0;
    }

    public Vector2F(float value)
    {
        x = value;
        y = value;
    }

    public Vector2F(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2F(Vector2F v)
    {
        x = v.x;
        y = v.y;
    }

    public void setAll(float value)
    {
        x = value;
        y = value;
    }

    public void set(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2F v)
    {
        x = v.x;
        y = v.y;
    }

    public Vector2F add(Vector2F v)
    {
        x += v.x;
        y += v.y;

        return this;
    }

    public Vector2F add(Vector2F v1, Vector2F v2)
    {
        x = v1.x + v2.x;
        y = v1.y + v2.y;

        return this;
    }

    public Vector2F addNew(Vector2F v)
    {
        return new Vector2F(x + v.x, y + v.y);
    }

    public Vector2F sub(Vector2F v)
    {
        x -= v.x;
        y -= v.y;

        return this;
    }

    public Vector2F sub(Vector2F v1, Vector2F v2)
    {
        x = v1.x - v2.x;
        y = v1.y - v2.x;

        return this;
    }

    public Vector2F subNew(Vector2F v)
    {
        return new Vector2F(x - v.x, y - v.y);
    }

    public Vector2F scale(float f)
    {
        x *= f;
        y *= f;

        return this;
    }

    public Vector2F scale(Vector2F v, float f)
    {
        x = v.x * f;
        y = v.y * f;

        return this;
    }

    public Vector2F scaleNew(float f)
    {
        return new Vector2F(x * f, y * f);
    }

    public Vector2F scaleInv(float f)
    {
        x /= f;
        y /= f;

        return this;
    }

    public Vector2F scaleInv(Vector2F v, float f)
    {
        x = v.x / f;
        y = v.y / f;

        return this;
    }

    public Vector2F scaleInvNew(float f)
    {
        return new Vector2F(x / f, y / f);
    }

    public Vector2F multiply(Vector2F v)
    {
        x *= v.x;
        y *= v.y;

        return this;
    }

    public Vector2F multiply(Vector2F v1, Vector2F v2)
    {
        x = v1.x * v2.x;
        y = v1.y * v2.y;

        return this;
    }

    public Vector2F multiplyNew(Vector2F v)
    {
        return new Vector2F(x / v.x, y / v.y);
    }

    public Vector2F divide(Vector2F v)
    {
        x /= v.x;
        y /= v.y;

        return this;
    }

    public Vector2F divide(Vector2F v1, Vector2F v2)
    {
        x = v1.x / v2.x;
        y = v1.y / v2.y;

        return this;
    }

    public Vector2F divideNew(Vector2F v)
    {
        return new Vector2F(x / v.x, y / v.y);
    }

    public float dot(Vector2F v)
    {
        return x * v.x + y * v.y;
    }

    public float magnitude()
    {
        return (float)Math.sqrt(x * x + y * y);
    }

    public Vector2F normalize()
    {
        float m = magnitude();

        x /= m;
        y /= m;

        return this;
    }

    public Vector2F normalize(Vector2F v)
    {
        float m = v.magnitude();

        x = v.x / m;
        y = v.y / m;

        return this;
    }

    public Vector2F normalizeNew()
    {
        float m = magnitude();

        return new Vector2F(x / m, y / m);
    }
}
