package com.example.task17;

import com.example.task17.controller.CustomerController;
import com.mongodb.BasicDBObject;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

//SpringBootTest
//DataMongoTest
//ExtendWith(SpringExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
class Task17ApplicationTests<Mongo> {

    @Autowired
    CustomerController controller;
    @Autowired
    MongoTemplate mongoTemplate;


    private static final String DATABASE_NAME = "embedded";

    private MongodExecutable mongodExe;
    private MongodProcess mongod;
    private Mongo mongo;
//
//	@Before
//	public void beforeEach() throws Exception {
//		MongoDBRuntime runtime = MongoDBRuntime.getDefaultInstance();
//		mongodExe = runtime.prepare(new MongodConfig(Version.V2_3_0, 12345, Network.localhostIsIPv6()));
//		mongod = mongodExe.start();
//		mongo = new Mongo("localhost", 12345);
//	}
//
//	@After
//	public void afterEach() throws Exception {
//		if (this.mongod != null) {
//			this.mongod.stop();
//			this.mongodExe.stop();
//		}
//	}
//
//	@Test
//	public void shouldCreateNewObjectInEmbeddedMongoDb() {
//		// given
//		DB db = mongo.getDB(DATABASE_NAME);
//		DBCollection col = db.createCollection("testCollection", new BasicDBObject());
//
//		// when
//		col.save(new BasicDBObject("testDoc", new Date()));
//
//		// then
//		assertThat(col.getCount(), Matchers.is(1L));
//	}

    @Test
    public void test() throws Exception {
        assertThat(controller).isNotNull();

    }

}
