import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateMonster {
    public static void updateMonster(Connection connection, HttpServletResponse resp, JSONObject info) throws JSONException, IOException {
        String id = info.getString("pad_ID");
        JSONObject monster = info.getJSONObject("monster");
        String name = monster.getString("name");
        int level = monster.getInt("level");
        int skill_level = monster.getInt("skill_level");
        int awakenings = monster.getInt("awakenings");
        int plus_eggs = monster.getInt("plus_eggs");
        String update_sql;
        try {
            update_sql = "INSERT INTO monster (pad_ID, name, level, skill_level, awakenings, plus_eggs) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(update_sql);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.setInt(3, level);
            stmt.setInt(4, skill_level);
            stmt.setInt(5, awakenings);
            stmt.setInt(6, plus_eggs);
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e) {
            try {
                update_sql = "UPDATE monster set level = ?, skill_level = ?, awakenings = ?, plus_eggs = ? where pad_ID = ? and name = ?";
                PreparedStatement stmt = connection.prepareStatement(update_sql);
                stmt.setInt(1, level);
                stmt.setInt(2, skill_level);
                stmt.setInt(3, awakenings);
                stmt.setInt(4, plus_eggs);
                stmt.setString(5, id);
                stmt.setString(6, name);
                stmt.executeUpdate();
                stmt.close();
            }
            catch (SQLException e1) {
                resp.setStatus(500);
                resp.getWriter().print("updateMonster error: " + Main.getStackTrace(e1));
            }
        }
    }
}
