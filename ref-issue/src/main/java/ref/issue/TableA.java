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

import javax.annotation.Nullable;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * A domain table.
 */
@MappedEntity
public class TableA {

  @Id
  @AutoPopulated
  @MappedProperty(type = DataType.UUID)
  UUID uuid;

  String name;

  /**
   * A foreign reference.
   */
  @ManyToOne(targetEntity=TableB.class)
  @MappedProperty(type = DataType.UUID)
  TableB tableB;

  @Nullable
  @MappedProperty(type = DataType.JSON)
  String fields;


  public TableA(String name) {
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

  public TableB getTableB() {
    return tableB;
  }

  public void setTableB(TableB tableB) {
    this.tableB = tableB;
  }

  @Nullable
  public String getFields() {
    return fields;
  }

  public void setFields(@Nullable String fields) {
    this.fields = fields;
  }
}
