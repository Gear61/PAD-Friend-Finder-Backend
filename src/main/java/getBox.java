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

public class getBox {
    public static void get_Box(Connection connection, HttpServletResponse resp, String id) throws JSONException, IOException {
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
            resp.getWriter().print("get_Box error: " + Main.getStackTrace(e));
        }
    }
}

