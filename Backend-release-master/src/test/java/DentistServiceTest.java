import org.example.model.Dentist;
import org.example.repository.implementation.DentistImplementation;
import org.example.service.DentistService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class DentistServiceTest {

    private static final DentistService dentistService = new DentistService(new DentistImplementation());

    @BeforeClass
    public static void loadingData() {
        Dentist dentist = dentistService.save(new Dentist(123L, "Cosme", "Fulanito"));
        Dentist dentist1 = dentistService.save(new Dentist(3456L, "John", "Connor"));

    }

    @Test
    public void saveAndFindTest() {
        Dentist dentist = dentistService.save(new Dentist(2L,"Matias","Duarte"));

        Assert.assertNotNull(dentistService.findById(dentist.getId()));
    }

    @Test
    public void deleteDentistTest() {
        dentistService.deleteById(1);
        Assert.assertNull(dentistService.findById(1));

    }

    @Test
    public void findAllTest() {
        List<Dentist> dentists = dentistService.findAll();
        Assert.assertFalse(dentists.isEmpty());
        Assert.assertTrue(true);
        System.out.println(dentists);
    }
}
