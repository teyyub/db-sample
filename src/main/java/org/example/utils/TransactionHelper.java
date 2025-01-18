package org.example.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionHelper {
    private final Connection connection;

    public TransactionHelper(Connection connection) {
        this.connection = connection;
    }

    public void executeInTransaction(TransactionCallback callback) throws SQLException {
        try {
            connection.setAutoCommit(false);
            callback.doInTransaction(); // Execute the transactional logic
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e; // Re-throw to propagate the error
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @FunctionalInterface
    public interface TransactionCallback {
        void doInTransaction() throws SQLException;
    }
}
