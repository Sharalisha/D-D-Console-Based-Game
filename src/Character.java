public class Character {
    int randomNumber;

    public void character(String name) {

        //for hitpoints this generates random number according to the hit die of each character
        switch (name) {
            case "barbarian":
                randomNumber = (int) (Math.random() * 1000 % 12 + 1);
                break;
            case "bard":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "cleric":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "druid":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "fighter":
                randomNumber = (int) (Math.random() * 1000 % 10 + 1);
                break;
            case "monk":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "paladin":
                randomNumber = (int) (Math.random() * 1000 % 10 + 1);
                break;
            case "ranger":
                randomNumber = (int) (Math.random() * 1000 % 10 + 1);
                break;
            case "rogue":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "sorcerer":
                randomNumber = (int) (Math.random() * 1000 % 6 + 1);
                break;
            case "Warlock":
                randomNumber = (int) (Math.random() * 1000 % 8 + 1);
                break;
            case "wizard":
                randomNumber = (int) (Math.random() * 1000 % 6 + 1);
                break;
            default:
                System.out.println(" ");
                break;
        }
    }
}