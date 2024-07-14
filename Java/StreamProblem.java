package Java;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//import Java.Employee;

public class StreamProblem {

    public static void main(String[] args) {

       
        interviewProblem();
        //Sort a hashmap
        sortHashMap();

        //Employee operations
        employeeOperations();

        //CoutnWords
        countWords();


    }

    public static void interviewProblem() {
        System.out.println("---Inteview question---");
        List<String> names = new ArrayList<String>();
        names.add("Bruce");
        names.add("0");
        names.add("Clark");
        names.add("DEEEEE");
        names.add("-1");
        names.add("FEEEEE");

        List<List<String>> list = new ArrayList<>();
        list.add(names);

        //list.stream().flatMap(e -> e.stream()).filter(e -> e.length()>2).forEach(System.out::println);
        List<String> filteredList = list.stream().flatMap(e -> e.stream()).filter(e -> e.length()>2).collect(Collectors.toList());
        filteredList.forEach(System.out::println);

    }

    public static void sortHashMap() {
        Map<String, Integer> unsortedMap = new HashMap<>();

        unsortedMap.put("London", 102);
        unsortedMap.put("Sussex", 101);
        unsortedMap.put("Glasgow", 106);
        unsortedMap.put("England", 103);

        unsortedMap.keySet().stream().forEach(System.out::println);
        unsortedMap.keySet().stream().forEach(k -> System.out.println(k+" - "+unsortedMap.get(k)));

        //Sort using treeMap
        System.out.println("------Sorting  Map-------based on key-name of the cities");
        Map<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(unsortedMap);
        sortedMap.keySet().stream().forEach(k-> System.out.println(k+"-"+sortedMap.get(k)));
        
        //Following method is not realated to Steam api
        System.out.println("------Sorting  Map-------on key");
        
        List<String> sortedOnKeys = new ArrayList<>(unsortedMap.keySet());
        Collections.sort(sortedOnKeys);
        sortedOnKeys.forEach(System.out::println);
        
        System.out.println("------Sorting  Map-------on values");
        
        List<Integer> sortedOnValues = new ArrayList<>(unsortedMap.values());
        Collections.sort(sortedOnValues);
        sortedOnValues.forEach(System.out::println);

        //Using stream API
        System.out.println("--Steam API----Sorting  Map-------on key");
        unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(System.out::println);
        

        System.out.println("---Stream API---Sorting  Map-------on values");
        unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);
            
        System.out.println("--Steam API----Sorting  Map-on key--Returning a map");
        LinkedHashMap<String, Integer> linkedSortedMap = unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry :: getKey, Map.Entry::getValue, 
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        linkedSortedMap.entrySet().stream().forEach(System.out::println);

        System.out.println("-Repeat--Steam API----Sorting  Map-on value--Returning a map");
        LinkedHashMap<String, Integer> sortedLinkedMap = unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
            (ov, nv)-> ov, LinkedHashMap::new));

            sortedLinkedMap.entrySet()
            .forEach(System.out::println);

        System.out.println("-------Practice---");

        LinkedHashMap<String, Integer> processedMap = unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o, n) -> n, LinkedHashMap::new));

        processedMap.entrySet().forEach(System.out::println);
    }

    public static void employeeOperations() {

        System.out.println("---Employee opreations---");
        //Create employees list and populate
        List<Employee> employees = new ArrayList<>();

        employees.add( new Employee("Bruce", "Wayne", 10, List.of("Project1", "Project2")));
        employees.add( new Employee("Clark", "Kent", 5, List.of("Project1")));
        employees.add( new Employee("Tony", "Stark", 15, List.of("Project1", "Project2", "Project3")));

        System.out.println("---Increased Salary---");
        //Increase salary by 10 times
        List<Employee> increasedSalary = employees.stream()
            .map(e -> new Employee(e.getFirstName(), e.getLastName(), e.getSalary()*10, e.getProjects())).collect(Collectors.toList());

        increasedSalary.forEach(System.out::println);

        System.out.println("---Filtered Salary more than 10---");
        List<Employee> filteredSalary = employees.stream()
            .filter(e-> e.getSalary()>=10).collect(Collectors.toList());
        filteredSalary.forEach(System.out::println);

        System.out.println("---Filtered Salary more than 15 with find first---");
        Employee filteredSalary2 = employees.stream()
            .filter(e -> e.getSalary() > 10).findFirst().orElseThrow();
        System.out.println(filteredSalary2);

        System.out.println("---Use of flatmap to take all the projects in comma separated strings---");
        String flatProjects = employees.stream()
            .map(e -> e.getProjects()).
            flatMap(e-> e.stream()).collect(Collectors.joining(","));
        System.out.println(flatProjects);

        System.out.println("---Sorting Based on salary---");
        List<Employee> sortedOnSalary = employees.stream()
            .sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary()))
            .collect(Collectors.toList());
            sortedOnSalary.forEach(System.out::println);

        System.out.println("---Sorting based on First Name---");
        List<Employee> sortedOnName = employees.stream()
            .sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
            .collect(Collectors.toList());
        sortedOnName.forEach(System.out::println);

        System.out.println("---Max salary ---");
        Employee maxSalEmployee = employees.stream()
            .max(Comparator.comparing(e -> e.getSalary()))
            .orElseThrow();
        System.out.println("Max Salary : "+maxSalEmployee);

        System.out.println("--- Total compensation");
        Integer total = employees.stream()
            .map(e -> e.getSalary())
            .reduce(Integer::sum)
            .orElseThrow();
        System.out.println(total);
        

    }

    public static void countWords() {
        System.out.println("Count words in array and create a count Map");
        List<String> users = Arrays.asList("Lambo", "Urus", "Lambo", "Bugati", "Mustang", "Lambo", "Mustang");
        //Create count map , key - user value - occurence
        Map<String, Long> countMap = users.stream()
            .collect(Collectors.groupingBy(str-> str, Collectors.counting()));

        System.out.println("Word with max occurence");
        countMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);

        
    }
    

}



class Employee {

    private String firstName;
    private String lastName;
    private Integer salary;
    private List<String> projects;

    public Employee(){}

    public Employee(String firstName, String lastName, Integer salary, List<String> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.projects = projects;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }
}
