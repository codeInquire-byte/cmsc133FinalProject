public class OnePieceAbilities extends AnimeCharacter {
    private boolean DevilFruits;
    private boolean Haki;
    private int DevilFruitPower;
    private int HakiPower;
    private int initialFruitPower;
    private int initialHaki;
    

    public OnePieceAbilities() {
        super();
        DevilFruits = false;
        Haki = true;
        DevilFruitPower = 0;
        HakiPower = 75;
        initialFruitPower = DevilFruitPower;
        initialHaki = HakiPower;
    }

    public OnePieceAbilities(int attackPower, int hp, String character, boolean DevilFruits, boolean Haki, int DevilFruitPower, int HakiPower) {
        super(attackPower, hp, character);
        this.DevilFruits = DevilFruits;
        this.Haki = Haki;
        this.DevilFruitPower = DevilFruitPower;
        this.HakiPower = HakiPower;
        this.initialFruitPower = DevilFruitPower;
        this.initialHaki = HakiPower;

    }

    public void useAbilities(AnimeCharacter other) {
        if (!DevilFruits && !Haki) {
            System.out.println("Has no abilities.");
        } else if (DevilFruits && !Haki) {
            if (DevilFruitPower < 15) {
                System.out.println("You've got nothing left in the tank to use your devil fruit.");
            }
            else {
                int potency = (int) (Math.random() * 16) + 10;
                System.out.println(this.getCharacter() + " just used their devil fruit against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                DevilFruitPower -= 15;
                other.setHp(other.getHp() - potency);
                if (other.getHp() <= 0) {
                other.gameOver();
                }
            }
        } else if (!DevilFruits && Haki) {
            if (HakiPower < 25) {
                System.out.println("You've got nothing left in the tank to use your haki.");
            }
            else {
                int potency = (int) (Math.random() * 26) + 15;
                System.out.println(this.getCharacter() + " just used their haki against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                HakiPower -= 25;
                other.setHp(other.getHp() - potency);
                if (other.getHp() <= 0) {
                other.gameOver();
                }
            }
        } else {
            if (DevilFruitPower < 15 || HakiPower < 25) {
                System.out.println("You tried to pull off a combo attack and failed. Shouldn't have been greedy and said yes to having both devil fruits and haki!");
            }
            else {
                int potency = (int) (Math.random() * 16) + 40;
                System.out.println(this.getCharacter() + " just used their haki and devil fruit against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                DevilFruitPower -= 15;
                HakiPower -= 25;
                other.setHp(other.getHp() - potency);
                if (other.getHp() <= 0) {
                other.gameOver();
                }
            }
        }
    }
    
    public void recover() {
        Haki = true;
        DevilFruits = true;
        this.DevilFruitPower = initialFruitPower;
        this.HakiPower = initialHaki;
    }

    public void gameOver() {
        DevilFruits = false;
        Haki = false;
        this.DevilFruitPower = 0;
        this.HakiPower = 0;
        System.out.println("You've lost your potential for both devil fruits and haki.");
        super.gameOver();
    }

    public boolean getDevilFruit() {
        return DevilFruits;
    }

    public boolean getHaki() {
        return Haki;
    }

    public int getDevilFruitPower() {
        return DevilFruitPower;
    }

    public int getHakiPower() {
        return HakiPower;
    }

    public void setDevilFruit(boolean DevilFruits) {
        this.DevilFruits = DevilFruits;
    }

    public void setHaki(boolean Haki) {
        this.Haki = Haki;
    }

    public void setDevilFruitPower(int DevilFruitPower) {
        this.DevilFruitPower = DevilFruitPower;
    }

    public void setHakiPower(int HakiPower) {
        this.HakiPower = HakiPower;
    }
    

    public String toString() {
        return super.toString() + " It is " + this.getHaki() + " that they have haki and " + this.getDevilFruit() + 
        " that they have a devil fruit. They have a haki power of " + this.HakiPower + " and a devil fruit power of " + this.DevilFruitPower + ".";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof OnePieceAbilities) {
            OnePieceAbilities other = (OnePieceAbilities)o;
            boolean result = super.equals(other) && this.DevilFruits == other.DevilFruits
            && this.Haki == other.Haki && this.DevilFruitPower == other.DevilFruitPower
            && this.HakiPower == other.HakiPower;
            return result;
        }

        return false;
    }

}
