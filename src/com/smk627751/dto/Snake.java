package com.smk627751.dto;

public class Snake
{
    private Point head;
    private Point tail;

    public Snake(Point head, Point tail)
    {
        this.head = head;
        this.tail = tail;
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public Point getTail() {
        return tail;
    }

    public void setTail(Point tail) {
        this.tail = tail;
    }

    public String toString()
    {
        return "{"+head.getX()+","+head.getY()+"}"+"{"+tail.getX()+","+tail.getY()+"}";
    }
}
