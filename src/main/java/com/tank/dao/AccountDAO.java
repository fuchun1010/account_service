package com.tank.dao;

import com.tank.model.TemporarySubMoneyDTO;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public interface AccountDAO {

  int addTempSubMoneyRecord(@NonNull final TemporarySubMoneyDTO temporarySubMoneyDTO);

  int subMoney(@NonNull final String xid);

  int deleteTempRecord(@NonNull final String xid);

}
