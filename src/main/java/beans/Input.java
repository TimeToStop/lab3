package beans;

import model.Dot;
import model.JSON;
import org.icefaces.apache.commons.fileupload.RequestContext;
import org.primefaces.PrimeFaces;
import sql.OracleDB;
import web.Request;
import web.RequestDispatcher;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

@Named
@SessionScoped
public class Input implements Serializable
{
    private final RequestDispatcher dispatcher;
    private final OracleDB db;
    private final LinkedList<Dot> dots;

    private String x;
    private Integer y;
    private boolean r1;
    private boolean r15;
    private boolean r2;
    private boolean r25;
    private boolean r3;

    public String getInput_x() {
        return input_x;
    }

    public void setInput_x(String input_x) {
        this.input_x = input_x;
    }

    public String getInput_y() {
        return input_y;
    }

    public void setInput_y(String input_y) {
        this.input_y = input_y;
    }

    public String getInput_r() {
        return input_r;
    }

    public void setInput_r(String input_r) {
        this.input_r = input_r;
    }

    private String input_x;
    private String input_y;
    private String input_r;

    public Input()
    {
        this.dispatcher = new RequestDispatcher(this);
        this.db = new OracleDB();
        this.dots = this.db.getDots();
    }

    public String imageSubmit()
    {
        try
        {
            double x = Double.parseDouble(input_x);
            double y = Double.parseDouble(input_y);
            double r = Double.parseDouble(input_r);

            addDot(new Dot(x, y, r, ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).getId()));
        }
        catch (NumberFormatException e)
        {
        }

        return "form.xhtml?faces-redirect=true";
    }

    public String submitted()
    {
        dispatcher.dispatch(new Request(x, y, new Boolean[]{r1, r15, r2, r25, r3}));
        return "form.xhtml?faces-redirect=true";
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
    }

    public boolean getR15()
    {
        return r15;
    }

    public void setR15(boolean r15)
    {
        this.r15 = r15;
    }

    public boolean getR2()
    {
        return r2;
    }

    public void setR2(boolean r2)
    {
        this.r2 = r2;
    }

    public boolean getR25()
    {
        return r25;
    }

    public void setR25(boolean r25)
    {
        this.r25 = r25;
    }

    public boolean getR3()
    {
        return r3;
    }

    public void setR3(boolean r3)
    {
        this.r3 = r3;
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
