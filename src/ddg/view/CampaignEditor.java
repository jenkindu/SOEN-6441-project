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
 * This class is show campaign editor view
 * 
 * @author 
 * @date Feb 5, 2017
 */
public class CampaignEditor extends JPanel implements ActionListener {

	private ActionListener listener;
	
	public CampaignEditor(ActionListener a) {
		this.listener = a;
		initView();
	}

	private void initView() {
		BorderLayout l = new BorderLayout();
	    setLayout(l);
		JPanel contentPanel = new JPanel();
		JTextArea ddg = new JTextArea("CAMPAIGN");
		ddg.setEditable(false);
		contentPanel.add(ddg);
	    add(contentPanel, BorderLayout.CENTER);
	    addNewLevel(contentPanel);
	    addOption();
	}
	int i = 1;
	private void addNewLevel(JPanel contentPanel) {
		OButton addBtn = new OButton("ADD", this);
		contentPanel.add(addBtn);
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(i==21)
					return;
//			    addNewLevel(contentPanel);
				JTextArea map = new JTextArea("MAP-"+i);
				contentPanel.add(map);
			    contentPanel.doLayout();
			    i++;
			}
			
		}; 
		addBtn.removeActionListener(this);
		addBtn.addActionListener(l);
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
			e = new ActionEvent(e.getSource(), e.getID(), "CAMPAIGN-BACK");
		}
		listener.actionPerformed(e);
	}
}
