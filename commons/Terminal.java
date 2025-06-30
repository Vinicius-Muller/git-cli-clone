package commons;

import java.util.Scanner;

public class Terminal {
  private final Scanner terminal;
  private final Comparator comparator;
  private String command;

  public Terminal() {
    terminal = new Scanner(System.in);
    comparator = new Comparator();
  }

  public void startTerminal() {
    System.out.println("Welcome to the VM CLI");
    command = terminal.nextLine();

    if(command.equals("vm init")) {
      System.out.println("Welcome to the cli");
      comparator.startComparation();
    } 
  }
}