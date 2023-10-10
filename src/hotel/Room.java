package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {

	private Integer roomNumber;
	private List<BookingDetail> bookings;

	public Room(Integer roomNumber) {
		this.roomNumber = roomNumber;
		bookings = new ArrayList<BookingDetail>();
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<BookingDetail> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDetail> bookings) {
		this.bookings = bookings;
	}

	public boolean checkAvailability(LocalDate date) {
		for (BookingDetail book : bookings) {
			if (Objects.equals(book.getDate(), date)) {
				return false;
			}
		}
		return true;
	}

	public void addNewBooking(BookingDetail bookingDetail) {
		bookings.add(bookingDetail);
	}
}