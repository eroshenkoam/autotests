package io.eroshenkoam.autotests.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.QueryTimeOut;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public interface DatabaseClient {

    @SqlQuery("SELECT owner\n" +
            "FROM repositories \n" +
            "WHERE owner LIKE :owner\n" +
            "ORDER BY APPSTATUSDATE DESC")
    @QueryTimeOut(60)
    String getApplicationIdByPassport(@Bind("owner") String owner);

}
