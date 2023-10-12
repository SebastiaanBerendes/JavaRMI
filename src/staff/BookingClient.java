package staff;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;
import java.util.Set;

import hotel.BookingDetail;
import hotel.BookingManager;
import shared.IBookingManager;

public class BookingClient extends AbstractScriptedSimpleTest {

	private IBookingManager bm = null;

	public static void main(String[] args) throws Exception {
		BookingClient client = new BookingClient();
		client.run();

		try {
			Registry registry = LocateRegistry.getRegistry();
			IBookingManager bookingM = (IBookingManager) registry.lookup("bookingM");
			client.bm = bookingM;
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}

	/***************
	 * CONSTRUCTOR *
	 ***************/
	public BookingClient() {
		try {
			//Look up the registered remote instance
			bm = new BookingManager();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Override
	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		try {
			return bm.isRoomAvailable(roomNumber, date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void addBooking(BookingDetail bookingDetail) {
		try {
			bm.addBooking(bookingDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Integer> getAvailableRooms(LocalDate date) {
		try {
			return bm.getAvailableRooms(date);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Set<Integer> getAllRooms() {
		try {
			return bm.getAllRooms();
		} catch (Exception e) {
			throw new RuntimeException();
		}
    }
}
