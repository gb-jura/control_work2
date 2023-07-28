import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyShop {
    private List<Toy> toys;

    public ToyShop() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeFrequency(int toyId, int frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(frequency);
                break;
            }
        }
    }

    public Toy choosePrizeToy() {
        int totalFrequency = 0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalFrequency);

        int count = 0;
        for (Toy toy : toys) {
            count += toy.getFrequency();
            if (randomNumber < count) {
                return toy;
            }
        }

        return null;
    }

    public void getPrizeToy() {
        Toy prizeToy = choosePrizeToy();
        if (prizeToy != null) {
            toys.remove(prizeToy);

            try {
                FileWriter writer = new FileWriter("prize_toys.txt", true);
                writer.write(prizeToy.getName() + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }
}