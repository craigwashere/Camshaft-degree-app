package com.beaubien.cam_degree;

/**
 * Created by Beaubien on 7/5/2017.
 */

public class lobe
{
    private float intake_duration, intake_centerline, exhaust_duration, exhaust_centerline, lobe_separation, overlap;
    private float intake_opens, intake_closes, exhaust_opens, exhaust_closes;

    public float getIntake_opens() {
        return intake_opens;
    }

    public float getIntake_closes() {
        return intake_closes;
    }

    public float getExhaust_opens() {
        return exhaust_opens;
    }

    public float getExhaust_closes() {
        return exhaust_closes;
    }

    public void setIntake_closes(float intake_closes) {
        this.intake_closes = intake_closes;
    }

    public void setExhaust_opens(float exhaust_opens) {
        this.exhaust_opens = exhaust_opens;
    }

    public void setExhaust_closes(float exhaust_closes) {
        this.exhaust_closes = exhaust_closes;
    }

    public void set_intake_opens(float intake_opens)
    {   this.intake_opens = intake_opens; }

    public float getIntake_duration() {
        return intake_duration;
    }

    public float getIntake_centerline() {
        return intake_centerline;
    }

    public float getExhaust_duration() {
        return exhaust_duration;
    }

    public float getExhaust_centerline() {
        return exhaust_centerline;
    }

    public float getLobe_separation() {
        return lobe_separation;
    }

    public float getOverlap() {
        return overlap;
    }

    lobe ()
    {
        intake_duration = 0;
        intake_centerline = 0;
        exhaust_duration = 0;
        exhaust_centerline = 0;
        lobe_separation = 0;
        overlap = 0;
    }

    lobe (float intake_opens, float intake_closes, float exhaust_opens, float exhaust_closes)
    {
        this.intake_closes = intake_closes;
        this.exhaust_opens = exhaust_opens;
        this.exhaust_closes = exhaust_closes;
        this.intake_opens = intake_opens;

        refactor();
    }

    /*  Example case:
        IO = 31-degrees BTDC IC = 63-degrees ABDC
        EO = 77-degrees BBDC EC = 29-degrees ATDC
        Intake Duration = IO + 180 + IC = 274
        Exhaust Duration =  EO + 180 + EC = 286
        Intake Centerline =  (duration ÷ 2) – IO = 106 degrees
        Exhaust Centerline = (calculated duration ÷ 2) – EC = 114
        LSA = (intake centerline + exhaust centerline) ÷ 2 = 110 degrees
    */    public void refactor()
    {
        intake_duration = intake_opens + 180 + intake_closes;
        intake_centerline = (intake_duration/2) - intake_opens;
        exhaust_duration = exhaust_opens + 180 + exhaust_closes;
        exhaust_centerline = (exhaust_duration/2) - exhaust_closes;
        lobe_separation = (intake_centerline + exhaust_centerline)/2;
        overlap = intake_opens + exhaust_closes;
    }
}
