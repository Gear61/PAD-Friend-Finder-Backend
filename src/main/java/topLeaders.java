import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jman0_000 on 9/30/2015.
 */
public class topLeaders {
    public static void topLeaders(Connection connection, HttpServletResponse resp) throws JSONException, IOException {
        try {
            String top_Monsters_SQL = "Select name, COUNT(*) as count from monster " +
                    "GROUP BY name ORDER BY COUNT DESC limit 30";
            PreparedStatement stmt = connection.prepareStatement(top_Monsters_SQL);
            ResultSet rs =  stmt.executeQuery();
            JSONArray top_count_array = new JSONArray();
            while (rs.next()) {
                JSONObject monster_count_pair = new JSONObject();
                monster_count_pair.put("name", rs.getString("name"));
                monster_count_pair.put("count", rs.getInt("count"));
                top_count_array.put(monster_count_pair);
            }
            stmt.close();
            resp.getWriter().print(top_count_array.toString());
        }
        catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print("HTTP.topLeaders error: " + Main.getStackTrace(e));
        }
    }
}
