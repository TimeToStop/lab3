package web;

import beans.Input;
import model.Dot;
import model.validation.*;

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
            double x = parserX.parse(request.getX());
            double y = parserY.parse(request.getY());
            double r = parserR.parse(request.getR());

            input.addDot(new Dot(x, y, r));
        }
        catch (ValidateException e)
        {
            // Error:
        }
    }
}
