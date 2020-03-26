package com.tank.protocol;

import com.tank.model.TemporarySubMoneyDTO;
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


  @Transient
  public TemporarySubMoneyDTO toTemporarySubMoneyDTO() {
    TemporarySubMoneyDTO dto = new TemporarySubMoneyDTO();
    return dto.setMoney(this.money).setXid(this.xid);
  }

}
