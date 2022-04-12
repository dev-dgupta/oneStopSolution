package designPatterns.creationalPattern.builder.badSolution;

public class Ingredients {

    private String milk;
    private String darjeelingTeaLeaves;
    private String munnarTeaLeaves;
    private String sugar;
    private String basil;
    private String cardamom;
    private String ginger;
    private String water;

    public Ingredients() {
    }

    public Ingredients(String milk, String darjeelingTeaLeaves,
                      String munnarTeaLeaves, String sugar, String basil, String cardamom, String ginger, String water) {
        this.milk = milk;
        this.darjeelingTeaLeaves = darjeelingTeaLeaves;
        this.munnarTeaLeaves = munnarTeaLeaves;
        this.sugar = sugar;
        this.basil = basil;
        this.cardamom = cardamom;
        this.ginger = ginger;
        this.water = water;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getDarjeelingTeaLeaves() {
        return darjeelingTeaLeaves;
    }

    public void setDarjeelingTeaLeaves(String darjeelingTeaLeaves) {
        this.darjeelingTeaLeaves = darjeelingTeaLeaves;
    }

    public String getMunnarTeaLeaves() {
        return munnarTeaLeaves;
    }

    public void setMunnarTeaLeaves(String munnarTeaLeaves) {
        this.munnarTeaLeaves = munnarTeaLeaves;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getBasil() {
        return basil;
    }

    public void setBasil(String basil) {
        this.basil = basil;
    }

    public String getCardamom() {
        return cardamom;
    }

    public void setCardamom(String cardamom) {
        this.cardamom = cardamom;
    }

    public String getGinger() {
        return ginger;
    }

    public void setGinger(String ginger) {
        this.ginger = ginger;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "Ingedients{" +
                "milk='" + milk + '\'' +
                ", darjeelingTeaLeaves='" + darjeelingTeaLeaves + '\'' +
                ", munnarTeaLeaves='" + munnarTeaLeaves + '\'' +
                ", sugar='" + sugar + '\'' +
                ", basil='" + basil + '\'' +
                ", cardamom='" + cardamom + '\'' +
                ", ginger='" + ginger + '\'' +
                ", water='" + water + '\'' +
                '}';
    }
}
