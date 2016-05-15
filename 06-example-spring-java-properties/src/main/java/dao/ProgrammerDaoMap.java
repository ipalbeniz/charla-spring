package dao;

import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmer Dao in memory Map implementation
 */
@Repository
public class ProgrammerDaoMap implements ProgrammerDao {

    @Value("${programmer.id}")
    private String id;

    @Value("${programmer.name}")
    private String name;

    @Value("${programmer.age}")
    private int age;

    @Autowired
    private Environment environment;

    private Map<String, Programmer> programmersById = new HashMap<String, Programmer>();

    @PostConstruct
    public void postConstruct() {
        Programmer programmer = new Programmer(id, environment.getProperty("programmer.name"), age);
        programmersById.put(programmer.getId(), programmer);

        programmer = new Programmer("lcroft", "Lara Croft", 27);
        programmersById.put(programmer.getId(), programmer);
    }

    public Programmer getById(String id) {
        return programmersById.get(id);
    }
}
