package basics.o19.dates.zadania.z4.turniej;

import basics.o19.dates.zadania.urodziny.InvalidBirthDateException;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Player {
    private String name;
    private String surname;
    private String nick;
    private List<Tournament> tournaments = new ArrayList<>();

    public static List<Player> extension = new ArrayList<>();

    public Player(String name, String nick, String surname) {
        this.name = name;
        this.nick = nick;
        this.surname = surname;

        extension.add(this);
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getSurname() {
        return surname;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public static Player getBestPlayerByMonth(Integer month) {

        Integer maxPoints = 0;
        Player bestPlayer = null;

        for (Player player : extension) {
            Integer playerTotalPoints = 0;
            for (Tournament tournament : player.getTournaments()) {
                if (tournament.getDate().getMonthValue() == month) {
                    playerTotalPoints += tournament.getPoints();
                }
            }
            if (playerTotalPoints > maxPoints) {
                maxPoints = playerTotalPoints;
                bestPlayer = player;
            }
        }

        if (bestPlayer == null) {
            throw new InvalidBirthDateException("No player found!");
        }

        return bestPlayer;
    }

    public static Player getBestPlayerByTimePeriod(LocalDate startDate, LocalDate EndDate) {
        Integer maxPoints = 0;
        Player bestPlayer = null;

        for (Player player : extension) {
            Integer playerTotalPoints = 0;
            for (Tournament tournament : player.getTournaments()) {
                if (tournament.getDate().isAfter(startDate) && tournament.getDate().isBefore(EndDate)) {
                    playerTotalPoints += tournament.getPoints();
                }
            }
            if (playerTotalPoints > maxPoints) {
                maxPoints = playerTotalPoints;
                bestPlayer = player;
            }
        }

        if (bestPlayer == null) {
            throw new InvalidBirthDateException("No player found!");
        }

        return bestPlayer;
    }

    public static Set<Player> getPlayersByTimePeriod(LocalDate startDate, LocalDate EndDate) {
        Set<Player> selectedPlayer = new HashSet<>();

        for (Player player : extension) {
            for (Tournament tournament : player.getTournaments()) {
                if (tournament.getDate().isAfter(startDate) && tournament.getDate().isBefore(EndDate)) {
                    selectedPlayer.add(player);
                }
            }
        }

        if (selectedPlayer.isEmpty()) {
            throw new InvalidBirthDateException("No player found!");
        }

        return selectedPlayer;
    }

    public static List<Player> getPlayersWithWinsInTwoDifferentMonths() {
        Map<Month, Player> winnersByMonth = new HashMap<>();

        for (Player player : extension) {
            for (Tournament tournament : player.getTournaments()) {
                Month month = tournament.getDate().getMonth();

                int maxPoints = tournament.getPoints();
                boolean isWinner = true;

                for (Player other : extension) {
                    for (Tournament otherTournament : other.getTournaments()) {
                        if (otherTournament == tournament){
                            continue;
                        }
                        if (otherTournament.getName().equals(tournament.getName())
                                && otherTournament.getPoints() > maxPoints) {
                            isWinner = false;
                            break;
                        }
                    }
                    if (!isWinner) break;
                }

                if (isWinner) {
                    winnersByMonth.put(month, player);
                }
            }
        }

        Map<Player, Set<Month>> playerMonths = new HashMap<>();

        for (Map.Entry<Month, Player> entry : winnersByMonth.entrySet()) {
            Player player = entry.getValue();
            Month month = entry.getKey();

            Set<Month> months = playerMonths.getOrDefault(player, new HashSet<>());
            months.add(month);
            playerMonths.put(player, months);
        }

        List<Player> result = new ArrayList<>();
        for (Map.Entry<Player, Set<Month>> entry : playerMonths.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getKey());
            }
        }

        if (result.isEmpty()) {
            throw new IllegalArgumentException("No player found!");
        }

        return result;
    }


}

