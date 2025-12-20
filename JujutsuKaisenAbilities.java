import java.util.*;

public class JujutsuKaisenAbilities extends AnimeCharacter {
    private int cursedEnergy;
    private int initialEnergy;
    private String cursedTechnique;
    private ArrayList<String> techniques = new ArrayList<String>(Arrays.asList("Limitless with Six Eyes", "Ten Shadows", "Idle Transfiguration", "Star Rage", "Copy", "Cursed Spirit Manipulation", "Cleave")
    );

    public JujutsuKaisenAbilities() {
        super();
        this.cursedEnergy = 80;
        this.initialEnergy = this.cursedEnergy;
        this.cursedTechnique = techniques.get((int) (Math.random() * techniques.size()));
    }

    public JujutsuKaisenAbilities(int attackPower, int hp, String character,
        int cursedEnergy, String cursedTechnique) {

        super(attackPower, hp, character);
        this.cursedEnergy = cursedEnergy;
        this.initialEnergy = this.cursedEnergy;
        this.cursedTechnique = cursedTechnique;
    }

    public void useCursedTechnique(AnimeCharacter other) {
        int potency = 49;
        int totalEnergyRequired = 49;
        // Techniques in ArrayList "techniques" already ordered in level of power from strongeset to weakest
        for (int i = 0; i < techniques.size(); i++) {
            if (techniques.get(i).equals(this.getCursedTechnique())) {
                break;
            } else {
                potency -= 7;
                totalEnergyRequired -= 7;
            }
        }

        if (this.cursedEnergy < totalEnergyRequired) {
            System.out.println(this.getCharacter() + " does not have enough cursed energy to use " + this.getCursedTechnique());
            return;
        }

        System.out.println(this.getCharacter() + " just used " + this.getCursedTechnique() + " against " + other.getCharacter() +
            ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
        
        other.setHp(other.getHp() - potency);
        this.cursedEnergy -= totalEnergyRequired;
        if (other.getHp() <= 0) {
            other.gameOver();
        }

    }

    public void recover() {
        super.recover();
        this.cursedEnergy = this.initialEnergy;
    }

    public void gameOver() {
        this.cursedEnergy = 0;
        this.cursedTechnique = null;
        super.gameOver();
    }

    public int getCursedEnergy() {
        return this.cursedEnergy;
    }
    
    public String getCursedTechnique() {
        return this.cursedTechnique;
    }

    public void setCursedEnergy(int cursedEnergy) {
        this.cursedEnergy = cursedEnergy;
    }    

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof JujutsuKaisenAbilities) {
            JujutsuKaisenAbilities other = (JujutsuKaisenAbilities)o;
            boolean result = super.equals(other) && this.cursedEnergy == other.getCursedEnergy()
            && this.cursedTechnique.equals(other.getCursedTechnique());
            return result;
        }

        return false;
    }
    

    public String toString() {
        return super.toString() + " They have a cursed energy value of " + 
        this.getCursedEnergy() + ", and uses " + this.getCursedTechnique();

    }



}
