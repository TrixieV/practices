package moderate;

public class MostAlive {
    public static void main(String[] args) {
        People p1 = new People("A", 1903, 1990);
        People p2 = new People("B", 1910, 1911);
        People p3 = new People("C", 1912, 1945);
        People p4 = new People("D", 1960, 1975);
        People p5 = new People("E", 1980, 1989);
        People p6 = new People("F", 1930, 1999);
        People p7 = new People("G", 1941, 1987);
        People p8 = new People("H", 1906, 1965);
        People p9 = new People("I", 1932, 1973);
        People p10 = new People("J", 1978, 1996);
        People p11 = new People("K", 1936, 1946);

        People[] people = new People[]{p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11};


        System.out.println(yearMostAlive(people, 1930, 1940));
    }

    private static int yearMostAlive(People[] people, int min, int max) {
        min = min % 100;
        max = max % 100;

        int[] years = new int[100];
        for (People person: people) {
            int birth = person.getBirth() % 100;
            int death = person.getDeath() % 100;
            if (birth >= min && birth <= max) {
                if (years[birth] == 0) {
                    years[birth] = 1;
                } else {
                    years[birth]++;
                }
            }
            if (death >= min && death <= max && death != birth) {
                if (years[death] == 0) {
                    years[death] = -1;
                } else {
                    years[death]--;
                }
            }
        }

        int count = 0, yearMostAlive = min, mostAlivePeople = 0;
        for (int i = min; i <= max; i++) {
            if (years[i] == 0) {
                continue;
            }
            count += years[i];
            if (count > mostAlivePeople) {
                mostAlivePeople = count;
                yearMostAlive = i;
            }
        }
        yearMostAlive += 1900;

        return yearMostAlive;
    }
}

class People {
    private String name;
    private int birth;
    private int death;

    public People(String name, int birth, int death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }
}
