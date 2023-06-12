package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        public Connection recuperarConexao() {
            try {
                return createDatasource().getConnection();
            } catch (SQLException e) {
                 throw new RuntimeException(e);
            }
        }
        private HikariDataSource createDatasource(){
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
            config.setUsername("root");
            config.setPassword("teste");
            config.setMaximumPoolSize(10);

            return new HikariDataSource(config);
        }
    }
