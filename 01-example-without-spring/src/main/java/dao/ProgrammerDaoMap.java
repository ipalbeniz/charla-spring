package dao;

import model.Programmer;

import java.util.HashMap;
import java.util.Map;

/**
 * Programmer Dao in memory Map implementation
 */
public class ProgrammerDaoMap implements ProgrammerDao {

    private static Map<String, Programmer> programmersById = new HashMap<String, Programmer>();

    static {
        Programmer programmer = new Programmer("iperez", "Iñaki", 38);
        programmersById.put(programmer.getId(), programmer);

        programmer = new Programmer("lcroft", "Lara Croft", 27);
        programmersById.put(programmer.getId(), programmer);
    }

    public Programmer getById(String id) {
        return programmersById.get(id);
    }
}
