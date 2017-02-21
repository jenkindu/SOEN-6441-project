package ddg.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import ddg.Config;
import ddg.view.component.OButton;
/**
 * This class is show item editor view
 * 
 * @author 
 * @date Feb 5, 2017
 */
public class ItemEditor extends JPanel implements ActionListener {

	private ActionListener listener;
	
	public ItemEditor(ActionListener a) {
		this.listener = a;
		initView();
	}

	private void initView() {
		BorderLayout l = new BorderLayout();
	    setLayout(l);
		
	    addEditor();
	    addOption();
	}

	private void addEditor() {
		JPanel contentPanel = new JPanel();
		JTextArea ddg = new JTextArea("ITEM NAME");
//		ddg.setEditable(false);
		contentPanel.add(ddg);
		
		JTextArea ability = new JTextArea("ITEM");
//		ddg.setEditable(false);
		contentPanel.add(ability);
	    add(contentPanel, BorderLayout.CENTER);
	}
	
	private void addOption() {
		JPanel optionPanel = new JPanel();
	    optionPanel.setPreferredSize(new Dimension(Config.OPTION_WIDTH, Config.OPTION_HEIGHT));
	    optionPanel.setBorder(Config.border);
	    JTextArea optionTitle = new JTextArea("OPTION");
	    optionTitle.setEditable(false);

	    OButton saveBtn = new OButton("SAVE", this);
	    saveBtn.setPreferredSize(new Dimension(Config.BTN_WIDTH, Config.BTN_HEIGHT));
	    OButton backBtn = new OButton("BACK", this);
	    backBtn.setPreferredSize(new Dimension(Config.BTN_WIDTH, Config.BTN_HEIGHT));
	    optionPanel.add(optionTitle);
	    optionPanel.add(saveBtn);
	    optionPanel.add(backBtn);
	    add(optionPanel, BorderLayout.EAST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("BACK")) {
			e = new ActionEvent(e.getSource(), e.getID(), "ITEM-BACK");
		}
		listener.actionPerformed(e);
	}
}
