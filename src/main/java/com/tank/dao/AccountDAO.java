package com.tank.dao;

import com.tank.model.TemporarySubMoneyDTO;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AccountDAO {

  int addTempSubMoneyRecord(@NonNull final TemporarySubMoneyDTO temporarySubMoneyDTO);

  int subMoney(@NonNull final int money);

  int deleteTempRecord(@NonNull final String xid);

  TemporarySubMoneyDTO findTemporarySubBy(@NonNull String xid);

}
