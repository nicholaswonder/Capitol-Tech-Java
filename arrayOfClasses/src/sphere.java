import java.util.Objects;

public class sphere
{
    private float radius;
    private float volume;
    private String color;

    public sphere()
    {
        radius = 1;
        color = "white";
    }

    public sphere(float radius, String color)
    {
        setRadius(radius);
        setColor(color);
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        if (radius > 0)
        {
            this.radius = radius;
            setVolume(this.radius);
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.isEmpty())
        {
            this.color = color;
        }
    }

    public float getVolume() {
        return volume;
    }

    private void setVolume(float radius) {
        volume = (float) ((4.0/3.0) * Math.PI * Math.pow(radius, 3));
    }

    // Volume is not included in the equals method since volume is updated in a private function when radius is
    // Therefore, there cannot be a sphere with equal radius and not equal volume.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        sphere sphere = (sphere) o;
        return Float.compare(radius, sphere.radius) == 0 && Objects.equals(color, sphere.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, color);
    }

    public String toString()
    {
        return "\nSphere\n" + "Color: " + getColor() + "\n" + "Radius: " + getRadius() + "\n" + "Volume: " + getVolume() + "\n";
    }
}
