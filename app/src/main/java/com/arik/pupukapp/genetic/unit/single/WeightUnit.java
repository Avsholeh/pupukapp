package com.arik.pupukapp.genetic.unit.single;

/*
 * This <unit-conversion> created by : 
 * Name         : syafiq
 * Date / Time  : 21 July 2017, 2:46 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public enum WeightUnit
{
    KILLOTONNE(1.0E9),
    TONNE(1.0E6),
    KILOGRAM(1.0E3),
    HECTOGRAM(1.0E2),
    DECAGRAM(1.0E1),
    GRAM(1.0E0),
    DECIGRAM(1.0E-1),
    CENTIGRAM(1.0E-2),
    MILIGRAM(1.0E-3),
    MICROGRAM(1.0E-6),
    NANOGRAM(1.0E-9);

    static final double MAX = Double.MAX_VALUE;

    public final double base;

    WeightUnit(double base)
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

    public static double converse(WeightUnit fromUnit, WeightWrapper<? extends Number> to)
    {
        return converse(1.0, fromUnit, to);
    }

    public static double converse(double fromVal, WeightUnit fromUnit, WeightWrapper<? extends Number> to)
    {
        return converse(fromVal, fromUnit, to.getValue().doubleValue(), to.getUnit());
    }

    //=================================================================================================================

    public static double converse(WeightWrapper<? extends Number> from, WeightUnit toUnit)
    {
        return converse(from, 1.0, toUnit);
    }

    public static double converse(WeightWrapper<? extends Number> from, double toVal, WeightUnit toUnit)
    {
        return converse(from.getValue().doubleValue(), from.getUnit(), toVal, toUnit);
    }

    //=================================================================================================================

    public static double converse(WeightUnit fromUnit, WeightUnit toUnit)
    {
        return converse(1.0, fromUnit, 1.0, toUnit);
    }

    public static double converse(WeightWrapper<? extends Number> from, WeightWrapper<? extends Number> to)
    {
        return converse(from.getValue().doubleValue(), from.getUnit(), to.getValue().doubleValue(), to.getUnit());
    }

    //=================================================================================================================


    public static double converse(WeightUnit fromUnit, double toVal, WeightUnit toUnit)
    {
        return converse(1.0, fromUnit, toVal, toUnit);
    }

    public static double converse(double fromVal, WeightUnit fromUnit, WeightUnit toUnit)
    {
        return converse(fromVal, fromUnit, 1.0, toUnit);
    }

    //=================================================================================================================

    public static double converse(double fromVal, WeightUnit from, double toVal, WeightUnit to)
    {
        final double calculate = from.base / to.base / toVal;
        return eval(fromVal, calculate, MAX / (calculate));
    }

    //=================================================================================================================

    public static interface WeightWrapper<N extends Number>
    {
        public WeightUnit getUnit();

        public N getValue();
    }
}

