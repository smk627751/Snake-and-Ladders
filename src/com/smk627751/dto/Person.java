package com.smk627751.dto;

public class Person {
    private String name;
    private Point pos;
    private boolean isLeft = true;
    public Person(String name, Point pos)
    {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPos() {
        return pos;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public String toString()
    {
        return this.name+": {"+pos.getX()+","+pos.getY()+"}";
    }

    public boolean getleft() {
        return isLeft;
    }

    public void setleft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    public boolean equals(Snake snake)
    {
        Point head = snake.getHead();
        return head.getX() == this.pos.getX() && head.getY() == this.pos.getY();
    }

    public boolean equals(Ladder ladder)
    {
        Point bottom = ladder.getBottom();
        return bottom.getX() == this.pos.getX() && bottom.getY() == this.pos.getY();
    }
}
