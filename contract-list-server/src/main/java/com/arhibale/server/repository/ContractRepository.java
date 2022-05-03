package com.arhibale.server.repository;

import com.arhibale.server.repository.connection.HikariDataSourceConfigure;
import com.arhibale.server.repository.dto.ContractDto;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    public List<ContractDto> getAll() throws SQLException {
        try (HikariDataSource dataSource = HikariDataSourceConfigure.getPostgres();
             Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from contract")) {

            List<ContractDto> dtoList = new ArrayList<>();
            while (resultSet.next()) {
                ContractDto contractDto = new ContractDto();
                contractDto.setId(resultSet.getLong("id"));
                contractDto.setDate(resultSet.getTimestamp("date").toLocalDateTime());
                contractDto.setContractNumber(resultSet.getInt("contract_number"));
                contractDto.setLastUpdate(resultSet.getTimestamp("last_update").toLocalDateTime());
                dtoList.add(contractDto);
            }
            return dtoList;
        }
    }
}