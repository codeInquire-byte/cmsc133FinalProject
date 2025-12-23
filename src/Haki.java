public class Haki extends OnePieceAbilities {
    private boolean armamentHaki;
    private boolean observationHaki;
    private boolean conquerorsHaki;

    public Haki() {
        super();
        armamentHaki = true;
        observationHaki = true;
        conquerorsHaki = false;
    }

    public Haki(boolean DevilFruits, boolean Haki, int DevilFruitPower, int HakiPower,
        boolean armamentHaki, boolean observationHaki, boolean conquerorsHaki) {
            super(30, 80, "Goku", DevilFruits, Haki, DevilFruitPower, HakiPower);
            this.armamentHaki = armamentHaki;
            this.observationHaki = observationHaki;
            this.conquerorsHaki = conquerorsHaki;
    }

    public void useHaki(AnimeCharacter other) {
        int potency;
        if (!(armamentHaki || observationHaki || conquerorsHaki)) {
            System.out.println("Has no haki types.");
        } 
        else if ((armamentHaki || observationHaki) && !conquerorsHaki) {
            if (super.getHakiPower() < 10) {
                System.out.println("Not enough in the tank");
            }
            else {
                potency = (int)(Math.random() * 11) + 10;
                System.out.println(this.getCharacter() + " just used the basic types of haki against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                other.setHp(other.getHp() - potency);
                super.setHakiPower(super.getHakiPower() - 10);
                if (other.getHp() <= 0) {
                    other.gameOver();
                }
            }
        }
        else if ((!(armamentHaki && observationHaki)) && conquerorsHaki) {
            if (super.getHakiPower() < 20) {
                System.out.println("Not enough in the tank.");
            }
            else {
                potency = (int)(Math.random() * 21) + 15;
                System.out.println(this.getCharacter() + " just used their conqueror's haki against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                other.setHp(other.getHp() - potency);
                super.setHakiPower(super.getHakiPower() - 20);
                if (other.getHp() <= 0) {
                    other.gameOver();
                }
            }
        }
        else if (armamentHaki && observationHaki && conquerorsHaki) {
            if (super.getHakiPower() < 40) {
                System.out.println("Not enough left in the tank.");
            }
            else {
                potency = (int)(Math.random() * 11) + 30;
                System.out.println(this.getCharacter() + " just used every type of haki against " + other.getCharacter() +
                ". It did " + potency + " damage and their health just went from " + other.getHp() + " to " + (other.getHp() - potency));
                other.setHp(other.getHp() - potency);
                super.setHakiPower(super.getHakiPower() - 35);
                if (other.getHp() <= 0) {
                    other.gameOver();
                }
            }
        }
    }

    public void recover() {
        armamentHaki = true;
        observationHaki = true;
        conquerorsHaki = true;
        super.setHakiPower(super.getHakiPower());
    }

    public void gameOver() {
        armamentHaki = false;
        observationHaki = false;
        conquerorsHaki = false;
        System.out.println("You've lost the potential for all types of haki. ");
        super.gameOver();
        
    }

    public boolean getArmamentHaki() {
        return armamentHaki;
    }

    public boolean getObservationHaki() {
        return observationHaki;
    }

    public boolean getConquerorsHaki() {
        return conquerorsHaki;
    }

    public String toString() {
        return super.toString() + " It is " + this.armamentHaki + " that they have armament haki, " +
        this.observationHaki + " that they have observation haki, and " + this.conquerorsHaki + " that they have conqueror's haki.";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Haki) {
            Haki other = (Haki)o;
            boolean result = super.equals(other) && this.armamentHaki == other.armamentHaki &&
            this.observationHaki == other.observationHaki && this.conquerorsHaki == other.conquerorsHaki;
            return result;
        }

        return false;
    }

}
