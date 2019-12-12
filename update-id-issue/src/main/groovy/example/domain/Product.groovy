package example.domain

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.DateCreated
import io.micronaut.data.annotation.DateUpdated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import io.micronaut.data.model.DataType

import javax.annotation.Nullable
import javax.inject.Singleton

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 * Sample Domain.
 */
@Singleton
@MappedEntity
@ToString(includeNames = true)
@CompileStatic
class Product {
  @Id @AutoPopulated UUID uuid
  //@Id @AutoPopulated UUID id

  String product
  @Nullable String title
  BigDecimal lotSize = 1.0

  Integer version = 0

  @DateCreated
  @MappedProperty(type = DataType.TIMESTAMP, definition = 'TIMESTAMP WITH TIME ZONE')
  Date dateCreated
  @DateUpdated
  @MappedProperty(type = DataType.TIMESTAMP, definition = 'TIMESTAMP WITH TIME ZONE')
  Date dateUpdated

  Product(String product) {
    this.product = product
  }
}
