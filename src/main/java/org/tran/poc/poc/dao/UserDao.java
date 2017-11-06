package org.tran.poc.poc.dao;

import java.util.List;

public interface UserDao {

    void save(TransAudit user);


    List<TransAudit> list();
}
