package dao;

import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@Profile("prod")
public class ProgrammerDaoMongo implements ProgrammerDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Programmer getById(String id) {

        Query query = new Query(where("username").is(id));

        return mongoTemplate.findOne(query, Programmer.class, "programmers");
    }

    @Override
    public List<Programmer> getAll() {
        return mongoTemplate.findAll(Programmer.class, "programmers");
    }
}
