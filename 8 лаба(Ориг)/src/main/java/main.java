import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args)
    {
        System.out.println("Задание 1");
        List<String> listy = new ArrayList<>(Arrays.asList("Яблоко","Апельсин","Роза","Апельсин"));
        listy.stream().forEach(x -> Collections.frequency(listy,x));
        List<Integer> misty = listy.stream().distinct().map(x -> Collections.frequency(listy,x)).collect(Collectors.toList());
        System.out.println(listy.get(misty.indexOf(Collections.max(misty))));

        System.out.println("Задание 2");
        List<Worker> workers = new ArrayList<>(Arrays.asList(
                new Worker( "Артём", 49, 400,Gender.Boy, Classification.Enginer),
                new Worker( "Никита", 50, 100,Gender.Boy,  Classification.Enginer),
                new Worker( "Коля", 30, 200,Gender.Boy,  Classification.Enginer),
                new Worker( "Женя", 25, 300,Gender.Boy,  Classification.Enginer),
                new Worker( "Юлия", 25, 340,Gender.Girl,  Classification.Enginer),
                new Worker( "Люся", 37, 140,Gender.Girl,  Classification.Enginer),
                new Worker( "Юля", 35, 220,Gender.Girl,  Classification.Enginer),
                new Worker( "Анна", 45, 240,Gender.Girl,  Classification.Enginer),

                new Worker( "Анна", 28, 150,Gender.Boy,  Classification.Cleaner),
                new Worker( "Ибрагим", 52, 400,Gender.Boy,  Classification.Cleaner),
                new Worker( "Сергей", 33, 400,Gender.Boy,  Classification.Cleaner),
                new Worker( "Алекс", 24, 150,Gender.Boy,  Classification.Cleaner),
                new Worker( "Юра", 83, 150,Gender.Boy,  Classification.Cleaner),
                new Worker( "Анастасия", 25, 340,Gender.Girl,  Classification.Cleaner),
                new Worker( "Света", 37, 140,Gender.Girl,  Classification.Cleaner),
                new Worker( "Марина", 18, 220,Gender.Girl,  Classification.Cleaner),
                new Worker( "Оля", 34, 240,Gender.Girl,  Classification.Cleaner)
                ));
        System.out.println(workers.stream().mapToDouble(Worker -> Worker.salary).average());
        System.out.println("Задание 3");
        Oldy(3,workers);
        WorkSort(3, workers);
        GenderSort(3, workers);
    }

    public static void Oldy(int n, List<Worker> x)
    {
         System.out.println(x.stream()
                 .sorted(Comparator.comparing(Worker::getAge).reversed())
                 .limit(n)
                 .sorted(Comparator.comparing(Worker::getName))
                 .map(Worker -> Worker.name)
                 .collect(Collectors.joining(" , ", n + "-х самых старших сотрудников зовут: ", ";")));
    }
    public static void WorkSort(int n, List<Worker> x)
    {
        System.out.println(x.stream()
                .filter(worker -> worker.getClassification().equals(Classification.Enginer))
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .map(Worker -> Worker.name)
                .collect(Collectors.joining(" , ", n + "-х самых старших сотрудников на должности Enginer зовут: ", ";")));

        System.out.println(x.stream()
                .filter(worker -> worker.getClassification().equals(Classification.Cleaner))
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .map(Worker -> Worker.name)
                .collect(Collectors.joining(" , ", n + "-х самых старших сотрудников на должности Cleaner зовут: ", ";")));
    }
    public static void GenderSort(int n, List<Worker> x)
    {
        System.out.println(x.stream()
                .filter(worker -> worker.getClassification().equals(Classification.Enginer))
                .filter(worker -> worker.getGender().equals(Gender.Girl))
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .sorted(Comparator.comparing(Worker::getSalary).reversed())
                .map(Worker -> Worker.name)
                .collect(Collectors.joining(" , ", n + "-х самых старших женщин на должности Enginer зовут ", ";")));
        System.out.println(x.stream()
                .filter(worker -> worker.getClassification().equals(Classification.Cleaner))
                .filter(worker -> worker.getGender().equals(Gender.Girl))
                .sorted(Comparator.comparing(Worker::getAge).reversed())
                .limit(n)
                .sorted(Comparator.comparing(Worker::getName))
                .sorted(Comparator.comparing(Worker::getSalary).reversed())
                .map(Worker -> Worker.name)
                .collect(Collectors.joining( " , " ,n+"-х самых старших женщин на должности Clener зовут " , ";" )));
    }
}
