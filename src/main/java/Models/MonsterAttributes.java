package Models;

/**
 * Created by alexanderchiou on 8/21/15.
 */
public class MonsterAttributes
{
    private String name;
    private int level;
    private int skillLevel;
    private int awakenings;
    private int monsterId;

    // For hard-coded hashmap
    public MonsterAttributes(String name, int level, int skillLevel, int awakenings, int monsterId)
    {
        this.name = name;
        this.level = level;
        this.skillLevel = skillLevel;
        this.awakenings = awakenings;
        this.monsterId = monsterId;
    }

    // Getters
    public String getName()
    {
        return name;
    }

    public int getLevel()
    {
        return level;
    }

    public int getSkillLevel()
    {
        return skillLevel;
    }

    public int getAwakenings()
    {
        return awakenings;
    }

    public int getMonsterId() { return monsterId; }

    public String getImageUrl()
    {
        return "http://puzzledragonx.com/en/img/book/" + String.valueOf(monsterId) + ".png";
    }
}
