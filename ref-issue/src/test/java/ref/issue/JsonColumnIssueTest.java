package ref.issue;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

@MicronautTest
public class JsonColumnIssueTest {

    @Inject
    EmbeddedApplication application;

    @Test
    @Transactional
    void testJsonColumnIssue() {
      // Save a record with a JSON string in the JSON field.
      TableARepository repo2 = application.getApplicationContext().getBean(TableARepository.class);
      TableA recordA = new TableA("ABC");
      String json = "{\"color\": \"Blue\"}"; // Actual string value is {"color": "Blue"}
      recordA.setFields(json);
      repo2.save(recordA);

      recordA = repo2.findById(recordA.getUuid()).get();

      System.out.println("  json:" + json);
      System.out.println("record:" + recordA.getFields());
      assert recordA.getFields().equals(json);

      /*
       This issue is fixed simplistically by setting the DefaultJdbcRepositoryOperations.JsonCodec to null.
       Other solutions might be possible.
       */
    }

}
