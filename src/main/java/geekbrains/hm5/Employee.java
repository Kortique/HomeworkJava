package geekbrains.hm5;

public class Employee {

    private String name;
    private String surname;
    private String middleName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String surname, String name, String middleName, String position, String email, String phone,
                    int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Сотрудник %s %s %s:\nЗанимаемая должность - %s;\nE-mail - %s;\n", surname, name, middleName,
                position, email);
        System.out.printf("Телефон - %s;\nОклад - %d;\nВозраст - %d.\n", phone, salary, age);
        System.out.println();
    }

    public static void main(String[] args) {
        Employee[] band = new Employee[5];
        band[0] = new Employee("Тетерев", "Сергей", "Петрович", "сисадмин",
                "winmustdie@yahoo.com","89003150080", 50_000, 43);
        band[1] = new Employee("Вульгарная", "Авдотья", "Арсеньевна",
                "менеджер по чистоте","", "4712363870", 15_000, 63);
        band[2] = new Employee("Тоненькая","Анна","Юрьевна", "секретарь",
                "cutekity@krovatka.ru", "89504268739", 45_000, 21);
        band[3] = new Employee("Тучный","Михаил","Викторович", "директор",
                "michailtuch@gmail.com", "88006006000", 135_000, 52);
        band[4] = new Employee("Ястреб", "Любовь", "Михайловна", "менеджер по найму",
                "welcome@company.by", "89511234568", 30_000, 33);

        for (int i = 0; i < band.length; i++) {
            if (band[i].age > 40)
                band[i].printInfo();
        }


    }
}