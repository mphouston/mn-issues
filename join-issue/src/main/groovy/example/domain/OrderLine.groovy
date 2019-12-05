package example.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import io.micronaut.core.annotation.Creator
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

import javax.annotation.Nullable

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 *
 */
@MappedEntity
@ToString(includeNames = true,excludes = ['ordr'])
@EqualsAndHashCode(includes = ['id'])
class OrderLine {
  @Id @AutoPopulated @Nullable UUID id // = UUID.randomUUID()

  //@ManyToOne // JPA approach.
  @Relation(value = Relation.Kind.MANY_TO_ONE)
  Order ordr
  String component
  BigDecimal qty = 1.0

  @Creator
  OrderLine(@Nullable Order ordr,@Nullable  String component) {
    this.ordr = ordr
    this.component = component
  }

  OrderLine(@Nullable Order ordr) {
    this.ordr = ordr
  }

  OrderLine() {

  }

}