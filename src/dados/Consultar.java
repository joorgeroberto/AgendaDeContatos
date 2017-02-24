/*
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
 
public class Consultar extends JFrame{
static ArrayList<Contato> contatos;// = new ArrayList<Contato>();
JButton pesquisar, apagar, editar, sair;
JTextField dados;
JTextArea area;
int num,posicao;
public Consultar(){
	contatos = new ArrayList<Contato>();
	Iterator it = contatos.iterator();
	contatos.clear();
	
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    Container container = getContentPane();	   
    container.setLayout(gridbag);

    // Os componentes podem ser esticados nas duas dire√ß√µes
    // para ocupar todo o espa√ßo dispon√≠vel
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10,  // Acima por fora
                          10,  // √Ä esquerda por fora
                          10,  // Abaixo por fora
                          10);
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.ipadx = 100;
    c.ipady = 10;
    c.gridwidth = GridBagConstraints.BOTH;
    
    dados = new JTextField("");
    dados.setToolTipText("Digite aqui o nome do contato que deseja consultar");
    gridbag.setConstraints(dados, c);
    container.add(dados);
    
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.ipadx = 10;
    
    pesquisar = new JButton("Pesquisar");
    pesquisar.setToolTipText( "Clique aqui para pesquisar o contato que deseja consultar." );
    gridbag.setConstraints(pesquisar, c);
    container.add(pesquisar);
    
    
    area = new JTextArea(10, 10);
    JScrollPane spTextArea = new JScrollPane(area,
                                             JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                             JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    //gridbag.setConstraints(area, c);
    gridbag.setConstraints(spTextArea, c);
    //container.add(area);
    container.add(spTextArea);
    
    c.gridwidth = GridBagConstraints.BOTH;
    apagar = new JButton("Apagar");
    apagar.setToolTipText( "Clique aqui para apagar o contato." );
    gridbag.setConstraints(apagar, c);
    container.add(apagar);
    apagar.setEnabled(false);
    c.gridwidth = GridBagConstraints.REMAINDER;
    editar = new JButton("Editar");
    editar.setToolTipText( "Clique aqui para editar o contato." );
    gridbag.setConstraints(editar, c);
    container.add(editar);
    editar.setEnabled(false);
    sair = new JButton("Sair");
    editar.setToolTipText( "Clique aqui para sair" );
    gridbag.setConstraints(sair, c);
    container.add(sair);
    File file = new File("C:\\arqs\\agenda.ser");
    if (!file.exists()){
		//if (fileFolder.exists)
        area.append("Nenhum contato gravado!\nPor favor, primeiro grave um contato para poder procur·-lo.\n");}
	else{
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\arqs\\agenda.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			num = ois.readInt();
			System.out.print("Existem: "+num+" arquivos.");
		
            	// ObtÈm os objetos do arquivo e adiciona na coleÁ„o
            	for (int i = 0; i < num; i++) {
            		contatos.add((Contato) ois.readObject());
            	}
            	
            	if (!it.hasNext()){
            	area.append("Nenhum contato gravado!\nPor favor, primeiro grave um contato para poder procur·-lo.\n\n");}
            	ois.close();
            	fis.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
    
    sair.addActionListener( new SairListener() );
    apagar.addActionListener( new ApagarListener() );
    editar.addActionListener( new EditarListener() );
    pesquisar.addActionListener( new PesquisarListener() );
    //contatos.clear();
    
    setVisible(true);
    setResizable(false);

    }

private class SairListener implements ActionListener {
             public void actionPerformed(ActionEvent e){
                  dispose();
             }
        }

private class ApagarListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
    	contatos.remove(posicao);
    	
    	Comparador comparator = new Comparador();
		Collections.sort(contatos, comparator);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("C:\\arqs\\agenda.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

	        
			//num=num+1;
	        oos.writeInt(contatos.size());

	        // Grava os objetos contatos
	        Iterator it = contatos.iterator();
	        while (it.hasNext()) {
	            oos.writeObject(it.next());
	        }

	        oos.flush();  // ForÁa a escrita dos buffers
	        oos.close();  // Fecha a stream
           	  
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	dispose();
    }
}

private class EditarListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
    	Editar application;
		try {
			application = new Editar(contatos, posicao);
			application.setTitle("Editar Contato");
			application.setSize(600,400);
			application.setVisible(true);
			application.setResizable(false);
			application.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		contatos.clear();
    	dispose();
    	
    	
    }
}

private class PesquisarListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
    	String nome =  (dados.getText() );            	 
        if ( ( nome.isEmpty()) || ( nome.equals("Digite um nome!") ) ){
      	  dados.setText("Digite um nome!");
        }else{
        	String esta = "NAO";
        	
        	for (int i = 0; i < (contatos.size()); i++) 
			{
				if ( nome.toUpperCase().equals (contatos.get(i).getNome()) )
				{
					posicao = i;
					area.append(("\n"+contatos.get(i).toString()));
					area.append("\n==================================================================\n");
					esta = "SIM";
					apagar.setEnabled(true);
					editar.setEnabled(true);
					break;
				} else{
					esta = "NAO";
				}
			}
        	if (esta.equals("NAO")){
        		area.append("O contato n„o est· gravado. Por favor procure outro.\n\n");
        	}
        	
        }
    }
}

}
