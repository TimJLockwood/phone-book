package bcu.willandtim.phonebook.main;

import java.util.List;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;

public class ListCommand implements Command {

	public ListCommand(String[] parts) throws InvalidCommandException {
		if (parts.length != 1) {
			throw new InvalidCommandException();
		}
	}

	@Override
	public void execute(PhoneBook phoneBook) throws AlreadyPresentException, NotPresentException {
		List<String> names = phoneBook.getAllNames();
		if (names.isEmpty()) {
			System.out.println("No entries.");
		} else {
			for (String name : names) {
				System.out.println(name);
			}
		}
	}

}
