# cmsc133FinalProjectOverview

My project is a PVP-Style fighting game with a hierarachal structure between the characters you can use along with their basic attacking power and health, along with special abilities you can grant from different animes, notably being Jujutsu Kaisen and One Piece. 

# Compiling and Running

In order to compile and run this program, there are multiple steps that need to be taken. A driver class must be created, where you would create the main method. In the main method, instances of the class would be created where you could call among any of the methods in the hierarchical structure, so long as you abide by the rules of Polymorphism.

# Classes and Interfaces, and their Roles

## Fighter Interface

The Fighter interface defines the behavior of the classes that are going to implement it. It has the method signatures of *recover* and *gameOver*, which all the other classes implement as methods

## Comparable<AnimeCharacter> interface

This interface helps define a way to compare and contrast different anime characters. 


## AnimeCharacter Class

This class is the superclass, the blueprint of a Character. All its subclasses serve to give special abilties and functions to it. As the superclass, it has the fields of attack power, hp (health), character (String), and an ArrayList of Strings from which characters are selected or filtered by (depending on the input in a constructor). This class will only let you chose a character that is in the ArrayList field named characters. If you don't, Goku will be selected for you. 

The compareTo method operates by comparing attack power and HP, the equals method works by seeing if attack power and HP are equal to the attack power and HP of the other instance of AnimeCharacter, and the String prints all the fields besides the arrayList of available characters.

## JujutsuKaisenAbilities Class

This class serves as a way to give special abilities to an anime character. It has instance variables representing your cursed energy (CE), your cursed technique (CT), and ur initial CE. It has constructors which use the super() keyword to invoke the superclass constructor, for both the default and custom constructors. It has getter and setters to retrieve the instance variables except for initial CE, and has an equals method which works by invoking the superclass's equals method and seeing if the CE and CT equal the CE and CT of the object being comapred. It has a toString method which calls on the superclass's toString method along with printing out both the value of their CE and their CT.

## OnePieceAbilitiesClass.

This class serves as a way to give special abilities to an anime character. It has boolean instance variables representing your ability to use haki or a devil fruit, int instance variables representing the total power left you have to use haki and your devil fruits, and int instance variables to keep track of those initial values. The constructors, both default and custom, invoke the superclass's constructor, for both the superclass's default and custmo constructor. They have getters and setters for the instance variables except for the ones used to keep track of the initial values. It has an equal method wnich invokes the superclass's equal method, as well as testing if the devil fruit status, haki status, devil fruit power, and haki power equal that of the object being compared. It also has a toString method which calls on the superclass's toString method and prints out all the instance variabls except for the ones which keep track of initial values.

## HakiClass

This class serves as a way to further detail the Haki abilities in OnePieceAbilities class. It is a subclass of said class, and  it has instance variables representing 3 types of haki. It has a default and custom constructor which uses super to call on the superclass's constructors, and sets the 3 boolean instance variables to true or false depending on whether or not they can use the haki. It has getters and setters for the instance variables, along with a toString method that calls on the superclass's toString, and prints out whether or not it can use each type of haki. It has an equals method which calls on the superclass's equals method, and tests whether or not the object being compared uses the same types of haki.

# Behavior

##  AnimeCharacter Class Behavior

This class has an attack method which removes HP from another character, and if that character's HP falls below 0, it calls the gameOver method on them. The gameOver method works by setting everything to 0 or null, depending on the data type of the field, and prinitng out that the character has died. There is a recursive method called combo attack, which continuously attacks a character until their hp falls below 0 (at which point the gameOver method willb e called for them), or the combo attack finishes. There is the randomize character method, which serves to just change the name of the character you are using and no other stats or data about them, and saveCharacter method, which appends the character's fields into a file where it is saved.


## JujutsuKaisen Class Behavior

This class has the useCT method, which depending on what CT the character has, does a set level of damage. It iterates through the ArrayList field of different techniques, and when it finds the one which matches your technique, depending on how many times it iterated, it will do a less and less amount of damage, but also take less and less CE to attack (because the ArrayList is ordered from strongest techniques to weakest). The recover method sets CE back to your initial CE, and gameOver sets everything to either 0 or null.

## OnePieceAbilities Class Behavior

This class has the useAbilities method, where depending on whether you have haki or a devil fruit, or even both, it will do more and more damage (going in order of least to most from devil fruit, to haki, to both) but also take more and more energy. If you don't have the required energy, you won't be able to do the attack. The recover method recovers the energy needed for Haki and Devil Fruit usage, and also sets your status of having both of them to true. The gameOver method sets everything to false or 0 and calls super.gameOver().

## Haki Class Behavior

This class has the useHaki method, where depending on the types of haki you have, you will do more and more damage, going in order from having no types of haki, having either armament/observation and no conqueror's, having conqueror's but no armament/obsevation, and having all 3 types. The recover method lets you have all types of haki, and gameOver sets everything to false and calls super.gameover()


# Challenges

Most of the challenges I faced stemmed from the fact of trying to coherently connect a logical and functional way of an inheritance project, where none of the classes overlap or are redunant/useless. It took a lot of brainstorming to do that part

# Debugging 

First, when doing the recusrive method for a combo attack, I kept printing more statementsof a character dying. I fixed that by taking it out of that part and leaving it only in gameOver(). Second, when writing the useCT method in my JJK abilities class, I accidentally had the energy usage the wrong way around, where the more powerful the attack was, the more energy it took. I fixed that by setting it initially to 49 and doing -= 7 every time it iterated through the arrayList

# Proposal 

For my final project, I intend to do a PVP-style program where people can choose
different fictional characters (from animes, tv shows, mangas, novels, and games). Each different fictional character will be a separate individual class, and they will be subclasses of a superclass that has commonalities between every character. For my interface, I will make it where it is a shared ability function every single character will do, such as surrendering. I will use File I/O to save character data, and arrays and ArrayLists to select characters from.


