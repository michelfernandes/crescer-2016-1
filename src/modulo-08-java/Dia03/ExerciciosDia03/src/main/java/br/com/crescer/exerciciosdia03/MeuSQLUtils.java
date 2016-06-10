package br.com.crescer.exerciciosdia03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MeuSQLUtils {
    
    public static void main(String[] args) {
        
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

    public static void lerSQL() {

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
