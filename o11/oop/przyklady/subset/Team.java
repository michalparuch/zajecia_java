package basics.o11.oop.przyklady.subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team {
    private String name;
    private List<Player> players = new ArrayList<>();
    private List<Player> trainers = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) && Objects.equals(players, team.players) && Objects.equals(trainers, team.trainers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, players, trainers);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.addTeam(this);
    }

    public void addTrainer(Player player) {
        if (players.contains(player)) {
            trainers.add(player);
            player.setTrainer(true);
        } else {
            throw new IllegalArgumentException("Player" + player.getName() + " " + player.getLastName() + "not in team");
        }
    }
}
