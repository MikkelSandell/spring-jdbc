package testrepo;

import com.example.demo.models.Employee;
import com.example.demo.repositories.IRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testrepo implements IRepository {

    ArrayList<Employee> allemply = new ArrayList<>(
            Arrays.asList(
                    new Employee(17,"hans","it",23,"10",1000,1000,10),
                    new Employee(12,"bo","it",23,"10",3000,16,30),
                    new Employee(15,"bob","it",23,"10",5000,107,40),
                    new Employee(18,"nick","it",23,"10",7000,112,10)
            )
    );
    @Override
    public List getAllEntities() {
        return allemply;
    }

    @Override
    public Object getSingleById(int id) {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }
}
