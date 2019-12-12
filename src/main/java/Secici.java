import java.math.BigDecimal;
import java.util.Scanner;

public class Secici {

    public static void genelMenuSecimYap(Scanner scanner) {
        boolean devamEdilsin = true;

        while (devamEdilsin) {
            int secim = scanner.nextInt();

            scanner.nextLine();

            switch (secim) {
                case 1:

                    String ad = Input.stringDegerIste(StringYazici.LUTFEN_ADINIZI_GIRINIZ_YAZISI, scanner);
                    String soyad = Input.stringDegerIste(StringYazici.LUTFEN_SOYADINIZI_GIRINIZ_YAZISI, scanner);

                    Hero hero = new Hero(ad, soyad);

                    Ekleyici.heroEkle(hero);

                    break;
                case 2:
                    EkranGosterici.heroListele();
                    //İd degerini kontrol et
                    int heroId = Input.sayiDegeriIste(StringYazici.KAHRAMAN_IDSINI_GIRINIZ_YAZISI, scanner);

                    scanner.nextLine();

                    String movieName = Input.stringDegerIste(StringYazici.MOVIE_ADINI_GIRINIZ_YAZISI, scanner);

                    BigDecimal budget = Input.decimalSayiDegeriIste(StringYazici.FILM_BUTCESI_GIRINIZ_YAZISI, scanner);

                    Movie movie = new Movie(heroId, movieName, budget);

                    Ekleyici.movieEkle(movie);

                    break;

                case 3:
                    EkranGosterici.heroAdiniSoyadiniBirlestirVeButceleriniTopla();

                    break;
                case 4:
                    EkranGosterici.kahramanlarinOynadiklariFilmSayilariniGoster();

                    break;
            }

        }
    }
}
