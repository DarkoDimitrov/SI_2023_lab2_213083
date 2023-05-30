import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    List<User>users=new ArrayList<>();

    @Test
    void everyBranchTest() {
        User user1 = new User(null, "asfrwvvsd123!0.", "darkodimitrov10@yahoo.com");
        User user2 = new User("Darko","1aa25!Ac34","darkogmail.com");
        User user3 = new User("Ana", "ana123", "ana@yahoo.com");
        User user4 = new User("Tode", "FSACefas!12345", "tode@yahoo.com");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //first test
        assertFalse(SILab2.function(user1, users));
        //second test
        assertFalse(SILab2.function(user2, users));
        //third test
        assertFalse(SILab2.function(user3, users));
        //fourth test
        assertTrue(SILab2.function(user4, users));
        //exception test
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }
    @Test
    void multipleConditionsTest(){
        User user1 = null;
        RuntimeException ex;
        User user2 = new User("Darko", null, "dimitrov@yahoo.com");
        User user3 = new User("Darko", "password", null);
        User user4 = new User("Darko", "password123!@", "dimitrov@hotmail.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        assertTrue(SILab2.function(user4, users));
    }

}