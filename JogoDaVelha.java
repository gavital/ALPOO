/**************************************************
 * Exercício aula ALPOO
 * Criar um jogo da velha que informe o vencedor.
 **************************************************/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class JogoDaVelha extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L; // nem ideia o pq precisa disso, mas tava no exemplo do professor
	private JButton botao[][] = new JButton[3][3]; // criando matriz de botões
	private JButton newGame, exitGame; // botões para novo jogo e sair
	private JTextArea contaVit1, contaVit2, contaEmpate; // coloquei só para organizar, nao sei como exibir o contador
	private JLabel player1, simbolo1, player2, simbolo2, totalWinPlayer1,
			totalWinPlayer2, totalDraw;
	private int quemJoga = 0; // implementado no método ACAO para alterar o simbolo
	

	// Método construtor
	public JogoDaVelha() {

		// Criação de todos os componentes da interface
		super("Jogo da Velha"); // nome da janela
		((JComponent)getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5)); // Determina uma borda ao redor dos componentes
		setSize(500, 270); // Tamanho da janela
		setLocationRelativeTo(null); // centralizando a janela
		setDefaultCloseOperation(EXIT_ON_CLOSE); // adicionando função fechar X

		player1 = new JLabel("Jogador 1");
		simbolo1 = new JLabel("Símbolo: X");
		player2 = new JLabel("Jogador 2");
		simbolo2 = new JLabel("Símbolo: O");
		totalWinPlayer1 = new JLabel("Número de vitórias: ");
		totalWinPlayer2 = new JLabel("Número de vitórias: ");
		totalDraw = new JLabel("Número de empates: ");
		contaVit1 = new JTextArea("0");
		contaVit2 = new JTextArea("0");
		contaEmpate = new JTextArea("0");

		// criando matriz de botões e adicionando ACTIONLISTENER para receber ação
		for (int n = 0; n < botao.length; n++) { // linha
			for (int m = 0; m < botao[n].length; m++) { // coluna
				botao[n][m] = new JButton("");
				botao[n][m].addActionListener(this);
			}
		}

		// Criando botões NOVO JOGO e SAIR
		newGame = new JButton("NOVO JOGO");
		newGame.addActionListener(this);
		exitGame = new JButton("SAIR");
		exitGame.addActionListener(this);

		// Criando e posicionando os componentes na janela
		Container janela;
		janela = getContentPane();
		janela.setLayout(new GridLayout(1, 2)); // grid 1x2 para colocar os paineis

		// Colocando os botões de jogo
		JPanel gamePanel = new JPanel(new GridLayout(3, 3));
		for (int n = 0; n < botao.length; n++) { // linha
			for (int m = 0; m < botao[n].length; m++) { // coluna
				botao[n][m].setFont(new Font("Calibri", Font.BOLD, 60));
				botao[n][m].setBackground(Color.white);
				gamePanel.add(botao[n][m]);
				
			}
		}
		janela.add(gamePanel); // adicionando painel do jogo

		// Colocando as informações do jogo em um segundo painel
		JPanel gameInfo = new JPanel(new GridLayout(8, 2));
		gameInfo.add(player1);// informações jogador 1
		gameInfo.add(simbolo1);
		gameInfo.add(totalWinPlayer1);
		gameInfo.add(contaVit1);
		gameInfo.add(player2); // informações jogador 2
		gameInfo.add(simbolo2);
		gameInfo.add(totalWinPlayer2);
		gameInfo.add(contaVit2);
		gameInfo.add(totalDraw); // informações de impate
		gameInfo.add(contaEmpate);

		gameInfo.add(newGame); // botão de novo jogo
		gameInfo.add(exitGame); // botão de sair

		janela.add(gameInfo);
	}
	
	// Colocando X ou O ao clicar em um dos botões
	public void Acao(int i, int j) {
		String XO;
		if (quemJoga == 0) {
			XO = "X";
			quemJoga = 1;
		} else {
			XO = "O";
			quemJoga = 0;
		}
		botao[i][j].setText(XO);
		Verifica(XO);
	}
	
	public void Verifica(String XO){
		// verificando as horizontais
		if ((botao[0][0].getText().equals(XO)) && (botao[0][1].getText().equals(XO))&&(botao[0][2].getText().equals(XO))){
			botao[0][0].setBackground(Color.green);
			botao[0][1].setBackground(Color.green);
			botao[0][2].setBackground(Color.green);
		}
		
		if ((botao[1][0].getText().equals(XO)) && (botao[1][1].getText().equals(XO))&&(botao[1][2].getText().equals(XO))){
			botao[1][0].setBackground(Color.green);
			botao[1][1].setBackground(Color.green);
			botao[1][2].setBackground(Color.green);
		}
		
		if ((botao[2][0].getText().equals(XO)) && (botao[2][1].getText().equals(XO))&&(botao[2][2].getText().equals(XO))){
			botao[2][0].setBackground(Color.green);
			botao[2][1].setBackground(Color.green);
			botao[2][2].setBackground(Color.green);
		}
		
		// Verificando as verticais
		if ((botao[0][0].getText().equals(XO)) && (botao[1][0].getText().equals(XO))&&(botao[2][0].getText().equals(XO))){
			botao[0][0].setBackground(Color.green);
			botao[1][0].setBackground(Color.green);
			botao[2][0].setBackground(Color.green);
		}
		
		if ((botao[0][1].getText().equals(XO)) && (botao[1][1].getText().equals(XO))&&(botao[2][1].getText().equals(XO))){
			botao[0][1].setBackground(Color.green);
			botao[1][1].setBackground(Color.green);
			botao[2][1].setBackground(Color.green);
		}
		
		if ((botao[0][2].getText().equals(XO)) && (botao[1][2].getText().equals(XO))&&(botao[2][2].getText().equals(XO))){
			botao[0][2].setBackground(Color.green);
			botao[1][2].setBackground(Color.green);
			botao[2][2].setBackground(Color.green);
		}
		
		// Verifica diagonais
		if ((botao[0][0].getText().equals(XO)) && (botao[1][1].getText().equals(XO))&&(botao[2][2].getText().equals(XO))){
			botao[0][0].setBackground(Color.green);
			botao[1][1].setBackground(Color.green);
			botao[2][2].setBackground(Color.green);
		}
		
		if ((botao[2][0].getText().equals(XO)) && (botao[1][1].getText().equals(XO))&&(botao[1][2].getText().equals(XO))){
			botao[2][0].setBackground(Color.green);
			botao[1][1].setBackground(Color.green);
			botao[1][2].setBackground(Color.green);
		}
		
		//Verifica se deu velha
		/*if ((botao[0][0].getText() != "   ") && (botao[1][0].getText() != "   ")
				&& (botao[2][0].getText() != "   ") && (botao[0][1].getText() != "   ")
				&& (botao[1][1].getText() != "   ") && (botao[2][1].getText() != "   ")
				&& (botao[0][2].getText() != "   ") && (botao[1][2].getText() != "   ")
				&& (botao[2][2].getText() != "   ")){
			for (int n = 0; n < botao.length; n++) { // linha
				for (int m = 0; m < botao[n].length; m++) {// colunas
					botao[n][m].setBackground(Color.red);
				}
			}
		}*/
	}
	
	public void actionPerformed(ActionEvent e) {
		// Desabilitando os botões depois de clicados
		for (int n = 0; n < botao.length; n++) { // linha
			for (int m = 0; m < botao[n].length; m++) {// colunas
				if (e.getSource() == botao[n][m]) {
					botao[n][m].setEnabled(false);
					Acao(n,m); // passando parametros para marcar com X ou O
				}
			}
		}
	
	
		if (e.getSource() == newGame){
				for (int n = 0; n < botao.length; n++) { // linha
					for (int m = 0; m < botao[n].length; m++) {// colunas
						botao[n][m].setText("");
						botao[n][m].setBackground(Color.white);
						botao[n][m].setEnabled(true);
					}
				}
		}
	
	}

	
	
	public static void main(String[] args) {
		JogoDaVelha jogo = new JogoDaVelha();
		jogo.setResizable(false);
		jogo.setVisible(true);
	}
}

