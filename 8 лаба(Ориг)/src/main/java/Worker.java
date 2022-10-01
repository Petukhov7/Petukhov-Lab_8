public class Worker {

    public final String name;
    public final int age;
    public final int salary;
    public final Classification classification;
    public final Gender gender;

    public Worker(String name, int age, int salary,Gender gender, Classification classification) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.classification = classification;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getSalary() {return salary;}
    public Gender getGender() {return gender;}
    public Classification getClassification() {return classification;}

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", classification=" + classification +
                '}';
    }

//    public void setName(String name) {this.name = name;}
//    public void setAge(int age) {this.age = age;}
//    public void setClassification(Classification classification) {this.classification = classification;}
//    public void setSalary(int salary) {this.salary = salary;}



}
