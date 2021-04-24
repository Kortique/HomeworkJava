package geekbrains.hm6;

class Cat extends Animal {
    private static int count = 0;
    private int runDist;
    private int swimDist;

    public Cat(String name, int runDist, int swimDist) {
        super(name);
        this.runDist = runDist;
        this.swimDist = swimDist;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getRunDist() {
        return runDist;
    }

    public int getSwimDist() {
        return swimDist;
    }

    @Override
    public void swim(int distance) {
        if (distance != 0)
            System.out.println("Кот " + super.name + " громко фыркнул, выразив своё презрение к воде.");
    }

    @Override
    public void run(int distance) {
        if (distance < 0 )
            System.out.println("Кот " + super.name + " не сдвинулся с места, ибо дистанция отрицательная");
        if (distance >=0 && distance<= 200)
            System.out.println("Кот " + super.name + " пробежал дистанцию " + distance + " метров.");
        else if (distance > 200)
            System.out.println("Кот " + super.name + " пробежал дистанцию 200 метров, но дальше ни-ни - ибо лапки.");
    }
}