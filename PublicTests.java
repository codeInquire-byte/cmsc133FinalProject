import static org.junit.Assert.*;
import org.junit.Test;

public class PublicTests {

    @Test
    public void testAttackAndGetHP() {
        AnimeCharacter Goku = new AnimeCharacter(100, 100, "Goku"); 
        AnimeCharacter Ichigo = new AnimeCharacter(80, 50, "Ichigo"); 
        
        Goku.comboAttack(Ichigo, 4);
        assertEquals(10, Ichigo.getHp());
    }

    @Test
    public void testRecover() {
        AnimeCharacter Beerus = new AnimeCharacter(100, 100, "Beerus");
        Beerus.recover();

        assertEquals(120, Beerus.getHp());
    }



    @Test
    public void testGameOver() {
        AnimeCharacter Goku2 = new AnimeCharacter(100, 100, "Goku");
        Goku2.gameOver();
        assertEquals(0, Goku2.getHp());
        assertEquals(0, Goku2.getAttackPower());
        assertNull(Goku2.getCharacter());
        
    }

    @Test
    public void testRandomizeCharacter() {
        AnimeCharacter test = new AnimeCharacter();
        String f = test.getCharacter();
        test.randomizeCharacter();

        assertTrue(!test.getCharacter().equals(f) && test != null);
    }


    @Test
    public void testCompare() {
        AnimeCharacter Naruto = new AnimeCharacter(70, 70, "Naruto");
        AnimeCharacter Sasuke = new AnimeCharacter(70, 70, "Sasuke");

        assertTrue(Sasuke.compareTo(Naruto) == 0);
    }

    @Test
    public void testEqualsOne() {
        AnimeCharacter Tester1 = new AnimeCharacter();
        AnimeCharacter Tester2 = new AnimeCharacter();

        assertEquals(Tester1, Tester2);
    }

    @Test
    public void testUnequal() {
        AnimeCharacter Tester14 = new AnimeCharacter();
        AnimeCharacter Chicken = new AnimeCharacter(70, 70, "Sasuke");

        assertNotEquals(Tester14, Chicken);


    }

    @Test
    public void testToString() {
        AnimeCharacter Goku3 = new AnimeCharacter(100, 100, "Goku");
        String f = Goku3.toString();
        String g = "Goku has an attack power of 100 and 100 health.";

        assertEquals(f, g);

    }

    @Test
    public void testOPAbilitiesAndHakiConstructorAndEquals() {
        Haki tester1 = new Haki();
        Haki tester2 = new Haki(false, true, 0, 100, true, true, true);

        assertTrue(tester1.getHaki());
        assertTrue(tester1.getArmamentHaki());
        assertTrue(tester1.getObservationHaki());
        assertFalse(tester1.getConquerorsHaki());

        assertFalse(tester2.getDevilFruit());
        assertTrue(tester2.getHaki());
        assertEquals(0, tester2.getDevilFruitPower());
        assertEquals(100, tester2.getHakiPower());
        assertTrue(tester2.getArmamentHaki());
        assertTrue(tester2.getObservationHaki());
        assertTrue(tester2.getConquerorsHaki());

        assertTrue(tester1.equals(tester1));
        assertTrue(tester2.equals(tester2)); 
        assertFalse(tester1.equals(tester2));


    }

    @Test
    public void testJJKConstructorandGetters() {
        JujutsuKaisenAbilities Beerus = new JujutsuKaisenAbilities(100, 100, "Beerus", 100, "Limitless with Six Eyes");
        assertEquals(100, Beerus.getAttackPower());
        assertEquals(100, Beerus.getHp());
        assertEquals("Beerus", Beerus.getCharacter());
        assertEquals(100, Beerus.getCursedEnergy());
        assertEquals("Limitless with Six Eyes", Beerus.getCursedTechnique());
    }

    @Test
    public void testJJKRecoverandUseAbilities() {
        JujutsuKaisenAbilities Beerus = new JujutsuKaisenAbilities(100, 100, "Beerus", 100, "Limitless with Six Eyes");
        JujutsuKaisenAbilities test = new JujutsuKaisenAbilities();
        Beerus.useCursedTechnique(test);

        Beerus.recover();

        assertEquals(100, Beerus.getCursedEnergy());

    }

}