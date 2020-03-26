package com.tank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TemporarySubMoneyDTO {

  private Integer id;

  private String xid;

  private Integer money;

  private String app;

  private Integer accountId;
}
