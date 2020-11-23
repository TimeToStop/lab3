package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Dot
{
    private final double x;
    private final double y;
    private final double r;
    private final String time;
    private final double time_execute;
    private final String result;

    public Dot(double x, double y, double r)
    {
        long start = System.nanoTime();

        this.x = x;
        this.y = y;
        this.r = r;
        this.result = HitManager.isHit(x, y, r) ? "Попадает в область" : "Не попадает в область";
        this.time = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date());
        this.time_execute = (System.nanoTime() - start)*1e-6;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getR()
    {
        return r;
    }

    public String getResult()
    {
        return result;
    }

    public String getTime()
    {
        return time;
    }

    public double getTimeExecuted()
    {
        return time_execute;
    }
}
