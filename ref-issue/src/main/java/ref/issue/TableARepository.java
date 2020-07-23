package ref.issue;

/*
 * Copyright Michael Houston 2020. All rights reserved.
 * Original Author: mph
 *
 */

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

/**
 * The repos for A.
 */
@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TableARepository extends CrudRepository<TableA, UUID> {
}
