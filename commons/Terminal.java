package commons;

import java.util.ArrayList;
import java.util.List;
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

    if(command.equals("close")) {
      terminal.close();
      System.out.println("Closing VM CLI");
      return;
    }

    if(command.equals("vm init")) {
      List<String> files = new ArrayList();
      
      System.out.println("Please enter the origin file path");

      while(files.size() < 2) {
        String fileSrc = terminal.nextLine();
        files.add(fileSrc);
      
        System.out.println("Please enter the to compare file path");  
      }
      terminal.close();

      comparator.startComparation(files.get(0), files.get(1));
    } else {
      System.out.println("Command not found: *Command List*");
      System.out.println("vm init | init the vm repo");
      System.out.println("vm init | close vm cli");
      startTerminal();
    }
  }
}