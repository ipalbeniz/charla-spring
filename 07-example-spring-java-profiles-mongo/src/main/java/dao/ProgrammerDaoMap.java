package dao;

import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Programmer Dao in memory Map implementation
 */
@Repository
@Profile("dev")
public class ProgrammerDaoMap implements ProgrammerDao {

    private Map<String, Programmer> programmersById = new HashMap<String, Programmer>();

    @PostConstruct
    public void postConstruct() {

        Programmer programmer = new Programmer("iperez", "Íñigo Montoya", 45);
        programmersById.put(programmer.getUsername(), programmer);

        programmer = new Programmer("lcroft", "Lara Croft", 27);
        programmersById.put(programmer.getUsername(), programmer);
    }

    public Programmer getById(String id) {
        return programmersById.get(id);
    }
}
