package com.tank.service;

import com.tank.dao.AccountDAO;
import com.tank.model.TemporarySubMoneyDTO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountService {

  @Transactional(rollbackFor = Exception.class)
  public boolean addTempSubMoneyRecord(@NonNull final TemporarySubMoneyDTO temporarySubMoneyDTO) {
    int result = accountDAO.addTempSubMoneyRecord(temporarySubMoneyDTO);
    System.out.println("result = " + result);
    return result > 0;
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean subMoney(@NonNull final String xid) {
    TemporarySubMoneyDTO dto = this.accountDAO.findTemporarySubBy(xid);
    if (dto == null) {
      throw new NullPointerException("异常");
    }
    //return accountDAO.deleteTempRecord(xid) > 0 ? accountDAO.subMoney(dto.getMoney()) > 0 : false;
    return true;
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean rollBackSubMoney(@NonNull final String xid) {
    return accountDAO.deleteTempRecord(xid) > 0;
  }

  @Autowired
  private AccountDAO accountDAO;
}
