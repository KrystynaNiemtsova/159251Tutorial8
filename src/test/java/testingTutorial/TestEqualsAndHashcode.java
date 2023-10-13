package testingTutorial;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestEqualsAndHashcode {
    private Lecturer lecturer1;
    private Lecturer lecturer2;
    private Lecturer lecturer3;
    private Lecturer lecturer4;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    @Before public void setUp() {
        lecturer1 = new Lecturer(1, "Tim", "McGill");
        lecturer2 = new Lecturer(2, "Tom", "McGill");
        lecturer3 = new Lecturer(2, "Tom", "Heart");
        lecturer4 = new Lecturer(1, "Tim", "McGill");
        student1 = new Student(1, "Matt", "Harlo");
        student2 = new Student(2, "Karl", "Sharl");
        student3 = new Student(2, "Karl", "Sharl");
        student4 = new Student(2, "Karl", "Hill");
    }
    @Test
    public void lecturerEqualandHash() {
        assertEquals(lecturer1, lecturer4);
        assertEquals(lecturer1.hashCode(), lecturer4.hashCode());

        assertNotEquals(lecturer1.hashCode(), lecturer3.hashCode());
        assertNotEquals(lecturer1, lecturer3);

        assertNotEquals(lecturer2.hashCode(), lecturer3.hashCode());
        assertNotEquals(lecturer2, lecturer3);
    }
    @Test
    public void studentEqualandHash() {
        assertEquals(student2, student3);
        assertEquals(student2.hashCode(), student3.hashCode());

        assertNotEquals(student1.hashCode(), student2.hashCode());
        assertNotEquals(student1, student2);

        assertNotEquals(student2.hashCode(), student4.hashCode());
        assertNotEquals(student2, student4);
    }
}