package ddg.model;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import ddg.model.entity.BaseItem;
import ddg.model.entity.ListEntry;

/**
 * 
 * This is Item model to restore all items
 * 
 * @author Zhen Du
 * @date Feb 22, 2017
 */
public class ItemEditorModel {
	
	private ArrayList<BaseItem> items;
	/**
	 * 
	 * Constructors for ItemEditor Data
	 *
	 */
	public ItemEditorModel() {
		super();
		this.items = new ArrayList<BaseItem>();
	}
	
	/**
	 * 
	 * Constructors for ItemEditor Data
	 * 
	 * @param items
	 */
	public ItemEditorModel(ArrayList<BaseItem> items) {
		super();
		this.items = items;
	}

	/**
	 * 
	 * This method is add item to the model
	 * 
	 * @param item
	 */
	public void addItem(BaseItem item) {
		int size = 0;
		for(int i = 0; i < this.items.size(); i++) {
			if(items.get(i).getName().equals(item.getName())) {
				size++;
			}
		}
		item.setId(item.getName()+"_"+(size+1));
		if(item.getName().equals("key")){
			this.items.add(0,item);
		}
		else
			this.items.add(item);
	}
	
	/**
	 * 
	 * Get List model
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel getListModel() {
		DefaultListModel l = new DefaultListModel();
		for(BaseItem i : items) {
			l.addElement(new ListEntry(i.getId(), new ImageIcon("res/"+i.getName()+".jpg")));
		}
		return l;
	}
	
	/**
	 * 
	 * Get List model by type
	 * 
	 * @return DefaultListModel
	 */
	public DefaultListModel getListModel(String type) {
		DefaultListModel l = new DefaultListModel();
		for(BaseItem i : items) {
			if(i.getName().equals(type)) {
				l.addElement(new ListEntry(i.getId(), new ImageIcon("res/"+i.getName()+".jpg")));
			}
		}
		return l;
	}
	
	/**
	 * 
	 * This method get item in the list by index
	 * 
	 * @param index
	 * @return BaseItem the value on the index
	 */
	public BaseItem getItemByIndex(int index) {
		if(index < 0 || index > items.size()-1)
			return null;
		return items.get(index);
	}
}
