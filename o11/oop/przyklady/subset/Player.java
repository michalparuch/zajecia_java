package basics.o11.oop.przyklady.subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player {
    private String name, lastName;
    private List<Team> teams = new ArrayList<>();
    private Boolean isTrainer = false;

    public Player(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getTrainer() {
        return isTrainer;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTrainer(Boolean trainer) {
        isTrainer = trainer;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(lastName, player.lastName) && Objects.equals(teams, player.teams) && Objects.equals(isTrainer, player.isTrainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, teams, isTrainer);
    }

    @Override
    public String toString() {
        return "Player{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void addTeam(Team team){
        teams.add(team);
    }
}
