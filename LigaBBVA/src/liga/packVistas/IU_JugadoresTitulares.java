package liga.packVistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IU_JugadoresTitulares extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPoner;
	private JButton btnQuitar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IU_JugadoresTitulares dialog = new IU_JugadoresTitulares();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IU_JugadoresTitulares() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JList listConvocables = new JList();
			listConvocables.setBounds(12, 47, 156, 180);
			contentPanel.add(listConvocables);
		}
		{
			JList listAConvocar = new JList();
			listAConvocar.setBounds(278, 47, 156, 180);
			contentPanel.add(listAConvocar);
		}
		{
			JLabel lblJugadoresConvocados = new JLabel("Jugadores convocados");
			lblJugadoresConvocados.setBounds(12, 20, 191, 15);
			contentPanel.add(lblJugadoresConvocados);
		}
		{
			JLabel lblJugadoresTitulares = new JLabel("Jugadores titulares");
			lblJugadoresTitulares.setHorizontalAlignment(SwingConstants.RIGHT);
			lblJugadoresTitulares.setBounds(243, 20, 191, 15);
			contentPanel.add(lblJugadoresTitulares);
		}
		contentPanel.add(getBtnPoner());
		contentPanel.add(getBtnQuitar());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JButton getBtnPoner() {
		if (btnPoner == null) {
			btnPoner = new JButton(">");
			btnPoner.setBounds(200, 70, 44, 25);
		}
		return btnPoner;
	}
	private JButton getBtnQuitar() {
		if (btnQuitar == null) {
			btnQuitar = new JButton("<");
			btnQuitar.setBounds(200, 107, 44, 25);
		}
		return btnQuitar;
	}
}