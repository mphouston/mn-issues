package example.domain

import edu.umd.cs.findbugs.annotations.NonNull
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository

import javax.validation.Valid
import javax.validation.constraints.NotNull

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 *
 */

@JdbcRepository(dialect = Dialect.H2)
interface OrderRepository extends CrudRepository<Order, UUID> {
  @Join(value = "orderLines", type = Join.Type.LEFT_FETCH, alias = "ol_")
  Optional<Order> find(String ordr)

}