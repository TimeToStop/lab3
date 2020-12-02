package web;

public class Request
{
    private final String x;
    private final Integer y;
    private final Boolean[] r;

    public Request(String x, Integer y, Boolean[] r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public String getX()
    {
        return this.x;
    }

    public Integer getY()
    {
        return this.y;
    }

    public Boolean[] getR()
    {
        return this.r;
    }
}
