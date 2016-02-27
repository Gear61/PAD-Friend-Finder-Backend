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
public class changeID {
    public static void changeID(Connection connection, HttpServletResponse resp, String old_id, String new_id) throws JSONException, IOException {
        try {
            String find_id_sql = "Select pad_ID FROM monster WHERE pad_ID = ? limit 1";
            PreparedStatement stmt = connection.prepareStatement(find_id_sql);
            stmt.setString(1, new_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                resp.setStatus(400);
            else {
                String id_change_sql = "UPDATE monster set pad_ID = ? where pad_ID = ?";
                stmt = connection.prepareStatement(id_change_sql);
                stmt.setString(1, new_id);
                stmt.setString(2, old_id);
                stmt.executeUpdate();
                resp.setStatus(200);
            }
            stmt.close();
        }
        catch (SQLException e1) {
            resp.setStatus(500);
        }
        finally {
            resp.getWriter().print("{}");
        }
    }
}
