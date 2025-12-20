import java.util.*;
import java.io.*;

public class AnimeCharacter implements Fighter, Comparable<AnimeCharacter> {
    private int attackPower;
    private int hp;
    private String character;
    private static final ArrayList<String> characters = new ArrayList<String>(Arrays.asList("Beerus", "Goku", "Ichigo", "Naruto", "Sasuke"));
    ;

    public AnimeCharacter() {
        attackPower = (int)(Math.random() * 100) + 1;
        hp = (int)(Math.random() * 51) + 50;
        character = this.characters.get((int)(Math.random() * 5));
    }

    public AnimeCharacter(int attackPower, int hp, String character) {
        if (!this.characters.contains(character)) {
            this.character = "Goku";
            this.attackPower = 100;
            this.hp = 100;
        } else {
            this.character = character;
            this.attackPower = attackPower;
            this.hp = hp;
        }
    }

    public void attack(AnimeCharacter other) {
        System.out.println(this.character + " attacked " + other.character + " for " + 
            (this.attackPower/10) + " damage! Their health went from " + other.hp + " to "
            + (other.hp - (this.attackPower/10)) + ".");

        other.hp -= this.attackPower/10;

        if (other.getHp() < 0) {
            System.out.println("The opponent's HP has fallen below 0, they are now dead.");
        } else if (other.getHp() == 0) {
            System.out.println("The opponent has died.");
        }
    }

    public void comboAttack(AnimeCharacter other, int times) {
        if (times == 0 ) {
            return;
        }
        if (other.getHp() < 0) {
            System.out.println("The opponent's HP has fallen below 0, they are now dead.");
            return;
        } else if (other.getHp() == 0) {
            System.out.println("The opponent has died.");
            return;
        }
        attack(other);
        comboAttack(other, times - 1);
    }

    public void recover() {
        this.hp += (int)(this.hp*0.2);

    }


    public void gameOver() {
        this.attackPower = 0;
        this.hp = 0;
        this.character = null;
        System.out.println("You died.");
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHp() {
        return hp;
    }

    public String getCharacter() {
        return character;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public void randomizeCharacter() {
        int random = (int)(Math.random() * characters.size());
        for (int i = 0; i < characters.size(); i++) {
            if (i == random) {
                this.character = characters.get(i);
                break;
            }
        }

    }

    public void saveCharacter(String file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(this.character + " has " + this.hp + " HP and " + this.attackPower + " AP.\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public int compareTo(AnimeCharacter other) {
        if (this.attackPower == other.attackPower) {
            if (this.hp == other.hp) {
                return 0;
            } else {
                return this.hp - other.hp;
            }
        }
        else {
            return this.attackPower - other.attackPower;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof AnimeCharacter) {
            AnimeCharacter other = (AnimeCharacter)o;
            boolean result = (this.attackPower == other.attackPower) && (this.hp == other.getHp())
            && (this.character.equals(other.getCharacter()));
            return result;
        }
        return false;
    }

    public String toString() {
        return this.character + " has an attack power of " + this.attackPower + " and " + this.hp + " health.";
    }
}