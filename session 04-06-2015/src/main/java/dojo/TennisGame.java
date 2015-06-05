package dojo;

/**
 * Created by mar on 4. 6. 2015.
 */
public class TennisGame {
    public static final String GUEST = "guest";
    public static final String HOME = "home";
    private Score score = new Score();
    private boolean isOver;
    private String advantage = "";

    public TennisGame() {
    }

    TennisGame(int homeScore, int guestScore) {
        score.setHome(homeScore);
        score.setGuest(guestScore);
    }

    public Score getScore() {
        return score;
    }

    public void homeScores() {
        if (score.getHome() == 40 && (score.getGuests() < 40 || advantage.equals(HOME))) {
            isOver = true;
        }
        if (score.getHome() == 40) {
            advantage = advantage.equals(GUEST) ? "" : HOME;
        }
        score.setHome(incrementScore(score.getHome()));
    }

    public boolean isOver() {
        return isOver;
    }

    public void guestScores() {
        if (score.getGuests() == 40 && (score.getHome() < 40 || advantage.equals(GUEST))) {
            isOver = true;
        }
        if (score.getGuests() == 40) {
            advantage = advantage.equals(HOME) ? "" : GUEST;
        }
        score.setGuest(incrementScore(score.getGuests()));
    }

    private int incrementScore(int score) {
        return score >= 30 ? 40 : score + 15;
    }
}
