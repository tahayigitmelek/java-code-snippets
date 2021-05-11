import java.util.*;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class RockstarGames implements Observable{

    public String releaseGame;
    private List<Observer> observers = new ArrayList<>();

    public void release(String game) {
        this.releaseGame = game;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Inform message to : " + observer);
            observer.update(releaseGame);
        }
    }

}

interface Observer {
    void update(String game);
}

class Gamer implements Observer{

    private String name;
    private String reaction;
    private Observable observable;

    private Set<String> games = new HashSet<>();

    public Gamer(String name, String reaction, Observable observable) {
        this.reaction = reaction;
        this.name = name;
        this.observable = observable;
    }

    public void buyGame(String game) {
        games.add(game);
        System.out.println(name + " says: " + reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public void update(String game) {
        buyGame(game);
    }
}

class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;

        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order", rockstarGames);
        Gamer peter = new Gamer("Peter Johnston", "Woow..", rockstarGames);
        Gamer helen = new Gamer("Helen Jack", "YEEESS!!", rockstarGames);

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        rockstarGames.release(game);

        scanner.close();
    }
}
