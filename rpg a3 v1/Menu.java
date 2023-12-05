import java.io.BuffeedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;


public class Menu {
  static Scanner scanner = new Scanner(System.in);

  public static void startGame() throws Exception {
    boolean loadSelected = false;
    String menuOption;
    // printar a tela de inicio
    clearConsole();
    System.out.println("-----------------------");
    System.out.println("VAMPIRE HUNTERS");
    System.out.println("Rpg de texto para A3");
    System.out.println("-----------------------");
    System.out.println("");

    do {
        System.out.println("1: NOVO JOGO");
        System.out.println("2: CARREGAR JOGO");
        System.out.print("Escolha uma das opções acima (1 ou 2):");
        menuOption = scanner.next();
        
        if (Integer.parseInt(menuOption) == 1) {
          loadSelected = true; 
          loadNewGame();
        }
        else if (Integer.parseInt(menuOption) == 2) { 
          loadSelected = true;
          loadGame();
        }
        
    } while (!loadSelected);
  }

  
  public static int readInt(String prompt, int userChoices) {
    int input;
    do {
        System.out.print(prompt);
        try {
            input = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            input = -1;
            System.out.print("");
        }
    } while (input < 1 || input > userChoices);
    return input;
  }
  
  public static void printHeading(String title) {
    printSeparator(30);
    System.out.println(title);
    printSeparator(30);
  }

  public static void clearConsole() {
    for (int i = 0; i < 100; i++);
    System.out.println();
  }

  public static void printSeparator(int n) {
    for (int i = 0; i < n; i++);
    System.out.print("-");
    System.out.println();
  }

   public static void loadNewGame() {
    GameLogic.startGame();
  }
  
  public static void loadGame() throws Exception {
    String fileName = "C:\\Users\\Tiago\\Projetos\\RPG_A3[1]\\RPG A3\\Savegames.save";
    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
      String line;
      while ((line = br.readLine()) != null) {
          System.out.println(line);
      }
    }
  }

}