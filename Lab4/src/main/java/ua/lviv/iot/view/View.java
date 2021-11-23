package ua.lviv.iot.view;


import ua.lviv.iot.controller.impl.*;
import ua.lviv.iot.model.entity.*;

import java.util.Scanner;

public class View {
    private static final String ERROR_INVALID_KEY_INPUT = ViewOperations.ERROR_INVALID_KEY_INPUT;
    private static final String EXIT_KEY = ViewOperations.EXIT_KEY;
    private static final String ADRESS          = "0";
    private static final String BATTERY         = "1";
    private static final String ENERGY          = "2";
    private static final String OWNER           = "3";
    private static final String PANEL           = "4";
    private static final String SOLAR_SYSTEM    = "5";
    private static final String GET_ALL         = "GA";
    private static final String GET_BY_ID       = "GI";
    private static final String UPDATE          = "U";
    private static final String CREATE          = "C";
    private static final String DELETE          = "D";
    static Scanner input = new Scanner(System.in);
    private static void printSeparator() {
        System.out.println("--------------------------------------");
    }

    private static String printMainMenu() {
        System.out.println("Choose table to work with:");
        System.out.println(ADRESS + "-" + "Adress");
        System.out.println(BATTERY + "-" + "Battery");
        System.out.println(ENERGY + "-" + "Energy");
        System.out.println(OWNER + "-" + "Owner");
        System.out.println(PANEL + "-" + "Panel");
        System.out.println(SOLAR_SYSTEM + "-" + "SolarSystem");
        System.out.println(EXIT_KEY + "-" + "Exit");
        return input.nextLine().toUpperCase();
    }

    private static String printTableMenu() {
        System.out.println("Choose what to do");
        System.out.println(GET_ALL + "-" + "Get all rows");
        System.out.println(GET_BY_ID + "-" + "Get row by id");
        System.out.println(UPDATE + "-" + "Update row");
        System.out.println(CREATE + "-" + "Create row");
        System.out.println(DELETE + "-" + "Delete row");
        System.out.println(EXIT_KEY + "-" + "Return to main menu");
        return input.nextLine().toUpperCase();
    }

    public static void execute() {

        main_label:
        while (true) {
            Class currentClass;
            AbstractControllerImpl controller;
            ViewOperations viewOperations;

            String mainMenuInput = printMainMenu();
            switch (mainMenuInput) {
                case ADRESS:
                    currentClass = Adress.class;
                    controller = new AdressControllerImpl();
                    break;
                case BATTERY:
                    currentClass = Battery.class;
                    controller = new BatteryControllerImpl();
                    break;
                case ENERGY:
                    currentClass = Energy.class;
                    controller = new EnergyControllerImpl();
                    break;
                case OWNER:
                    currentClass = Owner.class;
                    controller = new OwnerControllerImpl();
                    break;
                case PANEL:
                    currentClass = Panel.class;
                    controller = new PanelControllerImpl();
                    break;
                case SOLAR_SYSTEM:
                    currentClass = SolarSystem.class;
                    controller = new SolarSystemControllerImpl();
                    break;
                case EXIT_KEY:
                    break main_label;
                default:
                    System.out.println(ERROR_INVALID_KEY_INPUT);
                    continue;
            }
            printSeparator();
            viewOperations = new ViewOperations(controller, currentClass);
            table_label:
            while (true) {
                System.out.println("You are working with " + currentClass.getSimpleName() + " table");
                String tableMenuInput = printTableMenu();
                printSeparator();
                switch (tableMenuInput) {
                    case GET_ALL:
                        viewOperations.getAll();
                        break;
                    case GET_BY_ID:
                        viewOperations.get();
                        break;
                    case UPDATE:
                        viewOperations.update();
                        break;
                    case CREATE:
                        viewOperations.create();
                        break;
                    case DELETE:
                        viewOperations.delete();
                        break;
                    case EXIT_KEY:
                        break table_label;
                    default:
                        System.out.println(ERROR_INVALID_KEY_INPUT);
                }
                printSeparator();
            }
        }
    }

}
