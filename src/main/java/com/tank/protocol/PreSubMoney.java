package com.tank.protocol;

import com.tank.model.TemporarySubMoneyDTO;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.util.Objects;

@Getter
@Setter
public class PreSubMoney {

  private String app;

  private String xid;

  private Integer money;

  private Integer accountId;

  @Transient
  public boolean isEmptyMoney() {
    return Objects.isNull(money);
  }

  @Transient
  public boolean isEmptyAccountId() {
    return Objects.isNull(this.accountId);
  }


  @Transient
  public TemporarySubMoneyDTO toTemporarySubMoneyDTO() {
    TemporarySubMoneyDTO dto = new TemporarySubMoneyDTO();
    return dto.setMoney(this.money)
        .setXid(this.xid)
        .setAccountId(this.accountId)
        .setApp(app);
  }

}
