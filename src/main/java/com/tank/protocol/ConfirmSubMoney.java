package com.tank.protocol;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.beans.Transient;
import java.util.Objects;

/**
 * status : preOk
 * xid : x001
 * commit : [{"url":"","status":""}]
 * rollBacks : [{"url":"","status":""}]
 * adive : {"url":"","status":""}
 */

/**
 * @param
 * @author tank198435163.com
 */
@Getter
@Setter
public class ConfirmSubMoney {

  @Transient
  public boolean isEmptyXid() {
    return Objects.isNull(this.xid);
  }

  private String xid;
}
