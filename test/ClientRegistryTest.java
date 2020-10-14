import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jacaranda Perez
 * Date: 2020-10-09
 * Project: GymProgram
 */

class ClientRegistryTest {

    ClientRegistry clientRegistry = new ClientRegistry("test/test_customers.txt");

    @Test
    public final void getClientListTest()  {
        List<Client> customersListT = clientRegistry.getClientList();
        List<Client> listTest = new ArrayList<>();
        Client clientTest1 = new Client("7603021234", "Alhambra Aromes", LocalDate.parse("2019-07-01"));
        Client clientTest2 = new Client("8104021234", "Bear Belle", LocalDate.parse("2018-12-02"));
        Client clientTest3 = new Client("8512021234", "Chamade Coriola", LocalDate.parse("2017-03-12"));
        listTest.add(clientTest1);
        listTest.add(clientTest2);
        listTest.add(clientTest3);

        assertEquals(customersListT.get(0), listTest.get(0));
        assertEquals(customersListT.get(1), listTest.get(1));
        assertEquals(customersListT.get(2), listTest.get(2));

    }

   @Test
    public final void findByNameTest(){
        Client foundClient1 =clientRegistry.findByName("Bear Belle");
        Client foundClient2 =clientRegistry.findByName("Alhambra Aromes");
        Client foundClient3 =clientRegistry.findByName("Chamade Coriola");
        assertEquals("Bear Belle", foundClient1.getName() );
        assertEquals("Alhambra Aromes", foundClient2.getName() );
        assertEquals("Chamade Coriola", foundClient3.getName() );
    }

    @Test
    public final void findByNameNotFoundTest(){
        Client foundClient1 =clientRegistry.findByName("Bear Bell");
        Client foundClient2 =clientRegistry.findByName("Alhambra");
        Client foundClient3 =clientRegistry.findByName("Coriola");
        assertNull(foundClient1);
        assertNull(foundClient2);
        assertNull(foundClient3);
    }

    @Test
    public final void findByNameCanHandleNullInputTest(){
        Client foundClient =clientRegistry.findByName(null);
        assertNull(foundClient);
    }
    @Test
    public final void findByPersonNumberTest(){
        Client foundClient =clientRegistry.findByPersonNumber("7603021234");
        assertEquals("7603021234", foundClient.getPersonnumber() );
    }

    @Test
    public final void findByPersonNumberNotFoundTest(){
        Client foundClient =clientRegistry.findByPersonNumber("7603021255");
        assertNull(foundClient);
    }
    @Test
    public final void findByPersonNumberCanHandleNullInputTest(){
        Client foundClient =clientRegistry.findByPersonNumber(null);
        assertNull(foundClient);
    }

}