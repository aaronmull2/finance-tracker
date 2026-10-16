package com.aaronmull2.finance_tracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class MigrationIntegrationTest {

    @Autowired
    DataSource dataSource;

    @Test
    void migrations_create_all_expected_tables() throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            String[] expectedTables = {"accounts", "categories", "transactions", "import_runs"};

            for (String table : expectedTables) {
                ResultSet rs = conn.getMetaData().getTables(null, null, table, null);
                assertTrue(rs.next(), "Expected table to exist: " + table);
            }
        }
    }
}
