package br.com.cwi.exerciciosdia04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExportadorUtils {
    
    public static BufferedWriter getWriter(String fila) throws IOException {
       return new BufferedWriter(new FileWriter(fila,true));
   }
    
    public void exportarParaCSV(String arquivo, Object object) throws IOException{    
        
        String nome =  object.getClass().getName();
        
        switch(nome){
            case "Cidade":
                exportarCidade(arquivo);
            break;
            case "Cliente":
                exportarCliente(arquivo);
            break;
            case "Material":
                exportarMaterial(arquivo);
            break;
            case "Pedido":
                exportarPedido(arquivo);
            break;
            case "PedidoItem":
                exportarPedidoItem(arquivo);
            break;
            case "Pessoa":
                exportarPessoa(arquivo);
            break;
            case "Produto":
                exportarProduto(arquivo);
            break;
            case "ProdutoMaterial":
                exportarProdutoMaterial(arquivo);
            break;
            default:
                //...
            break;        
        }
        
    }

    public static void exportarCidade(String arquivo){
        BufferedWriter bufferedWriter = null;
        //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
        IRepositorio repositorio = new CidadeRepositorio();
        List<Cidade> cidades = repositorio.listAll();
        try {
            bufferedWriter = getWriter(arquivo);
            for(Cidade cidade : cidades){
            bufferedWriter.write(String.format("%s;%s;%s", Long.toString(cidade.getId()), cidade.getNome(), cidade.getUf()));
            bufferedWriter.newLine();
            bufferedWriter.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ExportadorUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void exportarCliente(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarMaterial(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarPedido(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarPedidoItem(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarPessoa(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarProduto(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void exportarProdutoMaterial(String arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
