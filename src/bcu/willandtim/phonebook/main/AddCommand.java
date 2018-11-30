package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.*;

public class AddCommand implements Command {
	private final String name;
	private final String phoneNumber;

	public AddCommand(String[] parts) throws InvalidCommandException {
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
	public void execute(PhoneBook phoneBook) throws AlreadyPresentException {
		phoneBook.addEntry(name, phoneNumber);
		System.out.println("Entry added.");
	}
}