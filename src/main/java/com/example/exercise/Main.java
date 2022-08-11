package com.example.exercise;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Select Option: ");
        List<Cargo> cargoList = new ArrayList<>();
        List<Warehouse> warehouseList = new ArrayList<>();
        uploadDataFromCSV(cargoList, warehouseList);
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("-------------------------------------");
            System.out.println("Choose option: ");
            System.out.println("1. Add new cargo to warehouse.");
            System.out.println("2. Remove cargo from warehouse.");
            System.out.println("3. Move cargo to another warehouse.");
            System.out.println("4. Display one of cargo.");
            System.out.println("5. Display overloaded warehouses");
            System.out.println("6. Display empty warehouses");
            System.out.println("7. Sort list by date");
            System.out.println("8. List of all cargo by category");
            System.out.println("9. Save in file");
            System.out.println("-------------------------------------");
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1:
                    Date date = new Date(2020,10,03);
                    Category category = Category.MERCHANDISE;
                    cargoList.add(new Cargo(category,"APPLE", 10, 20, warehouseList.get(0), date));
                    System.out.println("Cargo Added");
                    break;

                case 2:
                    System.out.println("Which cargo you want to remove");
                    Scanner scanner1 = new Scanner(System.in);
                    String word = scanner1.nextLine();
                    for (int i = 0; i < cargoList.size(); i++) {
                        if(word.equals(cargoList.get(i).getSpecificDescription())){
                            cargoList.remove(cargoList.get(i));
                            System.out.println(cargoList.get(i).getSpecificDescription()+" removed!");
                        }else{
                            System.out.println("We dont have this kind of cargo.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Which cargo you want to remove");
                    Scanner scanner2 = new Scanner(System.in);
                    String word1 = scanner2.nextLine();
                    for (int i = 0; i < cargoList.size(); i++) {
                        if(word1.equals(cargoList.get(i).getSpecificDescription())){
                            cargoList.remove(cargoList.get(i));
                            Category category1 = Category.MERCHANDISE;
                            Date date1 = new Date(2020,10,03);
                            cargoList.add(new Cargo(category1,"jabka", 10, 20, warehouseList.get(1), date1));
                            System.out.println(cargoList.get(i).getSpecificDescription()+" moved to the second warehouse!");
                        }else{
                            System.out.println("We dont have this kind of cargo.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Which cargo you want to see?");
                    for (int i = 0; i < cargoList.size(); i++) {
                        System.out.println(cargoList.get(i).getSpecificDescription());
                    }
              
                    String word3 = scanner.nextLine();
                    for (int i = 0; i < cargoList.size(); i++) {
                        if(word3.equals(cargoList.get(i).getSpecificDescription())){
                            System.out.println(cargoList.get(i).toString());
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < warehouseList.size(); i++) {
                        int warehouseCapacity = warehouseList.get(i).getCapacity();
                        int cargosWeight=0;
                        for (int j = 0; j < cargoList.size(); j++) {
                            String mag1 = cargoList.get(j).getWarehouse().getLocation();
                            String mag2 = warehouseList.get(i).getLocation();
                            if(mag1.equals(mag2)){
                                cargosWeight+=cargoList.get(j).getMassOfSinglePackage()*cargoList.get(j).getNumberOfPackages();
                            }
                        }
                        float temp =warehouseCapacity*4/5;
                        if(cargosWeight>temp){
                            System.out.println(warehouseList.get(i));
                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < warehouseList.size(); i++) {
                        int warehouseCapacity1 = warehouseList.get(i).getCapacity();
                        int cargosWeight1=0;
                        for (int j = 0; j < cargoList.size(); j++) {
                            if(cargoList.get(j).getWarehouse().getLocation().equals(warehouseList.get(i).getLocation())){
                                cargosWeight1+=cargoList.get(j).getMassOfSinglePackage()*cargoList.get(j).getNumberOfPackages();
                            }
                        }
                        float temp =warehouseCapacity1/5;
                        if(cargosWeight1<temp){
                            System.out.println(warehouseList.get(i));
                        }
                    }
                    break;
                case 7:

//                    Collections.sort(cargoList, new Comparator<Cargo>() {
//                        @Override
//                        public int compare(Cargo o1, Cargo o2) {
//                            if(o1.getArrivalDate()==null || o2.getArrivalDate()==null){
//                                return 0;
//
//                            }else{
//                                System.out.println(o1.getArrivalDate().compareTo(o2.getArrivalDate()));
//                                return o1.getArrivalDate().compareTo(o2.getArrivalDate());
//                            }
//
//                        }
//                    });
//
//                    cargoList.sort(Comparator.comparing(Cargo::getArrivalDate));

                    Comparator<Cargo> comparator=(o1, o2)-> Long.valueOf(o1.getArrivalDate().getTime()).compareTo(o2.getArrivalDate().getTime());
                    Collections.sort(cargoList,comparator);
                    cargoList.forEach(System.out::println);
                    break;
                case 8:
                    System.out.println("Choose category type of cargo: ");
                    Scanner scanner4 = new Scanner(System.in);
                    String word4 = scanner4.nextLine();
                    for (int i = 0; i < cargoList.size(); i++) {
                        if(word4.equals(cargoList.get(i).getCategory().toString())){
                            System.out.println(cargoList.get(i).toString());
                        }else {
                            System.out.println("We dont have this type of material");
                        }
                    }
                    break;
                case 9:
                    File currDir = new File(".");
                    String path = currDir.getAbsolutePath();
                    String fileLocation2 = path.substring(0, path.length() - 1)+"src/main/java/com/example/exercise/cargo1.csv";
                    FileWriter writer = new FileWriter(fileLocation2);
                    BufferedWriter bw = new BufferedWriter(writer);
                    for (int i = 0; i < cargoList.size(); i++) {
                        bw.write(cargoList.get(i).getCategory()+","+
                                     cargoList.get(i).getSpecificDescription()+","+
                                     cargoList.get(i).getMassOfSinglePackage()+","+
                                     cargoList.get(i).getNumberOfPackages()+","+
                                     cargoList.get(i).getWarehouse().getLocation()+","+
                                     cargoList.get(i).getArrivalDate());
                        bw.newLine();
                    }
                        bw.close();
                    writer.close();

                    File currDir1 = new File(".");
                    String path1 = currDir1.getAbsolutePath();
                    String fileLocation3 = path1.substring(0, path.length() - 1)+"src/main/java/com/example/exercise/warehouse1.csv";
                    FileWriter writer1 = new FileWriter(fileLocation3);
                    BufferedWriter bw1 = new BufferedWriter(writer1);
                    for (int i = 0; i < warehouseList.size(); i++) {
                        bw1.write(warehouseList.get(i).getLocation()+","+warehouseList.get(i).getCapacity());
                        bw1.newLine();
                    }
                    bw1.close();
                    writer1.close();
                    break;
            }
        }



    }

    private static void uploadDataFromCSV(List<Cargo> cargoList, List<Warehouse> warehouseList) throws IOException {
        String cargoFile = "cargo.csv";
        String warehouseFile = "warehouse.csv";

        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation1 = path.substring(0, path.length() - 1)+"src/main/java/com/example/exercise/"+ warehouseFile;
        String fileLocation2 = path.substring(0, path.length() - 1)+"src/main/java/com/example/exercise/"+ cargoFile;

        try(BufferedReader br = new BufferedReader(new FileReader(fileLocation1))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                warehouseList.add(new Warehouse(values[0],Integer.parseInt(values[1])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("blad");
        }

        try(BufferedReader br1= new BufferedReader(new FileReader(fileLocation2))) {
            String line1 = "";
            int i=0;
            while ((line1 = br1.readLine()) != null) {
                String[] values1 = line1.split(",");
                Date date = new Date(values1[5]);

                cargoList.add(new Cargo(Category.valueOf(values1[0]), values1[1], Integer.parseInt(values1[2]), Integer.parseInt(values1[3]), warehouseList.get(0), date));
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("blad");
        }
    }

}
