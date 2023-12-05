import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    // Elementos da historia
    public static String[] encounters = {"Batalha", "Batalha", "Batalha", "Descanso", "Descanso", };
    public static String[] enemies = {"Esqueleto Mago", "Esqueleto Arqueiro", "Esqueleto Guerreiro", "Lobisomen", "Lobisomen Marrom", "Vampiro Inferior", "Vampiro Médio", "Vampira Inferior", "Vampira Média", "Vampiro Arqueiro", "Vampiro Bruto", "Vampiro Escudeiro", "Monstro Sombra", "Demonio Inferior", "Demonio Médio", "Gárgola Voadora", "Gárgola Guerreira", "Morcego Gigante","Lobo Vampiro", "Caveira Flutuante"};
    public static int place = 0, act = 1;
    public static String[] places = {"Arredores de Whitechapel", "Nightosphere", "Castelo do Drácula"};

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

    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            ;
        System.out.println();

    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++);
        System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nInsira qualquer coisa para continuar...");
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        // printar a tela de inicio
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("VAMPIRE HUNTERS");
        System.out.println("Rpg de texto para A3");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("Qual o seu nome?");
            name = scanner.next();
            // perguntar se quer corrigir o nome
            clearConsole();
            printHeading("Seu nome é " + name + ".\nEstá correto?");
            System.out.println("(1) Sim");
            System.out.println("(2) Não, eu quero mudar meu nome");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);

        //intro da historia
        Historia.printIntro();

        // criar novo objeto player com nome
        player = new Player(name);

        Historia.printFirstActIntro();

        // configuração isRunning true para dar loop

        isRunning = true;

        // comear o loop do jogo
        gameLoop();
    }

    public static void checkAct(){
        if(player.xp >= 10 && act ==1){
            act = 2;
            place = 1;

            Historia.printFirstActOutro();
            // upar de lvl

            player.chooseTrait();

            Historia.printSecondActIntro();
            enemies[0] = "Grupo de Monstros";
            enemies[1] = "Lobos";
            enemies[2] = "Esqueletos";
            enemies[3] = "Grupo de Criaturas da Noite";
            enemies[4] = "Criaturas da Noite";
            // valores para encontros
            encounters[0] = "Batalha";
            encounters[1] = "Batalha";
            encounters[2] = "Descanso";
            encounters[3] = "Descanso";
            encounters[4] = "Loja";
     
    


        }else if (player.xp>= 25 && act == 2){
            act = 3;
            place = 2;

            Historia.printSecondActOutro();
            // upar de lvl
            player.chooseTrait();
            Historia.printThirdActIntro();
            enemies[0] = "Lobos";
            enemies[1] = "Lobos";
            enemies[2] = "Esqueletos";
            enemies[3] = "Grupo de Criaturas da Noite";
            enemies[4] = "Criaturas da Noite";
            // valores para encontros
            encounters[0] = "Batalha";
            encounters[1] = "Batalha";
            encounters[2] = "Descanso";
            encounters[3] = "Batalha";
            encounters[4] = "Loja";

            //curar o player

            player.hp = player.maxHp;

        }else if(player.xp >= 40 && act ==3){

            act = 4;
            place = 3;
            //historia
            Historia.printThirdActOutro();
            //lvl up
            player.chooseTrait();

            Historia.printFourthActIntro();

            player.hp = player.maxHp;
            //chamando a batalha final
            batalhaFinal();

        }
    }

    public static void randomEncounter(){
        // numero aleatorio
        int encounter = (int) (Math.random()* encounters.length);

        if(encounters[encounter].equals("Batalha")){
         randomBattle();
        }else if(encounters[encounter].equals("Descanso")){
            usarDescanso();
        }else{
            shop();
        }
    }

    public static void continueJourney() {
        checkAct();
        if(act != 4)
           randomEncounter();

    }

    public static void characterInfo() {
        clearConsole();
        printHeading("INFORMAÇÕES DO PERSONAGEM");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        //xp do jogador e dinheiro
        System.out.println("XP: " + player.xp + "\tDinheiro: " +player.gold);
        printSeparator(20);
        // nunemro de poçoes
        System.out.println("# de poções =" +player.poções);
        printSeparator(20);

        // printando os traços escolhidos
        if (player.numAtkUpgrades > 0) {
            System.out.println("Traço ofensivo: " + player.atkUpgrades[player.numAtkUpgrades]);
            printSeparator(20);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Traço defensivo: " + player.defUpgrades[player.numDefUpgrades]);

        }
        anythingToContinue();
    }

    //viajante aleatorio / compras
    public static void shop(){
        clearConsole();
        printHeading("Você encontrou um estranho misterioso.\n ele lhe oferece algo.");
        int price = (int) (Math.random()* (10 + player.poções*3) + 10 + player.poções);
        System.out.println("- Poção Mágica: "+ price + "de ouro.");
        printSeparator(20);
            // pergunta se ele compra uma
        System.out.println("Voce quer comprar uma?\n (1) Sim\n (2) Não");
        int input = readInt("->", 2);
        // checar se ele qr comprar
        if(input == 1){
            clearConsole();
            //checar se ele tem dinheiro
            if(player.gold >= price){
                printHeading("Você comprou uma poção magica por "+ price + "de ouro");
                player.poções++;
                player.gold -= price;
            }else
            printHeading("Você não tem dinheiro para comprar isso...");
            anythingToContinue();
        }
    }

    public static void usarDescanso(){
      clearConsole();
      if(player.descansosSobrando >= 1){
        printHeading("Você quer descansar? " + player.descansosSobrando + "  descansos sobrando.");
        System.out.println("(1) Sim\n (2) Não");
        int input = readInt("->", 2);
        if(input == 1){
            //player descansa
            clearConsole();
            if(player.hp < player.maxHp){
                int hpRestaurado = (int) (Math.random() * (player.xp/4+1)+10);
                player.hp += hpRestaurado;
                if(player.hp > player.maxHp){
                    player.hp = player.maxHp;
                    System.out.println("Voce descansou e restaurou ate " + hpRestaurado + "de vida");
                    System.out.println("Voce agora está com " + player.hp + "/" + player.maxHp + "de vida");
                    player.descansosSobrando--;
                }

            }else
            System.out.println("Voce esta com a vida cheia, não preicsa descansar!");
            anythingToContinue();
        } 
      }
    }
        

    public static void randomBattle(){
        clearConsole();
        printHeading("Você encontrou uma criatura do mal, você terá que enfrenta-lá");
        anythingToContinue();
        // criar novo inimigo novo nome
        battle(new Inimigo(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    public static void battle(Inimigo inimigo ){
        while(true){
            clearConsole();
            printHeading(inimigo.name + "\nHP: " + inimigo.hp + '/' + inimigo.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + '/' + player.maxHp);
            System.out.println("Escolha uma ação: ");
            printSeparator(20);
            System.out.println("(1) Lutar\n(2) Usar Poção\n(3) Correr");
            int input = readInt("->", 3);
            if(input == 1){

                //LUTAR CALCULAR DANO E DANO TOMADO

                int dmg = player.attack() - inimigo.defend();
                int dmgTook = inimigo.attack() - player.defend();

                //checar se o dano é negativo
                if(dmgTook < 0){
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0)
                  dmg = 0;
                  // dar o dano
                  player.hp -= dmgTook;
                  inimigo.hp -= dmg;
                  // informaçoes do combate
                  clearConsole();
                  printHeading("BATALHA");
                  System.out.println("Você deu "+ dmg + " de dano para o " + inimigo.name + ".");
                  printSeparator(15);
                  System.out.println("O" + inimigo.name + " deu " + dmgTook + " de dano a você");
                  anythingToContinue();

                  //checar se o player ta vivo
                  if(player.hp <= 0){
                    playerDied();
                    break;

                  }else if(inimigo.hp <=0){
                    clearConsole();
                    printHeading("Você derrotou o " + inimigo.name + "!");
                    //aumentar xp do player
                    player.xp += inimigo.xp;
                    System.out.println("Você ganhou "+ inimigo.xp + " XP!");
                    // drop aleatorio
                    boolean addDescanso = (Math.random()*5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random()*inimigo.xp);
                    if(addDescanso){
                        player.descansosSobrando++;
                        System.out.println("Você conseguiu a chance de um descanso adicional");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("Você coletou " + goldEarned + " de ouro do corpo de " + inimigo.name);

                    }
                    anythingToContinue();
                    break;
                  }

            }else if(input == 2){
                // usarpoçao
                clearConsole();
                if(player.poções > 0 && player.hp < player.maxHp){
                    //jogador pode usar poçao
                    // saber se o jogador qr usar a poção
                    printHeading("Você quer usar sua poção ? ("+ player.poções + "sobrando).");
                    System.out.println("(1) Sim\n(2) Não, talvez mais tarde");
                    input = readInt("->", 2);
                    if( input == 1){
                        //jogador uso pocao
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Você bebeu a poção magica e restaurou sua vida para "+ player.maxHp);
                        anythingToContinue();
                        break;
                    }
                }else{
                    //player n pode usar poçao 
                }
                

            }else{
                //correr
                clearConsole();
             if(act != 4){

            
                if(Math.random()*10+1 <= 3.5){
                    printHeading("Você correu de "+ inimigo.name + "!");
                    anythingToContinue();
                    break;
                }else{
                    printHeading("Você não conseguiu escapar");
                    int dmgTook = inimigo.attack();
                    System.out.println("Você tomou 0 "+ dmgTook + " damage!");
                    anythingToContinue();
                    if(player.hp <= 0)
                    playerDied();
                }

            }else{
            printHeading("Você nao pode escapar do Drácula");
            anythingToContinue();
        }
        }
        }
    }

    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma ação");
        printSeparator(20);
        System.out.println("(1) Continuar sua jornada");
        System.out.println("(2) Informações do Personagem");
        System.out.println("(3) Saída");
    }

    //batalha FINAL NICE
    public static void batalhaFinal(){
        Inimigo dracula = new Inimigo("O Drácula", 100);
    battle(dracula);

    if (dracula.getHp() <= 0) {
        Historia.printEnd();
        isRunning = false;
    }
}

    public static void playerDied(){
        clearConsole();
        printHeading("Você morreu...");
        printHeading("Você ganhou " + player.xp + " XP na sua jornada, tenta ganhar mais na próxima kk");
        System.out.println("Obrigado por jogar o nosso jogo, espero que tenha gostado!");
        isRunning = false;
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
            ;
        }
    }
}
