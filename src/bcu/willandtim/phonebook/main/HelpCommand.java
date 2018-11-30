package bcu.willandtim.phonebook.main;

import bcu.willandtim.phonebook.model.AlreadyPresentException;
import bcu.willandtim.phonebook.model.NotPresentException;
import bcu.willandtim.phonebook.model.PhoneBook;

public class HelpCommand implements Command {

	public static final String HELP_MESSAGE = 
			"Commands:\n" + "    add [name] [phoneNumber]        add a new entry\n"
			+ "    show [name]                     show an entry\n"
			+ "    update [name] [phoneNumber]     update an entry\n"
			+ "    remove [name]                   remove an entry\n"
			+ "    list                            show all names\n"
			+ "    help                            show this help message\n"
			+ "    exit                            exit the program";

	public HelpCommand(String[] parts) throws InvalidCommandException {
		if (parts.length != 1) {
			throw new InvalidCommandException();
		}
	}

	@Override
	public void execute(PhoneBook phonebook) throws AlreadyPresentException, NotPresentException {
		System.out.println(HELP_MESSAGE);

	}

}
