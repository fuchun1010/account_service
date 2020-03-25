package com.tank.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class TemporarySubMoneyDTO {

  private String xid;

  private Integer money;
}