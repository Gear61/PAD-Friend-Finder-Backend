package HTTP;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class deleteMonster {
    public static void delete_monster(Connection connection, HttpServletResponse resp, JSONObject info) throws JSONException, IOException {
        String id = info.getString("pad_ID");
        String name = info.getString("name");
        try {
            String delete_monster_sql = "Delete FROM monster WHERE pad_ID = ? and name = ? ";
            PreparedStatement stmt = connection.prepareStatement(delete_monster_sql);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException e1) {
            resp.setStatus(500);
            resp.getWriter().print("HTTP.deleteMonster exception: There was an error: " + Main.getStackTrace(e1));
        }
    }
}
