package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
    /*
     * Crate a HashMap of Integers for the keys and Strings for the values.
     * Create a GUI with three buttons.
     * Button 1: Add Entry
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      After an ID is entered, use another input dialog to ask the user
     *      to enter a name. Add this information as a new entry to your
     *      HashMap.
     * 
     * Button 2: Search by ID
     *      When this button is clicked, use an input dialog to ask the user
     *      to enter an ID number.
     *      If that ID exists, display that name to the user.
     *      Otherwise, tell the user that that entry does not exist.
     * 
     * Button 3: View List
     *      When this button is clicked, display the entire list in a message
     *      dialog in the following format:
     *      ID: 123  Name: Harry Howard
     *      ID: 245  Name: Polly Powers
     *      ID: 433  Name: Oliver Ortega
     *      etc...
     * 
     * When this is complete, add a fourth button to your window.
     * Button 4: Remove Entry
     *      When this button is clicked, prompt the user to enter an ID using
     *      an input dialog.
     *      If this ID exists in the HashMap, remove it. Otherwise, notify the
     *      user that the ID is not in the list.
     */
	
	JPanel panel;
	JFrame frame;
	JButton addEntry;
	JButton searchByID;
	JButton viewList;
	JButton removeEntry;
	
	HashMap<Integer, String> IDs;
	
	public static void main(String[] args) {
		_02_LogSearch runner = new _02_LogSearch();
		runner.setup();
	}
	
	void setup() {
		//UI
			frame = new JFrame("Log Search");
			panel = new JPanel();
			frame.add(panel);
			
			addEntry = new JButton("Add Entry");
			searchByID = new JButton("Search By ID");
			viewList = new JButton("View List");
			removeEntry = new JButton("Remove Entry");
			
			panel.add(addEntry);
			panel.add(searchByID);
			panel.add(viewList);
			panel.add(removeEntry);
			
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		//ID Hash Map
			IDs = new HashMap<Integer, String>();
		//Listner
			addEntry.addActionListener(this);
			searchByID.addActionListener(this);
			viewList.addActionListener(this);
			removeEntry.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		
		//Add Entry
			if(source == addEntry) {
				String IDString = JOptionPane.showInputDialog("Enter ID Number");
				int ID = Integer.parseInt(IDString);
				
				String name = JOptionPane.showInputDialog("Enter Name");
				
				IDs.put(ID, name);
			} 
		//Search By ID
			else if(source == searchByID) {
				String IDString = JOptionPane.showInputDialog("Enter ID Number");
				int ID = Integer.parseInt(IDString);
				
				if(IDs.get(ID) == null) {
					JOptionPane.showMessageDialog(null, "That ID does not exist");
				} else {
					JOptionPane.showMessageDialog(null, "ID found: " + IDs.get(ID));
				}
			}
		//View List
			else if(source == viewList) {
				String list = "List of all IDs and names:";
				
				for(int i : IDs.keySet()) {
					list+="\n    -ID: " + i + " ---  Name: " + IDs.get(i);
				}
				
				JOptionPane.showMessageDialog(null, list);
			}
		//Remove Entry
			else if(source == removeEntry) {
				String IDString = JOptionPane.showInputDialog("Enter ID Number");
				int ID = Integer.parseInt(IDString);
				
				if(IDs.get(ID) == null) {
					JOptionPane.showMessageDialog(null, "That ID does not exist");
				} else {
					JOptionPane.showMessageDialog(null, "ID found: " + IDs.get(ID) + " removed");
					IDs.remove(ID);
				}
			} else {
				System.out.println("Bad");
			}
	}
	
	
}
