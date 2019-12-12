import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EkranGosterici {

    public static void heroListele() {

        String selectAllFromQuery = "select * from hero";

        try (Connection conn = Connector.makeConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(selectAllFromQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            MenuOlusturucu.headerOlusturucu(StringYazici.HERO_ID_ADI_SOYADI_UST_YAZISI);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String adi = resultSet.getString("hero_name");
                String soyadi = resultSet.getString("hero_surname");

                System.out.printf("%d \t\t  \t\t%s \t\t%s  \n", id, adi, soyadi);

            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void heroAdiniSoyadiniBirlestirVeButceleriniTopla(){

        String selectAllFromQuery = "select  " +
                "concat(hero_name," + "' ' " + ",hero_surname) as hero," +
                "sum(m.budget) as totalbudget " +
                "from hero h " +
                "left join movie m " +
                "on h.id = m.hero_id " +
                "group by concat(hero_name," + "' ' " +",hero_surname) " +
                "order by sum(m.budget) desc";

        try (Connection conn = Connector.makeConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(selectAllFromQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            MenuOlusturucu.headerOlusturucu(StringYazici.HERO_ADI_SOYADI_BUTCE_UST_YAZISI);

            while (resultSet.next()) {

                String adiVeSoyadi = resultSet.getString("hero");
                String totalbudget = resultSet.getString("totalbudget");

                System.out.printf("%s \t\t %.2f  \n", adiVeSoyadi, totalbudget);

            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void kahramanlarinOynadiklariFilmSayilariniGoster(){

        String selectAllFromQuery = "select " +
                "concat(hero_name,"+ "' '"+",hero_surname) as hero, "+
                "count(m.movie) as movie_count " +
                "from hero h "+
                "left join movie m "+
                "on h.id = m.hero_id "+
                "group by concat(hero_name,"+"' '"+ ",hero_surname) "+
                "order by count(m.movie) desc";

        try (Connection conn = Connector.makeConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(selectAllFromQuery)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            MenuOlusturucu.headerOlusturucu(StringYazici.HERO_ADI_SOYADI_FILM_SAYISI);

            while (resultSet.next()) {

                String heroNameSurname = resultSet.getString("hero");
                String movieCount = resultSet.getString("movie_count");

                System.out.printf("%s \t \t \t %s  \n", heroNameSurname, movieCount);

            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
