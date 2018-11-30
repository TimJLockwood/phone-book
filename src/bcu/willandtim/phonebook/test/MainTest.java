package bcu.willandtim.phonebook.test;

import bcu.willandtim.phonebook.main.*;
import bcu.willandtim.phonebook.model.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MainTest {
	private final PhoneBook phoneBook = new PhoneBook();
	private final Main main = new Main(phoneBook);

	@Test
	public void testAddCommand() throws Exception {
		main.parseAndExecute("add Alice 12345");
		PhoneBookEntry entry = phoneBook.getEntry("alice");
		assertEquals("12345", entry.getPhoneNumber());
	}

	@Test
	public void testUpdateCommand() throws Exception {
		main.parseAndExecute("add Alice 12345");
		main.parseAndExecute("update alice 67890");
		PhoneBookEntry entry = phoneBook.getEntry("alice");
		assertEquals("67890", entry.getPhoneNumber());
	}

	@Test
	public void testRemoveCommand() throws Exception {
		main.parseAndExecute("add Alice 12345");
		main.parseAndExecute("remove alice");
		try {
			phoneBook.getEntry("alice");
			fail();
		} catch (NotPresentException ex) {
			// test passes
		}
	}

	@Test(expected = AlreadyPresentException.class)
	public void testAddAlreadyPresent() throws Exception {
		main.parseAndExecute("add Alice 12345");
		main.parseAndExecute("add Alice 67890");
	}

	@Test(expected = NotPresentException.class)
	public void testShowNotPresent() throws Exception {
		main.parseAndExecute("show alice");
	}

	@Test
	public void testAddCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("add Alice 1234");
		assertTrue(c instanceof AddCommand);
	}

	@Test
	public void testShowCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("show Alice");
		assertTrue(c instanceof ShowCommand);
	}

	@Test
	public void testUpdateCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("update Alice 12345");
		assertTrue(c instanceof UpdateCommand);
	}

	@Test
	public void testRemoveCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("remove Alice");
		assertTrue(c instanceof RemoveCommand);
	}

	@Test
	public void testListCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("list");
		assertTrue(c instanceof ListCommand);
	}

	@Test
	public void testHelpCommandReturnCommand() throws InvalidCommandException {
		Command c = Main.parse("help");
		assertTrue(c instanceof HelpCommand);
	}

	@Test(expected = InvalidCommandException.class)
	public void testAddZeroParam() throws InvalidCommandException {
		Main.parse("add");
	}

	@Test(expected = InvalidCommandException.class)
	public void testAddNameOnly() throws InvalidCommandException {
		Main.parse("add Alice");
	}

	@Test(expected = InvalidCommandException.class)
	public void testAddTooManyParams() throws InvalidCommandException {
		Main.parse("add Alice 1234 4321");
	}

	@Test(expected = InvalidCommandException.class)
	public void testShowNoName() throws InvalidCommandException {
		Main.parse("show");
	}

	@Test(expected = InvalidCommandException.class)
	public void testUpdateZeroParam() throws InvalidCommandException {
		Main.parse("update");
	}

	@Test(expected = InvalidCommandException.class)
	public void testUpdateNameOnly() throws InvalidCommandException {
		Main.parse("update Alice");
	}

	@Test(expected = InvalidCommandException.class)
	public void testUpdateTooManyParams() throws InvalidCommandException {
		Main.parse("update Alice 4321 1234");
	}

	@Test(expected = InvalidCommandException.class)
	public void testRemoveNoName() throws InvalidCommandException {
		Main.parse("remove");
	}

	@Test
	public void testAddCorrectNameAndNumberVars() throws InvalidCommandException {
		AddCommand c = (AddCommand) Main.parse("add Alice 12345");
		assertEquals("Alice", c.getName());
		assertEquals("12345", c.getPhoneNumber());
	}

	@Test
	public void testShowCorrectNameVar() throws InvalidCommandException {
		ShowCommand c = (ShowCommand) Main.parse("show Alice");
		assertEquals("Alice", c.getName());
	}

	@Test
	public void testUpdateCorrectNameAndNumberVars() throws InvalidCommandException {
		UpdateCommand c = (UpdateCommand) Main.parse("update Alice 12345");
		assertEquals("Alice", c.getName());
		assertEquals("12345", c.getPhoneNumber());
	}

	@Test
	public void testRemoveCorrectNameVar() throws InvalidCommandException {
		RemoveCommand c = (RemoveCommand) Main.parse("remove Alice");
		assertEquals("Alice", c.getName());
	}
}
