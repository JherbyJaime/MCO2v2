
/*
 * Character class that contains the logic for character creation and level up.
 */

public class CharacterCreation {

    // Initialize variable/s.
    private String name;
    final int maxName = 25;
    private String job;
    private int level;
    private int hp;
    private int dex;
    private int inte;
    private int end;
    private int str;
    private int fth;

    public void updateCharacterStats (int jobClass) {
        
        job = Jobclass.jobClasses[jobClass-1].getJobname();
        setJob(job);
        int charLevel = Jobclass.jobClasses[jobClass-1].getLevel();
        setLevel(charLevel);
        int charHp = Jobclass.jobClasses[jobClass-1].getHp();
        setHp(charHp);
        int charDex = Jobclass.jobClasses[jobClass-1].getDex();
        setDex(charDex);
        int charInte = Jobclass.jobClasses[jobClass-1].getInte();
        setInte(charInte);
        int charEnd = Jobclass.jobClasses[jobClass-1].getEnd();
        setEnd(charEnd);
        int charStr = Jobclass.jobClasses[jobClass-1].getStr();
        setStr(charStr);
        int charFth = Jobclass.jobClasses[jobClass-1].getFth();
        setFth(charFth);
    }


    /**
    * Getter for the Name of the Character.
    * @return name
    */
    public String getName(){
        return name;
    }

    /**
    * Setter for the Character Name.
    * @param charName the name value to set
    */
    public void setName(String charName) {
        this.name = charName;
    }

    /**
    * Getter for the Job of the Character.
    * @return job
    */
    public String getJob() {
        return job;
    }

    /**
    * Setter for the Character Job.
    * @param job the name value to set.
    */
    public void setJob(String job){
        this.job = job;
    }

    /**
    * Getter for the Level of the Character.
    * @return level
    */
    public int getLevel(){
        return level;
    }

    /**
    * Setter for the Character Level.
    * @param charLevel the level value to set.
    */
    public void setLevel(int charLevel){
        this.level = charLevel;
    }

    /**
    * Getter for the Health of the Character.
    * @return hp
    */
    public int getHp() {
        return hp;
    }

    /**
    * Setter for the Character Health.
    * @param hp the health value to set.
    */
    public void setHp(int hp){
        this.hp = hp;
    }

    /**
    * Getter for the Dexterity of the Character.
    * @return dex
    */
    public int getDex() {
        return dex;
    }

    /**
    * Setter for the Character Dexterity.
    * @param dex the dexterity value to set.
    */
    public void setDex(int dex){
        this.dex = dex;
    }

    /**
    * Getter for the Intelligence of the Character.
    * @return inte
    */
    public int getInte() {
        return inte;
    }

    /**
    * Setter for the Character Intelligence.
    * @param inte the Intelligence value to set.
    */
    public void setInte(int inte){
        this.inte = inte;
    }

    /**
    * Getter for the Endurance of the Character.
    * @return end
    */
    public int getEnd() {
        return end;
    }

    /**
    * Setter for the Character Endurance.
    * @param hp the Endurance value to set.
    */
    public void setEnd(int end){
        this.end = end;
    }

    /**
    * Getter for the Strength of the Character.
    * @return str
    */
    public int getStr() {
        return str;
    }

    /**
    * Setter for the Character Strength.
    * @param str the Strength value to set.
    */
    public void setStr(int str){
        this.str = str;
    }

    /**
    * Getter for the Faith of the Character.
    * @return fth
    */
    public int getFth() {
        return fth;
    }

    /**
    * Setter for the Character Faith.
    * @param fth the Faith value to set.
    */
    public void setFth(int fth){
        this.fth = fth;
    }

    
}
