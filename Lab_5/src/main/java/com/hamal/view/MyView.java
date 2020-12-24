package com.hamal.view;


import com.hamal.controller.implementation.*;
import com.hamal.model.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


import java.sql.Timestamp;



public class MyView {

    private final AirlineController airlineController = new AirlineController();
    private final CurrentLocationController currentLocationController = new CurrentLocationController();
    private final StateController stateController = new StateController();
    private final PlaneInfoController planeInfoController = new PlaneInfoController();
    private final PlaneController planeController = new PlaneController();
    private final FlightController flightController = new FlightController();

    private Map<String,String> menu;
    private Map<String,Printable> methodsMenu;  //об'єкт інтерфейсу Printable для запуску методу print


    private static Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();


        menu.put("11", "11 - Get all airline");
        menu.put("12", "12 - Get airline by ID");
        menu.put("13", "13 - Delete airline by ID");
        menu.put("14", "14 - Update airline by ID");
        menu.put("15", "15 - Create airline\n");

        menu.put("21", "21 - Get all current plane location");
        menu.put("22", "22 - Get current plane location by ID");
        menu.put("23", "23 - Delete current plane location by ID");
        menu.put("24", "24 - Update current plane location by ID");
        menu.put("25", "25 - Create current plane location\n");

        menu.put("31", "31 - Get all plane information");
        menu.put("32", "32 - Get plane information by ID");
        menu.put("33", "33 - Delete plane information by ID");
        menu.put("34", "34 - Update plane information by ID");
        menu.put("35", "35 - Create plane information location\n");

        menu.put("41", "41 - Get all state");
        menu.put("42", "42 - Get state by ID");
        menu.put("43", "43 - Delete state by ID");
        menu.put("44", "44 - Update state by ID");
        menu.put("45", "45 - Create state\n");

        menu.put("51", "51 - Get all flight");
        menu.put("52", "52 - Get flight by ID");
        menu.put("53", "53 - Delete flight by ID");
        menu.put("54", "54 - Update flight by ID");
        menu.put("55", "55 - Create flight\n");

        menu.put("61", "61 - Get all plane");
        menu.put("62", "62 - Get plane by ID");
        menu.put("63", "63 - Delete plane by ID");
        menu.put("64", "64 - Update plane by ID");
        menu.put("65", "65 - Create plane\n");


        menu.put("Q", "Q - exit\n");

                                                            // запаковується метод в  об'єкт інтерфейсу Printable (переназиває себе не метод print)
        methodsMenu.put("11", this::getAllAirline);         // У виведенні меню викликається print
        methodsMenu.put("12", this::getAirlineById);
        methodsMenu.put("13", this::deleteAirlineById);
        methodsMenu.put("14", this::updateAirlineById);
        methodsMenu.put("15", this::createAirline);

        methodsMenu.put("21", this::getAllCurrentLocation);
        methodsMenu.put("22", this::getCurrentLocationById);
        methodsMenu.put("23", this::deleteCurrentLocationById);
        methodsMenu.put("24", this::updateCurrentLocationById);
        methodsMenu.put("25", this::createCurrentLocation);

        methodsMenu.put("31", this::getAllPlaneInfo);
        methodsMenu.put("32", this::getPlaneInfoById);
        methodsMenu.put("33", this::deletePlaneInfoById);
        methodsMenu.put("34", this::updatePlaneInfoById);
        methodsMenu.put("35", this::createPlaneInfo);

        methodsMenu.put("41", this::getAllState);
        methodsMenu.put("42", this::getStateById);
        methodsMenu.put("43", this::deleteStateById);
        methodsMenu.put("44", this::updateStateById);
        methodsMenu.put("45", this::createState);

        methodsMenu.put("51", this::getAllFlight);
        methodsMenu.put("52", this::getFlightById);
        methodsMenu.put("53", this::deleteFlightById);
        methodsMenu.put("54", this::updateFlightById);
        methodsMenu.put("55", this::createFlight);

        methodsMenu.put("61", this::getAllPlane);
        methodsMenu.put("62", this::getPlaneById);
        methodsMenu.put("63", this::deletePlaneById);
        methodsMenu.put("64", this::updatePlaneById);
        methodsMenu.put("65", this::createPlane);


    }

