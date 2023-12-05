public class Player extends Personagem{
    // int pra amazenar o numero de upgrades/habilidades em cada caminho
    public int numAtkUpgrades, numDefUpgrades;
    //status adicional player
    int gold, descansosSobrando, poções;
    //arrays para armazanear nome de habilidades

    public String[] atkUpgrades = {"Forte", "Poderoso", "Incrível", "Força Divina"};
    public String[] defUpgrades = {"Ossos pesados", "Pele de pedra", "Armadura de escamas", "Aura Divina"};
    //Construtor especifico do player
    public Player(String name) {
        //chamando construtor de superclass
        super(name, 100, 0);
        //configurando # de upgrade para 0

        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //setando status adicional
        this.gold = 5;
        this.descansosSobrando = 1;
        this.poções = 0;

       //deixar o player escolher os traits quando criar um novo personagem
       chooseTrait();
        
    }

    public int attack() {
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades +1);

    }

    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Escolha um traço:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);
        //pegar a escolha do player
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        // lidar com os dois casos
        if(input == 1){
            GameLogic.printHeading("Você escolheu "+ atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("Você escolheu "+ defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}