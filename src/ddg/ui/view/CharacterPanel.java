package ddg.ui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ddg.Config;
import ddg.model.Fighter;
import ddg.model.item.BaseItem;
import ddg.ui.view.dialog.CharacterSelection;

/**
 * 
 * This class is to display information of a character during a game
 * 
 * @author Fei Yu
 * @date Mar 12, 2017
 */
public class CharacterPanel extends JPanel implements Observer {
	
	private final JButton inventoryBtn = new JButton("Inventory");
	private final JButton nextBtn = new JButton("Next one");

	public JLabel iconL = new JLabel();
	public JLabel nameL = new JLabel();
	private JLabel levelL = new JLabel();
	private JLabel typeL = new JLabel();
	private JLabel hitponitL = new JLabel();
	private JLabel strengthL = new JLabel();
	private JLabel dexterityL = new JLabel();
	private JLabel constitutionL = new JLabel();
	private JLabel intelligenceL = new JLabel();
	private JLabel wisdomL = new JLabel();
	private JLabel charismaL = new JLabel();
	private JLabel strengthModiferL = new JLabel();
	private JLabel dexModiferL = new JLabel();
	private JLabel conModiferL = new JLabel();
	private JLabel intelliModiferL = new JLabel();
	private JLabel wisModiferL = new JLabel();
	private JLabel chaModiferL = new JLabel();
	private JLabel armorClassL = new JLabel();
	public BaseItem selectedItem = null;
	public Fighter fighter = null;
	private MapPanelInGame owner1;	

	/**
	 * This method create the window of character information
	 * @param ownerFrame
	 */
	public static void createAndShowGUI(CharacterSelection ownerFrame) {
		JFrame frame2 = new JFrame();
		frame2.setLayout(new FlowLayout());
		frame2.add(new CharacterPanel(null));
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.pack();
		frame2.setVisible(true);

	}

	/**
	 * Constructor
	 * @param mapPanelInGame The map for the current game
	 */
	CharacterPanel(MapPanelInGame mapPanelInGame) {
		owner1 = mapPanelInGame;
		setLayout(new BorderLayout());
		JPanel backPanel = new JPanel(new BorderLayout());
		JPanel attributesPanel = new JPanel(new GridLayout(12, 3, 5, 5));
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		JPanel iconPanel = new JPanel(new FlowLayout());		

		add(backPanel, BorderLayout.NORTH);
		backPanel.add(attributesPanel, BorderLayout.CENTER);
		backPanel.add(iconPanel, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setPreferredSize(new Dimension(270, 90));
		attributesPanel.setPreferredSize(new Dimension(270, 310));

		strengthModiferL.setBorder(new LineBorder(Color.BLACK));
		dexModiferL.setBorder(new LineBorder(Color.BLACK));
		conModiferL.setBorder(new LineBorder(Color.BLACK));
		intelliModiferL.setBorder(new LineBorder(Color.BLACK));
		wisModiferL.setBorder(new LineBorder(Color.BLACK));
		chaModiferL.setBorder(new LineBorder(Color.BLACK));
		strengthL.setBorder(new LineBorder(Color.BLACK));
		dexterityL.setBorder(new LineBorder(Color.BLACK));
		constitutionL.setBorder(new LineBorder(Color.BLACK));
		intelligenceL.setBorder(new LineBorder(Color.BLACK));
		wisdomL.setBorder(new LineBorder(Color.BLACK));
		charismaL.setBorder(new LineBorder(Color.BLACK));
		armorClassL.setBorder(new LineBorder(Color.BLACK));

		iconL.setIcon(Config.NPC_ICON);
		iconPanel.add(iconL);
		attributesPanel.add(new JLabel(" Name "));
		attributesPanel.add(nameL);
		attributesPanel.add(new JLabel("     "));
		attributesPanel.add(new JLabel(" Type "));
		attributesPanel.add(typeL);
		attributesPanel.add(new JLabel("     "));
		attributesPanel.add(new JLabel(" Level "));
		attributesPanel.add(levelL);
		attributesPanel.add(new JLabel("     "));
		attributesPanel.add(new JLabel(" Hitpoints "));
		attributesPanel.add(hitponitL);
		attributesPanel.add(new JLabel("     "));
		attributesPanel.add(new JLabel("      "));
		attributesPanel.add(new JLabel(" Value "));
		attributesPanel.add(new JLabel(" Modifier "));
		attributesPanel.add(new JLabel(" Strength "));
		attributesPanel.add(strengthL);
		attributesPanel.add(strengthModiferL);
		attributesPanel.add(new JLabel(" Dexterity "));
		attributesPanel.add(dexterityL);
		attributesPanel.add(dexModiferL);
		attributesPanel.add(new JLabel(" Constitution "));
		attributesPanel.add(constitutionL);
		attributesPanel.add(conModiferL);
		attributesPanel.add(new JLabel(" Intelligence "));
		attributesPanel.add(intelligenceL);
		attributesPanel.add(intelliModiferL);
		attributesPanel.add(new JLabel(" Wisdom "));
		attributesPanel.add(wisdomL);
		attributesPanel.add(wisModiferL);
		attributesPanel.add(new JLabel(" Charisma "));
		attributesPanel.add(charismaL);
		attributesPanel.add(chaModiferL);
		attributesPanel.add(new JLabel(" Armor Class "));
		attributesPanel.add(armorClassL);
		attributesPanel.add(new JLabel("      "));
		
		inventoryBtn.setPreferredSize(new Dimension(240, 40));
		nextBtn.setPreferredSize(new Dimension(240, 40));
		buttonsPanel.add(nextBtn);
		buttonsPanel.add(inventoryBtn);
		buttonsManage();

	}

	/**
	 * This method refresh attribute values of a character during a game.
	 * @param fighter The selected character in the game
	 */
	protected void updateAttributes(Fighter fighter) {
		nameL.setText(fighter.getName());
		levelL.setText(Integer.toString(fighter.getLevel()));
		hitponitL.setText(Integer.toString(fighter.getHitPoints()));

		strengthL.setText(Integer.toString(fighter.getTotalStrength()));
		dexterityL.setText(Integer.toString(fighter.getTotalDexterity()));
		constitutionL.setText(Integer.toString(fighter.getTotalConstitution()));
		intelligenceL.setText(Integer.toString(fighter.getTotalIntelligence()));
		wisdomL.setText(Integer.toString(fighter.getTotalWisdom()));
		charismaL.setText(Integer.toString(fighter.getTotalCharisma()));
		armorClassL.setText(Integer.toString(fighter.getTotalArmorClass()));
		
		strengthModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalStrength())));
		dexModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalDexterity())));
		conModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalConstitution())));
		intelliModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalIntelligence())));
		wisModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalWisdom())));
		chaModiferL.setText(Integer.toString(fighter.getModifier(fighter.getTotalCharisma())));

	}

	/**
	 * This method defines actions of different buttons in this frame.
	 */
	private void buttonsManage() {
		inventoryBtn.addActionListener(owner1);
		nextBtn.addActionListener(owner1);
	}

	@Override
	public void update(Observable o, Object arg) {
		updateAttributes((Fighter)arg);
	}

}