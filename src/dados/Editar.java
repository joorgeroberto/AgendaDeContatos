package dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;












public class Editar extends JFrame{
	
	static ArrayList<Contato> contatosNovos = new ArrayList<Contato>();
	private JButton ok, cancela;
	private JLabel titulo,espaco, nomeLabel, cpfLabel, fixoLabel, celularLabel, nascimentoLabel, emailLabel; 
	private JTextField nomeField, cpfField, fixoField, celularField, diaField,mesField,anoField, emailField;
	private int posicaoApagada;
	static Scanner input;
        
	public Editar(ArrayList<Contato> contatos, int posicao) throws IOException{//ArrayList<Contato> contatos
		posicaoApagada = posicao;
		contatosNovos.clear();
				
		Iterator it = contatos.iterator();
        while (it.hasNext()) {
            contatosNovos.add((Contato) it.next());
        }
		
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        Container container = getContentPane();	   
        container.setLayout(gridbag);

        // Os componentes podem ser esticados nas duas direções
        // para ocupar todo o espaço disponível
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,  // Acima por fora
                              10,  // À esquerda por fora
                              10,  // Abaixo por fora
                              10);
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.ipadx = 100;
        c.ipady = 10;
        c.gridwidth = GridBagConstraints.BOTH;
    
		titulo = new JLabel("Complete os campos abaixo:");
		        gridbag.setConstraints(titulo, c);
		        container.add(titulo);
		        
		c.gridwidth = GridBagConstraints.REMAINDER;
		        espaco = new JLabel("  ");
		        gridbag.setConstraints(espaco, c);
		        container.add(espaco);
		        
		c.gridwidth = GridBagConstraints.BOTH;
		        nomeLabel = new JLabel("Nome: ");
		nomeLabel.setToolTipText( "Digite o nome do contato." );
		        gridbag.setConstraints(nomeLabel, c);
		        container.add(nomeLabel);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		nomeField = new JTextField(30);
		        gridbag.setConstraints(nomeField, c);
		        container.add(nomeField);
		        nomeField.setText(contatos.get(posicao).getNome());
		c.gridwidth = GridBagConstraints.BOTH;
		cpfLabel = new JLabel("Cpf: ");
		cpfLabel.setToolTipText( "Digite o cpf do contato." );
		        gridbag.setConstraints(cpfLabel, c);
		        container.add(cpfLabel);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		cpfField = new JTextField(50);
		        gridbag.setConstraints(cpfField, c);
		        container.add(cpfField);
		        cpfField.setText(Long.toString(contatos.get(posicao).getCpf()));
		c.gridwidth = GridBagConstraints.BOTH;
		fixoLabel = new JLabel("Telefone fixo: ");
		fixoLabel.setToolTipText( "Digite o telefone fixo do contato. Se n�o possuir digite 00" );
		        gridbag.setConstraints(fixoLabel, c);
		        container.add(fixoLabel);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		fixoField = new JTextField(13);
		fixoField.setToolTipText( "Se o contato nao possuir telefone fixo digite 00" );
		        gridbag.setConstraints(fixoField, c);
		        container.add(fixoField);
		        fixoField.setText(Long.toString(contatos.get(posicao).getTelefoneFixo()));
		        
		c.gridwidth = GridBagConstraints.BOTH;
		celularLabel = new JLabel("Telefone celular: ");
		celularLabel.setToolTipText( "Digite o telefone celular do contato. Se n�o possuir digite 00" );
		        gridbag.setConstraints(celularLabel, c);
		        container.add(celularLabel);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		celularField = new JTextField(13); 
		celularField.setToolTipText( "Se o contato nao possuir celular digite 00" );
		        gridbag.setConstraints(celularField, c);
		        container.add(celularField);
		        celularField.setText(Long.toString(contatos.get(posicao).getTelefoneCelular()));
		        
		c.gridwidth = GridBagConstraints.BOTH;
		nascimentoLabel = new JLabel("Data de nascimento: ");
		nascimentoLabel.setToolTipText( "Digite a data de nascimento na forma: DD/MM/AAAA" );
		        gridbag.setConstraints(nascimentoLabel, c);
		        container.add(nascimentoLabel);
		        c.gridwidth = GridBagConstraints.BOTH;
		diaField = new JTextField(10);
		diaField.setToolTipText( "Digite o dia de nascimento:" );
		        gridbag.setConstraints(diaField, c);
		        container.add(diaField);
		        c.gridwidth = GridBagConstraints.BOTH;
		        diaField.setText ( (Integer.toString (contatos.get(posicao).getAniversario().getDia() ) ) );
		        
		mesField = new JTextField(10);
		mesField.setToolTipText( "Digite o mes de nascimento:" );
		        gridbag.setConstraints(mesField, c);
		        container.add(mesField);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		        mesField.setText ( (Integer.toString (contatos.get(posicao).getAniversario().getMes() ) ) );
		        
		anoField = new JTextField(10);
		anoField.setToolTipText( "Digite o ano de nascimento:" );
		        gridbag.setConstraints(anoField, c);
		        container.add(anoField);
		        anoField.setText ( (Integer.toString (contatos.get(posicao).getAniversario().getAno() ) ) );
		        
