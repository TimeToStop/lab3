package web;

import beans.Input;
import model.Dot;
import model.validation.*;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class RequestDispatcher
{
    private final Input input;

    private final static ParserX parserX = new ParserX();
    private final static ParserY parserY = new ParserY();
    private final static ParserR parserR = new ParserR();

    public RequestDispatcher(Input input)
    {
        this.input = input;
    }

    public void dispatch(Request request)
    {
        try
        {
            FacesContext fCtx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);

            double x = parserX.parse(request.getX());
            double y = parserY.parse(request.getY());
            double r = parserR.parse(request.getR());

            String sessionId = session.getId();
            input.addDot(new Dot(x, y, r, sessionId));
        }
        catch (ValidateException e)
        {
            input.setError(e.getMessage());
        }
    }
}
