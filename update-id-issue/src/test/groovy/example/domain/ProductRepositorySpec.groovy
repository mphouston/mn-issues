package example.domain

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Shared
import spock.lang.Specification

import javax.inject.Inject

/*
 * Copyright Michael Houston 2019. All rights reserved.
 * Original Author: mph
 *
*/

/**
 * Tests for update with uuid issue.
 */
@MicronautTest
class ProductRepositorySpec extends Specification {

  @Inject @Shared ProductRepository productRepository

  def "verify that "() {
    when: 'the record is created'
    def product=new Product('BIKE')
    productRepository.save(product)

    and: 'updated'
    product.title = 'new title'
    productRepository.update(product)

    then: 'the product is re-read from the DB'
    def product2 = productRepository.findById(product.uuid).orElse(null)
    product2.title == "new title"


  }
}
