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
    return accountDAO.addTempSubMoneyRecord(temporarySubMoneyDTO) > 0;
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean subMoney(@NonNull final String xid) {
    return accountDAO.deleteTempRecord(xid) > 0 ? accountDAO.subMoney(xid) > 0 : false;
  }

  @Transactional(rollbackFor = Exception.class)
  public boolean rollBackSubMoney(@NonNull final String xid) {
    return accountDAO.deleteTempRecord(xid) > 0;
  }

  @Autowired
  private AccountDAO accountDAO;
}
