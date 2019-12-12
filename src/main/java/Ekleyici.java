import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ekleyici {

    public static void heroEkle(Hero hero) {

        String sql = "insert into hero (hero_name, hero_surname) " +
                "values (?, ?) ";

        try (Connection conn = Connector.makeConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, hero.getAdi());
            preparedStatement.setString(2, hero.getSoyadi());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " satır eklendi.");

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void movieEkle(Movie movie) {

        String sql = "insert into movie (hero_id, movie, budget) " +
                "values (?, ?, ?) ";

        try (Connection conn = Connector.makeConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, movie.getHero_id());
            preparedStatement.setString(2, movie.getMovieName());
            preparedStatement.setBigDecimal(3, movie.getBudget());

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows + " satır eklendi.");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
