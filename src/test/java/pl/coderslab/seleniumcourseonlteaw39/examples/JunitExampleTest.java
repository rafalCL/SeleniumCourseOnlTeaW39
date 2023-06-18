package pl.coderslab.seleniumcourseonlteaw39.examples;

import org.junit.jupiter.api.*;

public class JunitExampleTest {
    @Test
    public void firstTest() {
        System.out.println("firstTest uruchomiony");
    }

    @Test
    public void secondTest() {
        System.out.println("secondTest uruchomiony");
    }

    @Disabled
    @Test
    public void disabledTest() {
        System.out.println("disabledTest uruchomiony");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("this will be run BEFORE EACH test");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("this will be run AFTER EACH test");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("this will be run BEFORE ALL tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("this will be run AFTER ALL tests");
    }
}
