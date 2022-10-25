package com.backend.backendcadastro.modelos;

import java.util.Calendar;

public class Autor 
{
    private int         idAutor;
    private String      nomeAutor;
    private String      idadeAutor;
    private Calendar    anoNascimentoAutor;
    private String      nomePersona;
    private String      idadePersona;
    private String      sexoPersona;

    public Autor()
    {}

    public Autor(String pNomeAutor, String pIdadeAutor,  Calendar pAnoNascimentoAutor, 
                 String pNomePersona, String pIdadePersona, String pSexoPersona)
    {
        this.nomeAutor              = pNomeAutor;
        this.idadeAutor             = pIdadeAutor;
        this.anoNascimentoAutor     = pAnoNascimentoAutor;
        this.nomePersona            = pNomePersona;
        this.idadePersona           = pIdadePersona;
        this.sexoPersona            = pSexoPersona;
    };

    public int getIdAutor()
    {
        return idAutor;
    }

    public void setIdAutor(int idAutor)
    {
        this.idAutor = idAutor;
    }

    public String getnomeAutor()
    {
        return nomeAutor;
    }

    public void setnomeAutor(String nomeAutor)
    {
        this.nomeAutor = nomeAutor;
    }

    public String getidadeAutor()
    {
        return idadeAutor;
    }

    public void setidadeAutor(String idadeAutor)
    {
        this.idadeAutor = idadeAutor;
    }

     public Calendar getanoNascimentoAutor()
    {
        return anoNascimentoAutor;
    }

    public void setanoNascimentoAutor(Calendar anoNascimentoAutor)
    {
        this.anoNascimentoAutor = anoNascimentoAutor;
    }
   
    public String getnomePersona()
    {
        return nomePersona;
    }

    public void setnomePersona(String nomePersona)
    {
        this.nomePersona = nomePersona;
    }

    public String getidadePersona()
    {
        return idadePersona;
    }

    public void setidadePersona(String idadePersona)
    {
        this.idadePersona = idadePersona;
    }
    
    public String getsexoPersona()
    {
        return sexoPersona;
    }

    public void setsexoPersona(String sexoPersona)
    {
        this.sexoPersona = sexoPersona;
    }
}
