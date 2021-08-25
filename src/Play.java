import java.sql.*;

public class Play {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\martins.zalitis\\IdeaProjects\\Class25\\class25.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");
            //statement.execute("INSERT INTO contacts VALUES('Martins',12345567,'martins@email.com')");
//            statement.execute("INSERT INTO contacts VALUES('Peteris',7851567,'peteris@email.com')");
//            statement.execute("INSERT INTO contacts VALUES('Alise',12345,'alise@email.com')");
            statement.execute("SELECT * FROM contacts");
            ResultSet result = statement.getResultSet();
            while (result.next()){
                System.out.println(result.getString("name") + " " + result.getInt("phone") + " " + result.getString("email"));
            }
            statement.close();
            conn.close();
        } catch (SQLException e){
            System.out.println("Somtething went wrong: " + e.getMessage());
        }

    }
}
