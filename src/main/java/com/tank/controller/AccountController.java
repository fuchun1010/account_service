package com.tank.controller;

import com.tank.model.TemporarySubMoneyDTO;
import com.tank.protocol.ApiResult;
import com.tank.protocol.ConfirmSubMoney;
import com.tank.protocol.PreSubMoney;
import com.tank.protocol.RollBackMoney;
import com.tank.service.AccountService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/v1")
public class AccountController {

  @PostMapping("/preSubMoney")
  public ResponseEntity<ApiResult<Integer>> preSubMoney(@RequestBody @NonNull final PreSubMoney preSubMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    if (preSubMoney.isEmptyAccountId()) {
      apiResult.setStatus(HttpStatus.BAD_REQUEST.value());
      return ResponseEntity.ok(apiResult);
    }
    TemporarySubMoneyDTO dto = preSubMoney.toTemporarySubMoneyDTO();
    boolean isOk = this.accountService.addTempSubMoneyRecord(dto);

    if (isOk) {
      apiResult.setStatus(200);
    } else {
      apiResult.setStatus(500);
      apiResult.setError("pre sub money failure");
    }

    return ResponseEntity.ok(apiResult);

  }

  @PostMapping("/confirmMoney")
  public ResponseEntity<ApiResult<Integer>> confirmSubMoney(@RequestBody @NonNull final ConfirmSubMoney confirmSubMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    if (confirmSubMoney.isEmptyXid()) {
      apiResult.setStatus(400);
    } else {
      apiResult.setStatus(200);
    }

    boolean isOk = this.accountService.subMoney(confirmSubMoney.getXid());
    if (!isOk) {
      apiResult.setStatus(500);
    }
    return ResponseEntity.ok(apiResult);
  }

  @PostMapping("/rollBackSubMoney")
  public ResponseEntity<ApiResult<Integer>> rollBackSubMoney(@RequestBody @NonNull final RollBackMoney rollBackMoney) {
    ApiResult<Integer> apiResult = ApiResult.<Integer>builder().build();
    apiResult.setStatus(200);
    return ResponseEntity.ok(apiResult);
  }


  @Autowired
  private AccountService accountService;

  private AtomicInteger pk = new AtomicInteger(0);
}
