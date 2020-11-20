package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
public class Input implements Serializable
{
    private String x;
    private String y;
    private boolean r1;
    private boolean r15;
    private boolean r2;
    private boolean r25;
    private boolean r3;

    public Input() {

    }

    public void submitted() {
        System.err.println("Submitted");
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public boolean isR1() {
        return r1;
    }

    public void setR1(boolean r1) {
        this.r1 = r1;
    }

    public boolean isR15() {
        return r15;
    }

    public void setR15(boolean r15) {
        this.r15 = r15;
    }

    public boolean isR2() {
        return r2;
    }

    public void setR2(boolean r2) {
        this.r2 = r2;
    }

    public boolean isR25() {
        return r25;
    }

    public void setR25(boolean r25) {
        this.r25 = r25;
    }

    public boolean isR3() {
        return r3;
    }

    public void setR3(boolean r3) {
        this.r3 = r3;
    }
}