//--------------AIRLINE FUNCTIONS---------------------

    private void getAllAirline() throws SQLException{
        System.out.println("\nTable: Airline");
        airlineController.getAllEntities();
    }

    private void getAirlineById() throws SQLException {
        System.out.println("Enter Airline ID:");
        int id = input.nextInt();
        airlineController.getEntity(id);
    }

    private void deleteAirlineById() throws SQLException {
        System.out.println("Enter ID to delete Airline: ");
        int id = input.nextInt();
        airlineController.removeEntity(id);
    }


    private void createAirline() throws SQLException {
        Airline entity  = new Airline();

        System.out.println("Enter new airline id: ");
        int id = input.nextInt();
        entity.setId(id);

        input.nextLine();

        System.out.println("Enter new airline name: ");
        String name = input.nextLine();
        entity.setName(name);


        airlineController.createEntity(entity);

    }

    private void updateAirlineById() throws SQLException {
        Airline entity  = new Airline();


        System.out.println("Enter airline id to update: ");
        int id = input.nextInt();
        entity.setId(id);

        input.nextLine();

        System.out.println("Enter new airline name: ");
        String name = input.nextLine();
        entity.setName(name);

        airlineController.updateEntity(entity);
    }
//-------------------------------------------------------

//----------------CURRENT LOCATION FUNCTIONS-------------

    private void getAllCurrentLocation() throws SQLException{
        System.out.println("\nTable: Current Location");
        currentLocationController.getAllEntities();
    }

    private void getCurrentLocationById() throws SQLException {
        System.out.println("Enter Current Location ID:");
        int id = input.nextInt();
        currentLocationController.getEntity(id);
    }

    private void deleteCurrentLocationById() throws SQLException {

        System.out.println("Enter ID to delete CurrentLocation: ");
        int id = input.nextInt();
        currentLocationController.removeEntity(id);
    }


    private void createCurrentLocation() throws SQLException {

        CurrentLocation entity  = new CurrentLocation();

        System.out.println("Enter new current location id: ");
        int id = input.nextInt();
        entity.setId(id);
        input.nextLine();

        System.out.println("Enter new current location country: ");
        String country = input.nextLine();
        entity.setCountry(country);


        System.out.println("Enter new current location city: ");
        String city = input.nextLine();
        entity.setCity(city);

        System.out.println("Enter new current location airport: ");
        String airportLocation = input.nextLine();
        entity.setAirport(airportLocation);

        currentLocationController.createEntity(entity);
    }

    private void updateCurrentLocationById() throws SQLException {
        CurrentLocation entity  = new CurrentLocation();


        System.out.println("Enter current location id to update: ");
        int id = input.nextInt();
        entity.setId(id);
        input.nextLine();

        System.out.println("Enter new name for country: ");
        String country = input.nextLine();
        entity.setCountry(country);

        System.out.println("Enter new name for city: ");
        String city = input.nextLine();
        entity.setCity(city);

        System.out.println("Enter new name for airport: ");
        String airport = input.nextLine();
        entity.setAirport(airport);

        currentLocationController.updateEntity(entity);

    }
//-------------------------------------------------------

