package model;

public class HitManager
{
    public static boolean isHit(double x, double y, double r)
    {
        boolean success = false;

        if(x >= 0 && y <= 0)
        {
            success = (x <= r && y >= -r/2);
        }
        else if (x <= 0 && y <= 0)
        {
            success = (x * x + y * y <= r * r / 4);
        }
        else if (x <= 0 && y >= 0)
        {
            success = (y <= (x + r)/2);
        }

        return success;
    }
}
