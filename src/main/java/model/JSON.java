package model;

import java.util.LinkedList;

public class JSON
{
    public static String toJson(LinkedList<Dot> dots)
    {
        StringBuilder b = new StringBuilder();
        b.append("[");

        for(Dot dot : dots)
        {
            b.append("{")
                .append("\"x\" : ").append(dot.getX()).append(",")
                .append("\"y\" : ").append(dot.getY()).append(",")
                .append("\"r\" : ").append(dot.getR()).append(",")
                .append("\"hit\" : ").append(dot.getResultAsBoolean())
            .append("},");
        }

        if (b.lastIndexOf(",") > 0)
        {
            b.deleteCharAt(b.length() - 1);
        }

        b.append("]");
        return b.toString();
    }
}
