package com.arik.pupukapp.genetic.unit.single;

/*
 * This <unit-conversion> created by : 
 * Name         : syafiq
 * Date / Time  : 21 July 2017, 2:43 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public enum AreaUnit
{
    SQUARE_MILLIMETER(1.0E-6),
    SQUARE_CENTIMETER(1.0E-4),
    SQUARE_DECIMETER(1.0E-2),
    SQUARE_METER(1.0E0),
    SQUARE_DECAMETER(1.0E2),
    SQUARE_HECTOMETER(1.0E4),
    SQUARE_KILOMETER(1.0E6),

    ARE(1.0E2),
    DECARE(1.0E3),
    HECTARE(1.0E4);

    static final double MAX = Double.MAX_VALUE;

    public final double base;

    AreaUnit(double base)
    {
        this.base = base;
    }

    static double eval(double d, double m, double over)
    {
        if(d > over)
        {
            return Double.MAX_VALUE;
        }
        if(d < -over)
        {
            return Double.MIN_VALUE;
        }
        return d * m;
    }

    //=================================================================================================================

    public static double converse(AreaUnit fromUnit, AreaWrapper<? extends Number> to)
    {
        return converse(1.0, fromUnit, to);
    }

    public static double converse(double fromVal, AreaUnit fromUnit, AreaWrapper<? extends Number> to)
    {
        return converse(fromVal, fromUnit, to.getValue().doubleValue(), to.getUnit());
    }

    //=================================================================================================================

    public static double converse(AreaWrapper<? extends Number> from, AreaUnit toUnit)
    {
        return converse(from, 1.0, toUnit);
    }

    public static double converse(AreaWrapper<? extends Number> from, double toVal, AreaUnit toUnit)
    {
        return converse(from.getValue().doubleValue(), from.getUnit(), toVal, toUnit);
    }

    //=================================================================================================================

    public static double converse(AreaUnit fromUnit, AreaUnit toUnit)
    {
        return converse(1.0, fromUnit, 1.0, toUnit);
    }

    public static double converse(AreaWrapper<? extends Number> from, AreaWrapper<? extends Number> to)
    {
        return converse(from.getValue().doubleValue(), from.getUnit(), to.getValue().doubleValue(), to.getUnit());
    }

    //=================================================================================================================


    public static double converse(AreaUnit fromUnit, double toVal, AreaUnit toUnit)
    {
        return converse(1.0, fromUnit, toVal, toUnit);
    }

    public static double converse(double fromVal, AreaUnit fromUnit, AreaUnit toUnit)
    {
        return converse(fromVal, fromUnit, 1.0, toUnit);
    }

    //=================================================================================================================

    public static double converse(double fromVal, AreaUnit from, double toVal, AreaUnit to)
    {
        final double calculate = from.base / to.base / toVal;
        return eval(fromVal, calculate, MAX / (calculate));
    }

    //=================================================================================================================

    public static interface AreaWrapper<N extends Number>
    {
        public AreaUnit getUnit();

        public N getValue();
    }
}
