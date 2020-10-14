import javax.swing.*;
import java.time.LocalDate;

public class GymProgram {

   LocalDate dateToday = LocalDate.now();


ClientRegistry clientRegistry = new ClientRegistry("src/customers.txt");
VisitRegistry visitRegistry = new VisitRegistry("src/gymClientsTrainingHistory.txt");


public Client findClient() {

    String input = JOptionPane.showInputDialog("Please enter the client's name or personal number");
    if (input == null) {
        System.exit(0);
    }
    input = input.trim();
    if (input.matches("[0-9]+")) {
        return clientRegistry.findByPersonNumber(input);
    }
    else {
        return clientRegistry.findByName(input);
    }
}

public boolean shouldRegisterVisit(){
    int selection = JOptionPane.showConfirmDialog(null, "Do you want to register this visit to the gym?", "Registration", JOptionPane.YES_NO_OPTION);
    if(selection == JOptionPane.YES_OPTION){
        return true;
    }
    return false;
}

public void registerVisit(Client client) {
    try {
        visitRegistry.registerVisit(client);
        JOptionPane.showMessageDialog(null, "Visit registered");


    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Visit couldn't be registered");
        e.printStackTrace();
    }
}
    public void myMain() {

    Client foundClient = findClient();
        if (foundClient == null) {
            JOptionPane.showMessageDialog(null, "The person is not a client");
        }
        else {
            if (foundClient.hasValidMembership(dateToday)) {
                JOptionPane.showMessageDialog(null, "The client has a valid membership");
                if(shouldRegisterVisit()) {
                    registerVisit(foundClient);
                }
            } else {
                JOptionPane.showMessageDialog(null, "The client has an expired membership");
            }
        }
    }

    public static void main(String[] args) {
        GymProgram gymProgram = new GymProgram();

        while(true) {
            gymProgram.myMain();
        }

    }
}