import java.math.BigDecimal;

public class Movie {

    private int hero_id;
    private String movieName;
    private BigDecimal budget;

    public Movie(int hero_id, String movieName, BigDecimal budget) {
        this.hero_id = hero_id;
        this.movieName = movieName;
        this.budget = budget;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
