package ufl.cs1.controllers;

import game.controllers.DefenderController;
import game.models.Defender;
import game.models.Game;

import java.util.List;

public final class StudentController implements DefenderController
{
    public enum State{ATTACC, PROTECC}
    Game previousGameState;
    Game currentGameState;

	public void init(Game game) { }

	public void shutdown(Game game) { }

	public int[] update(Game game,long timeDue)
	{
        this.currentGameState = game;
        if (this.previousGameState == null) {
            this.previousGameState = game;
        }
		int[] actions = new int[Game.NUM_DEFENDER];
		List<Defender> enemies = game.getDefenders();

        actions[0] = getBehavior1(enemies.get(0), game);
        actions[1] = getBehavior2(enemies.get(1), game);
        actions[2] = getBehavior3(enemies.get(2), game);
        actions[3] = getBehavior4(enemies.get(3), game);

		return actions;
	}

	public int getBehavior1(Defender defender, Game game){
        List<Integer> possibleDirs = defender.getPossibleDirs();
        System.out.println("Defender 1 " + possibleDirs);

        if (possibleDirs.size() != 0)
            return possibleDirs.get(0);
        else
            return -1;
    }
    public int getBehavior2(Defender defender, Game game){
	    return 0;
    }
    public int getBehavior3(Defender defender, Game game){
        return 0;
    }
    public int getBehavior4(Defender defender, Game game){
        //Non-student code, just a placeholder for the fourth defender's behavior
        List<Integer> possibleDirs = defender.getPossibleDirs();
        if (possibleDirs.size() != 0)
            return possibleDirs.get(Game.rng.nextInt(possibleDirs.size()));
        else
            return -1;
    }
}