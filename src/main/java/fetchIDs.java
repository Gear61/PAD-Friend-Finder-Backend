import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fetchIDs {

    public static void fetchIDs(Connection connection, HttpServletResponse resp, JSONObject info) throws JSONException, IOException {
        try {
            String fetch_sql = "Select * from monster " +
                    "where pad_ID <> ? and name = ? and level >= ? and skill_level >= ? and awakenings >= ? and plus_eggs >= ? " +
                    " Order by RANDOM() Limit 10 ";
            PreparedStatement stmt = connection.prepareStatement(fetch_sql);
            JSONObject monster = info.getJSONObject("monster");
            stmt.setString(1, info.getString("pad_ID"));
            stmt.setString(2,monster.getString("name"));
            stmt.setInt(3, monster.getInt("level"));
            stmt.setInt(4, monster.getInt("skill_level"));
            stmt.setInt(5,monster.getInt("awakenings"));
            stmt.setInt(6,monster.getInt("plus_eggs"));
            ResultSet rs =  stmt.executeQuery();
            JSONArray ppl_array = new JSONArray();
            while (rs.next()) {
                JSONObject person = new JSONObject();
                person.put("pad_ID", rs.getString("pad_ID"));
                person.put("level", rs.getInt("level"));
                person.put("skill_level", rs.getInt("skill_level"));
                person.put("awakenings", rs.getInt("awakenings"));
                person.put("plus_eggs", rs.getInt("plus_eggs"));
                ppl_array.put(person);
            }
            stmt.close();
            resp.getWriter().print(ppl_array.toString());
        }
        catch (SQLException e) {
            resp.setStatus(500);
            resp.getWriter().print("fetch IDS error: " + Main.getStackTrace(e));
        }
    }
}
