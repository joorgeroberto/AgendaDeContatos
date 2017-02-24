package dados;
//import java.util.Scanner;
import dados.Aniversario;
//import java.lang.Comparable;
/*import java.util.TreeSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;*/

import java.io.Serializable;
public class Contato implements Serializable
{
	//Atributos.
	private String nome;
	private long telefoneFixo;
	private long telefoneCelular;
	private String email;
	private Aniversario aniversario;
	private long cpf;
	 
	//Construtor
	public Contato (String nome, long telefoneFixo, long telefoneCelular, String email, Aniversario aniversario, long cpf)//, int posicao, int  ultimaPosicao)
	{
		this.nome = nome;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;	
		this.email = email;
		this.aniversario = aniversario;
		this.cpf = cpf;
		
	}
	
	public long getCpf() {
		return this.cpf;
	}
	public String getNome() 
	{
		return this.nome;
	}
	public long getTelefoneFixo() 
	{
		return this.telefoneFixo;
	}
	public long getTelefoneCelular() 
	{
		return this.telefoneCelular;
	}
	public String getEmail() 
	{
		return this.email;
	}
	public Aniversario getAniversario() 
	{
		return this.aniversario;
	}
	
	//Metodos modificadores.
	public void setCpf(long cpf)
	{
		this.cpf = cpf;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public void setTelefoneFixo (long telefoneFixo) 
	{
		this.telefoneFixo = telefoneFixo;
	}
	public void setTelefoneCelular(long telefoneCelular) 
	{
		this.telefoneCelular = telefoneCelular;	
	}
	public void setEmail (String email)
	{
		this.email = email;
	}
	public void setAniversario (Aniversario aniversario)
	{
		this.aniversario = aniversario;
	}
	
	public String toString() //nome, cpf, fixo, celular, aniversario, email.
    {
        String fixo,celular;
		//Long fixo2;
		if (this.telefoneFixo == 00){
        	fixo = ("O contato não possui Telefone Fixo");
        } else{
        	fixo = Long.toString(this.telefoneFixo);  
        }
		
		//Long fixo2;
		if (this.telefoneCelular == 00){
			celular = ("O contato não possui Telefone Celular");
        } else{
        	celular = Long.toString(this.telefoneCelular);  
        }
		String Email = "Iniciando";
		if (this.email.equals("00")){
			 Email = ("O contato não possui Email");
        } else{
        	Email=this.email;  
        }
		
		
		
		
		return ("Nome: "+this.nome + 
        		"\nCPF: "+ this.cpf +
        		"\nTelefone Fixo: "+ fixo +
        		"\nTelefone celular: "+ celular +
        		"\nAniversario: "+ this.aniversario.getDia()+"/"+ this.aniversario.getMes() + "/" + this.aniversario.getAno() +
        		"\nEmail: "+ Email +"\n");

    }

	
} 