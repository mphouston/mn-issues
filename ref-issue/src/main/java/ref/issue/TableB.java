package ref.issue;

/*
 * Copyright Michael Houston 2020. All rights reserved.
 * Original Author: mph
 *
 */

import io.micronaut.data.annotation.AutoPopulated;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.model.DataType;

import java.util.UUID;

/**
 * A domain table.
 */
@MappedEntity
public class TableB {

  @Id
  @AutoPopulated
  @MappedProperty(type = DataType.UUID)
  UUID uuid;

  String name;

  public TableB(String name) {
    this.name = name;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
