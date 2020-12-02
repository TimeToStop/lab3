package model.validation;

public class ParserY implements Parser<Double, Integer>
{
    public ParserY()
    {
    }

    @Override
    public Double parse(Integer data) throws ValidateException
    {
        if (data == null) return 123.0;

        if (data <= -40 || data >= 40)
        {
            throw new ValidateException("Y is not in range (-4, 4)");
        }

        return data / 10.0;
    }
}
