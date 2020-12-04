package model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "HISTORY")
public class Dot
{
    @Id
    @GeneratedValue(generator="HISTORY_ID")
    @Column(name = "id")
    private int id;
    @Column (name = "x")
    private double x;
    @Column (name = "y")
    private double y;
    @Column (name = "r")
    private double r;
    @Column (name = "time_request")
    private String time;
    @Column (name = "execution_time")
    private double executed;
    @Column (name = "hit_result")
    private String result;
    @Column (name="session_id")
    private String session;

    public Dot()
    {
    }

    public Dot(double x, double y, double r, String session)
    {
        long start = System.nanoTime();

        this.x = x;
        this.y = y;
        this.r = r;
        this.session = session;
        this.result = HitManager.isHit(x, y, r) ? "Попадает в область" : "Не попадает в область";
        this.time = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date());
        this.executed = (System.nanoTime() - start)*1e-6;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setSession(String session) { this.session = session; }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void setR(double r)
    {
        this.r = r;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setExecuted(double executed)
    {
        this.executed = executed;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getSession() { return session; }

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

    public boolean getResultAsBoolean() { return result.equals("Попадает в область");}

    public String getTime()
    {
        return time;
    }

    public double getExecuted()
    {
        return executed;
    }

    public int getId()
    {
        return id;
    }
}
