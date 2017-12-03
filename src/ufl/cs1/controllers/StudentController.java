package ufl.cs1.controllers;

import game.controllers.DefenderController;
import game.models.*;

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
        Maze maze = game.getCurMaze();
	    Node attackerNode = game.getAttacker().getLocation();
        Attacker attacker = game.getAttacker();
        List<Integer> directions = defender.getPossibleDirs();
        List<Node> locations = defender.getPossibleLocations();
        if (directions.size() > 1 && defender.getLairTime() <= 0){
            int bestDirection = -1;
            int bestLength = 1000;
            for(int i=0; i<4; i++){
                if(locations.get(i) != null){
                    int possibleLength = locations.get(i).getPathDistance(attackerNode);
                    Node closestPowerPill = attacker.getTargetNode(maze.getPowerPillNodes(), true);
                    if (attacker.getLocation().getPathDistance(closestPowerPill) <= 10) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (!defender.isVulnerable()) {
                        if (possibleLength < bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (defender.isVulnerable()) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                }
            }
            return bestDirection;
        }
        return 1;
    }
    public int getBehavior2(Defender defender, Game game){
        Maze maze = game.getCurMaze();
        Node attackerNode = game.getAttacker().getLocation();
        Attacker attacker = game.getAttacker();
        List<Integer> directions = defender.getPossibleDirs();
        List<Node> locations = defender.getPossibleLocations();
        if (directions.size() > 1 && defender.getLairTime() <= 0){
            int bestDirection = -1;
            int bestLength = 1000;
            for(int i=0; i<4; i++){
                if(locations.get(i) != null){
                    int possibleLength = locations.get(i).getPathDistance(attackerNode);
                    Node closestPowerPill = attacker.getTargetNode(maze.getPowerPillNodes(), true);
                    if (attacker.getLocation().getPathDistance(closestPowerPill) <= 10) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (!defender.isVulnerable()) {
                        if (possibleLength < bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (defender.isVulnerable()) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                }
            }
            return bestDirection;
        }
        return 1;
    }
    public int getBehavior3(Defender defender, Game game){
        Maze maze = game.getCurMaze();
        Node attackerNode = game.getAttacker().getLocation();
        Attacker attacker = game.getAttacker();
        List<Integer> directions = defender.getPossibleDirs();
        List<Node> locations = defender.getPossibleLocations();
        if (directions.size() > 1 && defender.getLairTime() <= 0){
            int bestDirection = -1;
            int bestLength = 1000;
            for(int i=0; i<4; i++){
                if(locations.get(i) != null){
                    int possibleLength = locations.get(i).getPathDistance(attackerNode);
                    Node closestPowerPill = attacker.getTargetNode(maze.getPowerPillNodes(), true);
                    if (attacker.getLocation().getPathDistance(closestPowerPill) <= 10) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (!defender.isVulnerable()) {
                        if (possibleLength < bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                    else if (defender.isVulnerable()) {
                        if (possibleLength > bestLength) {
                            bestDirection = i;
                            bestLength = possibleLength;
                        }
                    }
                }
            }
            return bestDirection;
        }
        return 1;
    }
    public int getBehavior4(Defender defender, Game game){
        Node attackerNode = game.getAttacker().getLocation();
        List<Integer> directions = defender.getPossibleDirs();
        List<Node> locations = defender.getPossibleLocations();
        if (directions.size() > 1 && defender.getLairTime() <= 0){
            int bestDirection = -1;
            int bestLength = 1000;
            for(int i=0; i<4; i++){
                if(locations.get(i) != null){
                    int possibleLength = locations.get(i).getPathDistance(attackerNode);
                    if (possibleLength < bestLength) {
                        bestDirection = i;
                        bestLength = possibleLength;
                    }
                }
            }
            return bestDirection;
        }
        return 1;
    }
}