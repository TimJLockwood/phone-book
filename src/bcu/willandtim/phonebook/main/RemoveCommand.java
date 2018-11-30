package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;

public class RemoveCommand implements Command {
	private String name;

	public RemoveCommand(String[] parts) throws InvalidCommandException {
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
		phoneBook.removeEntry(name);
		System.out.println("Entry removed.");
	}

}
