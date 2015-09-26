package HTTP;

import Models.MonsterAttributes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jman0_000 on 8/23/2015.
 */
public class printMonsterList {
    public static void printMonsterList(HttpServletResponse resp)
            throws JSONException, IOException {
        List<MonsterAttributes> monsterList = MonsterServer.getInstance().getMonsters();
        JSONArray monsterArray = new JSONArray();
        for (MonsterAttributes currentMonster : monsterList) {
            JSONObject monster = new JSONObject();
            monster.put("name", currentMonster.getName());
            monster.put("level", currentMonster.getLevel());
            monster.put("skill_level", currentMonster.getSkillLevel());
            monster.put("awakenings", currentMonster.getAwakenings());
            monster.put("monsterId", currentMonster.getMonsterId());
            monsterArray.put(monster);
        }
        resp.getWriter().print(monsterArray.toString());
    }
}
