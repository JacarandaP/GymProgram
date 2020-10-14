import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Jacaranda Perez
 * Date: 2020-10-10
 * Project: GymProgram
 */


class ClientTest {

    LocalDate today = LocalDate.now();
    Client clientTest = new Client("7603021234", "Alhambra Aromes", LocalDate.parse("2019-10-15"));
    Client clientTest2 = new Client("7603021234", "Alhambra Amores", LocalDate.parse("2020-10-01"));
    Client clientTest3 = new Client("7603021234", "Alhambra Amores", LocalDate.parse("2020-05-01"));


    Client clientTest4 = new Client("7603021234", "Alhambra Aromes", LocalDate.parse("2015-12-01"));
    Client clientTest5 = new Client("7603021234", "Alhambra Amores", LocalDate.parse("2016-11-01"));
    Client clientTest6 = new Client("7603021234", "Alhambra Amores", LocalDate.parse("2017-11-01"));

    @Test
    public final void hasValidMembership(){

        assertTrue(clientTest.hasValidMembership(today));
        assertTrue(clientTest2.hasValidMembership(today));
        assertTrue(clientTest3.hasValidMembership(today));
    }

    @Test
    public final void hasINValidMembership(){

        assertFalse(clientTest4.hasValidMembership(today));
        assertFalse(clientTest5.hasValidMembership(today));
        assertFalse(clientTest6.hasValidMembership(today));
    }
}