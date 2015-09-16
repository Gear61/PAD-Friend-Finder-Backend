import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jman0_000 on 9/15/2015.
 */
public class CheckID {
    public static void checkID(Connection connection, HttpServletResponse resp, String old_id, String new_id) throws JSONException, IOException {
        try{
            String find_id_sql = "Select pad_ID FROM monster WHERE pad_ID = ? limit 1";
            PreparedStatement stmt = connection.prepareStatement(find_id_sql);
            stmt.setString(1, new_id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next())
                resp.setStatus(400);
            else {
                String id_change_sql = "UPDATE monster set pad_ID = ? where pad_ID = ?";
                stmt = connection.prepareStatement(id_change_sql);
                stmt.setString(1, new_id);
                stmt.setString(2, old_id);
                resp.getWriter().print(id_change_sql + "\n");
                stmt.executeUpdate();
                resp.setStatus(200);
            }
            stmt.close();
        }
        catch (SQLException e1) {
            resp.setStatus(500);
            resp.getWriter().print("checkID SQL error: " + Main.getStackTrace(e1));
        }
    }

}
