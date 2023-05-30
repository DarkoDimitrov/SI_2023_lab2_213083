# Втора лабораториска вежба по Софтверско инженерство
## Дарко Димитров 213083
### Control Flow Graph
![CFG  MConverter eu](https://github.com/DarkoDimitrov/SI_2023_lab2_213083/assets/128037328/8834541f-9012-4667-bc8d-4343b9f978b8)
### Цикломатска комплексност
Цикломатската комплексност се пресметува со формулата за региони r = e - v + 2, каде е е бројот на ребра, v е бројот на темиња, така што цикломатската комплексност е r = 34 - 23 + 2 = 13
### Every Branch
Бројот на јазлите може да се види во кодот искоментирани се во самите линии
![image](https://github.com/DarkoDimitrov/SI_2023_lab2_213083/assets/128037328/b2a30a5d-b321-4f31-ba49-bf76a7974262)

Со првиот тест се изминуваат најголемиот дел од гранките. Само гранките 1-2, 3-5, 5-11, 11-12, 12-19, 14-18, 16-17,  17-19, 2-19 остануваат не изминати.

Со вториот тест се изминуваат 3-5, 5-11 и 14-18. Јазлите 1-2, 11-12, 12-19, 16-17, 17-19, 2-19 остануваат не изминати.

Со третиот и четвртиот тест се изминуваат 11-12, 12-19 и 16-17, 17-19 соодветно.За овие ребра неопходно е два посебни тестови поради return statementot во јазлите.

Со петтиот тест се изминуваат ребрата 1-2 и 2-19 кои го опфаќаат случајот за исклучокот.

Со овие тестови се опфаќаат сите ребра.



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
    
### Multiple Condition
if (user==null || user.getPassword()==null || user.getEmail()==null)

Во овој услов има 3 подуслови што значи дека има 2^3 односно 8 комбинации кои треба да се испитаат.

Поради логичкиот оператор “или“ помеѓу изразите некои од овие комбинации се преклопуваат конкретно ако првиот услов е исполнет нема потреба другите два да се проверуваат исто ако вториот услов е исполнет не е важно каков ке биде исходот од третиот подуслов.

Сумаризирано доаѓаме до 4 комбинации кои треба да се проверат:

TXX

FTX

FFX

FFF

Овие комбинации се тестирани со следните тестови:



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
