package beans;

import model.Dot;
import model.JSON;
import sql.OracleDB;
import web.Request;
import web.RequestDispatcher;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;

@Named
@SessionScoped
public class Input implements Serializable
{
    private final RequestDispatcher dispatcher;
    private final OracleDB db;
    private final LinkedList<Dot> dots;

    private String lastR = "1";

    private String x;
    private Integer y;
    private boolean r1;
    private boolean r15;
    private boolean r2;
    private boolean r25;
    private boolean r3;

    public Input()
    {
        this.dispatcher = new RequestDispatcher(this);
        this.db = new OracleDB();
        this.dots = this.db.getDots();
    }

    public void submitted()
    {
        dispatcher.dispatch(new Request(x, y, new Boolean[]{r1, r15, r2, r25, r3}));
    }

    public void getDotsByR() throws IOException
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        ec.setResponseContentType("text/plain");
        ec.setResponseCharacterEncoding("UTF-8");
        ec.getResponseOutputWriter().write(JSON.toJson(dots));
        fc.responseComplete();
    }

    public String getX()
    {
        return x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    public Integer getY()
    {
        return y;
    }

    public void setY(Integer y)
    {
        this.y = y;
    }

    public boolean getR1()
    {
        return r1;
    }

    public void setR1(boolean r1)
    {
        this.r1 = r1;
        this.lastR = "1";
    }

    public boolean getR15()
    {
        return r15;
    }

    public void setR15(boolean r15)
    {
        this.r15 = r15;
        this.lastR = "1.5";
    }

    public boolean getR2()
    {
        return r2;
    }

    public void setR2(boolean r2)
    {
        this.r2 = r2;
        this.lastR = "2";
    }

    public boolean getR25()
    {
        return r25;
    }

    public void setR25(boolean r25)
    {
        this.r25 = r25;
        this.lastR = "2.5";
    }

    public boolean getR3()
    {
        return r3;
    }

    public void setR3(boolean r3)
    {
        this.r3 = r3;
        this.lastR = "3";
    }

    public String getLastR()
    {
        return this.lastR;
    }

    public LinkedList<Dot> getDots()
    {
        return this.dots;
    }

    public void addDot(Dot dot)
    {
        this.db.addDot(dot);
        this.dots.addFirst(dot);
    }
}
