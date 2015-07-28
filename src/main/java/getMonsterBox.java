import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class getMonsterBox {
    public static void getMonsterBox(Connection connection, HttpServletResponse resp, String id) throws JSONException, IOException {
        try {
            String get_Box_SQL = "Select * from monster where pad_ID = ? ";
            PreparedStatement stmt = connection.prepareStatement(get_Box_SQL);
            stmt.setString(1, id);
            ResultSet rs =  stmt.executeQuery();
            JSONArray monster_array = new JSONArray();
            while (rs.next()) {
                JSONObject monster = new JSONObject();
                monster.put("name", rs.getString("name"));
                monster.put("level", rs.getInt("level"));
                monster.put("skill_level", rs.getInt("skill_level"));
                monster.put("awakenings", rs.getInt("awakenings"));
                monster.put("plus_eggs", rs.getInt("plus_eggs"));
                monster_array.put(monster);
            }
            stmt.close();
            resp.getWriter().print(monster_array.toString());
        }
        catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print("getMonsterBox error: " + Main.getStackTrace(e));
        }
    }
}

