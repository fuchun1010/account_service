package com.tank.protocol;

import lombok.Getter;
import lombok.Setter;

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

  private String xid;
}
