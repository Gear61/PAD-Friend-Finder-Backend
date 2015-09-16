import Models.MonsterAttributes;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
			resp.setStatus(500);
			resp.getWriter().print("Table creation error: " + e.getMessage());
		}

		try {
			String req_string = req.getRequestURI();
			String[] split_req = req_string.split("/");

			if (split_req[1].equals("getMonsters")) {
				resp.setStatus(200);
				printMonsterList.printMonsterList(resp);
			}
			else if (split_req[1].equals("changeID")) {
				CheckID.checkID(connection, resp, split_req[2], split_req[3]);
			} else if (split_req.length < 3) {
				resp.setStatus(404);
			} else if (split_req[1].equals("monsters")) {
				getMonsterBox.getMonsterBox(connection, resp, split_req[2]);
			} else {
				resp.setStatus(404);
			}
		}
		catch (JSONException e1) {
			resp.setStatus(500);
			resp.getWriter().print("Failed to parse body JSON: " + getStackTrace(e1));
		}
		catch (IOException e) {
			resp.setStatus(500);
			resp.getWriter().print("Failed to prepare SQL statement: " + getStackTrace(e));
		}
		
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				resp.getWriter().print("Failed to close connection: " + getStackTrace(e));
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
			resp.setStatus(500);
			resp.getWriter().print("Table creation error: " + e.getMessage());
		}
		
		StringBuffer jb = new StringBuffer();
		String line;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		}
		catch (IOException e) {
			resp.setStatus(400);
			resp.getWriter().print("Couldn't read in request body: " + getStackTrace(e));
		}
		
		try {
			JSONObject jsonObject = new JSONObject(jb.toString());
			if (req.getRequestURI().endsWith("/fetch")) {
				fetchIDs.fetchIDs(connection, resp, jsonObject);
			}
			else if (req.getRequestURI().endsWith("/update")) {
				updateMonster.updateMonster(connection, resp, jsonObject);
			}
			else if (req.getRequestURI().endsWith("/delete")) {
				deleteMonster.delete_monster(connection, resp, jsonObject);
			}
			else {
				resp.setStatus(404);
			}
		}
		catch (JSONException e1) {
			resp.setStatus(400);
			resp.getWriter().print("Error parsing request JSON: " + getStackTrace(e1));
		}
		catch (IOException e) {
			resp.setStatus(500);
			resp.getWriter().print("Error creating SQL statement: " + getStackTrace(e));
		}
		
		finally {
			try {
				connection.close();
			}
			catch (SQLException e) {
				resp.getWriter().print("Failed to close connection: " + getStackTrace(e));
			}
		}
	}

	private static Connection getConnection() throws URISyntaxException, SQLException
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