package geekbrains.hm6;

class Dog extends Animal {
    private static int count = 0;
    private int runDist;
    private int swimDist;
    public Dog(String name, int runDist, int swimDist) {
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
    public void run(int distance) {
        if (distance < 0 )
            System.out.println("Пёс " + super.name + " не сдвинулся с места, ибо дистанция отрицательная.");
        if (distance >=0 && distance<= 500)
            System.out.println("Пёс " + super.name + " пробежал дистанцию " + distance + " метров.");
        else if (distance > 500)
            System.out.println("Пёс " + super.name + " пробежал дистанцию 500 метров и, притомившись, слёг.");
    }

    @Override
    public void swim(int distance) {
        if (distance < 0 )
            System.out.println("Пёс " + super.name + " не сдвинулся с места, ибо дистанция отрицательная.");
        if (distance >=0 && distance<= 10)
            System.out.println("Пёс " + super.name + " проплыл дистанцию " + distance + " метров.");
        else if (distance > 10)
            System.out.println("Пёс " + super.name + " отказался плыть, трезво оценив свои силы.");
    }
}

