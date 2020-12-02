package model.validation;

public class ParserX implements Parser<Double, String>
{
    public ParserX()
    {
    }

    @Override
    public Double parse(String data) throws ValidateException
    {
        try
        {
            Double.parseDouble(data);

            if(data.length() > 5)
            {
                data = data.substring(0, 5);
            }

            double value = Double.parseDouble(data);

            if (value < -5 || value > 3)
            {
                throw new ValidateException("X is not in range (-5, 3)");
            }

            return value;
        }
        catch (NumberFormatException e)
        {
            throw new ValidateException("X is not a number");
        }
    }
}
