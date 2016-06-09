package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAO implements IPessoa{   
    
    @Override
    public void insert(Pessoa pessoa) {
        
        final String insert = "INSERT INTO PESSOA( ID_PESSOA, NM_PESSOA ) "
                    + "VALUES ((SELECT MAX(ID_PESSOA)+1 FROM PESSOA), ?)";
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
              
                preparedStatement.setString(1,pessoa.getNome());
                preparedStatement.executeUpdate();
              
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
        
    }

    @Override
    public void update(Pessoa pessoa) {
        final String update = "UPDATE PESSOA SET NM_PESSOA = ? "
                    + " WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(update)) {
              
                preparedStatement.setString(1,pessoa.getNome());
                preparedStatement.setLong(2,pessoa.getId());
                preparedStatement.executeUpdate();
              
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        final String delete = "DELETE FROM PESSOA "
                    + "WHERE ID_PESSOA = ?";
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
              
                preparedStatement.setLong(1,pessoa.getId());
                preparedStatement.executeUpdate();
              
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public List<Pessoa> listAll() {
        final String query = "SELECT * FROM PESSOA";
        List<Pessoa> lista = new ArrayList<Pessoa>();
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        lista.add(new Pessoa(resultSet.getString("NM_PESSOA"),resultSet.getLong("ID_PESSOA")));
                    }
                } catch (final SQLException e) {
                  System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }
        }catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
        return lista;
    }

    @Override
    public List<Pessoa> findNome(String nome) {
        final String query = "SELECT * FROM PESSOA WHERE LOWER(NM_PESSOA) LIKE (?)";
        List<Pessoa> lista = new ArrayList<Pessoa>();
        
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement(query)) {
              
                preparedStatement.setString(1,"%"+nome+"%");     
            
                try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        lista.add(new Pessoa(resultSet.getString("NM_PESSOA"),resultSet.getLong("ID_PESSOA")));
                    }
                } catch (final SQLException e) {
                  System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
              System.err.format("SQLException: %s", e);
            }  
            
        }catch (SQLException e) {
          System.err.format("SQLException: %s", e);
        }
        return lista;
    }
    
    
}
