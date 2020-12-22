package services;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Class used to query database</p>
 * <p>Create QueryService instance and execute query on the object</p>
 * <p>Example:</p>
 *  <pre>
 *  {@code
 *  QueryService service = QueryService("database", "username", "password");
 *  List<House> listOfHouses= service.queryMultiple("select * from house", rs -> {
 *         try {
 *             long id = rs.getLong(1);
 *             String address = rs.getString(2);
 *             String contact = rs.getString(3);
 *             String street = rs.getString(4);
 *             return new House(id, address, contact, street);
 *          } catch (SQLException e) {
 *             return new House(0, "default", "default", "default");
 *          }
 *       });
 *  </pre>
 */
public class QueryService {

    interface RowMapper<T> {
        T map(ResultSet rs) throws SQLException;
    }

    public QueryService() {
     
    }

    private Connection getConnection() throws SQLException {
//        try {
//            return DriverManager.getConnection(url, username, password);
//        } catch (SQLException sqlException) {
//            throw new SQLException("Error in getting connection. Check your password, " +
//                    "username and url");
//        }
       try{
          return MysqlConnection.getMysqlConnection();
       }catch(Exception e){
           throw new SQLException();
       }
    }

    /**
     * Query and map one or more rows to a list of objects
     * @param sql SQL query used to query database
     * @param mapper RowMapper for mapping between row and object
     * @param <T> type of returned objects
     * @return list of mapped objects
     * @throws SQLException when sql is not valid or url of connection is wrong
     */
    public <T> List<T> queryMultiple(String sql, RowMapper<T> mapper) throws SQLException {
        Connection temporaryConnection = getConnection();
        PreparedStatement statement = temporaryConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<T> resultList = new ArrayList<>();
        while (rs.next()) {
            T mappedObj = mapper.map(rs);
            resultList.add(mappedObj);
        }
        temporaryConnection.close();
        return resultList;
    }

    /**
     * Query and map one or more rows to a list of objects
     * @param sql SQL query used to query database
     * @param mapper RowMapper for mapping between row and object
     * @param <T> type of returned objects
     * @return mapped object
     * @throws SQLException when sql is not valid or url of connection is wrong
     */
    public <T> T querySingle(String sql, RowMapper<T> mapper) throws SQLException {
        Connection temporaryConnection = getConnection();
        PreparedStatement statement = temporaryConnection.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        T result;
        if (rs.next()) {
            result = mapper.map(rs);
        } else result = null;
        temporaryConnection.close();
        return result;
    }

    public void queryNoResult(String sql) throws SQLException{
        Connection temporaryConnection = getConnection();
        PreparedStatement statement = temporaryConnection.prepareStatement(sql);
        statement.execute();
        temporaryConnection.close();
    }
}
