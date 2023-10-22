package org.example;

import facade.CheckFacade;

public class Main {
    public static void main(String[] args) {
        CheckFacade cliente1 = new CheckFacade();
        cliente1.buscar("02/07/08", "25/07/12", "lima","cancun");

        CheckFacade cliente2 = new CheckFacade();
        cliente2.buscar("02/08/08", "02/09/12", "san jose","madrid");

    }
}