import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SoftwareTesting2020Test {

//    class MyDatabasestub implements NCTUDatabase {
//        public int getScore(String StudentId){
//            return 95;
//        }
//    }
    class MypaypalService implements paypalService {
        public String doDonate(){
            return "succeed";
        }
    }


    @Mock
    private Date dateStub;
    @Spy private Hospital hospitalstub;
    @Spy private NCTUDatabase databaseStub;

    private MypaypalService papalStub;

    @InjectMocks
    private SoftwareTesting2020 softwareTesting2020 = new SoftwareTesting2020();


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }



    @Test
    void test_a() throws InterruptedException {
        Student student_fev = new Student("168168168", 39);
        System.out.println(student_fev.getStudentId());
        System.out.println(student_fev.getTemperature());

//        dateStub = mock(Date.class);
//        doReturn(5).when(dateStub).getWeekday();
        when(dateStub.getWeekday()).thenReturn(4);
//        hospitalstub = mock(Hospital.class);

        System.out.println(softwareTesting2020.enterClass(student_fev));
        verify(hospitalstub, never()).treatment(student_fev);
    }

    @Test
    void test_b() throws InterruptedException {
        Student student_fev = new Student("168168168", 39);
        System.out.println(student_fev.getStudentId());
        System.out.println(student_fev.getTemperature());


        when(dateStub.getWeekday()).thenReturn(5);
//        hospitalstub = mock(Hospital.class);
        doNothing().when(hospitalstub).isolation(any(Student.class));

        System.out.println(softwareTesting2020.enterClass(student_fev));
        assertEquals("After a long time treatment. The student can get out! ^__^", softwareTesting2020.enterClass(student_fev));

    }

    @Test
    void test_c() throws InterruptedException {
        Student student_fev1 = new Student("168168000", 39);
        System.out.println(student_fev1.getStudentId());
        System.out.println(student_fev1.getTemperature());

        Student student_fev2 = new Student("168168168", 38);
        System.out.println(student_fev2.getStudentId());
        System.out.println(student_fev2.getTemperature());

        Student student_fev3 = new Student("168000000", 37);
        System.out.println(student_fev3.getStudentId());
        System.out.println(student_fev3.getTemperature());

        Hospital hospital = new Hospital();
        Hospital spy = spy(hospital);
        doNothing().when(spy).isolation(any(Student.class));

        spy.treatment(student_fev1);
        spy.treatment(student_fev2);
        spy.treatment(student_fev3);

        System.out.println(spy.getLog());
        assertEquals(asList("168168000", "168168168", "168000000"), spy.getLog());

    }

    @Test
    void test_d() {

        when(databaseStub.getScore("168168168")).thenReturn(95);

        System.out.println(softwareTesting2020.getScore("168168168"));
        assertEquals(95, softwareTesting2020.getScore("168168168"));
    }

    @Test
    void test_e() {
        Student student_fev = new Student("168168168", 39);
        System.out.println(student_fev.getStudentId());
        System.out.println(student_fev.getTemperature());
        papalStub = new MypaypalService();

        System.out.println(softwareTesting2020.donate(papalStub));
        assertEquals("Thanks you", softwareTesting2020.donate(papalStub));
    }
}