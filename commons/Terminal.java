package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class Terminal {
  private final Scanner terminal;
  private final Comparator comparator;
  private String command;

  public Terminal() {
    terminal = new Scanner(System.in);
    comparator = new Comparator();
  }

  public void startTerminal(String welcome) {
    if(welcome != null) {
      System.out.println(welcome);
    }
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

        if(fileSrc.equals("undone")) {
          files.remove(0);
          System.out.println("choice undone.");
          continue;
        }

        Path path = Paths.get(fileSrc);

        if(!Files.exists(path)) {
          System.out.println("File not found, try again.");
          continue;
        }
        files.add(fileSrc);
      
        if(files.size() == 1) {
          System.out.println("Please enter the to compare file path");
        }  
      }
      terminal.close();

      comparator.startComparation(files.get(0), files.get(1));
      System.out.println("Diff file created into head folder");
    } else {
      System.out.println("Command not found: *Command List*");
      System.out.println("vm init | init the vm repo");
      System.out.println("close | close vm cli");
      System.out.println("undone | undo a choice");
      startTerminal(null);
    }
  }
}