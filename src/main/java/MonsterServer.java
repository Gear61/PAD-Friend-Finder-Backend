/**
 * Created by alexanderchiou on 7/13/15.
 */

import Models.MonsterAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 11/1/2014.
 */
public class MonsterServer
{
    private static MonsterServer instance = null;
    private static List<MonsterAttributes> monsters = new ArrayList<>();

    private MonsterServer()
    {
        setUpServer();
    }

    public static MonsterServer getInstance()
    {
        if (instance == null)
        {
            instance = new MonsterServer();
        }
        return instance;
    }

    private static void setUpServer()
    {
        // FRIEND FINDER CREATURES
        monsters.add(new MonsterAttributes("Ancient Dragon Knight, Zeal", 9, 5, 3, 824));
        monsters.add(new MonsterAttributes("World Tree Sprite, Alraune", 99, 11, 3, 1101));
        monsters.add(new MonsterAttributes("Dancing Light, Amaterasu Ohkami", 99, 11, 4, 988));
        monsters.add(new MonsterAttributes("Deathly Hell Deity Jackal, Anubis", 99, 11, 4, 1001));
        monsters.add(new MonsterAttributes("Heavenly Herald, Archangel", 99, 6, 3, 1103));
        monsters.add(new MonsterAttributes("Guardian of the Sacred City, Athena", 99, 9, 6, 1422));
        monsters.add(new MonsterAttributes("Moonlit Feline Goddess, Bastet", 99, 8, 4, 1613));
        monsters.add(new MonsterAttributes("Feline Deity of Harmony, Bastet", 99, 8, 4, 888));
        monsters.add(new MonsterAttributes("BAO Batman+Batarang", 50, 4, 0, 677));
        monsters.add(new MonsterAttributes("BAO Batman+BW Stealth", 99, 4, 7, 1476));
        monsters.add(new MonsterAttributes("Crazed King of Purgatory, Beelzebub", 99, 5, 8, 1371));
        monsters.add(new MonsterAttributes("Endless Blue Dragon Caller, Sonia", 99, 6, 6, 1089));
        monsters.add(new MonsterAttributes("Keeper of Paradise, Metatron", 99, 6, 6, 1518));
        monsters.add(new MonsterAttributes("Awoken Ceres", 99, 3, 8, 1535));
        monsters.add(new MonsterAttributes("Destroying Goddess of Power, Kali", 99, 6, 6, 1588));
        monsters.add(new MonsterAttributes("Arbiter of Judgement, Metatron", 99, 4, 7, 1644));
        monsters.add(new MonsterAttributes("Divine Flowers, Da Qiao & Xiao Qiao", 99, 6, 4, 1238));
        monsters.add(new MonsterAttributes("Demon Slaying Goddess, Durga", 99, 6, 4, 1339));
        monsters.add(new MonsterAttributes("Hell-Creating Archdemon, Lucifer", 99, 16, 4, 1553));
        monsters.add(new MonsterAttributes("Goemon, the Thief", 99, 15, 3, 566));
        monsters.add(new MonsterAttributes("Shining Lance Wielder, Odin", 99, 6, 8, 1423));
        monsters.add(new MonsterAttributes("Eternal Jade Dragon Caller, Sonia", 99, 6, 6, 914));
        monsters.add(new MonsterAttributes("Genius Sleeping Dragon, Zhuge Liang", 99, 5, 5, 1373));
        monsters.add(new MonsterAttributes("Banishing Claw Byakko, Haku", 99, 6, 7, 1269));
        monsters.add(new MonsterAttributes("Sacred Life Goddess, Hathor", 99, 6, 4, 1666));
        monsters.add(new MonsterAttributes("Blazing Deity Falcon, Horus", 99, 11, 4, 995));
        monsters.add(new MonsterAttributes("Eternal Twin Stars, Idunn&Idunna", 99, 9, 4, 1345));
        monsters.add(new MonsterAttributes("Shining Sea Deity, Isis", 99, 6, 4, 997));
        monsters.add(new MonsterAttributes("Kirin of the Sacred Gleam, Sakuya", 99, 6, 7, 1218));
        monsters.add(new MonsterAttributes("Divine Brave General, Krishna", 99, 6, 4, 1331));
        monsters.add(new MonsterAttributes("Devoted Miko Goddess, Kushinadahime", 99, 4, 7, 1298));
        monsters.add(new MonsterAttributes("Shining Goddess of Secrets, Kali", 99, 6, 5, 1586));
        monsters.add(new MonsterAttributes("Keeper of the Sacred Texts, Metatron", 99, 6, 6, 1217));
        monsters.add(new MonsterAttributes("Divine Flying General, Lu Bu", 99, 6, 4, 1240));
        monsters.add(new MonsterAttributes("Divine Law Goddess, Valkyrie Rose", 99, 7, 5, 1727));
        monsters.add(new MonsterAttributes("Celestial Life Dragon, Zhuge Liang", 99, 6, 6, 1375));
        monsters.add(new MonsterAttributes("Sea God's Songstress, Siren", 99, 7, 3, 1100));
        monsters.add(new MonsterAttributes("Awoken Minerva", 99, 3, 8, 1533));
        monsters.add(new MonsterAttributes("Goddess of the Dead, Nephthys", 99, 6, 4, 1668));
        monsters.add(new MonsterAttributes("Awoken Neptune", 99, 3, 8, 1534));
        monsters.add(new MonsterAttributes("Roaming National Founder, Okuninushi", 99, 4, 4, 1300));
        monsters.add(new MonsterAttributes("God of Dark Riches, Osiris", 99, 6, 4, 1664));
        monsters.add(new MonsterAttributes("Goddess of the Bleak Night, Pandora", 99, 6, 4, 1074));
        monsters.add(new MonsterAttributes("Pure Light Sun Deity, Ra", 99, 8, 4, 999));
        monsters.add(new MonsterAttributes("BAO Robin", 99, 4, 0, 673));
        monsters.add(new MonsterAttributes("Awoken Phantom God, Odin", 99, 6, 6, 1108));
        monsters.add(new MonsterAttributes("Marvelous Red Dragon Caller, Sonia", 99, 6, 6, 1645));
        monsters.add(new MonsterAttributes("Holy Night Kirin Princess, Sakuya", 99, 6, 7, 1783));
        monsters.add(new MonsterAttributes("King of Hell, Satan", 99, 16, 3, 1646));
        monsters.add(new MonsterAttributes("Demolishing Creator, Shiva", 99, 6, 4, 1113));
        monsters.add(new MonsterAttributes("Rebel Seraph Lucifer", 99, 16, 4, 1216));
        monsters.add(new MonsterAttributes("Sylph", 35, 6, 0, 356));
        monsters.add(new MonsterAttributes("Divine Wardens, Umisachi&Yamasachi", 99, 4, 7, 1297));
        monsters.add(new MonsterAttributes("Awoken Zeus Olympios", 99, 16, 3, 917));
        monsters.add(new MonsterAttributes("BAO Robin+E. Stick", 99, 4, 3, 674));
        monsters.add(new MonsterAttributes("Dark Sun Deity, Ra", 99, 8, 4, 998));
        monsters.add(new MonsterAttributes("Gleaming Kouryu Emperor, Fagan", 99, 6, 8, 1342));
        monsters.add(new MonsterAttributes("Dark Kouryu Emperor, Fagan", 99, 6, 8, 1343));
        monsters.add(new MonsterAttributes("Seraph of Dawn Lucifer", 99, 16, 4, 629));
        monsters.add(new MonsterAttributes("Dark Liege, Vampire Duke", 99, 7, 3, 894));
        monsters.add(new MonsterAttributes("Jester Dragon, Drawn Joker", 99, 7, 3, 761));
        monsters.add(new MonsterAttributes("Asuka&Eva Unit-02", 50, 11, 0, 695));
        monsters.add(new MonsterAttributes("Awoken Dancing Queen Hera-Ur", 99, 5, 6, 1536));
        monsters.add(new MonsterAttributes("Awoken Hinokagutsuchi", 99, 5, 8, 1726));
        monsters.add(new MonsterAttributes("Crimson Lotus Mistress, Echidna", 99, 6, 3, 1099));
        monsters.add(new MonsterAttributes("Unyielding Samurai Dragon King, Zaerog", 99, 5, 4, 1712));
        monsters.add(new MonsterAttributes("TAMADRApurin", 99, 5, 4, 1163));
        monsters.add(new MonsterAttributes("Norn of the Past, Urd", 99, 6, 5, 1670));
        monsters.add(new MonsterAttributes("Norn of the Present, Verdandi", 99, 6, 5, 1672));
        monsters.add(new MonsterAttributes("Norn of the Future, Skuld", 99, 6, 6, 1674));
        monsters.add(new MonsterAttributes("Gods of Hunt, Umisachi&Yamasachi", 99, 4, 4, 802));
        monsters.add(new MonsterAttributes("Awoken Odin", 99, 6, 5, 363));
        monsters.add(new MonsterAttributes("Nocturne Chanter, Tsukuyomi", 99, 6, 4, 990));
        monsters.add(new MonsterAttributes("Hand of the Dark God, Metatron", 99, 6, 6, 643));
        monsters.add(new MonsterAttributes("Warrior Rose, Graceful Valkyrie", 99, 7, 3, 694));
        monsters.add(new MonsterAttributes("Scholarly God, Ganesha", 99, 6, 4, 1337));
        monsters.add(new MonsterAttributes("Goddess of Rice Fields, Kushinada", 99, 4, 4, 804));
        monsters.add(new MonsterAttributes("Voice of God, Metatron", 99, 6, 5, 641));
        monsters.add(new MonsterAttributes("Extant Red Dragon Caller, Sonia", 99, 6, 5, 912));
        monsters.add(new MonsterAttributes("Kirin of the Aurora, Sakuya", 99, 6, 4, 752));
        monsters.add(new MonsterAttributes("Noble Wolf King Hero, Cu Chulainn", 99, 7, 3, 693));
        monsters.add(new MonsterAttributes("Earth-Rending Emperor, Siegfried", 99, 7, 3, 692));
        monsters.add(new MonsterAttributes("Abyssal Hell Deity Jackal, Anubis", 99, 11, 4, 1000));
        monsters.add(new MonsterAttributes("Sparkling Goddess of Secrets, Kali", 99, 6, 6, 1747));
        monsters.add(new MonsterAttributes("Awoken Horus", 99, 5, 8, 2009));
        monsters.add(new MonsterAttributes("Awoken Ra", 99, 5, 8, 2012));
        monsters.add(new MonsterAttributes("Awoken Bastet", 99, 5, 8, 2011));
        monsters.add(new MonsterAttributes("Awoken Shiva", 99, 5, 8, 1954));
        monsters.add(new MonsterAttributes("Magic Hand Slayer Goddess, Durga", 99, 6, 4, 2083));
        monsters.add(new MonsterAttributes("Avowed Thief, Ishikawa Goemon", 99, 6, 4, 2006));
        monsters.add(new MonsterAttributes("Wailing Bleak Night Goddess, Pandora", 99, 6, 7, 1736));
        monsters.add(new MonsterAttributes("Chaotic Flying General, Lu Bu", 99, 5, 7, 1746));
        monsters.add(new MonsterAttributes("Awoken Meimei", 99, 5, 8, 2075));
        monsters.add(new MonsterAttributes("Lightning Red Dragonbound, Gadius", 99, 6, 5, 1947));
        monsters.add(new MonsterAttributes("Dawning Dragon Caller, Sonia Gran", 99, 11, 9, 1760));
        monsters.add(new MonsterAttributes("Blue Chain Starsea Goddess, Andromeda", 99, 6, 7, 1733));
        monsters.add(new MonsterAttributes("Sacred Divine Flower, Xiao Qiao", 99, 6, 4, 1745));
        monsters.add(new MonsterAttributes("Awoken Venus", 99, 5, 8, 1928));
        monsters.add(new MonsterAttributes("Awoken Hades", 99, 5, 8, 1748));
        monsters.add(new MonsterAttributes("Awoken Lakshmi", 99, 5, 8, 1955));
        monsters.add(new MonsterAttributes("Awoken Parvati", 99, 5, 8, 1956));
        monsters.add(new MonsterAttributes("Sacred Dragon Princess, Da Qiao", 99, 6, 7, 1744));
        monsters.add(new MonsterAttributes("Scholarship Student, Isis", 99, 6, 5, 2017));
        monsters.add(new MonsterAttributes("Discipline Committee Chair, Athena", 99, 9, 6, 2015));
        monsters.add(new MonsterAttributes("Stormy God-Emperor, Yamato Takeru", 99, 6, 7, 1732));
        monsters.add(new MonsterAttributes("Revered Monkey King, Sun Wukong", 99, 6, 7, 1735));
        monsters.add(new MonsterAttributes("Green Star Vanquishing Deity, Perseus", 99, 6, 7, 1734));
        monsters.add(new MonsterAttributes("Dominating Warrior King, Cao Cao", 99, 6, 7, 1738));
        monsters.add(new MonsterAttributes("Unifying Martial Deity, Cao Cao", 99, 6, 4, 1739));
        monsters.add(new MonsterAttributes("Divine General of the Sun, Krishna", 99, 10, 4, 2079));
        monsters.add(new MonsterAttributes("Wise and Moral Goddess, Sarasvati", 99, 10, 4, 2080));
        monsters.add(new MonsterAttributes("Awoken Isis", 99, 5, 8, 2010));
        monsters.add(new MonsterAttributes("Awoken Anubis", 99, 5, 8, 2013));
        monsters.add(new MonsterAttributes("Enraged Black Phantom Demon, Zuoh", 99, 6, 5, 1953));
    }

    public List<MonsterAttributes> getMonsters()
    {
        return monsters;
    }
}

