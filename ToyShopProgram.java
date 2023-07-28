public class ToyShopProgram {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        Toy toy1 = new Toy(1, "Car", 5, 30);
        Toy toy2 = new Toy(2, "Doll", 10, 50);
        Toy toy3 = new Toy(3, "Robot", 3, 20);

        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);

        toyShop.changeFrequency(2, 70);

        toyShop.getPrizeToy();
    }
}