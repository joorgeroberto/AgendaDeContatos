package dados;
import java.util.Scanner;

import dados.Contato;
import dados.Menu;

import java.util.Collections;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




/*Projeto referente a disciplina: Programa��o Orientada a Objetos (COMP0198 - Turma 01) 
 * Professor: Alberto Costa Neto
 * UFS - UNIVERSIDADE FEDERAL DE SERGIPE.
 * 
 * Agenda de contatos:
 * Feita por:
 * Jorge Roberto de Carvalho J�nior
 * Juliana Teixeira do Nascimento
 * Luciano Pedreira Cardoso J�nior
 * Leonardo Ikejiri Carrara
 * 
 * 
 * */


public class AgendaDeContatos extends JFrame
{
	
	static Scanner input;
	//public JButton b1, b2, b3;
	static int novamente = 1;
	static ArrayList<Contato> contatos = new ArrayList<Contato>();
	
	
	 
	
	 
	public static void main(String[] args) 
	{
		
		do {		
			// TODO Auto-generated method stub
			input = new Scanner(System.in);
			
			Menu application = new Menu();
			
			application.setSize(400,350);
			application.setVisible(true);
			application.setResizable(false);
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
		}
		while(novamente == 0);
		
	}

}

