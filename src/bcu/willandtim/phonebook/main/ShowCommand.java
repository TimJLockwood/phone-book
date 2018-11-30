package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;
import bcu.willandtim.phonebook.model.PhoneBookEntry;

public class ShowCommand implements Command {
	private String name;

	public ShowCommand(String[] parts) throws InvalidCommandException {
		if (parts.length != 2) {
			throw new InvalidCommandException();
		}
		this.name = parts[1];
	}

	public String getName() {
		return name;
	}

	@Override
	public void execute(PhoneBook phoneBook) throws AlreadyPresentException, NotPresentException {
		PhoneBookEntry entry = phoneBook.getEntry(name);
		System.out.println("Name: " + entry.getName());
		System.out.println("Phone number: " + entry.getPhoneNumber());

	}

}
