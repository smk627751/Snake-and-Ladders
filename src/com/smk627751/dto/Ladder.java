package com.smk627751.dto;

public class Ladder
{
    private Point top;
    private Point bottom;

    public Ladder(Point top, Point bottom)
    {
        this.top = top;
        this.bottom = bottom;
    }

    public Point getTop() {
        return top;
    }

    public void setTop(Point top) {
        this.top = top;
    }

    public Point getBottom() {
        return bottom;
    }

    public void setBottom(Point bottom) {
        this.bottom = bottom;
    }

    public String toString()
    {
        return "{"+top.getX()+","+top.getY()+"}"+"{"+bottom.getX()+","+bottom.getY()+"}";
    }
}