		c.gridwidth = GridBagConstraints.BOTH;
		emailLabel = new JLabel("Email: ");
		emailLabel.setToolTipText( "Digite o email do contato. Se nao possuir digite 00" );
		        gridbag.setConstraints(emailLabel, c);
		        container.add(emailLabel);
		        c.gridwidth = GridBagConstraints.REMAINDER;
		emailField = new JTextField(30); 
		emailField.setToolTipText( "Se o contato nao possuir email digite 00" );
		        gridbag.setConstraints(emailField, c);
		        container.add(emailField);
		        emailField.setText(contatos.get(posicao).getEmail());

        /*cpfField.setEnabled(true);
        fixoField.setEnabled(true);
        celularField.setEnabled(true);
        diaField.setEnabled(true);
        mesField.setEnabled(true);
        anoField.setEnabled(true);
        emailField.setEnabled(true);*/

        c.gridwidth = GridBagConstraints.BOTH;
        ok = new JButton("Gravar");
        gridbag.setConstraints(ok, c);
        container.add(ok);
        c.gridwidth = GridBagConstraints.REMAINDER;
        cancela = new JButton("Cancelar");
        gridbag.setConstraints(cancela, c);
        container.add(cancela);	
                
                ok.addActionListener( new OkListener() );
                cancela.addActionListener( new CancelListener() );
                
                
	
	
	}
	
	private class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
                
        	
        	String vazio =  (nomeField.getText() );            	 
            if ( ( vazio.isEmpty()) || ( vazio.equals("Digite um nome!") ) ){
          	  nomeField.setText("Digite um nome!");
          	  
            }
            else {
          	 vazio = (cpfField.getText() ); 
          	 
     			
          	 if ( ( vazio.isEmpty()) || ( vazio.equals("Digite um cpf válido!") ) ){// || vazio.equals("Por favor, digite outro cpf.") ){                		  
                  	  cpfField.setText("Digite um cpf válido!"); 
                  	  	
            } 
          	 else {
          		 vazio = (fixoField.getText() ); 
              	 if ( ( vazio.isEmpty()) || ( vazio.equals("Digite um Telefone Fixo ou 00!") ) ){                		  
                      	  fixoField.setText("Digite um Telefone Fixo ou 00!"); 
              	 }
              	 else{
              		 vazio = (celularField.getText() ); 
                  	 if ( ( vazio.isEmpty()) || ( vazio.equals("Digite um Telefone Celular ou 00!") ) ){                		  
                          	  celularField.setText("Digite um Telefone Celular ou 00!"); 
                  	 }
                  	 else{
                  		 vazio = (diaField.getText() ); 
                      	 if  ( vazio.isEmpty() ){//|| (vazio.length() != 10) ){                		  
                              	  //nascimentoField.setText(vazio+" -- Digite uma data de aniversário válida!"); 
                      	 }
                      	 
                      	else{
                   		 vazio = (mesField.getText() ); 
                       	 if ( vazio.isEmpty() ){                		  
                               	  //nascimentoField.setText("Digite uma data de anivers�rio v�lida!"); 
                       	 } 
                   	 
                       	 else{
                       		 vazio = (anoField.getText() ); 
                           	 if ( vazio.isEmpty() ){                		  
                                   	  //nascimentoField.setText("Digite uma data de anivers�rio v�lida!"); 
                           	 } 
                      	 
                      	 
                      	 
                      	 else {
                      		 vazio = (emailField.getText() ); 
                          	 if ( ( vazio.isEmpty()) || ( vazio.equals("Digite um email ou 00!") ) ){                		  
                          		 	emailField.setText("Digite um email ou 00!"); 
                          	 } 
                          	 else{
                          		 contatosNovos.remove(posicaoApagada);
                          		 Aniversario aniversario = new Aniversario(Integer.parseInt(diaField.getText()),
                                                          	Integer.parseInt(mesField.getText()),
                                                          	Integer.parseInt(anoField.getText()));
                          		 Contato contato = new Contato(nomeField.getText().toUpperCase(),
                                              					Long.parseLong(fixoField.getText()),
				                                              	Long.parseLong(celularField.getText()),
					                                            emailField.getText().toLowerCase(),
					                                            aniversario,
					                                            Long.parseLong(cpfField.getText()));
                          		 //contatos.remove(posicaoApagada);
				                contatosNovos.add(contato);
				                Comparador comparator = new Comparador();
				                Collections.sort(contatosNovos, comparator);
				                FileOutputStream fos;
				                try {
				                	fos = new FileOutputStream("C:\\arqs\\agenda.ser");
				                	ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				                	// Grava o n�mero de contatos
				                	oos.writeInt(contatosNovos.size());
				
				                	// Grava os objetos contatos.
				                	Iterator it = contatosNovos.iterator();
				                	while (it.hasNext()) {
				                		oos.writeObject(it.next());
				                	}
				
				                	oos.flush();  // For�a a escrita dos buffers
				                	oos.close();  // Fecha a stream
				                	
				                } catch (FileNotFoundException e1) {
				                	// TODO Auto-generated catch block
				                	e1.printStackTrace();
				                } catch (IOException e1) {
				                	// TODO Auto-generated catch block
				                	e1.printStackTrace();
				                }
							
								contatosNovos.clear();    
					        	dispose();
                          	 }}}}}}}}
	        }
	   }
	
	private class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
             dispose();
        }
   }
}