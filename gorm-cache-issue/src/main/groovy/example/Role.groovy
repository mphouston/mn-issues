package example

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode

/*
 * Copyright Michael Houston 2018. All rights reserved.
 * Original Author: mph
 *
*/

/**
 * Defines a Role for security.  These roles are used by the access points (controllers) to determine which users
 * can have access to the system.
 */
@Entity
@EqualsAndHashCode(includes = ['authority'])
class Role {

  /**
   * The Role name (authority).  Example: 'ROLE_ADMIN'.
   */
  String authority

  /**
   * The short title of this object.
   */
  String title

  static mapping = {
    cache true
  }

  /**
   * Internal field constraints.
   */
  static constraints = {
    authority(maxSize: 30, blank: false, unique: true)
    title(maxSize: 30, blank: false, nullable: false)
  }

  /**
   *  Build a human-readable version of this object.
   * @return The human-readable string.
   */
  @Override
  String toString() {
    return title
  }


}
