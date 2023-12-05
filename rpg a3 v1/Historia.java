public class Historia {
    public static void printIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Historia");
        GameLogic.printSeparator(30);
        System.out.println(
                "Você é um dos caçadores de vampiro, que chegou em Londres para expurgar os vampiros da cidade.");
        System.out.println("Londres atualmente se encontra infestada de vampiros, e você está aqui para matá-los");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ATO I - Introdução");
        GameLogic.printSeparator(30);
        System.out.println("Você começa sua história nos arredores de Londres, no bairro de Whitechapel");
        System.out.println("Whitechapel é famosa pelos seus mistérios e clima nebuloso.");
        System.out.println("Mas para um caçador de vampiro isso não é nada.");
    }

    public static void printFirstActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ATO I - Finalização");
        GameLogic.printSeparator(30);
        System.out.println("Após os desafios enfrentados em Whitechapel você se dirige a outro lugar.");
        System.out.println("A Nightoshere.");
        System.out.println("Um lugar cheio de segredos.");
    }



    public static void printSecondActIntro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ATO 2 - Introdução");
        GameLogic.printSeparator(30);
        System.out.println("Vocês continuam sua história no Distrito de Nightosphere.");
        System.out.println("Nightosphere é tido como enfeitiçado pelos moradores.");
        System.out.println(
                "Devido a sua iluminação peculiar, onde mesmo a luz do dia, possui um céu sombrio, se assemelhando a noite.");
        System.out.println("Vocês devem continuar avançando até chegar no assustador Castelo do Drácula!");

    }

    public static void printSecondActOutro() {
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ATO 2 - Finalização ");
        GameLogic.printSeparator(30);
        System.out.println("Depois dos desafios encontrados em Nightosphere.");
        System.out.println("Um lugar mais sombrio aguarda vocês.");
        System.out.println("O castelo do Drácula, com uma atmosfera sinistra e amedontradora. ");
   

    }


public static void printThirdActIntro(){
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("ATO 3 - Introdução");
    GameLogic.printSeparator(30);
    System.out.println("O destino final é o Castelo do Drácula!");
    System.out.println("Cercado de incontáveis inimigos, o castelo guarda a fonte de todo o mal que assombra a cidade."); 
    System.out.println("A missão de vocês é eliminar os vampiros e derrotar o poderoso Drácula!");

    
}


public static void printThirdActOutro(){
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("ATO 3 - Finalização");
    GameLogic.printSeparator(30);
    System.out.println("Após passar pelo Castelo do Drácula você se encontra na sala principal.");
    System.out.println("Onde o Drácula lhe aguarda para sua batalha final.");


    
}


public static void printFourthActIntro(){
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("ATO 4 - Ato Final");
    GameLogic.printSeparator(30);
    System.out.println("Você se encontra cara a cara com o Drácula.");
    System.out.println("O destino de Londres depende do resultado dessa batalha.");


    
}

public static void printEnd(){
    GameLogic.clearConsole();
    GameLogic.printSeparator(30);
    System.out.println("Parabéns Jogador!");
    GameLogic.printSeparator(30);
    System.out.println("Você derrotou o Drácula e libertou Londres dos vampiros!");
    System.out.println("Londres agora está a salvo!");


    
}
}