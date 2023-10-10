package hotel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookingManager {

	private Room[] rooms;

	public BookingManager() {
		this.rooms = initializeRooms();
	}

	public Set<Integer> getAllRooms() {
		Set<Integer> allRooms = new HashSet<Integer>();
		Iterable<Room> roomIterator = Arrays.asList(rooms);
		for (Room room : roomIterator) {
			allRooms.add(room.getRoomNumber());
		}
		return allRooms;
	}

	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		boolean available = false;
		for (Room room1 : rooms) {
			if (Objects.equals(room1.getRoomNumber(), roomNumber)) {
				available = room1.checkAvailability(date);
			}
		}

		return available;
	}

	public void addBooking(BookingDetail bookingDetail) {
		Integer roomNumber = bookingDetail.getRoomNumber();
		LocalDate date = bookingDetail.getDate();
		String guest = bookingDetail.getGuest();
		if (!isRoomAvailable(roomNumber, date)) {return;}
		for (Room room : rooms) {
			if (Objects.equals(room.getRoomNumber(), roomNumber)) {
				room.addNewBooking(new BookingDetail(guest, roomNumber, date));
			}
		}
	}

	public Set<Integer> getAvailableRooms(LocalDate date) {
		Set<Integer> availableRooms = new HashSet<Integer>();
		for (Room room : rooms) {
			if (room.checkAvailability(date)) {
				availableRooms.add(room.getRoomNumber());
			}
		}
		return availableRooms;
	}

	private static Room[] initializeRooms() {
		Room[] rooms = new Room[4];
		rooms[0] = new Room(101);
		rooms[1] = new Room(102);
		rooms[2] = new Room(201);
		rooms[3] = new Room(203);
		return rooms;
	}
}
