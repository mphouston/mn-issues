package example.domain

import groovy.transform.ToString
import io.micronaut.data.annotation.AutoPopulated
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 *
 */
@MappedEntity('ordr')
//@Table(name ="ordr")
@ToString(includeNames = true)
class Order {
  @Id @AutoPopulated UUID id // = UUID.randomUUID()

  String ordr

  //@OneToMany(targetEntity=OrderLine, cascade= CascadeType.ALL, mappedBy="ordr")  // JPA approach.
  @Relation(value = Relation.Kind.ONE_TO_MANY, cascade = Relation.Cascade.ALL, mappedBy="ordr")
  List<OrderLine> orderLines = []

  Order(String ordr) {
    this.ordr = ordr
  }

  Order() {

  }

  Order(String ordr, UUID uuid) {
    this.ordr = ordr
    this.id = uuid
  }

}