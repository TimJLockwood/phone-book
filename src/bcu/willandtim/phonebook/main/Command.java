package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;

public interface Command {
	public void execute(PhoneBook phoneBook) throws AlreadyPresentException, NotPresentException;
}
