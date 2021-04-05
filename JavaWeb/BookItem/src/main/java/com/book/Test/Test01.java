package com.book.Test;

import com.book.Utils.JDBCUtils;
import org.junit.Test;

import java.sql.SQLException;

public class Test01 {
    @Test
    public void test1() throws SQLException {
        System.out.println(JDBCUtils.getConnection());
    }
}
