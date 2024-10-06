package Java;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.naming.NameNotFoundException;



public class StreamPractice {

    public static void main(String[] args) {

        interviewProblem();
        System.out.println("Sorted hashmap operations : ");
        sortHashMap();

        employeeOperations();

        

    } 

    public static void interviewProblem() {
        System.out.println("----Interview Problem---");
        List<String> names = new ArrayList<>();
        names.add("Bruce");
        names.add("0");
        names.add("Clark");
        names.add("DEEEEE");
        names.add("-1");
        names.add("FEEEEE");

        List<List<String>> list = new ArrayList<>();
        list.add(names);

        List<String> filteredList = list.stream().flatMap(e -> e.stream())
                                    .filter(e -> e.length() > 2).collect(Collectors.toList());
        filteredList.forEach(System.out::println);                                    

    }
    
    public static void sortHashMap() {
        Map<String, Integer> unsortedMap = new HashMap<>();

        unsortedMap.put("London", 102);
        unsortedMap.put("Sussex", 101);
        unsortedMap.put("Glasgow", 106);
        unsortedMap.put("England", 103);

        //Print keySet
        unsortedMap.keySet().stream().forEach(System.out::println);
        //print entry 
        System.out.println("Printing entry : ");
        unsortedMap.entrySet().stream().forEach(e->System.out.println(e.getKey()+" - "+ e.getValue()));

        //Sort using stream
        //on Key
        System.out.println("\nSorted on keys : ");
        unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(System.out::println);

        System.out.println("\nSorted on values : ");
        unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .forEach(System.out::println);

        //Sort and collect in a map
        System.out.println("\n Sort by key and collect into a map");
        HashMap<String, Integer> sortedMap = unsortedMap.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (o1, o2) -> o1, LinkedHashMap::new));
        
        sortedMap.entrySet().stream()
            .forEach(System.out::println);

        
    }

    static void employeeOperations() {
        System.out.println("\n------Employee Operations---");
        
        List<Employee> employees = new ArrayList<>();
        employees.add( new Employee("Bruce", "Wayne", 10, List.of("Project1", "Project2")));
        employees.add( new Employee("Clark", "Kent", 5, List.of("Project1")));
        employees.add( new Employee("Tony", "Stark", 15, List.of("Project1", "Project2", "Project3")));

        //Increase salary by 10 times
        System.out.println("Increased salary by 10 times");
        List<Employee> increasedSalary = employees.stream()
                                            .map(e -> new Employee(e.getFirstName(), e.getLastName(), e.getSalary()*10, e.getProjects()))
                                            .collect(Collectors.toList());
        
        increasedSalary.forEach(System.out::println);

        //Find max salary
        System.out.println("---Max Salary---");
        Employee maxSalaryEmployee = employees.stream()
                .max(Comparator.comparing(e -> e.getSalary()))
                .orElseThrow();
        System.out.println("---Max Salary--- : "+maxSalaryEmployee);

        Integer totalSal = employees.stream()
                .map(e -> e.getSalary())
                .reduce(Integer::sum)
                .orElseThrow();
        System.out.println("---Total salary sum--- : "+totalSal);

        int[] numbers = {5, 13, 41, 88, 99, 77};

        Integer secondHighest = Arrays.stream(numbers).boxed()
                                .sorted(Comparator.reverseOrder())
                                .skip(1).findFirst().get();
        System.out.println("Second highest integer : "+secondHighest);

        Integer  secondHighestSalary = employees.stream()
                                    .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                    .skip(1).findFirst().get().getSalary();

        System.out.println("Second highest salary : "+secondHighestSalary);
    
        List<Employee> sortedEmpList = employees.stream()
                                        .sorted((o1, o2)-> Integer.compare(o1.getSalary(), o2.getSalary()))
                                        .collect(Collectors.toList());
        System.out.println("Sorted employee list :");
        sortedEmpList.forEach(System.out::println);
        
    }


    static void countWords() {
        System.out.println("Count words in array and create a count Map");
        List<String> users = Arrays.asList("Lambo", "Urus", "Lambo", "Bugati", "Mustang", "Lambo", "Mustang");   

        //users.stream()
        //    .collect(Collectors.groupingBy(str -> str, Collectors.counting()));

        Map<String, Long> countMap = users.stream()
                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Count Words");                            
       countMap.entrySet().stream() 
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
