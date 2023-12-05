public class Inimigo extends Personagem{

    // variavel para armazenar o xp dos players
    int playerXp;

    public Inimigo(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*(playerXp/4+2)+ 1));
      // dando a variavel
      this.playerXp = playerXp;
    }

    public int attack() {
        return (int) (Math.random()+(playerXp/4 + 1)* xp/4 + 3);
    }

    public int defend() {
        return (int) (Math.random()+(playerXp/7 + 1)* xp/4 + 3);
    }

    public int getHp() {
        return hp;
    }
    
}
