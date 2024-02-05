package com.smk627751.viewmodel;

import com.smk627751.dto.Ladder;
import com.smk627751.dto.Person;
import com.smk627751.dto.Point;
import com.smk627751.dto.Snake;
import com.smk627751.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewModel {
    private View view;
    private List<Snake> snakes = new ArrayList<>();
    private List<Ladder> ladders = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();
    private int boardRow;
    private int boardCol;
    public ViewModel(View view) {
        this.view = view;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
        this.persons = new ArrayList<>();
    }
    public void start()
    {
        Scanner sc = new Scanner(System.in);
        int[] destination = getPosition(boardCol,boardRow * boardCol);
        outer:while(true)
        {
           for(Person curr : persons)
           {
               System.out.println(curr.getName()+" Press enter to roll the dice");
               sc.nextLine();
               int dice = (int)((Math.random() * 6) + 1);
               int currX = curr.getPos().getX();
               int currY = curr.getPos().getY();
               if (curr.getleft()) {
//                   System.out.println("toRight");
                   int newY = currY + dice;
                   if (newY >= boardCol) {
                       int remainingSteps = newY - boardCol;
                       int newRow = currX - 1;
                       int newCol = boardCol - 1 - remainingSteps;
                       curr.getPos().setX(newRow);
                       curr.getPos().setY(newCol);
                   } else {
                       curr.getPos().setY(newY);
                   }
               } else {
//                   System.out.println("toLeft");
                   int newY = currY - dice;
                   if (newY < 0) {
                       int remainingSteps = Math.abs(newY) + boardCol * (Math.abs(newY) / boardCol);
                       int newRow = currX - 1;
                       int newCol = remainingSteps % boardCol;
                       curr.getPos().setX(newRow);
                       curr.getPos().setY(newCol - 1);
                   } else {
                       curr.getPos().setY(newY);
                   }
               }
               if(curr.getPos().getX() < 0 || curr.getPos().getY() < 0)
               {
                   curr.getPos().setX(currX);
                   curr.getPos().setY(currY);
               }
               for(Snake snake : snakes)
               {
                   if(curr.equals(snake))
                   {
                       System.out.println("Hit by the snake...");
                       Point pos = snake.getTail();
                       curr.getPos().setX(pos.getX());
                       curr.getPos().setY(pos.getY());
                       break;
                   }
               }
               for (Ladder ladder : ladders)
               {
                   if(curr.equals(ladder))
                   {
                       System.out.println("Climbed a ladder...");
                       Point pos = ladder.getTop();
                       curr.getPos().setX(pos.getX());
                       curr.getPos().setY(pos.getY());
                       break;
                   }
               }
               curr.setleft(curr.getPos().getX() % 2 != 0);
               System.out.println(curr.getName()+" rolled a "+dice+" and moved from ("+currX+","+currY+") to ("+curr.getPos().getX()+","+curr.getPos().getY()+")");
               System.out.println(curr.getName()+" rolled a "+dice+" and moved from "+getPosition(boardCol,currX,currY)+" to "+getPosition(boardCol,curr.getPos().getX(),curr.getPos().getY()));
               if(curr.getPos().getX() == destination[0] && curr.getPos().getY() == destination[1])
               {
                   System.out.println(curr.getName()+" won the game");
                   break outer;
               }
           }
        }
    }
    public int getPosition(int size, int row, int col) {
        // Calculate the position based on the provided row and column indices
        int pos = 0;

        // Determine the position considering the layout
        if (row == 0) {
            pos = size - col;
        } else if (row == size - 1) {
            pos = size * (size - 1) + col + 1;
        } else {
            int row_pos = size - row - 1;
            if (row_pos % 2 == 0) {
                pos = size * row_pos + col + 1;
            } else {
                pos = size * row_pos + (size - col);
            }
        }
        return pos;
    }

    public int[] getPosition(int size,int pos)
    {
        int quotient = pos / size, rem = pos % size, row, col;

        row = (size - 1) - (rem % size == 0 ? (quotient - 1) : quotient);

        if (row % 2 == 0) {

            col = pos % size == 0 ? 0 : size - (pos % size);
        } else {
            col = pos % size == 0 ? (size - 1) : (pos % size - 1);
        }
        return new int[]{row,col};
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public int getBoardRow()
    {
        return boardRow;
    }
    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }
    public int getBoardCol()
    {
        return boardCol;
    }
    public void setBoardCol(int boardCol) {
        this.boardCol = boardCol;
    }
}
