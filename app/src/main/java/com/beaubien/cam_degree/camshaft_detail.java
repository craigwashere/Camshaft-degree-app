package com.beaubien.cam_degree;
/**
 * Created by Beaubien on 7/1/2017.
 */

public class camshaft_detail
{
    private float intake_duration, intake_centerline, exhaust_duration, exhaust_centerline, lobe_separation, overlap;


    camshaft_detail(float intake_opens, float intake_closes, float exhaust_opens, float exhaust_closes)
    {
        intake_duration = intake_opens + 180 + intake_closes;
        intake_centerline = (intake_duration/2) - intake_opens;

        exhaust_duration = exhaust_opens + 180 + exhaust_closes;
        exhaust_centerline = (exhaust_duration/2) - exhaust_closes;

        lobe_separation = (intake_duration + exhaust_duration)/2;
        overlap = intake_opens + exhaust_closes;
    }

    public float getExhaust_centerline()    {  return exhaust_centerline;   }

    public float getExhaust_duration()      {   return exhaust_duration;    }

    public float getIntake_centerline()     {   return intake_centerline;   }

    public float getIntake_duration()       {   return intake_duration;     }

    public float getLobe_separation()       {   return lobe_separation;     }

    public float getOverlap()               {   return overlap;             }
}
