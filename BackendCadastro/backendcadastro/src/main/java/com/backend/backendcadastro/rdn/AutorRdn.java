package com.backend.backendcadastro.rdn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import com.backend.backendcadastro.modelos.Autor;


public class AutorRdn {

    public int Inserir(Autor autor) throws SQLException 
    {
        StringBuilder sql = new StringBuilder();
        int linhasAfetadas = 0;

        sql.append("INSERT INTO AUTOR                   ");
        sql.append("            (nomeAutor              ");
        sql.append("            ,idadeAutor             ");
        sql.append("            ,anoNascimentoAutor     ");
		sql.append("            ,nomePersona            ");
		sql.append("            ,idadePersona           ");
		sql.append("            ,sexoPersona)           ");
        sql.append("   VALUES                           ");
        sql.append("            (?                      ");
        sql.append("            ,?                      ");
        sql.append("            ,?                      ");
	    sql.append("            ,?                      ");
        sql.append("            ,?                      ");
		sql.append("            ,?)                     ");

        Connection conn = new ConnectionFactroy().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql.toString());

        stmt.setString(1, autor.getnomeAutor());
        stmt.setString(2, autor.getidadeAutor());
        
        Calendar today = Calendar.getInstance();
        autor.setanoNascimentoAutor(today);
        stmt.setDate(3, new java.sql.Date(today.getTimeInMillis()));     


        stmt.setString(4, autor.getnomePersona());
        stmt.setString(5, autor.getidadePersona());

        stmt.setString(6, autor.getsexoPersona());

        linhasAfetadas = stmt.executeUpdate();

        System.out.print("linhas afetadas: " + linhasAfetadas);

        stmt.close();
        conn.close();

        return linhasAfetadas;
    }

    public ArrayList<Autor> obterTodos() 
    {
        ArrayList<Autor> retorno = new ArrayList<Autor>();
        try 
        {
            StringBuilder str = new StringBuilder();

            str.append("select   a.IdAutor                  ");
            str.append("        ,a.nomeAutor                ");
            str.append("        ,a.idadeAutor               ");
            str.append("        ,a.anoNascimentoAutor       ");
            str.append("        ,a.nomePersona              ");
            str.append("        ,a.idadePersona             ");
            str.append("        ,a.sexoPersona              ");
            str.append(" from autor a                       ");

            Connection conn = new ConnectionFactroy().getConnection();                
            Statement stmt = conn.createStatement();   
            ResultSet rs = stmt.executeQuery(str.toString());

            while (rs.next()) 
            {
                Autor autor = new Autor();

                autor.setIdAutor(rs.getInt("IdAutor"));
                autor.setnomeAutor(rs.getString("nomeAutor"));
                autor.setidadeAutor(rs.getString("idadeAutor"));    

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("anoNascimentoAutor"));
                autor.setanoNascimentoAutor(calendar);

                autor.setnomePersona(rs.getString("nomePersona"));
                autor.setidadePersona(rs.getString("idadePersona"));
                autor.setsexoPersona(rs.getString("sexoPersona"));

                //ADICIONAR O OBJETO CLIENTE NA LISTA DE CLIENTES
                retorno.add(autor);

            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
        
        return retorno;   //print
    }
    
    public int excluir(int idAutor) {

        int numeroLinhasAfetadas = 0;

        try {

            String str = "delete from autor where IdAutor = ?";
           
            Connection conn = new ConnectionFactroy().getConnection();
            
            PreparedStatement statement = conn.prepareStatement(str);            
            
            statement.setInt(1, idAutor);
            
            numeroLinhasAfetadas = statement.executeUpdate();

            conn.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return numeroLinhasAfetadas;  //print
    }
  
    public int deletar(int idAutor) {

        int numeroLinhasAfetadas = 0;

        try {

            String str = "delete from autor where IdAutor = ?";
         
            Connection conn = new ConnectionFactroy().getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(str.toString());
            
            stmt.setInt(1, idAutor);        
            
            numeroLinhasAfetadas = stmt.executeUpdate();
            
            conn.close();
            stmt.close();

        } 
        catch (SQLException e) 
        {
            System.out.println(e);
        }

        return numeroLinhasAfetadas;  //print
    }
    
    public int alterar(Autor autor) 
    {

        StringBuilder str = new StringBuilder();
        int numeroLinhasAfetadas = 0;

        try {

            str.append(" update autor set nomeAutor = ?                    ");
            //str.append("                    ,nomeAutor = ?                 ");
            str.append("                    ,idadeAutor = ?                ");
            str.append("                    ,anoNascimentoAutor = ?        ");  
            str.append("                    ,nomePersona = ?               ");
            str.append("                    ,idadePersona = ?              ");
            str.append("                    ,sexoPersona = ?               ");                   
            str.append("where IdAutor = ?                                  ");
            
            Connection conn = new ConnectionFactroy().getConnection();
            
            PreparedStatement stmt = conn.prepareStatement(str.toString());
           
            stmt.setString(1, autor.getnomeAutor());
            stmt.setString(2, autor.getidadeAutor());

                Calendar today = Calendar.getInstance();
                autor.setanoNascimentoAutor(today);

                stmt.setDate(3, new java.sql.Date(today.getTimeInMillis()));

            stmt.setString(4, autor.getnomePersona());
            stmt.setString(5, autor.getidadePersona());
            stmt.setString(6, autor.getsexoPersona());

            //EXECUTAR O COMANDO
            numeroLinhasAfetadas = stmt.executeUpdate();

            //FECHAR OS RECURSOS
            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println(e);
        }

        return numeroLinhasAfetadas; //print

    }

    public Autor obterPorId(int idAutor) 
    {
    
    Autor autor = new Autor();

        try 
        {
            StringBuilder str = new StringBuilder();

            str.append("select  a.IdAutor                   ");
            str.append("        ,a.nomeAutor                ");
            str.append("        ,a.idadeAutor               ");
            str.append("        ,a.anoNascimentoAutor       "); 
            str.append("        ,a.nomePersona              ");
            str.append("        ,a.idadePersona             ");
            str.append("        ,a.sexoPersona              ");          
            str.append(" from autor a                       ");
            str.append(" where a.IdAutor = ?                ");

            Connection conn = new ConnectionFactroy().getConnection();
           
            PreparedStatement stmt = conn.prepareStatement(str.toString());
           
            stmt.setInt(1, idAutor);
        
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) 
            {
                autor.setIdAutor(rs.getInt("IdAutor"));
                autor.setnomeAutor(rs.getString("nomeAutor"));
                autor.setidadeAutor(rs.getString("idadeAutor"));

                //CONVERTER SQL DATE TO CALENDAR
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("anoNascimentoAutor"));
                autor.setanoNascimentoAutor(calendar);  
                
                autor.setnomePersona(rs.getString("nomePersona"));
                autor.setidadePersona(rs.getString("idadePersona"));
                autor.setsexoPersona(rs.getString("sexoPersona"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException e) 
        {
            System.out.println(e);
        }
            
    return autor;

    }
}
