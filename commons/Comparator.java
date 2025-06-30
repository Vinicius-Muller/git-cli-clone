package commons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Comparator {
  public void startComparation() {
    Path original = Paths.get("./index.html");
    Path copyToCompare = Paths.get("./about.html"); 
    File diffFile = new File("./head/diff.txt");

    try (FileWriter writer = new FileWriter(diffFile)) {
    List<String> originalContent = Files.readAllLines(original);
    List<String> copyToCompareContent = Files.readAllLines(copyToCompare);
    Set<String> originalContentMap = new HashSet(originalContent);
    Set<String> copyToCompareContentMap = new HashSet(copyToCompareContent);

    for (String line : copyToCompareContent) {
      if(!originalContentMap.contains(line)) {
        writer.write("--- " + line + "\n");
      }
    }

    writer.write("\n");

    for (String line : originalContent) {
      if(!copyToCompareContentMap.contains(line)) {
        writer.write("+++ " + line + "\n");
      }
    }

    writer.close();
    } catch(IOException e) {
      System.err.println(e);
    }
  }
}