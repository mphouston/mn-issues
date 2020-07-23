package ref.issue;

import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@MicronautTest
public class RefIssueTest {

    @Inject
    EmbeddedApplication application;

    @Test
    @Transactional
    void testNullRefIssue() {
      // Save a record with a null foreign reference.
      TableARepository repo2 = application.getApplicationContext().getBean(TableARepository.class);
      TableA recordA = new TableA("ABC");
      //recordA.setTableB(recordB);
      repo2.save(recordA);

      // Update the record with a null foreign reference.
      // Will fail with a Postgres SQL error:
      //   io.micronaut.data.exceptions.DataAccessException: Error executing SQL UPDATE: ERROR: column "table_bid" is of type uuid but expression is of type bigint
      repo2.update(recordA);
      /*
      Fixed by modifying the mn-data JdbcQueryStatement method:
         QueryStatement<PreparedStatement, Integer> setDynamic(@NonNull PreparedStatement statement, @NonNull Integer index, @NonNull DataType dataType, Object value) {
           if (dataType == DataType.ENTITY) {
             statement.setNull(index, Types.OTHER)
             return this
           }
           return super.setDynamic(statement, index, dataType, value)
         }

       */

      Iterable<TableA> list = repo2.findAll();
      for (TableA record: list) {
        System.out.println("record:" + record.getName()+" uuid: "+record.getUuid()+" Foreign Ref: "+record.getTableB());
      }
    }

}
