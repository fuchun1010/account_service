package com.tank.protocol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Setter
@Getter
@Builder
@Accessors(chain = true)
public class ApiResult<T> {

  private int status;

  private T data;

  private String error;
}