//----------------PLANE INFO FUNCTIONS-------------------

    private void getAllPlaneInfo() throws SQLException{

        System.out.println("\nTable: plane_info");
        planeInfoController.getAllEntities();
    }

    private void getPlaneInfoById() throws SQLException {
        System.out.println("Enter plane ID:");
        int id = input.nextInt();
        input.nextLine();
        planeInfoController.getEntity(id);
    }

    private void deletePlaneInfoById() throws SQLException {
        System.out.println("Enter plane ID to delete: ");
        int id = input.nextInt();
        input.nextLine();
        planeInfoController.removeEntity(id);
    }


    private void createPlaneInfo() throws SQLException {

        PlaneInfo entity  = new PlaneInfo();

        System.out.println("Enter new Plane Id: ");
        int id = input.nextInt();
        input.nextLine();
        entity.setPlaneId(id);

        System.out.println("Enter new Plane Identifier: ");
        String planeIdentifier = input.nextLine();
        entity.setPlaneIdentifier(planeIdentifier);

        System.out.println("Enter new type of plane: ");
        String type = input.nextLine();
        entity.setType(type);

        System.out.println("Enter new total hours: ");
        int totalHours = input.nextInt();
        entity.setTotalHrs(totalHours);

        System.out.println("Enter new maximum speed: ");
        int maximumSpeed = input.nextInt();
        entity.setMaxSpeed(maximumSpeed);

        planeInfoController.createEntity(entity);

    }

    private void updatePlaneInfoById() throws SQLException {
        PlaneInfo entity  = new PlaneInfo();
        System.out.println("Enter current plane id to update: ");
        int id = input.nextInt();
        input.nextLine();
        entity.setPlaneId(id);

        System.out.println("Enter new Plane Identifier: ");
        String planeIdentifier = input.nextLine();
        entity.setPlaneIdentifier(planeIdentifier);

        System.out.println("Enter new type of plane: ");
        String type = input.nextLine();
        entity.setType(type);

        System.out.println("Enter new total hours: ");
        int totalHours = input.nextInt();
        entity.setTotalHrs(totalHours);

        System.out.println("Enter new maximum speed: ");
        int maximumSpeed = input.nextInt();
        entity.setMaxSpeed(maximumSpeed);

        planeInfoController.updateEntity(entity);


    }
    //-------------------------------------------------------

    //----------------STATE  FUNCTIONS-----------------------
    private void getAllState() throws SQLException{
        System.out.println("\nTable: Current Location");
        stateController.getAllEntities();
    }

    private void getStateById() throws SQLException {

        System.out.println("Enter state ID:");
        int id = input.nextInt();
        currentLocationController.getEntity(id);

    }

    private void deleteStateById() throws SQLException {
        System.out.println("Enter state ID to delete: ");
        int id = input.nextInt();
        stateController.removeEntity(id);
    }


    private void createState() throws SQLException {

        State entity  = new State();

        System.out.println("Enter new state id: ");
        int id = input.nextInt();
        entity.setId(id);

        input.nextLine();

        System.out.println("Enter new state name: ");
        String name = input.nextLine();
        entity.setState(name);

        stateController.createEntity(entity);
    }

    private void updateStateById() throws SQLException {

        State entity  = new State();


        System.out.println("Enter state id to update: ");
        int id = input.nextInt();
        entity.setId(id);

        input.nextLine();

        System.out.println("Enter new state name: ");
        String name = input.nextLine();
        entity.setState(name);

        stateController.updateEntity(entity);
    }

