package club.banyuan.log.srevice.impl;

import club.banyuan.log.srevice.LogService;
import org.springframework.beans.factory.annotation.Autowired;

public class LogServiceImpl implements LogService {

  @Autowired
  private LogDao logDao;

  @Override
  public int insert(Log record) {
    return logDao.insert(record);
  }
}
