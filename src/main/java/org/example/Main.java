package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new LinkedList<>();

        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(4, "Burak", "Cevizli"));
        employeeList.add(null);

        System.out.println("Employee List");
        System.out.println(employeeList);
        System.out.println("findDuplicates");
        System.out.println(findDuplicates(employeeList));
        System.out.println("findUniques");
        System.out.println(findUniques(employeeList));
        System.out.println("removeDuplicates");
        System.out.println(removeDuplicates(employeeList));
        System.out.println(removeDuplicates(employeeList).get(0));

        System.out.println("----------------------------------------------------");

        //WordCounter.calculatedWord();

    }
    public static List<Employee> findDuplicates(List<Employee> employeeList){
        Set<Employee> seen = new LinkedHashSet<>();
        Set<Employee> dublicates = new LinkedHashSet<>();

        for(Employee employee : employeeList){
            if(!seen.add(employee)){
                dublicates.add(employee);
            }
        }
        return new ArrayList<>(dublicates);
    }
    public static Map<Integer,Employee> findUniques(List<Employee> employeeList){
        Map<Integer, Employee> uniqueMap = new LinkedHashMap<>();
        Set<Integer> seen = new LinkedHashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        // İlk geçiş: her employee'in id'sini kontrol et
        for (Employee employee : employeeList) {
            if (!seen.add(employee.getId())) {
                duplicates.add(employee.getId());
            }
        }

        // İkinci geçiş: uniqueMap'i doldur
        for (Employee employee : employeeList) {
            if (!duplicates.contains(employee.getId())) {
                uniqueMap.put(employee.getId(), employee);
            }
        }
        // Tekrar eden employee'leri de ekleyelim, sadece bir kez
        for (Integer id : duplicates) {
            for (Employee employee : employeeList) {
                if (employee.getId() == id) {
                    uniqueMap.put(id, employee);
                    break; // Duplicate için yalnızca bir örneğini ekle
                }
            }
        }

        return uniqueMap;


    }
    public static List<Employee> removeDuplicates(List<Employee> employeeList){
        Set<Employee> seen = new LinkedHashSet<>();
        Set<Employee> dublicates = new LinkedHashSet<>();

        for(Employee employee : employeeList){
            if(!seen.add(employee)){
                dublicates.add(employee);
            }
        }
        seen.removeAll(dublicates);
        return new ArrayList<>(seen);
    }

}