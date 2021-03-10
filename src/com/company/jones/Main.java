package com.company.jones;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AdIn input =new AdIn();
        System.out.println("to do list time");
        int choice;
        ArrayList<Task> theList=new ArrayList<Task>();
        do {

            choice=(input.promptInt("pick time! choos e nuber for action/n" +
                    "1: add task\n"+
                    "2: remove task\n" +
                    "3:update task\n" +
                    "4:list all task\n" +
                    "0: exit\nChoice:", 4));
            switch(choice)
            {
                case 1:
                    theList=addTask(input, theList);
                    break;
                case 2:
                    if (theList.size()!=0) {
                        theList = removeTask(input, theList);
                    }else System.out.println("bruh what you gon remove there aint none here");

                    break;
                case 3:
                    if (theList.size()!=0) {
                        theList=updateTask(input, theList);
                    }else System.out.println("bruh what you gon update there aint none here");
                    break;
                case 4:

                    sendList(input, theList);
                    break;
                case 0:
                    System.out.println("ok bye");
                    break;
                default:
                    System.out.println("how does he even read it?");
                    break;

            }
        }while (choice!=0);
    }
    private static ArrayList<Task> addTask(AdIn input, ArrayList<Task> theList){
        theList.add(new Task(input));
        return theList;


    }
    private static ArrayList<Task> removeTask(AdIn input,ArrayList<Task> theList){
        theList.remove(input.promptInt("which index wold you like to remove", theList.size()-1));
        return theList;
    }
    private static ArrayList<Task> updateTask(AdIn input, ArrayList<Task> theList){
        System.out.println();
        int replaceIndex=input.promptInt("which index would you like to update", theList.size()-1);
        theList.set(replaceIndex, new Task(input));
        return theList;
    }
    private static void sendList(AdIn input,ArrayList<Task> theList) {
        int priority=input.promptInt("If you would like to only look for a certain priority level of items, please input that priority number. if you wish to print all items, hit the 6 key and then the enter key", 6);
        if (priority ==6){
            for (int t=0;t<theList.size();t++){
                System.out.println(theList.get(t).toString());
            }
        }else{
            for (int i=0;i<theList.size();i++){
                if (theList.get(i).getPriority()==priority){
                    System.out.println(theList.get(i).toString());
                }
            }
        }
    }
}