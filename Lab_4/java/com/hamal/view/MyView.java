package com.hamal.view;


import com.hamal.controller.implementation.*;
import com.hamal.model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class MyView {

    private final AirlineController airlineController = new AirlineController();
    private final CurrentLocationController currentLocationController = new CurrentLocationController();
    private final PlaneInfoController planeInfoController = new PlaneInfoController();
    private final StateController stateController = new StateController();
    private final FlightController flightController = new FlightController();
    private final PlaneController planeController = new PlaneController();


    private Map<String,String> menu;
    private Map<String,Printable> methodsMenu;          //об'єкт інтерфейсу Printable для запуску методу print


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
        airlineController.getAll();
    }

    private void getAirlineById() throws SQLException {
        System.out.println("Enter Airline ID:");
        int id = input.nextInt();
        input.nextLine();
        airlineController.getById(id);
    }

    private void deleteAirlineById() throws SQLException {
        System.out.println("Enter ID to delete Airline: ");
        int id = input.nextInt();

        airlineController.delete(id);
    }


    private void createAirline() throws SQLException {
        System.out.println("Enter new airline name: ");
        String name = input.nextLine();
        Airline entity = new Airline(0, name);
        airlineController.create(entity);
    }

    private void updateAirlineById() throws SQLException {

        System.out.println("Enter airline id to update: ");
        int id = input.nextInt();
        input.nextLine();

        Airline oldAirline = airlineController.getService().getById(id);
        System.out.println("Enter new name for airline: ");
        String name = input.nextLine();

        if (name.equals("")) name = oldAirline.getName();


        Airline entity = new Airline(id, name);
        airlineController.update(entity);
    }
//-------------------------------------------------------

//----------------CURRENT LOCATION FUNCTIONS-------------

private void getAllCurrentLocation() throws SQLException{

    System.out.println("\nTable: current_location");
    currentLocationController.getAll();
}

    private void getCurrentLocationById() throws SQLException {
        System.out.println("Enter current location ID:");
        int id = input.nextInt();
        input.nextLine();
        currentLocationController.getById(id);
    }

    private void deleteCurrentLocationById() throws SQLException {
        System.out.println("Enter ID to delete Airline: ");
        int id = input.nextInt();
        input.nextLine();
        currentLocationController.delete(id);
    }


    private void createCurrentLocation() throws SQLException {
        System.out.println("Enter new current location country: ");
        String country = input.nextLine();
        System.out.println("Enter new current location city: ");
        String city = input.nextLine();
        System.out.println("Enter new current location airport: ");
        String location = input.nextLine();

        CurrentLocation entity = new CurrentLocation(0,country, city,location);

        currentLocationController.create(entity);
    }

    private void updateCurrentLocationById() throws SQLException {

        System.out.println("Enter current location id to update: ");
        int id = input.nextInt();
        input.nextLine();

        CurrentLocation oldCurrentLocation = currentLocationController.getService().getById(id);


        System.out.println("Enter new name for country: ");
        String country = input.nextLine();

        System.out.println("Enter new name for city: ");
        String city = input.nextLine();

        System.out.println("Enter new name for airport: ");
        String airport = input.nextLine();

        if (country.equals("")) country = oldCurrentLocation.getCountry();
        if (city.equals("")) city = oldCurrentLocation.getCity();
        if (airport.equals("")) airport = oldCurrentLocation.getAirport();

        CurrentLocation entity = new CurrentLocation(id,country, city,airport);

        currentLocationController.update(entity);

    }
//-------------------------------------------------------

//----------------PLANE INFO FUNCTIONS-------------------