//-------------------------------------------------------
//----------------FLIGHT FUNCTIONS-----------------------
private void getAllFlight() throws SQLException{
    System.out.println("\nTable: flight");
    flightController.getAllEntities();
}

    private void getFlightById() throws SQLException {
        System.out.println("Enter flight ID:");
        int id = input.nextInt();
        input.nextLine();
        flightController.getEntity(id);
    }

    private void deleteFlightById() throws SQLException {
        System.out.println("Enter flight ID to delete: ");
        int id = input.nextInt();
        flightController.removeEntity(id);
    }
    private void createFlight() throws SQLException {
        Flight entity  = new Flight();
        Plane entity1 = new Plane();
        State entity2 = new State();

        System.out.println("Enter new plane Id: ");
        int planeId = input.nextInt();
        input.nextLine();
        entity.setId(planeId);

        System.out.println("Enter new flight number: ");
        String flightNumber = input.nextLine();
        entity.setFlightNumber(flightNumber);

        System.out.println("Enter new direction: ");
        String direction = input.nextLine();
        entity.setDirection(direction);

        System.out.println("Enter new departure time  in format yyyy-[m]m-[d]d hh:mm:ss[.f...]: ");
        String departure = input.nextLine();
        entity.setDepartureTime(Timestamp.valueOf(departure));

        System.out.println("Enter new arrival time  in format yyyy-[m]m-[d]d hh:mm:ss[.f...]: ");
        String arrival = input.nextLine();
        entity.setArrivalTime(Timestamp.valueOf(arrival));

        System.out.println("Enter  Plane Id: ");
        int plane_id = input.nextInt();
        entity1.setId(plane_id);
        entity.setPlaneByPlaneId(entity1);

        System.out.println("Enter  State Id: ");
        int stateId = input.nextInt();
        entity2.setId(stateId);
        entity.setStateByStateId(entity2);

        flightController.createEntity(entity);

    }

    private void updateFlightById() throws SQLException {
        Flight entity  = new Flight();
        Plane entity1 = new Plane();
        State entity2 = new State();

        System.out.println("Enter  plane Id to update: ");
        int planeId = input.nextInt();
        input.nextLine();
        entity.setId(planeId);

        System.out.println("Enter new flight number: ");
        String flightNumber = input.nextLine();
        entity.setFlightNumber(flightNumber);

        System.out.println("Enter new direction: ");
        String direction = input.nextLine();
        entity.setDirection(direction);

        System.out.println("Enter new departure time  in format yyyy-[m]m-[d]d hh:mm:ss[.f...]: ");
        String departure = input.nextLine();
        entity.setDepartureTime(Timestamp.valueOf(departure));

        System.out.println("Enter new arrival time  in format yyyy-[m]m-[d]d hh:mm:ss[.f...]: ");
        String arrival = input.nextLine();
        entity.setArrivalTime(Timestamp.valueOf(arrival));

        System.out.println("Enter  Plane Id: ");
        int plane_id = input.nextInt();
        entity1.setId(plane_id);
        entity.setPlaneByPlaneId(entity1);

        System.out.println("Enter  State Id: ");
        int stateId = input.nextInt();
        entity2.setId(stateId);
        entity.setStateByStateId(entity2);




        flightController.updateEntity(entity);

    }
//-------------------------------------------------------




    //----------------PLANE  FUNCTIONS-----------------------
    private void getAllPlane() throws SQLException{
        System.out.println("\nTable: plane");
        planeController.getAllEntities();
    }

    private void getPlaneById() throws SQLException {
        System.out.println("Enter plane ID:");
        int id = input.nextInt();
        input.nextLine();
        planeController.getEntity(id);
    }

    private void deletePlaneById() throws SQLException {
        System.out.println("Enter ID to delete plane: ");
        int id = input.nextInt();
        input.nextLine();
        planeController.removeEntity(id);
    }


    private void createPlane() throws SQLException {
        Plane entity  = new Plane();
        Airline entity1 = new Airline();
        CurrentLocation entity2 = new CurrentLocation();

        System.out.println("Enter new Id: ");
        int Id = input.nextInt();
        entity.setId(Id);

       System.out.println("Enter  airline Id: ");
       int airlineId = input.nextInt();
       entity1.setId(airlineId);

        System.out.println("Enter  currentLocation Id: ");
        int currentLocationId = input.nextInt();
        entity2.setId(currentLocationId);

        entity.setAirlineByAirlineId(entity1);
        entity.setCurrentLocationByCurrentLocationId(entity2);

        planeController.createEntity(entity);
    }

    private void updatePlaneById() throws SQLException {
        Plane entity  = new Plane();
        Airline entity1 = new Airline();
        CurrentLocation entity2 = new CurrentLocation();

        System.out.println("Enter Id to update: ");
        int Id = input.nextInt();
        entity.setId(Id);

        System.out.println("Enter  airline Id: ");
        int airlineId = input.nextInt();
        entity1.setId(airlineId);

        System.out.println("Enter  currentLocation Id: ");
        int currentLocationId = input.nextInt();
        entity2.setId(currentLocationId);

        entity.setAirlineByAirlineId(entity1);
        entity.setCurrentLocationByCurrentLocationId(entity2);

        planeController.updateEntity(entity);
    }


//-------------------------------------------------------
//------------------- MENU ------------------------------

    private  void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet()) {
                System.out.println(menu.get(key));
        }
    }

    public  void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point:");
            keyMenu = input.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {}
        } while (!keyMenu.equals("Q"));


    }

}
