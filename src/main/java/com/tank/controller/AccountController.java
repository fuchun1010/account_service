package com.tank.controller;

import com.tank.protocol.ApiResult;
import com.tank.protocol.ConfirmSubMoney;
import com.tank.protocol.PreSubMoney;
import com.tank.protocol.RollBackMoney;
import com.tank.service.AccountService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

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

  @GetMapping("/test")
  public ResponseEntity<ApiResult<String>> test() {
    ApiResult<String> apiResult = ApiResult.<String>builder().build();
    apiResult.setData("test");
//    TemporarySubMoneyDTO dto = TemporarySubMoneyDTO.builder().build();
//    dto.setXid("s0001");
//    dto.setMoney(100);
//    dto.setApp("app");
//    dto.setId(pk.incrementAndGet());
//    this.accountService.addTempSubMoneyRecord(dto);
    this.accountService.subMoney("s0001");
    return ResponseEntity.ok(apiResult);
  }


  @Autowired
  private AccountService accountService;

  private AtomicInteger pk = new AtomicInteger(0);
}
