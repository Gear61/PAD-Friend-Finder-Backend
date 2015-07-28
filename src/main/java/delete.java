import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class delete {
    public static void delete_monster(Connection connection, HttpServletResponse resp, JSONObject info) throws JSONException, IOException {
        String id = info.getString("pad_ID");
        String name = info.getString("name");
        try {
            resp.getWriter().print("Deleting\n");
            String delete_monster_sql = "Delete FROM monster WHERE pad_ID = ? and name = ? ";
            PreparedStatement stmt = connection.prepareStatement(delete_monster_sql);
            stmt.setString(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
            stmt.close();
            resp.getWriter().print("Monster deleted!");
        }
        catch (SQLException e1) {
            resp.getWriter().print("delete exception: There was an error: " + Main.getStackTrace(e1));
        }
    }
}
