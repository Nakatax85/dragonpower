package org.earthspecialforces.dragonpower.game.gameObjects;

/**
 * Created by joaorocha on 13/06/2017.
 */
public class GameObjectFactory {

    /**
     * Manufactures new random cars
     * @return a newly instantiated car
     */
    public static GameObject getNewGameObject() {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];

        Car car;

        switch (carType) {
            case FIAT:
                car = new Fiat();
                break;
            case MUSTANG:
                car = new Mustang();
                break;
            default:
                car = new Fiat();
        }

        return car;

    }

}

    public Crashable createCrashable(){

        return null;
    }

    public Collectable createCollectable(){

        return null;
    }
}

