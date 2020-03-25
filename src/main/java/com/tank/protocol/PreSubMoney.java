package com.tank.protocol;

import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.util.Objects;

@Getter
@Setter
public class PreSubMoney {

  private String appName;

  private String xid;

  private Integer money;

  @Transient
  public boolean isEmptyMoney() {
    return Objects.isNull(money);
  }

}
