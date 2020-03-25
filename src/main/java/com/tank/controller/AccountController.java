package com.tank.controller;

import com.tank.protocol.ApiResult;
import com.tank.protocol.ConfirmSubMoney;
import com.tank.protocol.PreSubMoney;
import com.tank.protocol.RollBackMoney;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AccountController {

  @PostMapping("/preSubMoney")
  public ResponseEntity<ApiResult<Integer>> preSubMoney(@RequestBody @NonNull final PreSubMoney preSubMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    apiResult.setData(preSubMoney.getMoney());
    apiResult.setStatus(200);
    return ResponseEntity.ok(apiResult);
  }

  @PostMapping("/confirmMoney")
  public ResponseEntity<ApiResult<Integer>> confirmSubMoney(@RequestBody @NonNull final ConfirmSubMoney confirmSubMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    apiResult.setStatus(200);
    return ResponseEntity.ok(apiResult);
  }

  @PostMapping("/rollBackSubMoney")
  public ResponseEntity<ApiResult<Integer>> rollBackSubMoney(@RequestBody @NonNull final RollBackMoney rollBackMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    apiResult.setStatus(200);
    return ResponseEntity.ok(apiResult);
  }

}
