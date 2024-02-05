package com.smk627751.view;

import com.smk627751.dto.Ladder;
import com.smk627751.dto.Person;
import com.smk627751.dto.Point;
import com.smk627751.dto.Snake;
import com.smk627751.viewmodel.ViewModel;

import java.util.Scanner;

public class View {

    ViewModel viewModel;
    public View()
    {
        this.viewModel = new ViewModel(this);
    }
    public void init()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board size: ");
        int n = sc.nextInt();
        viewModel.setBoardRow(n);
        viewModel.setBoardCol(n);
        System.out.println("Enter no of snakes: ");
        int snakesCount = sc.nextInt();
        for(int i = 0; i < snakesCount; i++)
        {
            System.out.println("Enter Head position: ");
            int[] pos = viewModel.getPosition(n,sc.nextInt());
            Point head = new Point(pos[0],pos[1]);
            System.out.println("Enter Tail position: ");
            pos = viewModel.getPosition(n,sc.nextInt());
            Point tail = new Point(pos[0],pos[1]);
            viewModel.getSnakes().add(new Snake(head,tail));
        }
        System.out.println("Enter no of Ladders: ");
        int laddersCount = sc.nextInt();
        for(int i = 0; i < laddersCount; i++)
        {
            System.out.println("Enter top position: ");
            int[] pos = viewModel.getPosition(n,sc.nextInt());
            Point top = new Point(pos[0],pos[1]);
            System.out.println("Enter bottom position: ");
            pos = viewModel.getPosition(n,sc.nextInt());
            Point bottom = new Point(pos[0],pos[1]);
            viewModel.getLadders().add(new Ladder(top,bottom));
        }
        System.out.println("Enter no of persons: ");
        int personCount = sc.nextInt();
        for(int i = 0; i < personCount; i++)
        {
            System.out.println("Enter the name: ");
            String name = sc.nextLine();
            name += sc.nextLine();
            Point pos = new Point(viewModel.getBoardRow() - 1, 0);
            viewModel.getPersons().add(new Person(name,pos));
        }
        viewModel.start();
    }
}
