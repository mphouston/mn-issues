package example.domain

import io.micronaut.context.annotation.Requires
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 * Repository to test issue with uuid and update.
 */
@JdbcRepository(dialect = Dialect.H2)
@Requires(env = ["test"])
interface ProductRepository extends CrudRepository<Product, UUID> {
  
}
