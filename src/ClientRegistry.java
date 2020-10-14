import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jacaranda Perez
 * Date: 2020-10-10
 * Project: GymProgram
 */

public class ClientRegistry {

    final String filePath;

    public ClientRegistry(String filePath){

        this.filePath = filePath;
    }
    public List<Client> getClientList()  {

        List<Client> clientList = new ArrayList<>();
        try (
            Scanner cList = new Scanner(new File(filePath))) {
            while (cList.hasNext()) {
                String clientLine = cList.nextLine();
                String membershipLine = cList.nextLine();

                String[] clientParts = clientLine.split(",");

                String personNumber = clientParts[0].trim();
                String name = clientParts[1].trim();
                LocalDate membership = LocalDate.parse(membershipLine);

                Client client = new Client(personNumber, name, membership);
                clientList.add(client);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file");
            e.printStackTrace();
            System.exit(0);
        }

        return clientList;
    }

    /**
     *
     * @param name costumer's name as input from user
     * @return returns client if matching name, null if not match is found.
     */
    public Client findByName(String name)  {

        List<Client> clientList = getClientList();
        for(Client client: clientList) {
            if (client.getName().equalsIgnoreCase(name)) {
                return client;
            }
        }
        return null;
    }

    public Client findByPersonNumber(String personNumber)  {
        List<Client> clientList = getClientList();
        for(Client client: clientList) {
            if (client.getPersonnumber().equalsIgnoreCase(personNumber)) {
                return client;
            }
        }
        return null;
    }

}
