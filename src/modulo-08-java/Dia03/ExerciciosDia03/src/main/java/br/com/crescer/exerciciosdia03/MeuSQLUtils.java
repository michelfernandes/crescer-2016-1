package br.com.crescer.exerciciosdia03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MeuSQLUtils {

    public static void main(String[] args) {

    }

    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }

    private static BufferedReader getReader(String fila) throws FileNotFoundException {
        return new BufferedReader(new FileReader(fila));
    }

    private static void executarIntrucao(String instrucao) {
        final String comando[] = instrucao.split(";");

        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {

                for (String eachComando : comando) {
                    statement.addBatch(eachComando);
                }
                statement.executeBatch();

            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    public static void exportarCSV() {
        String query = "SELECT * FROM PESSOA";
        
        BufferedWriter bufferedWriter = null;
        
        
         try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    
                    while (resultSet.next()) {
                        try{
                        bufferedWriter = getWriter("exportar.csv");
                        bufferedWriter.write(resultSet.getLong("ID_PESSOA")+";"+resultSet.getString("NM_PESSOA")+";");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                        }catch(Exception e){
                        //...
                        }                        
                        //lista.add(new Pessoa(resultSet.getString("NM_PESSOA"),resultSet.getLong("ID_PESSOA")));
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
    }

    public static void importarCSV() {

        BufferedReader bufferReader = null;
        try {
            bufferReader = MeuSQLUtils.getReader("importar.csv");
            String linha;
            long id;
            String nome;

            String insert = "INSERT INTO PESSOA (ID_PESSOA,NM_PESSOA)"
                    + "VALUES(?,?)";
            while (true) {
                linha = bufferReader.readLine();
                if (linha != null) {
                    id = Long.parseLong(linha.split(";")[0]);
                    nome = linha.split(";")[1];

                    try (Connection connection = ConnectionUtils.getConnection()) {
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
                            preparedStatement.setLong(1, id);
                            preparedStatement.setString(2, nome);
                            preparedStatement.executeUpdate();
                        } catch (final SQLException e) {
                            System.err.format("SQLException: %s", e);
                        }
                    } catch (final SQLException e) {
                        System.err.format("SQLException: %s", e);
                    }

                } else {
                    break;
                }
            }

        } catch (Exception e) {
            //....
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (IOException ex) {

            }
        }

    }

    public static void lerArquivo() {

        BufferedReader bufferReader = null;
        try {
            bufferReader = MeuSQLUtils.getReader("Instrucao.sql");
            String linha;
            String instrucao = "";

            while (true) {
                linha = bufferReader.readLine();
                if (linha != null) {
                    instrucao = instrucao + linha;
                } else {
                    break;
                }
            }

            executarIntrucao(instrucao);

        } catch (Exception e) {
            //....
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (IOException ex) {

            }
        }

    }
}