private void getAllPlaneInfo() throws SQLException{

    System.out.println("\nTable: plane_info");
    planeInfoController.getAll();
}

    private void getPlaneInfoById() throws SQLException {
        System.out.println("Enter plane ID:");
        int id = input.nextInt();
        input.nextLine();
        planeInfoController.getById(id);
    }

    private void deletePlaneInfoById() throws SQLException {
        System.out.println("Enter plane ID to delete: ");
        int id = input.nextInt();
        input.nextLine();
        planeInfoController.delete(id);
    }


    private void createPlaneInfo() throws SQLException {

        System.out.println("Enter new Plane Id: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.println("Enter new Plane Identifier: ");
        String planeIdentifier = input.nextLine();

        System.out.println("Enter new type of plane: ");
        String type = input.nextLine();

        System.out.println("Enter new total hours: ");
        int totalHours = input.nextInt();

        System.out.println("Enter new maximum speed: ");
        int maximumSpeed = input.nextInt();
        PlaneInfo entity = new PlaneInfo(id, planeIdentifier, type,totalHours,maximumSpeed);

        planeInfoController.create(entity);
    }

    private void updatePlaneInfoById() throws SQLException {

        System.out.println("Enter current plane id to update: ");
        int id = input.nextInt();
        input.nextLine();

        PlaneInfo oldPlaneInfo = planeInfoController.getService().getById(id);


        System.out.println("Enter new Plane Identifier: ");
        String planeIdentifier = input.nextLine();

        System.out.println("Enter new type of plane: ");
        String type = input.nextLine();

        System.out.println("Enter new total hours: ");
        int totalHours = input.nextInt();

        System.out.println("Enter new maximum speed: ");
        int maximumSpeed = input.nextInt();

        if (planeIdentifier.equals("")) planeIdentifier = oldPlaneInfo.getPlaneIdentifier();
        if (type.equals("")) type = oldPlaneInfo.getType();

        PlaneInfo entity = new PlaneInfo(id,planeIdentifier, type,totalHours,maximumSpeed);

        planeInfoController.update(entity);
    }
//-------------------------------------------------------

//----------------STATE  FUNCTIONS-----------------------
    private void getAllState() throws SQLException{

        System.out.println("\nTable: state");
        stateController.getAll();
    }

    private void getStateById() throws SQLException {
        System.out.println("Enter state ID:");
        int id = input.nextInt();
        input.nextLine();
        stateController.getById(id);
    }

    private void deleteStateById() throws SQLException {
        System.out.println("Enter state ID to delete: ");
        int id = input.nextInt();
        input.nextLine();
        stateController.delete(id);
    }


    private void createState() throws SQLException {
        System.out.println("Enter new state: ");
        String name = input.nextLine();
        State entity = new State(0, name);
        stateController.create(entity);
    }

    private void updateStateById() throws SQLException {

        System.out.println("Enter state id to update: ");
        int id = input.nextInt();
        input.nextLine();

        State oldState = stateController.getService().getById(id);
        System.out.println("Enter new state: ");
        String state = input.nextLine();
        if (state.equals("")) state = oldState.getState();
        State entity = new State(id, state);
        stateController.update(entity);
    }

//-------------------------------------------------------

//----------------FLIGHT FUNCTIONS-----------------------
private void getAllFlight() throws SQLException{
        System.out.println("\nTable: flight");
        flightController.getAll();
    }

    private void getFlightById() throws SQLException {
        System.out.println("Enter flight ID:");
        int id = input.nextInt();
        input.nextLine();
        flightController.getById(id);
    }

    private void deleteFlightById() throws SQLException {
        System.out.println("Enter flight ID to delete: ");
        int id = input.nextInt();
        flightController.delete(id);
    }


    private void createFlight() throws SQLException {
        System.out.println("Enter new plane Id: ");
        int planeId = input.nextInt();
        input.nextLine();

        System.out.println("Enter new flight number: ");
        String flightNumber = input.nextLine();

        System.out.println("Enter new direction: ");
        String direction = input.nextLine();

        System.out.println("Enter new departure time: ");
        String departureTime = input.nextLine();

        System.out.println("Enter new arrival time ");
        String arrivalTime = input.nextLine();

        System.out.println("Enter new state");
        int state = input.nextInt();

        Flight entity = new Flight(0, planeId,flightNumber,direction,departureTime,arrivalTime,state);
        flightController.create(entity);
    }

    private void updateFlightById() throws SQLException {

        System.out.println("Enter flight id to update: ");
        int id = input.nextInt();
        input.nextLine();

        Flight oldFlight = flightController.getService().getById(id);

        System.out.println("Enter new plane Id: ");
        int planeId = input.nextInt();
        input.nextLine();

        System.out.println("Enter new flight number: ");
        String flightNumber = input.nextLine();

        System.out.println("Enter new direction: ");
        String direction = input.nextLine();

        System.out.println("Enter new departure time: ");
        String departureTime = input.nextLine();

        System.out.println("Enter new arrival time ");
        String arrivalTime = input.nextLine();

        System.out.println("Enter new state: ");
        int state = input.nextInt();

        if (flightNumber.equals("")) flightNumber = oldFlight.getFlightNumber();
        if (direction.equals("")) direction = oldFlight.getDirection();
        if (departureTime.equals("")) departureTime = oldFlight.getDepartureTime();
        if (arrivalTime.equals("")) arrivalTime = oldFlight.getArrivalTime();


        Flight entity = new Flight(id, planeId,flightNumber,direction,departureTime,arrivalTime,state);
        flightController.update(entity);


    }
//-------------------------------------------------------

//----------------PLANE  FUNCTIONS-----------------------
private void getAllPlane() throws SQLException{
    System.out.println("\nTable: plane");
    planeController.getAll();
}

    private void getPlaneById() throws SQLException {
        System.out.println("Enter plane ID:");
        int id = input.nextInt();
        input.nextLine();
        planeController.getById(id);
    }

    private void deletePlaneById() throws SQLException {
        System.out.println("Enter ID to delete plane: ");
        int id = input.nextInt();
        input.nextLine();
        planeController.delete(id);
    }


    private void createPlane() throws SQLException {

        System.out.println("Enter new airline Id: ");
        int airlineId = input.nextInt();

        System.out.println("Enter new current location Id: ");
        int currentLocationId = input.nextInt();

        Plane entity = new Plane(0, airlineId,currentLocationId);
        planeController.create(entity);
    }

    private void updatePlaneById() throws SQLException {

        System.out.println("Enter Plane id to update: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("Enter new airline Id: ");
        int airlineId = input.nextInt();

        System.out.println("Enter new current location Id: ");
        int currentLocationId = input.nextInt();


        Plane entity = new Plane(id, airlineId,currentLocationId);
        planeController.update(entity);
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
