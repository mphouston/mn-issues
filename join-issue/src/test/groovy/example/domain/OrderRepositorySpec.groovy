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
 *
 */
@MicronautTest
class OrderRepositorySpec extends Specification {
  @Inject
  @Shared
  OrderRepository orderRepository

  def "verify that crud works with foreign reference"() {
    when:
    'an order is created'
    Order order = new Order("M1001")
    order.orderLines << new OrderLine(order, 'SEAT')
    order.orderLines << new OrderLine(order, 'WHEELS')
    order.orderLines << new OrderLine(order, 'BRAKES')
    println "order = $order"
    orderRepository.save(order)

    then:
    'the order can be found'
    def orderRead = orderRepository.find('M1001').orElse(null)
    println "orderRead = $orderRead"
    //def orderRead = orderRepository.findById(order.uuid).orElse(null)
    orderRead.orderLines.size() == 3

  }

}
