import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class KolokwiumDroga  extends JFrame implements ActionListener {
	
	// s=at^2/2
	
	JTextField wartosc_a;
	JTextField wartosc_t;
	JButton oblicz;
	JLabel wynik_s;
	
	public static void main(String[] args) {
		KolokwiumDroga frame = new KolokwiumDroga();
		frame.initUI();
	}

	private void initUI() {
		
		wartosc_a = new JTextField("Wprowadz przyœpieszenie (a)");
		wartosc_t = new JTextField("Wprowadz czas (t)");
		oblicz = new JButton("Oblicz");
		oblicz.addActionListener(this);
		wynik_s = new JLabel();
		
		this.add(wartosc_a);
		this.add(wartosc_t);
		this.add(oblicz);
		this.add(wynik_s);
		
		this.setLayout(new GridLayout(4, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setTitle("Zgadywanie Liczby");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(oblicz.equals(e.getSource())) {
			obliczDroge();
		}
		
	}

	private void obliczDroge() {
		
		try {
		String pole_podane_a = wartosc_a.getText();
		double podane_a = Double.parseDouble(pole_podane_a);
		
		String pole_podane_t = wartosc_t.getText();
		double podane_t = Double.parseDouble(pole_podane_t);
		
		double wartosc_s = (double) (podane_a*Math.pow(podane_t, 2))/2;
		wynik_s.setText("Cia³o pokona drogê: " + wartosc_s + " w ruchu jednostajnym prostoliniowym.");
		
		} catch(NumberFormatException e1) {
			wynik_s.setText("Wprowadz wy³¹cznie liczby!");
		}
		
		if(wartosc_a.getText().trim().equals("")) {
			wynik_s.setText("Wprowadz brakuj¹ce dane!");
		}
		
		if(wartosc_t.getText().trim().equals("")) {
			wynik_s.setText("Wprowadz brakuj¹ce dane!");
		}
		
	}

}
