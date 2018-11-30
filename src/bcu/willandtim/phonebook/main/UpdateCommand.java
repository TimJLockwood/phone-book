package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;

public class UpdateCommand implements Command {
	private String name;
	private String phoneNumber;

	public UpdateCommand(String[] parts) throws InvalidCommandException {
		if (parts.length != 3) {
			throw new InvalidCommandException();
		}
		this.name = parts[1];
		this.phoneNumber = parts[2];
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void execute(PhoneBook phoneBook) throws AlreadyPresentException, NotPresentException {
		phoneBook.updateEntry(name, phoneNumber);
		System.out.println("Entry updated.");
	}

}
