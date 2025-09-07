package basics.o19.dates.zadania.z4.turniej;

import java.time.LocalDate;

public class Tournament {
    private String name;
    private String price;
    private LocalDate date;
    private Integer points;
    private Player player;

    public Tournament(String name, Integer points, LocalDate date, String price, Player player) {
        this.name = name;
        this.points = points;
        this.date = date;
        this.price = price;
        this.player = player;

        player.getTournaments().add(this);
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getPoints() {
        return points;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }
}
