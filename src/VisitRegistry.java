import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;

/**
 * Created by Jacaranda Perez
 * Date: 2020-10-10
 * Project: GymProgram
 */

public class VisitRegistry {

    String trainingHistoryFileName;

    public VisitRegistry(String trainingHistoryFileName) {
    }

    public void registerVisit(Client client) throws IOException {
            String history = client.getPersonnumber() + "," + client.getName() + "," + LocalDate.now() + "\n";
            Path p = Paths.get(trainingHistoryFileName);
            Files.writeString(p,history, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        }

}