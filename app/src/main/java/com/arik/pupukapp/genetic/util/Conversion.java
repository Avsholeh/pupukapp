package com.arik.pupukapp.genetic.util;

/*
 * This <unit-conversion> created by : 
 * Name         : syafiq
 * Date / Time  : 24 July 2017, 7:57 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public interface Conversion<U>
{
    double to(U to, double value, double base);

    double to(U to, double value);
}
