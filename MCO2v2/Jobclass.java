


/*
 * Jobclass class that is a subclass of the Character class.
 */
public class Jobclass extends CharacterCreation{

    // Initialize variable/s.
    private String jobName;
    private int level;
    private int hp;
    private int dex;
    private int inte;
    private int end;
    private int str;
    private int fth;

    // Array of objects containing different types of jobclasses each having their own set of statistics.
    public static Jobclass[] jobClasses = {
        new Jobclass("Vagabond", 9, 15, 13, 9, 11, 14, 8),
        new Jobclass("Samurai", 9, 15, 13, 9, 11, 14, 8),
        new Jobclass("Warrior", 9, 15, 13, 9, 11, 14, 8),
        new Jobclass("Hero", 9, 15, 13, 9, 11, 14, 8),
        new Jobclass("Astrologer", 9, 15, 13, 9, 11, 14, 8),
        new Jobclass("Prophet", 9, 15, 13, 9, 11, 14, 8)
    };


    // Constructor for Jobclass class
    public Jobclass(String jobName, int level, int hp, int dex, int inte, int end, int str, int fth) {
        this.jobName = jobName;
        this.level = level;
        this.hp = hp;
        this.dex = dex;
        this.inte = inte;
        this.end = end;
        this.str = str;
        this.fth = fth;
    }

    /**
    * Getter for the Job Name of the Character.
    * @return jobName
    */
    public String getJobname() {
        return jobName;
    }

    /**
    * Getter for the Level of the Character.
    * @return level
    */
    public int getLevel() {
        return level;
    }

    /**
    * Getter for the Health of the Character.
    * @return hp
    */
    public int getHp() {
    return hp;
    }

    /**
    * Getter for the Dexterity of the Character.
    * @return dex
    */
    public int getDex() {
        return dex;
    }

    /**
    * Getter for the Intelligence of the Character.
    * @return inte
    */
    public int getInte() {
        return inte;
    }

    /**
    * Getter for the Endurance of the Character.
    * @return end
    */
    public int getEnd() {
        return end;
    }

    /**
    * Getter for the Strength of the Character.
    * @return str
    */
    public int getStr() {
        return str;
    }

    /**
    * Getter for the Faith of the Character.
    * @return fth
    */
    public int getFth() {
        return fth;
    }

}

