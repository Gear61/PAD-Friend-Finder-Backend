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

public class Main extends HttpServlet {
	
	private static String TABLE_CREATION = "CREATE TABLE IF NOT EXISTS monster " +
		"(pad_ID varchar(9), name varchar(64), level int, " +
		"skill_level int, awakenings int, plus_eggs int, " + 
		"CONSTRAINT uniqueMonster UNIQUE (pad_ID, name))";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(TABLE_CREATION);
		}
		catch (Exception e) {
			resp.getWriter().print("doPost exception 1: There was an error: " + e.getMessage());
		}
		
		try {
			String req_string = req.getRequestURI();
			String[] split_req = req_string.split("/");
			if (split_req.length < 3)
				return;
			
			if(split_req[1].equals("monsters"))
				getBox.get_Box(connection, resp, split_req[2]);
				
		}
		catch (JSONException e1) {
			resp.getWriter().print("doPost exception 3: There was an error: " + getStackTrace(e1));
		}
		catch (IOException e) {
			resp.getWriter().print("doPost exception 4: There was an error: " + getStackTrace(e));
		}
		
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				resp.getWriter().print("doPost exception 5: There was an error: " + getStackTrace(e));
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
	{
		Connection connection = null;
		try {
			connection = getConnection();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(TABLE_CREATION);
		}
		catch (Exception e) {
			resp.getWriter().print("doPost exception 1: There was an error: " + e.getMessage());
		}
		
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		}
		catch (IOException e) {
			resp.getWriter().print("doPost exception 2: There was an error: " + getStackTrace(e));
		}
		
		try {
			JSONObject jsonObject = new JSONObject(jb.toString());
			if (req.getRequestURI().endsWith("/fetch"))
				fetchIDs.fetch_IDS(connection, resp, jsonObject);
			else if (req.getRequestURI().endsWith("/update")) {
				resp.getWriter().print("Posting\n");
				update.update_profile(connection, resp, jsonObject);
			}
			else if (req.getRequestURI().endsWith("/delete")) {
				delete.delete_monster(connection, resp, jsonObject);
			}
			else
				resp.getWriter().print("Post");
		}
		catch (JSONException e1) {
			resp.getWriter().print("doPost exception 3: There was an error: " + getStackTrace(e1));
		}
		catch (IOException e) {
			resp.getWriter().print("doPost exception 4: There was an error: " + getStackTrace(e));
		}
		
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				resp.getWriter().print("doPost exception 5: There was an error: " + getStackTrace(e));
			}
		}
	
	}
	
	private Connection getConnection() throws URISyntaxException, SQLException
	{
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);	
		context.addServlet(new ServletHolder(new Main()), "/*");
		server.start();
		server.join();
	}
	
	public static String getStackTrace(Throwable aThrowable) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}
}