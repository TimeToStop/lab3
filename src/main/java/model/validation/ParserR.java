package model.validation;

public class ParserR implements Parser<Double, Boolean[]>
{
    public ParserR()
    {
    }

    @Override
    public Double parse(Boolean[] data) throws ValidateException
    {
        int count = 0;
        double value = 1;
        double res_value = 0;

        for(Boolean b : data)
        {
            if (b)
            {
                count++;
                res_value = value;
            }

            value += 0.5;
        }

        if (count == 0)
        {
            throw new ValidateException("Selected none of R");
        }
        else if (count != 1)
        {
            throw new ValidateException("Selected multiplies R");
        }

        return res_value;
    }
}
